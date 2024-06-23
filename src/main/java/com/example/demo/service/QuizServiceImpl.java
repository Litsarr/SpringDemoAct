package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizServiceImpl implements QuizService {

    //Map to store quiz results, keyed by username
    private static final Map<String, Map<String, Object>> QUIZ_RESULTS = new HashMap<>();

    //Correct answers to the quiz
    private static final String[] CORRECT_ANSWERS = { "D", "C", "B", "C", "B" };

    //Retrieves all quiz results
    @Override
    public List<Map<String, Object>> getAllQuizResults() {
        return new ArrayList<>(QUIZ_RESULTS.values());
    }

    //Grades the user's quiz and replaces the value if they already have an existing record and if not record a new one
    @Override
    public Map<String, Object> gradeQuiz(String username, Map<String, String> answers) {
        int correctCount = 0;

        for (int i = 0; i < CORRECT_ANSWERS.length; i++) {
            if (answers.containsKey("ques" + (i + 1)) && answers.get("ques" + (i + 1)).equals(CORRECT_ANSWERS[i])) {
                correctCount++;
            }
        }

        double scorePercentage = ((double) correctCount / CORRECT_ANSWERS.length) * 100;

        Map<String, Object> result = new HashMap<>();
        result.put("username", username);
        result.put("correctCount", correctCount);
        result.put("scorePercentage", scorePercentage);

        // Check if user already has a quiz result stored
        if (QUIZ_RESULTS.containsKey(username)) {
            // Update existing result
            QUIZ_RESULTS.put(username, result);
        } else {
            // Add new result
            QUIZ_RESULTS.put(username, result);
        }


        return result;
    }
}
