package com.quizapp.quizapp.Services;

import com.quizapp.quizapp.Quizz.Question;

import java.util.List;

public interface QuestionService {
List<Question> getallquestions();
List<Question> getallquestionsbycategory(String category);

void addquestion(Question quiz);
}
