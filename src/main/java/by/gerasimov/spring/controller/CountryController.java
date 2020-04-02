package by.gerasimov.spring.controller;

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
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public String main(Map<String, Object> model) {
        model.put("countries", countryRepository.findAll());
        return "countries";
    }

    @PostMapping("/countries")
    public String add(@RequestParam String name, @RequestParam String tag, Map<String, Object> model) {
        Country country = new Country(name, tag);
        countryRepository.save(country);
        model.put("countries", countryRepository.findAll());
        return "countries";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        if (filter != null && !filter.isEmpty()) {
            model.put("countries", countryRepository.findByNameContaining(filter));
        } else {
            model.put("countries", countryRepository.findAll());
        }
        return "countries";
    }
}
