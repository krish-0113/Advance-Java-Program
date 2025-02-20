package com.krishna;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question1_id;

    private String question1s;

    @OneToMany(mappedBy = "question1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer1> answers = new ArrayList<>();

    // Helper method to maintain bidirectional relationship
    public void addAnswer(Answer1 answer) {
        this.answers.add(answer);
        answer.setQuestion1(this);
    }

    public List<Answer1> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer1> answers) {
        this.answers = answers;
    }

    public int getQuestion1_id() {
        return question1_id;
    }

    public void setQuestion1_id(int question1_id) {
        this.question1_id = question1_id;
    }

    public String getQuestion1s() {
        return question1s;
    }

    public void setQuestion1s(String question1s) {
        this.question1s = question1s;
    }
}
