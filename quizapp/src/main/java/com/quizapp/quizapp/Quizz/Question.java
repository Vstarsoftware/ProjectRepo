package com.quizapp.quizapp.Quizz;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question_table")
public class Question {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "question_title")
    private String questiontitle;
    @Column(name = "option1")
    private String option1;
    @Column(name="option2")
    private String option2;
    @Column(name="option3")
    private String option3;
    @Column(name = "option4")
    private String option4;
    @Column(name = "right_answer")
    private  String rightAnswer;
    @Column(name="difficulty_level")
    private String difficultylevel;
    @Column(name="category")
    private String category;


    @Override
    public String toString() {
        return "Quiz{" +
                "Id=" + Id +
                ", questiontitle='" + questiontitle + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", difficultylevel='" + difficultylevel + '\'' +
                '}';
    }
}
