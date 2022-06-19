package com.ey.todo.web;

import com.ey.todo.TodoApplication;
import com.ey.todo.constants.ToDoConstants;
import com.ey.todo.dto.TodoItem;
import com.ey.todo.repository.TodoRepository;
import com.ey.todo.service.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodoApplication.class)
class TodoControllerTest {
    @InjectMocks
    private TodoController todoController;

    @Mock
    private TodoService service;
    @Mock
    TodoRepository todoRepository;

    /*@Test
    void fetchAllTodoItems() {
        List<TodoItem> list = new ArrayList<>();
        TodoItem todoItem = new TodoItem();
        todoItem.setTask("task1");
        list.add(todoItem);
        when(service.fetchAllTodoItems()).thenReturn(list);
        List<TodoItem> ret = todoController.fetchAllTodoItems();
        Assertions.assertThat(ret).isEqualTo(list);
    }

    @Test
    void updateTodoItems() {
        TodoItem todoItem = new TodoItem();
        todoItem.setTask("");
        when(service.updateTodoItems(any(),any(TodoItem.class))).thenReturn(todoItem);
        ResponseEntity<?> responseEntity  = todoController.updateTodoItems(1,todoItem);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(todoItem);
    }

    @Test
    void createNewTodoItems() {
        TodoItem todoItem = new TodoItem();
        todoItem.setTask("");
        when(service.createNewTodoItems(any(TodoItem.class))).thenReturn(ToDoConstants.SUCCESS.toString());
        String status =todoController.createNewTodoItems(todoItem);
        Assertions.assertThat(status).isEqualTo(ToDoConstants.SUCCESS.toString());

        when(service.createNewTodoItems(any(TodoItem.class))).thenReturn(ToDoConstants.FAILURE.toString());
        status =todoController.createNewTodoItems(todoItem);
        Assertions.assertThat(status).isEqualTo(ToDoConstants.FAILURE.toString());
    }

    @Test
    void deleteTodoItem() {
        when(service.deleteTodoItem(any())).thenReturn(ToDoConstants.DELETED.toString());
        String ret = todoController.deleteTodoItem(1);
        Assertions.assertThat(ret).isEqualTo(ToDoConstants.DELETED.toString());
    }*/
}