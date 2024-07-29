package com.example.app_caculator.controller;

import com.example.app_caculator.model.Caculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "caculatorServlet", urlPatterns = "/caculator")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(req.getParameter("first-operand"));
        float secondOperand = Float.parseFloat(req.getParameter("second-operand"));
        char operator = req.getParameter("operator").charAt(0);
        float result = Caculator.caculatorResult(firstOperand, secondOperand, operator);

        req.setAttribute("result", result);
        req.setAttribute("operator", operator);
        req.setAttribute("firstOperand", firstOperand);
        req.setAttribute("secondOperand", secondOperand);
        req.getRequestDispatcher("/caculator.jsp").forward(req, resp);
    }
}

