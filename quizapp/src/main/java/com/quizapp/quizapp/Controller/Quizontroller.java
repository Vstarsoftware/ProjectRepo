package com.quizapp.quizapp.Controller;

import com.quizapp.quizapp.Quizz.Question;
import com.quizapp.quizapp.Quizz.QuestionWrapper;
import com.quizapp.quizapp.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Quizontroller {
    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numq,@RequestParam String title){
     return  quizService.createquiz(category,numq,title);
     @GetMapping("/get/{id}")
             public ResponseEntity<List<QuestionWrapper>> getquizquestion(@PathVariable Integer id){
         return quizService.getquizquestion(id);
        }
        @PostMapping("/submit/{id}")
                public ResponseEntity<Integer> submitquiz(@PathVariable Integer id ,@RequestBody  List<Responses> responses){
         return quizService.calculateresult(id,responses);
        }
    }

}
