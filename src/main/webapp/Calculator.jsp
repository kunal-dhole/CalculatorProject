<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h1>Simple Calculator</h1>
    <form action="CalculatorServlet" method="post">
    
        <input type="number" name="num1" placeholder="Enter first number" required>
        <input type="number" name="num2" placeholder="Enter second number" required>
        <br><br>
        
        <input type="radio" name="operation" value="add" checked>Add
        <input type="radio" name="operation" value="subtract">Subtract
        <input type="radio" name="operation" value="multiply">Multiply
        <input type="radio" name="operation" value="divide">Divide
        <br><br>
        <input type="submit" value="Calculate">
    </form>

    <%
        Double result = (Double) request.getAttribute("result");
        String error = (String) request.getAttribute("error");
        if (result != null) {
    %>
        <h2>Result: <%= result %></h2>
    <%
        }
        if (error != null) {
    %>
        <h2 style="color:red;"><%= error %></h2>
    <%
        }
    %>
</body>
</html>
