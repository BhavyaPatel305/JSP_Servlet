<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
<%
    // We catch all error messages using all the keys passed from RegistrationController.java file
    String firstNameError = (String) request.getAttribute("firstNameError");
    String emailError = (String) request.getAttribute("emailError"); 
    String passwordError = (String) request.getAttribute("passwordError");

%>

	<form action="RegistrationController">
		FirstName: <input name = "firstname" type="text" />
        <!--Print value of each variable if not null-->
        <%=firstNameError == null ? "" : firstNameError%>

        <br><br>
		Email: <input name="email" type="text" />
        <%=emailError == null ? "" : emailError%>
        
        <br><br>
		Password: <input name="pass" type="text" />
        <%=passwordError == null ? "" : passwordError%>
        
        <br>
		<input type="submit" value="Signup"/>
         
	</form>
</body>
</html>