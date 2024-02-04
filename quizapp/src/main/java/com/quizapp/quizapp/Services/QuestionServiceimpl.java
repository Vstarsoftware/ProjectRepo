package com.quizapp.quizapp.Services;

import com.quizapp.quizapp.Quizz.Question;
import com.quizapp.quizapp.quizdao.Questiondao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceimpl implements QuestionService {
    @Autowired
    Questiondao quizdao;
    @Override
    public List<Question> getallquestions() {
        return quizdao.findAll();
    }

    @Override
    public List<Question> getallquestionsbycategory(String category) {
      return quizdao.findByCategory(category);
    }

    @Override
    public void addquestion(Question quiz) {
        quizdao.save(quiz);
    }
}
