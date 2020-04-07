package by.gerasimov.spring.controller;

import by.gerasimov.spring.model.Country;
import by.gerasimov.spring.model.User;
import by.gerasimov.spring.repository.CountryRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Map<String, Object> model) {
        Iterable<Country> countries;
        if (filter != null && !filter.isEmpty()) {
            countries = countryRepository.findByNameContaining(filter);
        } else {
            countries = countryRepository.findAll();
        }
        model.put("countries", countries);
        model.put("filter", filter);
        return "countries";
    }

    @PostMapping("/countries")
    public String add(
        @AuthenticationPrincipal User user, @RequestParam String name, @RequestParam String tag,
        Map<String, Object> model) {
        Country country = new Country(name, tag, user);
        countryRepository.save(country);
        model.put("countries", countryRepository.findAll());
        return "countries";
    }
}
