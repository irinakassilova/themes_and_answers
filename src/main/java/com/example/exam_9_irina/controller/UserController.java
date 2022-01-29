package com.example.exam_9_irina.controller;

import com.example.exam_9_irina.model.form.UserRegisterForm;
import com.example.exam_9_irina.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model){
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserRegisterForm());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerPage(@Valid UserRegisterForm userRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("user", userRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect: /register";
        }

        userService.register(userRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        var user = userService.getByEmail(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }
}


