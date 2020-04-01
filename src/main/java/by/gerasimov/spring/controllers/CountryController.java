package by.gerasimov.spring.controllers;

import by.gerasimov.spring.model.Country;
import by.gerasimov.spring.repository.CountryRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("countries", repository.findAll());
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String tag, Map<String, Object> model) {
        Country country = new Country(name, tag);
        repository.save(country);
        model.put("countries", repository.findAll());
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        if (filter == null || filter.isEmpty()) {
            model.put("countries", repository.findByNameContaining(filter));
        } else {
            model.put("countries", repository.findAll());
        }
        return "main";
    }
}
