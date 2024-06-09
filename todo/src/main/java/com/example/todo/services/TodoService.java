package com.example.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.todo.repositorys.TodoRepository;
import com.example.todo.models.Todo;

@Service
public class TodoService {
  //
  @Autowired 
  private TodoRepository todoRepository;

  //全てのTodoの値を返す
  public List<Todo> getTodo(){
    return todoRepository.findAll();
  }
  //特定のTodoの値を返す
  public Optional<Todo> getTodoById(Long id){
    return todoRepository.findById(id);
  }
  //データベースに保存する
  public Todo createTodo(Todo todo){
    return todoRepository.save(todo);
  }
  //Todoを変更する
  public Todo updateTodo(long id, Todo todoDetails){
    Optional<Todo> optionalTodo = getTodoById(id);
    if(!optionalTodo.isPresent()){
      throw new RuntimeException("Todo not found");
    }
    Todo todo = optionalTodo.get();
    todo.setTitle(todoDetails.getTitle());
    return todoRepository.save(todo);
  }
  //Todoを削除する
  public void deleteTodo(Long id){
    todoRepository.deleteById(id);
  }
}
