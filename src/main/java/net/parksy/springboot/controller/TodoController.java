package net.parksy.springboot.controller;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import net.parksy.springboot.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.parksy.springboot.model.Todo;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;
    private final RestTemplate restTemplate;

    public TodoController(TodoService todoService, RestTemplate restTemplate) {
        this.todoService = todoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<Todo> getTodo(@PathVariable Integer id) {
        return todoService.findById(id);
    }


    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        try {
            int result = todoService.delete(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/")
    public Todo create(@RequestBody Todo todo) {
        todoService.save(todo);
        return todo;
    }

}
