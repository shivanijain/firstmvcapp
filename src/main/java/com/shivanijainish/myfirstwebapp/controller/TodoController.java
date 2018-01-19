package com.shivanijainish.myfirstwebapp.controller;

import com.shivanijainish.myfirstwebapp.com.shivanijainish.myfirstwebapp.model.Todo;
import com.shivanijainish.myfirstwebapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    ToDoService service;

    @RequestMapping(value="/list-todo", method = RequestMethod.GET)
    public String listTodo(ModelMap m ) {
        String username = ( String ) m.get("name");
        List<Todo> td = service.getTodos( username );
        m.put( "lists", td );
        return "todolist";
    }

    @RequestMapping("/add-todo")
    public String AddTodo(ModelMap m ) {
        m.addAttribute( "todo", new Todo(0, ( String ) m.get("name"), "", new Date(), false ) );
        return "addtodo";
    }

    @RequestMapping(value="/insert-todo", method = RequestMethod.POST)
    public String insertTodo(ModelMap m, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()) {
            return "addtodo";
        }
        service.addTodo( ( String )m.get("name"), todo.getDesc(), new Date());
        return "redirect:/list-todo";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        service.removeTodo(id);
        return "redirect:/list-todo";
    }
}
