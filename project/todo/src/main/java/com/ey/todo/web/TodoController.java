package com.ey.todo.web;

import com.ey.todo.domain.TodoItem;
import com.ey.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//regular controller vs controller
//controller returns a view only
public class TodoController {

    @Autowired
    private TodoService todoService;

    //fetch all to_do items from database
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems(){
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();
        return ResponseEntity.status(HttpStatus.OK).body(todoItems);
    }

    @PutMapping("/api/todoItems/{id}")
    public ResponseEntity<?> updateTodoItems(@PathVariable Integer id , @RequestBody TodoItem todoItem){
        //call service . get data back from server .
        TodoItem item = todoService.updateTodoItems(id,todoItem);
        //send it back to front end
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @PostMapping(value = "/api/todoItems")
    public ResponseEntity<?> createNewTodoItems(){
        TodoItem item = todoService.createNewTodoItems();
        return ResponseEntity.ok(item);
    }
    @DeleteMapping(value="/api/deleteTodoItems/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Integer id){
    todoService.deleteTodoItem(id);
    return  ResponseEntity.ok("ok");
    }
}
