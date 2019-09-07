<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    Favorite Language:

    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
    C# <form:radiobutton path="favoriteLanguage" value="C#"/>
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
    <br><br>

    Operating Systems:

    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Mac <form:checkbox path="operatingSystems" value="Mac"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>

    <br><br>
    <%@ include file="footer.jsp"%>
</form:form>
</body>
</html>
