<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Student Page</title>
    </head>
    <body>
        <h2>Hello World of Spring </h2>
        <br><br>
        <h3>Student name: ${param.studentName}</h3>
        <br><br>
        <h3>The message: ${message}</h3>
        <a href="/spring_mvc_demo" class="btn btn-primary" type="button">Home</a>
    </body>
</html>
