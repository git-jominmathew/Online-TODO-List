package com.ey.todo.utility;

import com.ey.todo.dto.TodoItem;
import com.ey.todo.model.ToDoEntiy;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoMapper {

    /**
     * method to map Entity To DTO List
     * @param entiyList
     * @return
     */
    public static List<TodoItem> mapToDTO(List<ToDoEntiy> entiyList){
            return entiyList.stream()
                .map(TodoItem::new).collect(Collectors.toList());
    }
}
