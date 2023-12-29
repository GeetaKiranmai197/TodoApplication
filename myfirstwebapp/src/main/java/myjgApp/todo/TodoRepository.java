package myjgApp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {// it should wrap the bean name and the primary key data type
 public List<Todo> findByUsername(String username);
}
