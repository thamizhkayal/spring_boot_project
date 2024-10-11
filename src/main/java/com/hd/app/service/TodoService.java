package com.hd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.app.exceptions.NotFoundException;
import com.hd.app.model.Todo;
import com.hd.app.model.User;
import com.hd.app.repository.TodoRepository;
import com.hd.app.repository.UserRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Todo> getAllTodo(int userId) {
        return todoRepo.findByUserId(userId);
    }

    public Todo getTodoById(int id) {
        return todoRepo.findById(id).orElseThrow(() -> new NotFoundException("Todo Not Found by this id : " + id));
    }

    public Todo addTodo(int userId, Todo todo) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User Not Found || Id : " + userId));
        todo.setUser(user);
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
