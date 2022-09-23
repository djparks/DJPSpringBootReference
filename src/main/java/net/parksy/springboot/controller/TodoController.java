package net.parksy.springboot.controller;

import net.parksy.springboot.model.Todo;
import net.parksy.springboot.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;
    private final RestTemplate restTemplate;

    public TodoController(TodoService todoService, RestTemplate restTemplate) {
        this.todoService = todoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Todo> getTodo(@PathVariable int id) {
        return todoService.findById(id);
    }

}
