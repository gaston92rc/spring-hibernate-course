<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Hellow World - Input Form</title>
</head>
<body>
<form action="processFormVersionThree" method="get">
    <input type="text" name="studentName" placeholder="What's your name?"/>
    <%@ include file="footer.jsp"%>
</form>
</body>
</html>
