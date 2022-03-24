package com.lms.controller;

import com.lms.model.Book;
import com.lms.model.User;
import com.lms.resttemplate.AuthorTemplate;
import com.lms.resttemplate.BookTemplate;
import com.lms.resttemplate.UserTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MainController {

    @Autowired
    private BookTemplate bookTemplate;

    @Autowired
    private UserTemplate userTemplate;

    @Autowired
    private AuthorTemplate authorTemplate;


    @RequestMapping(value = "/addNew")
    public String addPage(ModelMap model){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();
        String date = formatter.format(today);
        Book book = new Book();
        model.addAttribute("date",date);
        model.addAttribute("book",book);
        model.addAttribute("author",authorTemplate.getAuthors());

        return "newEntry";
    }

    @GetMapping(value = "/addNew")
    public String showLoginPage(ModelMap model){
        model.addAttribute("user",new User());
        return "login";
    }

    /*@GetMapping(value = "/edit/{id}")
    public String editPage(ModelMap model, @PathVariable long id){
        System.out.println(id);
        //Book book = bookRepository.getById(id);
        //model.addAttribute("book",book);
        return "editEntry";
    }*/
}
