package com.krishna;

import jakarta.persistence.*;

@Entity
public class Answer1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Answer1_id;

    // Remove unique constraint if not needed, or make it explicitly unique if required
    @Column(name = "Answer1")
    private String Answer1;

    @ManyToOne
    @JoinColumn(name = "Question1_id")
    private Question1 Question1;

    public int getAnswer1_id() {
        return Answer1_id;
    }

    public void setAnswer1_id(int Answer1_id) {
        this.Answer1_id = Answer1_id;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String Answer1) {
        this.Answer1 = Answer1;
    }

    public Question1 getQuestion1() {
        return Question1;
    }

    public void setQuestion1(Question1 Question1) {
        this.Question1 = Question1;
    }
}