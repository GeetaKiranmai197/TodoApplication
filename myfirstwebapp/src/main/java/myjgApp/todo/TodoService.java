package myjgApp.todo;

import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService{
    private static int todosCount = 0;
    private static final List<Todo> todos = new ArrayList<>();
    static{
        todos.add(new Todo(++todosCount,"geeta","Learn SpringBoot", LocalDate.now().plusMonths(3),false));
        todos.add(new Todo(++todosCount,"geeta","Learn Full Stack Development", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"geeta","Learn Azure", LocalDate.now().plusWeeks(6),true));
        todos.add(new Todo(++todosCount,"jay","Learn ML", LocalDate.now().plusWeeks(6),true));
        todos.add(new Todo(++todosCount,"jay","Learn how to behavior properly when roommate is not there", LocalDate.now().plusWeeks(6),true));
        todos.add(new Todo(++todosCount,"jay","Buy Helicopter inspired by animal movie", LocalDate.now().plusWeeks(6),false));
        todos.add(new Todo(++todosCount,"jay","Must start believing and having faith in geeta", LocalDate.now().plusDays(1),true));

    }
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
    public void addTodo(String username, String description, LocalDate targetDate,boolean done){
       Todo todo = new Todo(++todosCount,username,description,targetDate,done); // new obj for new todo in list of todos
       todos.add(todo); //this will print the added new todo
    }
    public void deleteById(int id){
        // so the approach is todo.getId()==id
        // we use Lambda Function todo->todo.getId()==id
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        todos.removeIf(predicate);
    }
    public static Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }


}
