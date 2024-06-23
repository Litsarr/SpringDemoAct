package com.example.demo.controller;

import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultsController {

    @Autowired
    private QuizService quizService;

    // Mapping for results view and gets the values stored in the quizResults
    @GetMapping("/results")
    public String showResults(Model model) {
        model.addAttribute("quizResults", quizService.getAllQuizResults());
        return "results";
    }
}
