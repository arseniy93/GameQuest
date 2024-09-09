package com.example.gamquest.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.gamquest.constants.Constants.pathToJsonFile;

public class InitializationOfObjects {
    public Data initealizationFromJson(Map<Integer, Question> mapQuestions, Map<Integer, Answer> mapAnswers, JsonNode jsonNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonNode = objectMapper.readTree(new File(pathToJsonFile));
        } catch (IOException e) {
            //TODO set log
            throw new RuntimeException(e);
        }
        questionJsonToObject(jsonNode, mapQuestions);
        answerJsonToObject(jsonNode, mapAnswers);
        Data data = new Data(mapQuestions, mapAnswers);
        return data;
    }
    public int lastQuestion(Data data){
        return data.getQuestions().size();

    }

    private static void answerJsonToObject(JsonNode jsonNode, Map<Integer, Answer> mapAnswers) {
        Answer answers;
        for (JsonNode node : jsonNode.get("answers")) {
            answers = new Answer(node.get("id").asInt(),
                    node.get("question").asText(),
                    node.get("answer").asInt());
            mapAnswers.put(node.get("id").asInt(), answers);
        }
    }

    private static void questionJsonToObject(JsonNode jsonNode, Map<Integer, Question> map) {
        Question questions;
        for (JsonNode node : jsonNode.get("questions")) {
            List<Integer> listOfAnswer = new ArrayList<>();
            if (node.get("answer") != null) {
                for (int i = 0; i < node.get("answer").size(); i++) {
                    listOfAnswer.add(Integer.parseInt(node.get("answer").get(i).asText()));
                }
            }
            questions = new Question(node.get("id").asInt(),
                    node.get("question").asText(),
                    listOfAnswer,
                    node.get("success").asBoolean());
            map.put(node.get("id").asInt(), questions);
        }
    }

    public void printObjectsFromJson(Map<Integer, Question> mapQuestions, Map<Integer, Answer> mapAnswers) {
        mapQuestions.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("************************************************");
        mapAnswers.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}

