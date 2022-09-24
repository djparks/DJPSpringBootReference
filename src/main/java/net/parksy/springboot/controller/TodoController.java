package net.parksy.springboot.controller;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import net.parksy.springboot.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.parksy.springboot.model.Todo;

@Slf4j
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
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
                return new ResponseEntity<>("Cannot find Todo with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Todo was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete Todo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/")
    public Todo create(@RequestBody Todo todo) {
        todoService.save(todo);
        return todo;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable("id") Integer id, @RequestBody String description) {
        Optional<Todo> todo = todoService.findById(id);
        log.info("Todo before change {}", todo.toString());

        if (todo.isPresent()) {
            Todo _todo = todo.get();
            _todo.setTitle(description);
            if(_todo.getVersion() == null) {
                _todo.setVersion(1);
            } else {
                _todo.setVersion(_todo.getVersion() + 1);
            }

            todoService.save(_todo);
            log.info("Todo after change {}", todo.toString());
            return new ResponseEntity<>("Todo was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Todo with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
}
