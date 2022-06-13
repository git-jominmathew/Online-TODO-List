package com.ey.todo.service;
/**
 * @author : jomin mathew
 * TodoService
 */

import com.ey.todo.model.TodoItem;
import com.ey.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    /**
     * method to get all the items
     * @return
     */
    public List<TodoItem> fetchAllTodoItems(){
        return (List<TodoItem>) todoRepository.findAll();
    }

    /**
     * method to update To-do Items
     * @param id
     * @param todoItem
     * @return
     */
    public TodoItem updateTodoItems(Integer id, TodoItem todoItem) {
        TodoItem savedToDo = null;
        Optional<TodoItem>  toDoOp = todoRepository.findById(id);
        if(toDoOp.isPresent()){
            savedToDo = toDoOp.get();
            savedToDo.setDone(todoItem.getDone());
            savedToDo.setTask(todoItem.getTask());
            todoRepository.save(savedToDo);
        }
        return savedToDo;
    }

    /**
     * method to create New Todo Items
     * @param todoItem
     * @return
     */
    public int createNewTodoItems(TodoItem todoItem) {
        todoRepository.save(todoItem);
        return todoItem.getId() ;
    }

    /**
     * method to delete TodoItem
     * @param id
     */
    public void deleteTodoItem(Integer id) {
        todoRepository.deleteById(id);
    }
}
