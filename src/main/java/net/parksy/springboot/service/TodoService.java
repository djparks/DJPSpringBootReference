package net.parksy.springboot.service;

import net.parksy.springboot.model.Todo;
import net.parksy.springboot.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);
    private final String DASHBOARD_API_URL = "http://localhost:8081/api/dashboard/todos";
    private final TodoRepository repository;
    private final RestTemplate restTemplate;

    public TodoService(TodoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo findById(int id) {
        return repository.findById(id);
    }

    public void saveAll(List<Todo> todos) {
        repository.saveAll(todos);
    }

    public void save(Todo todo) {
        repository.save(todo);
    }

    public int delete(Integer id) {
        return repository.delete(id);
    }

}
