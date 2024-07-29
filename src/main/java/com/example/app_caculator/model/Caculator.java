package com.example.app_caculator.model;

public class Caculator {
    public static float caculatorResult(float firstOperand, float secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                }
                else
                    throw new ArithmeticException("Division by zero");
            default:
                throw new ArithmeticException("Invalid operator");
        }
    }
}
