package com.ey.todo.service;

import com.ey.todo.domain.TodoItem;
import com.ey.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> fetchAllTodoItems(){
        return todoRepository.fetchAllTodoItems();
    }

    public TodoItem updateTodoItems(Integer id, TodoItem todoItem) {
        TodoItem item = null;
        Optional<TodoItem> todoItemDB = todoRepository.fetchAllTodoItems().stream()
                .filter(todo -> todo.getId().equals(id))
                .findAny();
        if(todoItemDB.isPresent()){
            item = todoItemDB.get();
            item.setDone(todoItem.getDone());
            item.setTask(todoItem.getTask());
        }
        return item;
    }

    public TodoItem createNewTodoItems() {
        TodoItem item = new TodoItem();
        item.setDone(false);
        todoRepository.save(item);
        item.setTask("Task #"+item.getId());
        return item;
    }

    public void deleteTodoItem(Integer id) {
        todoRepository.deleteTodoItem(id);
    }
}
