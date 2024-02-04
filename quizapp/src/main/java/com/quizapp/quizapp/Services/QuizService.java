package com.quizapp.quizapp.Services;

import com.quizapp.quizapp.Quizz.Question;
import com.quizapp.quizapp.Quizz.QuestionWrapper;
import com.quizapp.quizapp.Quizz.Quiz;
import com.quizapp.quizapp.Quizz.Responses;
import com.quizapp.quizapp.quizdao.Questiondao;
import com.quizapp.quizapp.quizdao.Quizdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    Quizdao quizdao;
    @Autowired
    Questiondao questiondao;

    public ResponseEntity<String> createquiz(String category, int numq, String title) {
        List<Question> list = questiondao.findrandomquestionbycategory(category, numq);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(list);
        quizdao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getquizquestion(Integer id) {

        Optional<Quiz> quiz = quizdao.findById(id);
        List<Question> ls = quiz.get().getQuestionList();
        List<QuestionWrapper> lt = new ArrayList<>();
        for (Question q : ls) {
            QuestionWrapper qs = new QuestionWrapper(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            lt.add(qs);
        }


    }
  public  ResponseEntity<Integer> calculateresult(Integer id,List<Responses> responses){
        Quiz quiz=quizdao.findById(id).get();
        List<Question> questions=quiz.getQuestionList();
        int right=0;
        int i=0;
        for(Responses responses1:responses){
            if(responses1.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
  }
}
