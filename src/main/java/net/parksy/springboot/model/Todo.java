package net.parksy.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Data
public class Todo {
    @Id Integer id;
    Integer userId;
    String title;
    boolean completed;
    @Version Integer version;
}
