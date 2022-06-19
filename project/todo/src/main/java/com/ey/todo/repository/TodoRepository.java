package com.ey.todo.repository;

import com.ey.todo.model.ToDoEntiy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<ToDoEntiy,Integer> {
    List<ToDoEntiy> findAllByUserId(Integer userId);
    List<ToDoEntiy> findAllByUserUserName(String name);

}
