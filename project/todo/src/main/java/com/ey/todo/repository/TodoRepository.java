package com.ey.todo.repository;

import com.ey.todo.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    private List<TodoItem> todoItems = null;
    private Integer idCounter = 1;
    public List<TodoItem> fetchAllTodoItems(){
        if(todoItems ==null){
            todoItems = new ArrayList<TodoItem>();
            TodoItem todoItem = new TodoItem();
            todoItem.setId(idCounter++);
            todoItem.setDone(true);
            todoItem.setTask("Task #1");
            todoItems.add(todoItem);
        }
        return todoItems;
    }

    public TodoItem save(TodoItem item) {
        item.setId(idCounter++);
        todoItems.add(item);
        return item;
    }

    public void deleteTodoItem(Integer id) {
        todoItems = todoItems!=null?todoItems.stream()
                    .filter(delItem -> !delItem.getId().equals(id))
                    .collect(Collectors.toList()):null;

    }
}
