package com.example.gamquest.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j

public class Data {
    public Map<Integer, Question> getQuestions() {
        return questions;
    }


    public Data(Map<Integer, Question> questions, Map<Integer, Answer> answers) {
        this.questions = questions;
        this.answers = answers;
    }
    public Map<Integer, Answer> getAnswers() {
        return answers;
    }
    private Map<Integer, Question> questions;
    private Map<Integer, Answer> answers;
}

