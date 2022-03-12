package za.ac.cput.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.ac.cput.app.service.UserService;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/27/2022 | 12:40 PM
 *
 * <p>Project spring-security-basics</p>
 */
@Controller
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping("/user")
    public String registration(Model model) {
        return "user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}