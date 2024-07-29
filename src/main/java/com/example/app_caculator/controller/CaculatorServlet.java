package com.example.app_caculator.controller;

import com.example.app_caculator.model.Caculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "caculatorServlet", urlPatterns = "/caculator")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstOperand = 0;
        float secondOperand = 0;
        char operator = ' ';
        float result = 0;
        String errorMessage = null;

        try {
            firstOperand = Float.parseFloat(req.getParameter("first-operand"));
            secondOperand = Float.parseFloat(req.getParameter("second-operand"));
            operator = req.getParameter("operator").charAt(0);

            result = Caculator.caculatorResult(firstOperand, secondOperand, operator);
        } catch (NumberFormatException e) {
            errorMessage = "Invalid number format. Please enter valid numbers.";
        } catch (ArithmeticException e) {
            errorMessage = e.getMessage();
            result = Float.NaN;
        } catch (Exception e) {
            errorMessage = "An unexpected error occurred.";
            result = Float.NaN;
        }

        // Set attributes for JSP
        req.setAttribute("result", result);
        req.setAttribute("operator", operator);
        req.setAttribute("firstOperand", firstOperand);
        req.setAttribute("secondOperand", secondOperand);
        req.setAttribute("errorMessage", errorMessage);

        req.getRequestDispatcher("/caculator.jsp").forward(req, resp);
    }
}
