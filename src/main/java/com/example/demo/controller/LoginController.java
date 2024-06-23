
package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    //Initialization of map of users
    private static final Map<String, User> users = new HashMap<>();

    //Adding of data into the map of users
    static {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    //Mapping for "/" to redirect to login view
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    //Mapping for login view
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //Session is started if authenticate returns true else redirect back to login view
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request) {

        if (authenticate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return "redirect:/home";
        } else {
            return "redirect:/login?error=true";
        }
    }

    //Mapping for home view redirected to login view if there no current user session
    @GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "home";
        } else {
            return "redirect:/login";
        }
    }

    //Authentication if entered credentials matches a key and pair value in the map
    private boolean authenticate(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }

    //Terminate user session and redirect back to login
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/login"; // Redirect to the login page
    }
}
