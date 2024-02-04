package com.quizapp.quizapp.quizdao;

import com.quizapp.quizapp.Quizz.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Questiondao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM question_table q WHERE q.category=:category ORDER BY Rand() LIMIT :numq",nativeQuery=true)
    List<Question> findrandomquestionbycategory(String category, int numq);
}
