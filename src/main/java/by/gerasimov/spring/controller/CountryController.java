package by.gerasimov.spring.controller;

import by.gerasimov.spring.model.Country;
import by.gerasimov.spring.model.User;
import by.gerasimov.spring.repository.CountryRepository;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${country.flags}")
    private String countryFlags;

    @GetMapping("/countries")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Country> countries;
        if (filter != null && !filter.isEmpty()) {
            countries = countryRepository.findByNameContaining(filter);
        } else {
            countries = countryRepository.findAll();
        }
        model.addAttribute("countries", countries);
        model.addAttribute("filter", filter);
        return "countries";
    }

    @PostMapping("/countries")
    public String add(
        @AuthenticationPrincipal User user, @RequestParam String name, @RequestParam String tag,
        @RequestParam("file") MultipartFile file
    ) throws IOException {
        Country country = new Country(name, tag, user);
        if (file != null && makeDirExists()) {
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + countryFlags + "/" + resultFileName));
            country.setFlagFileName(resultFileName);
        }
        countryRepository.save(country);
        return "redirect:/countries";
    }

    private boolean makeDirExists() {
        File uploadDir = new File(uploadPath + countryFlags);
        if (!uploadDir.exists()) {
            return uploadDir.mkdirs();
        }
        return true;
    }
}
