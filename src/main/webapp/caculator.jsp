<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator Result</title>
</head>
<body>
<h2>Simple Calculator</h2>
<form action="caculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First Operand:</td>
                <td><input name="first-operand" type="text" value="${firstOperand}"/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second Operand:</td>
                <td><input name="second-operand" type="text" value="${secondOperand}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<h3>Result:</h3>
<c:choose>
    <c:when test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:when>
    <c:otherwise>
        <p>${firstOperand} ${operator} ${secondOperand} = ${result}</p>
    </c:otherwise>
</c:choose>
</body>
</html>
