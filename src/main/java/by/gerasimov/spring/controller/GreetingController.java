package by.gerasimov.spring.controller;

import by.gerasimov.spring.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(
        @AuthenticationPrincipal User user,
        @RequestParam(name = "name", required = false, defaultValue = "User") String name, Model model) {
        model.addAttribute("name", user != null ? user.getUsername() : name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getUsername());
        return "main";
    }
}