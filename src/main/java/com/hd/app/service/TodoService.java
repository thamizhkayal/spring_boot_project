package com.hd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.app.model.Todo;
import com.hd.app.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    public List<Todo> getAllTodo() {
        return todoRepo.findAll();
    }

    public Todo addTodo(Todo todo) {

        return todoRepo.save(todo);
    }

}
