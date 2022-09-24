package net.parksy.springboot.repository;

import net.parksy.springboot.model.Todo;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository  {

    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    @Override
    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * from Todo", BeanPropertyRowMapper.newInstance(Todo.class));
    }

//    @Override
    public Todo findById(int id) {
        try {

            return jdbcTemplate.queryForObject("SELECT * FROM Todo WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Todo.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public int save(Todo todo) {
        return jdbcTemplate.update("INSERT INTO Todo (id, user_id, title, completed, version) VALUES(?,?,?,?,?)",
                todo.getId(), todo.getUserId(), todo.getTitle(), todo.isCompleted(), todo.getVersion());
    }

    public void saveAll(List<Todo> todos) {
        for (Todo todo: todos) {
            save(todo);
        }
    }

    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM Todo WHERE id=?", id);
    }

}
