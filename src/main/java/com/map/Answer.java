package com.map;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {
    @Id
    private int answerId;
    private String answer;

    // Getters and setters...

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
