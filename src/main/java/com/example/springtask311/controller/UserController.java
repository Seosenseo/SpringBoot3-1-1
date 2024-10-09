package com.example.springtask311.controller;


import com.example.springtask311.model.User;
import com.example.springtask311.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping("/users")
    public String listUsers(ModelMap model) {
        List<User> users = userServiceImp.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        User user = userServiceImp.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        userServiceImp.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userServiceImp.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/clear-table")
    public String showCleanUsersTable() {
        return "clear-table";
    }

    @PostMapping("/clear-table")
    public String cleanUsersTable() {
        userServiceImp.cleanUsersTable();
        return "users";
    }
}
