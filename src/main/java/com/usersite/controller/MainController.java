package com.usersite.controller;

import com.usersite.model.User;
import com.usersite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index(Model model){
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("users", allUsers);
        return "index";
    }

    @GetMapping("/add")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        System.out.println(user.getId());
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        System.out.println(user);
        System.out.println(user.getId());
        if(user.getId() == null) {
            service.saveUser(user);
        } else {
            service.updateUser(user);
        }
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUSer(@RequestParam("id") int id){
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") int id, Model model){
        User user = service.findById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user-info";
    }
}
