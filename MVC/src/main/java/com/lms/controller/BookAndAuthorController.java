package com.lms.controller;

import com.lms.exceptions.BookNotFoundException;
import com.lms.model.Book;
import com.lms.resttemplate.AuthorTemplate;
import com.lms.resttemplate.BookTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
//@RequestMapping("/api/book")
@Controller
public class BookAndAuthorController {

    @Autowired
    private BookTemplate bookTemplate;

    @Autowired
    private AuthorTemplate authorTemplate;


    @PostMapping("/add")
    public String saveBook(RedirectAttributes redirectAttributes){
        //bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Added Successfully!");
        return "redirect:/welcome";
    }

    @PostMapping("/edit/update")
    public String updateBook(@ModelAttribute("book")Book book, RedirectAttributes redirectAttributes,@PathVariable("id")Long id) throws BookNotFoundException {
        bookTemplate.editBook(book);
        redirectAttributes.addFlashAttribute("message","Updated Successfully!");
        return "redirect:/welcome";
    }

    @GetMapping("/edit")
    public String showEditForm(@PathVariable("id")Long id, ModelMap model, RedirectAttributes redirectAttributes) {
        Book book = bookTemplate.getBook(id);
        model.addAttribute("book",book);
        model.addAttribute("author",authorTemplate.getAuthors());

        return "editEntry";

    }

    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable("id")Long id, RedirectAttributes redirectAttributes){
        bookTemplate.deleteBook(id);
        return "redirect:/welcome";
    }







}
