package com.ey.todo.repository;

import com.ey.todo.model.ToDoEntiy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<ToDoEntiy,Integer> {
}
