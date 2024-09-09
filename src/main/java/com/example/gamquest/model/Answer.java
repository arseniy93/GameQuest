package com.example.gamquest.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Answer extends Words {
    public Answer(int id, String question, int answer) {
        if(id<=0){
            log.error(" id is negative or 0");
            throw new IllegalArgumentException("id cannot be negative or 0");
        }
        if(Objects.isNull(question)){
            log.error("Name is null");
            throw new IllegalArgumentException("Name cannot be null.");
        }

        if(answer<0){
            log.error(" answerId is negative or 0");
            throw new IllegalArgumentException("answerId cannot be negative or 0");
        }


        this.id = id;

        this.question = question;

        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }

    public int id;
    public String question;
    public int answer;


    public int getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
