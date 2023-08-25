<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="">
    </head>
    <body>
        <div>
            <h1>Login</h1>
        </div>
        <div>
            <%
                String email = (String)request.getAttribute("email");
                String pass = (String)request.getAttribute("pass");
            %>
            <form action="/LoginController">
                <label for="email">Enter your email:</label>
                <input type="text" id="email" name="email"/><%=email==null?null:email%>

                <label for="pass">Enter your password:</label>
                <input type="text" id="pass" name="pass"/><%=pass==null?null:pass%>

                <input type="submit" value="SUBMIT" />
            </form>
            <a href="ForgotPassword.jsp">Forgot Password</a>
        </div>
        
        <script src="" async defer></script>
    </body>
</html>