<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Student Registration Form</title>
    </head>
    <body>
        <h2>The student is confirmed: ${student.firstName} ${student.lastName}</h2>
        <br><br>

        <h2>Country: ${student.country}</h2>

        <br><br>

        <h2>Favorite Language: ${student.favoriteLanguage}</h2>

        <br><br>

        <h2>Operating System:
            <ul>
                <c:forEach var="temp" items="${student.operatingSystems}">
                    <li>${temp}</li>
                </c:forEach>
            </ul>
        </h2>
        <br><br>
        <a href="/spring_mvc_demo" class="btn btn-primary" type="button">Home</a>
    </body>
</html>
