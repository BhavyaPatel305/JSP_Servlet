<!DOCTYPE html>
<%@page import="com.Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
        <table border="10px">
            <tr>
                <th>First Name</th>
                <th>Email</th>
            </tr>
        <%
            ArrayList<UserBean> lst = (ArrayList<UserBean>)request.getAttribute("list");
            // for loop to print each element of the array list
            for(int i = 0; i < lst.size(); i++){ %>
                
                    <tr>
                        <td><%= lst.get(i).getFirstName() %></td>
                        <td><%=lst.get(i).getEmail()%></td>
                    </tr>
                
                
            <%}
        %>
        </table>
        
    
    </div>
</body>
</html>