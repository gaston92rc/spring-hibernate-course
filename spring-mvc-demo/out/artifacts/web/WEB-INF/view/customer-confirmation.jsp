<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
        <title>Customer Confirmation</title>
    </head>
    <body>
        <br><br>
        <h1>The Customer is confirmed: ${customer.firstName} ${customer.lastName}</h1>
        <br><br>
        <h1>Free Passes: ${customer.freePasses}</h1>
        <br><br>
        <h1>Postal Code: ${customer.postalCode}</h1>
        <br><br>
        <h1>Course Code: ${customer.courseCode}</h1>
        <br><br>
        <a href="/spring_mvc_demo" class="btn btn-primary" type="button">Home</a>
    </body>
</html>
