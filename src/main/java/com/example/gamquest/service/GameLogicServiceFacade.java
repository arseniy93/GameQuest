package com.example.gamquest.service;


import com.example.gamquest.model.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLogicServiceFacade {
    private Map<Integer, Question> mapQuestions;
    private Map<Integer, Answer> mapAnswers;
    private JsonNode jsonNode;
    private GameLogic gameLogic;
    private InitializationOfObjects initializationOfObjects;
    private int lastQuestion;


    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameLogicServiceFacade() {
        JsonNode jsonNode = null;
        mapQuestions = new HashMap<>();
        mapAnswers = new HashMap<>();
        initializationOfObjects = new InitializationOfObjects();
        Data data = initializationOfObjects.initealizationFromJson(mapQuestions, mapAnswers, jsonNode);
        gameLogic = new GameLogic(mapQuestions, mapAnswers);
        initializationOfObjects.printObjectsFromJson(mapQuestions, mapAnswers);
        lastQuestion=initializationOfObjects.lastQuestion(data);
    }
    public int getLastQuestion(){
        return lastQuestion;
    }
    public Question getQuestion(int numberOfQuestions){
        return gameLogic.getQuestion(numberOfQuestions);
    }
    public String askQuestion(int nubmerOfQuestion){
        return gameLogic.askQuestion(nubmerOfQuestion);
    }
    public int getNumberOfQuestion(){
        return gameLogic.getNumberOfQuestion();
    }
    public List<Integer> getIdsOfAnswer(String question){
        return gameLogic.getIdsOfAnswer(question);
    }
    public int getQuantityOfLose(){
        return gameLogic.getQuantityOfLose();
    }
    public int getQuantityOfWin(){
        return gameLogic.getQuantityOfWin();
    }
    public void setNumberOfQuestion(int nubmerOfQuestion){
        gameLogic.setNumberOfQuestion(nubmerOfQuestion);
    }
    public Answer getAnswer(int setAnswer){
        return gameLogic.getAnswer(setAnswer);
    }
    public int getIdToQuestionOfIdAnswer(String answer){
        return gameLogic.getIdOfQuestion(answer);
    }
// обмен в json
//    public int getNumberOfQuestion(){
//        return gameLogic.getNumberOfQuestion();
//    }

}
