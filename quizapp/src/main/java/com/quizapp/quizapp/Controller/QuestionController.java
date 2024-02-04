package com.quizapp.quizapp.Controller;

import com.quizapp.quizapp.Quizz.Question;
import com.quizapp.quizapp.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app")
public class QuestionController {
    @Autowired
    QuestionService quizService;
   @GetMapping("/allques")
    public ResponseEntity<List<Question>> getallquestion(){
       try {
           return new ResponseEntity<>(quizService.getallquestions(), HttpStatus.OK);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
   }
    @GetMapping("/ques/{category}")
    public ResponseEntity<List<Question>> getallquestionbycategory(@PathVariable String category){
       try {
           return new ResponseEntity<>(quizService.getallquestionsbycategory(category),HttpStatus.OK);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
       }
    @PostMapping("/add")
    public ResponseEntity<String> addquestion(@RequestBody Question quiz){

          quizService.addquestion(quiz);

       return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

}
