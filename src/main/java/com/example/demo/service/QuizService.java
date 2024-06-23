package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface QuizService {
    //Returns the grade of the user after taking the quiz
    Map<String, Object> gradeQuiz(String username, Map<String, String> answers);
    //Returns all the quiz results for each user
    List<Map<String, Object>> getAllQuizResults();
}
