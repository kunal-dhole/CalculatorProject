package com.tka;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")

public class CalculatorServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");
        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    request.setAttribute("error", "Division by zero is not allowed.");
                    request.getRequestDispatcher("Calculator.jsp").
                    forward(request, response);
                    return;
                }
                break;
            default:
                request.setAttribute("error", "Invalid operation.");
                request.getRequestDispatcher("Calculator.jsp").forward(request, response);
                return;
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("Calculator.jsp").forward(request, response);
    }
}
