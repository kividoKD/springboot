package com.example.springboot.controllers;


import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(@RequestParam(value = "count", defaultValue = "5") String count,
                            ModelMap model) {
        model.addAttribute("count", count);
        model.addAttribute("users", userService.getListUsers());

        return "users/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setId(id);
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
