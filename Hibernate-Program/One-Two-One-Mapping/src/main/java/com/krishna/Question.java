package com.krishna;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    private int question_id;
    private String questions;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL) // Bidirectional mapping
    private Answer answer;


    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        answer.setQuestion(this);  // Ensure bidirectional link
    }
}
