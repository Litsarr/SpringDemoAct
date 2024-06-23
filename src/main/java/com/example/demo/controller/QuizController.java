package com.example.demo.controller;

import com.example.demo.service.QuizService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    //Handles form submission in the quiz page gets the current session username else redirects to login and records the username of the session and their answers to be handled in the quizService
    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam Map<String, String> quizAnswers, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        quizService.gradeQuiz(username, quizAnswers);

        return "redirect:/results";
    }
}
