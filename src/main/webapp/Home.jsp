<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="">
    </head>
    <body> 
       
       <a href="ListUserController">List users</a>
        <!--If user gives all inputs than come to Home.jsp and print all the values input by the user-->
        FirstName : <%=request.getAttribute("firstNameValue")%>
        <br>
        Email : <%=request.getAttribute("emailValue")%>
        <br>
        Password:<%=request.getAttribute("passwordValue")%>
        <br>
        <script src="" async defer></script>
    </body>
</html>