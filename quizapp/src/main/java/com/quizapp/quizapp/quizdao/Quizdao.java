package com.quizapp.quizapp.quizdao;

import com.quizapp.quizapp.Quizz.Question;
import com.quizapp.quizapp.Quizz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Quizdao extends JpaRepository<Quiz,Integer> {



    }

