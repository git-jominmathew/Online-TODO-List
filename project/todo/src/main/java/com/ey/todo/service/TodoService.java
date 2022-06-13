package com.ey.todo.service;


import com.ey.todo.constants.ToDoConstants;
import com.ey.todo.dto.TodoItem;
import com.ey.todo.model.ToDoEntiy;
import com.ey.todo.repository.TodoRepository;
import com.ey.todo.utility.ToDoMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * to-do-service
 */
@Service
public class TodoService {

    Logger log = LoggerFactory.getLogger(TodoService.class);
     static final String PATTERN = "dd-MMM-yyyy HH:MM:SS";
    @Autowired
    private TodoRepository todoRepository;


    public List<TodoItem> fetchAllTodoItems() {
        log.info("entering fetchAllTodoItems");
        List<ToDoEntiy> entiyList = (List<ToDoEntiy>) todoRepository.findAll();
        return ToDoMapper.mapToDTO(entiyList);
    }


    public TodoItem updateTodoItems(Integer id, TodoItem todoItem) {
        log.info("entering updateTodoItems");
        ToDoEntiy savedToDo = null;
        Optional<ToDoEntiy> toDoOp = todoRepository.findById(id);
        if (toDoOp.isPresent()) {
            savedToDo = toDoOp.get();
            if (todoItem.getDone() != null) {//update the whether Done, only if the task is not null
                savedToDo.setDone(todoItem.getDone());
            }
            if (todoItem.getTask() != null) {//update the task only if the task is not null
                savedToDo.setTask(todoItem.getTask());
            }
            savedToDo.setLastUpdateTime(createNewTime());//create new time while updating the entry
            todoRepository.save(savedToDo);
            //map the updated entries back to DTO
            ModelMapper modelMapper = new ModelMapper();
            todoItem = modelMapper.map(savedToDo, TodoItem.class);
        }else {
            todoItem = null;
        }
        return todoItem;
    }


    /**
     * create new to-do items
     * save : if new task
     * update : if existing task
     *
     * @param todoItem todoItem
     * @return {@link String}
     * @see String
     */
    public String createNewTodoItems(TodoItem todoItem) {
        log.info("entering create new to-do items");
        ModelMapper modelMapper = new ModelMapper();

        //check whether the task already exists
        List<ToDoEntiy> entiyList = (List<ToDoEntiy>) todoRepository.findAll();
        Optional<ToDoEntiy> entityToUpdate = entiyList.stream().filter(e -> e.getTask().equals(todoItem.getTask())).findFirst();
        if (entityToUpdate.isPresent()) {//update
            updateTodoItems(entityToUpdate.get().getId(), todoItem);
        } else {//save
            ToDoEntiy toDoEntiy = modelMapper.map(todoItem, ToDoEntiy.class);
            toDoEntiy.setLastUpdateTime(createNewTime());
            try {
                todoRepository.save(toDoEntiy);
            } catch (RuntimeException re) {
                log.error(re.getMessage());
                return ToDoConstants.FAILURE.toString();
            }
        }
        return ToDoConstants.SUCCESS.toString();
    }


    /**
     *
     * @param id
     * @return
     */
    public String deleteTodoItem(Integer id) {
        log.info("Repo entering deleteTodoItem");
        try {
            todoRepository.deleteById(id);
        } catch (RuntimeException re) {
            log.error(re.getMessage());
            return ToDoConstants.FAILURE.toString();
        }
        return ToDoConstants.DELETED.toString();
    }

    /**
     * createNewTime
     *
     * @return
     */
    public String createNewTime() {
        SimpleDateFormat sf = new SimpleDateFormat(PATTERN);
        return sf.format(new Date());
    }
}
