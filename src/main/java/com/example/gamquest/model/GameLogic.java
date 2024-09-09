package com.example.gamquest.model;

import com.example.gamquest.exeption.ExaptionsOfQA;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class GameLogic {
    private Map<Integer, Question> mapQuestions;
    private Map<Integer, Answer> mapAnswers;
    private List<Question> listOfQuestions;
    private List<Answer> listOfAnswers;
    private int quantityOfWin;
    private int quantityOfLose;
    private int numberOfQuestion;

    public GameLogic(Map<Integer, Question> mapQuestions, Map<Integer, Answer> mapAnswers) {
        log.info("inizialization GameLogic");
        this.mapQuestions = mapQuestions;
        this.mapAnswers = mapAnswers;
        listOfQuestions = new ArrayList<>(mapQuestions.values());
        listOfAnswers = new ArrayList<>(mapAnswers.values());
        quantityOfWin = 0;
        quantityOfLose = 0;
        numberOfQuestion = 1;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getQuantityOfWin() {
        return quantityOfWin;
    }

    public int getQuantityOfLose() {
        return quantityOfLose;
    }

    public String answerQuestion(int setAnswer) {
        return getAnswer(setAnswer).getQuestion();
    }

    //TODO change
    public String askQuestion(int setNumberOfQuestion) {
        log.info("askQuestion");
        String questions = "";
        if (getQuestion(setNumberOfQuestion).isSuccess()==true) {
            if (getQuestion(setNumberOfQuestion).getId()==listOfQuestions.size()) {
                questions = getQuestion(setNumberOfQuestion).getQuestion();
                quantityOfWin++;
                setNumberOfQuestion = 1;
                setNumberOfQuestion(1);

            } else {
                questions = getQuestion(setNumberOfQuestion).getQuestion();
            }

        } else if (getQuestion(setNumberOfQuestion).isSuccess()==false) {
            quantityOfLose++;
            questions = getQuestion(setNumberOfQuestion).getQuestion();
            setNumberOfQuestion = 1;
            setNumberOfQuestion(1);

        }
        return questions;
    }


    public Answer getAnswer(int numberOfAnswers) {
        if (checkSizeOfAnswersOrQuestions(listOfAnswers, numberOfAnswers)) {
            log.info("getAnswer");
            return listOfAnswers.get(numberOfAnswers - 1);
        } else {
            try {
                log.error("превысил число вопросов или ответов");
                throw new ExaptionsOfQA("превысил число вопросов или ответов");
            } catch (ExaptionsOfQA e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Question getQuestion(int numberOfQuestions) {
        if (checkSizeOfAnswersOrQuestions(listOfQuestions, numberOfQuestions)) {
            return listOfQuestions.get(numberOfQuestions - 1);
        } else {
            try {
                log.error("превысил число вопросов или вопросов");
                throw new ExaptionsOfQA("превысил число вопросов или вопросов");
            } catch (ExaptionsOfQA e) {
                throw new RuntimeException(e);
            }
        }

    }


    private boolean checkSizeOfAnswersOrQuestions(List<? extends Words> listOfAnswer, int numberOfAnswers) {
        return (listOfAnswer.size() > numberOfAnswers - 1) ? true:false;
    }

    public int getIdOfQuestion(String question) {
        int k = 0;
        for (int i = 0; i < listOfQuestions.size(); i++) {
            if (listOfQuestions.get(i).getQuestion().equals(question)) {
                k = i + 1;
            }

        }
        return k;
    }

    public List<Integer> getIdsOfAnswer(String question) {
        List<Integer> integerList = new ArrayList<>();
        if(listOfQuestions.isEmpty()){
            log.error("пустой список");
            throw new RuntimeException("пустой элемент");
        }
        else{
            for (int i = 0; i < listOfQuestions.size(); i++) {
                if (listOfQuestions.get(i).getQuestion().equals(question)) {
                    integerList = (listOfQuestions.get(i).getAnswerList());
                }
            }
        }

        return integerList;
    }


    public int getIdOfAnswer(String answer) {
        int k = 0;
        for (int i = 0; i < listOfAnswers.size(); i++) {
            if (listOfAnswers.get(i).getQuestion().equals(answer)) {
                k = i + 1;
            }

        }
        return k;
    }

    public int getIdToQuestionOfIdAnswer(String answer) {
        int k = 0;
        for (int i = 0; i < listOfAnswers.size(); i++) {
            if (listOfAnswers.get(i).getQuestion().equals(answer)) {
                k= listOfAnswers.get(i).getAnswer();
            }

        }
        return k;
    }


}
//public class GameLogic {
//    private Map<Integer, Question> mapQuestions;
//    private Map<Integer, Answer> mapAnswers;
//    private List<Question> listOfQuestions;
//    private List<Answer> listOfAnswers;
//    private int quantityOfWin;
//    private int quantityOfLose;
//    private int sumOfQuantityOfGame;
//
//
//
//    private int numberOfQuestion;
//    public GameLogic(Map<Integer, Question> mapQuestions, Map<Integer, Answer> mapAnswers) {
//        this.mapQuestions = mapQuestions;
//        this.mapAnswers = mapAnswers;
//        listOfQuestions = new ArrayList<>(mapQuestions.values());
//        listOfAnswers = new ArrayList<>(mapAnswers.values());
//        quantityOfWin = 0;
//        quantityOfLose = 0;
//        sumOfQuantityOfGame=0;
//        numberOfQuestion=1;
//
//    }
//    public int getNumberOfQuestion() {
//        return numberOfQuestion;
//    }
//
//    public void setNumberOfQuestion(int numberOfQuestion) {
//        this.numberOfQuestion = numberOfQuestion;
//    }
//
//    public void setQuantityOfWin(int quantityOfWin) {
//        this.quantityOfWin = quantityOfWin;
//    }
//
//    public void setQuantityOfLose(int quantityOfLose) {
//        this.quantityOfLose = quantityOfLose;
//    }
//
//
//
//    public int getSumOfQuantityOfGame() {
//        return sumOfQuantityOfGame;
//    }
//
//    public void setSumOfQuantityOfGame(int sumOfQuantityOfGame) {
//        this.sumOfQuantityOfGame = sumOfQuantityOfGame;
//    }
//
//
//
//    public int getQuantityOfWin() {
//        return quantityOfWin;
//    }
//
//    public int getQuantityOfLose() {
//        return quantityOfLose;
//    }
//
//    public String askQuestion(int setNumberOfQuestion) {
//        String questions = "";
//        if (getQuestion(setNumberOfQuestion).isSuccess() == true) {
//            if (getQuestion(setNumberOfQuestion).getId() == listOfQuestions.size()) {
//                quantityOfWin++;
//                setNumberOfQuestion(1);
//                setNumberOfQuestion = 1;
//                questions = getQuestion(setNumberOfQuestion).getQuestion();
//            } else {
//                questions = getQuestion(setNumberOfQuestion).getQuestion();
//            }
//
//        } else if (getQuestion(setNumberOfQuestion).isSuccess() == false) {
//            quantityOfLose++;
//            setNumberOfQuestion(1);
//            setNumberOfQuestion = 1;
//            questions = getQuestion(setNumberOfQuestion).getQuestion();
//        }
//        return questions;
//    }
//    public String answerQuestion(int setAnswer) {
//        return  getAnswer(setAnswer).getQuestion();
//    }
//
//    public Answer getAnswer(int numberOfAnswers) {
//        if (checkSizeOfAnswersOrQuestions(listOfAnswers, numberOfAnswers)) {
//            return listOfAnswers.get(numberOfAnswers - 1);
//        } else {
//            try {
//                throw new ExaptionsOfQA("превысил число вопросов или ответов");
//            } catch (ExaptionsOfQA e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
//
//    public Question getQuestion(int numberOfQuestions) {
//        if (checkSizeOfAnswersOrQuestions(listOfQuestions, numberOfQuestions)) {
//            return listOfQuestions.get(numberOfQuestions - 1);
//        } else {
//            try {
//                throw new ExaptionsOfQA("превысил число вопросов или ответов");
//            } catch (ExaptionsOfQA e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//    public int getIdOfQuestion(String question){
//        int k=0;
//        for (int i = 0; i < listOfQuestions.size(); i++) {
//            if(listOfQuestions.get(i).getQuestion().equals(question)){
//                k=i+1;
//            }
//
//        }
//        return k;
//    }
//
//    public int getIdOfAnswer(String answer){
//        int k=0;
//        for (int i = 0; i < listOfAnswers.size(); i++) {
//            if(listOfAnswers.get(i).getQuestion().equals(answer)){
//                k=i+1;
//            }
//
//        }
//        return k;
//    }
//
//
//    private boolean checkSizeOfAnswersOrQuestions(List<? extends Words> listOfAnswer, int numberOfAnswers) {
//        return (listOfAnswer.size() > numberOfAnswers - 1) ? true : false;
//    }
//}
