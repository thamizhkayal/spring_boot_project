package com.hd.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.app.model.Todo;
import com.hd.app.service.TodoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController("todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodo();
    }

    @PostMapping("todo")
    public Todo addTodo(@RequestBody Todo todo) {

        return todoService.addTodo(todo);
    }

    @PostMapping("todos")
    public List<Todo> addTodos(@RequestBody List<Todo> todos) {
        return todoService.addTodos(todos);
    }

    @PutMapping("todo/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable int id, @RequestBody Todo newTodo) {
        Todo updatedTodo = todoService.updateTodo(id, newTodo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted by id : " + id);

    }

}
