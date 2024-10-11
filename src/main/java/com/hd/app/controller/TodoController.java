package com.hd.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hd.app.dto.TodoDto;
import com.hd.app.model.Todo;
import com.hd.app.service.TodoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController("todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("todos/{userId}")
    public List<Todo> getAllTodos(@PathVariable int userId) {
        return todoService.getAllTodo(userId);
    }

    @GetMapping("todo/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @PostMapping("todo/{id}")
    public ResponseEntity<TodoDto> addTodo(@PathVariable int id, @RequestBody Todo newTodo) {
        Todo todo = todoService.addTodo(id, newTodo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId())
                .toUri();
        return ResponseEntity.created(location).body(new TodoDto(todo));
    }

    // @PostMapping("todos")
    // public List<Todo> addTodos(@RequestBody List<Todo> todos) {
    // return todoService.addTodos(todos);
    // }

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
