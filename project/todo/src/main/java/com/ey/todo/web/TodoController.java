package com.ey.todo.web;
/**
 * @author : jomin mathew
 * TodoController
 */
import com.ey.todo.model.TodoItem;
import com.ey.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * method to get all the items
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<?> fetchAllTodoItems(){
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();
        return ResponseEntity.status(HttpStatus.OK).body(todoItems);
    }

    /**
     * method to update items
     * @param id
     * @param todoItem
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTodoItems(@PathVariable Integer id , @RequestBody TodoItem todoItem){
        //call service . get data back from server .
        TodoItem item = todoService.updateTodoItems(id,todoItem);
        //send it back to front end
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    /**
     * method to save items
     * @param todoItem
     * @return
     */
    @PostMapping(value = "/save")
    public ResponseEntity<?> createNewTodoItems(@RequestBody TodoItem todoItem){
        todoService.createNewTodoItems(todoItem);
        return ResponseEntity.ok(todoItem);
    }

    /**
     * method to save items
     * @param id
     * @return
     */
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Integer id){
    todoService.deleteTodoItem(id);
    return  ResponseEntity.ok("ok");
    }
}
