<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<form action="RegistrationController">
		FirstName: <input name = "firstname" type="text" /><br><br>
		Email: <input name="email" type="text" /><br><br>
		Password: <input name="pass" type="text" /><br>
		<input type="submit" value="Signup"/>
        <%
            // Here we catch the value sent by RegistrationController.java using the key "err_msg"
            String msg = (String)request.getAttribute("err_msg");
            if(msg!=null){
                out.println(msg);
            }
        %>
	</form>
</body>
</html>