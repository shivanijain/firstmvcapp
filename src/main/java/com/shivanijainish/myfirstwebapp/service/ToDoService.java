package com.shivanijainish.myfirstwebapp.service;


import com.shivanijainish.myfirstwebapp.com.shivanijainish.myfirstwebapp.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ToDoService {

    private static List<Todo> todo = new ArrayList<Todo>();

    static {
        todo.add( new Todo( 1,"Shivani","My first Todo", new Date(), false ) );
        todo.add( new Todo( 2,"Shivani","My Second Todo", new Date(), false ) );
        todo.add( new Todo( 3,"Rishu","My first Todo", new Date(), false ) );
    }

    public void addTodo( String username, String desc, Date targetdate ) {
        Todo td = new Todo(todo.size()+1, username, desc, targetdate, false);
        todo.add(td);
    }

    public void updateTodo( int id, String name, String desc, Date targetdate, boolean isDone ) {
        Todo td = new Todo( id, name, desc, targetdate, isDone );
        todo.add( id, td);
    }

    public void removeTodo( int id ) {
        Iterator<Todo> iterator = todo.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public List<Todo> getTodos( String username ) {
        List<Todo> filtertodo = new ArrayList<Todo>();
        for ( Todo usertodo: todo ) {
            if(usertodo.getName().equalsIgnoreCase(username) ) {
                filtertodo.add(usertodo);
            }
        }
        return filtertodo;
    }
}
