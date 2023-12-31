package web.pp_3_1_2_spring_boot.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.pp_3_1_2_spring_boot.model.User;
import web.pp_3_1_2_spring_boot.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/saveOrUpdateUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (!result.hasErrors()) {
            service.addOrUpdateUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "edit";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        service.deleteUser(service.getById(id));
        return "redirect:/users";
    }
}