package com.hd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.app.exceptions.NotFoundException;
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

    public List<Todo> addTodos(List<Todo> todos) {
        return todoRepo.saveAll(todos);
    }

    public Todo updateTodo(int id, Todo newTodo) {

        return todoRepo.findById(id).map(todo -> {
            todo.setName(newTodo.getName());
            todo.setDescription(newTodo.getDescription());
            todo.setDueDate(newTodo.getDueDate());
            todo.setCompleted(newTodo.isCompleted());
            return todoRepo.save(todo);
        })
                .orElseThrow(() -> new NotFoundException("Todo not found with id " + id));
    }

    public void deleteTodo(int id) {
        if (todoRepo.existsById(id)) {
            todoRepo.deleteById(id);
        } else {
            throw new NotFoundException("Todo not found in this id : " + id);
        }

    }

}
