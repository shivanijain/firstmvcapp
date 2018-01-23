package com.shivanijainish.myfirstwebapp.controller;

import com.shivanijainish.myfirstwebapp.com.shivanijainish.myfirstwebapp.model.Todo;
import com.shivanijainish.myfirstwebapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    ToDoService service;

    @InitBinder
    public void binder( WebDataBinder binder ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }
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
        service.addTodo( ( String )m.get("name"), todo.getDesc(), todo.getTargetDate());
        return "redirect:/list-todo";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        service.removeTodo(id);
        return "redirect:/list-todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap m) {
        Todo todo = service.getTodo( id );
        m.addAttribute("updatetodo", todo);
        return "updatetodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodoById(ModelMap m, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return result.getAllErrors().toString();
        }
        todo.setName((String) m.get("name"));
        service.updateTodo(todo);
        return "redirect:/list-todo";
    }
}
