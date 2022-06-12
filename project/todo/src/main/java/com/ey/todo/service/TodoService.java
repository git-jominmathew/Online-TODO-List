package com.ey.todo.service;

import com.ey.todo.model.TodoItem;
import com.ey.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> fetchAllTodoItems(){
        List<TodoItem> todoItems = (List<TodoItem>) todoRepository.findAll();
        if(todoItems ==null){
            todoItems = new ArrayList<>();
            TodoItem todoItem = new TodoItem();
           // todoItem.setId(idCounter++);
            todoItem.setDone(true);
            todoItem.setTask("Task #1");
            todoItems.add(todoItem);
        }
        return todoItems;
    }

    public TodoItem updateTodoItems(Integer id, TodoItem todoItem) {
        TodoItem item = null;
        Optional<TodoItem>  toDoOp = todoRepository.findById(id);
        TodoItem savedToDo = toDoOp.get();
        savedToDo.setDone(todoItem.getDone());
        savedToDo.setTask(todoItem.getTask());
        todoRepository.save(savedToDo);
        return savedToDo;
    }

    public int createNewTodoItems(TodoItem todoItem) {
        todoRepository.save(todoItem);
        return todoItem.getId() ;
    }

    public void deleteTodoItem(Integer id) {
        todoRepository.deleteById(id);
    }
}
