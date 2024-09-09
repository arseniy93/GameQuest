package com.example.gamquest.model;

import java.util.List;

public class Question extends Words {
    public int id;
    public String question;
    public List<Integer> answer;
    public Boolean success;

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                ", success=" + success +
                '}';
    }

    public Question(int id, String questions, List<Integer> answer, boolean success) {
        this.id = id;
        this.question = questions;
        this.answer = answer;
        this.success = success;
    }

    public Question() {
    }

    public int getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<Integer> getAnswerList() {
        return this.answer;
    }


    public boolean isSuccess() {
        return this.success;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }
}