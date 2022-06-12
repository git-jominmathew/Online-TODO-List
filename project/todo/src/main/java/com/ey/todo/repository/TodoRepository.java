package com.ey.todo.repository;

import com.ey.todo.model.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends CrudRepository<TodoItem,Integer> {


}
