package com.quizapp.quizapp.Quizz;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="quiz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name="id")
    private String Id;
  //  @Column(name="title")
    private  String Title;
    @ManyToMany
    private List<Question> questionList;


}
