package com.ey.todo.web;

import com.ey.todo.dto.TodoItem;
import com.ey.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * to-do controller
 */
@RestController
public class TodoController {

    Logger log = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;

    /**
     * fetch All To-do Items
     *
     * @return
     */
    @GetMapping("/get")
    public List<TodoItem> fetchAllTodoItems() {
        log.info("TodoController:fetchAllTodoItems");
        return todoService.fetchAllTodoItems();
    }

    /**
     * update To-do Items
     *
     * @param id
     * @param todoItem
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTodoItems(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
        log.info("TodoController:updateTodoItems");
        todoItem =  todoService.updateTodoItems(id, todoItem);
        if(todoItem!=null){
            return ResponseEntity.ok(todoItem);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * create New To-do Items
     *
     * @param todoItem
     * @return
     */
    @PostMapping(value = "/save")
    public String createNewTodoItems(@RequestBody TodoItem todoItem) {
        log.info("TodoController:createNewTodoItems");
        return todoService.createNewTodoItems(todoItem);
    }

    /**
     * delete To-do Items
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public String deleteTodoItem(@PathVariable Integer id) {
        log.info("TodoController:deleteTodoItem");
        return  todoService.deleteTodoItem(id);
    }
}
