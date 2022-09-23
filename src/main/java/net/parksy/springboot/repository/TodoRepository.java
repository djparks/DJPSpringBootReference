package net.parksy.springboot.repository;

import net.parksy.springboot.model.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo,Integer> {

}
