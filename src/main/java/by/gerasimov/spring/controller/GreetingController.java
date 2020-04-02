package by.gerasimov.spring.controller;

import by.gerasimov.spring.model.User;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(
        @AuthenticationPrincipal User user,
        @RequestParam(name = "name", required = false, defaultValue = "User") String name, Map<String, Object> model) {
        model.put("name", user != null ? user.getUsername() : name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model) {
        model.put("username", user.getUsername());
        return "main";
    }
}