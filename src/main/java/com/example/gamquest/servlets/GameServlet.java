package com.example.gamquest.servlets;

import com.example.gamquest.service.GameLogicServiceFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
//import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;
@Slf4j
@WebServlet(name = "helloGames", value = "/games")
public class GameServlet extends HttpServlet {
    private GameLogicServiceFacade gameLogicServiceFacade;
    private String question;

    public void init() {
        gameLogicServiceFacade = new GameLogicServiceFacade();
        System.out.println("initServlet");
        log.info("init GameServlet");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("GameServlet -doGet");
        if (gameLogicServiceFacade.getNumberOfQuestion() == gameLogicServiceFacade.getLastQuestion()) {
            question = gameLogicServiceFacade.askQuestion(gameLogicServiceFacade.getLastQuestion());
            request.setAttribute("question", question);
            gameLogicServiceFacade.setNumberOfQuestion(1);
            getServletContext().getRequestDispatcher("/win.jsp").forward(request, response);
        } else {
            question = gameLogicServiceFacade.askQuestion(gameLogicServiceFacade.getNumberOfQuestion());
            String answer1 = gameLogicServiceFacade.getAnswer(gameLogicServiceFacade.getIdsOfAnswer(question).get(0)).getQuestion();
            String answer2 = gameLogicServiceFacade.getAnswer(gameLogicServiceFacade.getIdsOfAnswer(question).get(1)).getQuestion();
            request.setAttribute("question", question);
            request.setAttribute("answer1", answer1);
            request.setAttribute("answer2", answer2);
            setWinLoseInAttribute(request);
            getServletContext().getRequestDispatcher("/Game.jsp").forward(request, response);
        }
    }

    private void setWinLoseInAttribute(HttpServletRequest request) {
        String win=String.valueOf(gameLogicServiceFacade.getQuantityOfWin());
        String lose=String.valueOf(gameLogicServiceFacade.getQuantityOfLose());
        request.setAttribute("win", win);
        request.setAttribute("lose", lose);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        log.info("GameServlet -doPost");
        if (Boolean.parseBoolean(request.getParameter("flexRadioDefault")) == false) {
            gameLogicServiceFacade.setNumberOfQuestion(gameLogicServiceFacade.getAnswer(gameLogicServiceFacade.getIdsOfAnswer(question).get(1)).getAnswer());
            doGet(request, response);
        } else {
            gameLogicServiceFacade.setNumberOfQuestion(gameLogicServiceFacade.getAnswer(gameLogicServiceFacade.getIdsOfAnswer(question).get(0)).getAnswer());
            question = gameLogicServiceFacade.askQuestion(gameLogicServiceFacade.getNumberOfQuestion());
            request.setAttribute("question", question);
            gameLogicServiceFacade.setNumberOfQuestion(1);
            getServletContext().getRequestDispatcher("/lose.jsp").forward(request, response);
        }

    }
}


