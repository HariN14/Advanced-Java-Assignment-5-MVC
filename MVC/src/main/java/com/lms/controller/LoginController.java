package com.lms.controller;

import com.lms.model.User;
import com.lms.resttemplate.BookTemplate;
import com.lms.resttemplate.UserTemplate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    UserTemplate userTemplate;

    @Autowired
    BookTemplate bookTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping(value = "/")
    public String showLoginPage(ModelMap model){
        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logOut(ModelMap model,HttpSession session){
        model.addAttribute("user",new User());
        session.setAttribute("loggedIn","no");
        return "redirect:/";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String backWelcome(ModelMap model,HttpSession session){
        model.addAttribute("products",bookTemplate.getBooks());
        System.out.println(session.getAttribute("loggedIn"));
        if(!session.getAttribute("loggedIn").equals("yes"))
            return "redirect:/";
        return "welcome";
    }

    @PostMapping(value = "/welcome")  //@RequestParam String userId, @RequestParam String password
    public String showWelcomePage(@ModelAttribute("user") User user, ModelMap model, @RequestParam String userId, @RequestParam String password, HttpSession session, BindingResult result){

        User currentUser = userTemplate.getUser(user.getUserId());
        if(!validateUser(user)){
            model.put("errorMessage","Invalid Credentials");
            return "redirect:/";
        }
        else {
            //model.addAttribute("username", userId);
            session.setAttribute("username",userId);
            session.setAttribute("loggedIn","yes");
            //model.addAttribute("products",bookAndAuthorController.getAllBookData());
            model.addAttribute("products",bookTemplate.getBooks());
            //model.addAttribute("author",authorService.listAllAuthor());

            return "welcome";
        }

    }

    public boolean validateUser(User user){
        Session session = sessionFactory.getCurrentSession();
        User currentUser = session.get(User.class, user.getUserId());
        if (user.getPassword().equals(currentUser.getPassword()) && user.getUserId().equals(currentUser.getUserId())) {
            return true;
        }
        return false;
    }

}
