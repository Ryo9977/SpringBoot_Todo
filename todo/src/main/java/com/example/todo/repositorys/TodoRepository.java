package com.example.todo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
  
}
