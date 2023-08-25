<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SignUp</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="">
        
    </head>
    <body>
        <div>
            <h1>Sign Up</h1>
        </div>
        <div>
            <%
                String fname = (String)request.getAttribute("fname");
                String lname = (String)request.getAttribute("lname");
                String email = (String)request.getAttribute("email");
                String pnum = (String)request.getAttribute("pnum");
                String pass = (String)request.getAttribute("pass");
            %>

            <form action="/SignupController">
                <label for="fname">Enter your first name:</label>
                <input type="text" id="fname" name="fname"/><%=fname==null?null:fname%>
                <br>

                <label for="lname">Enter your last name:</label>
                <input type="text" id="lname" name="lname"/><%=lname==null?null:lname%>
                <br>

                <label for="email">Enter your email:</label>
                <input type="text" id="email" name="email"/><%=email==null?null:email%>
                <br>

                <label for="pnum">Enter your phone number:</label>
                <input type="text" id="pnum" name="pnum"/><%=pnum==null?null:pnum%>
                <br>

                <label for="pass">Enter password:</label>
                <input type="text" id="pass" name="pass"/><%=pass==null?null:pass%>
                <br>

                <input type="submit" value="SUBMIT" />

            </form>
        </div>
        
        <script src="" async defer></script>
    </body>
</html>