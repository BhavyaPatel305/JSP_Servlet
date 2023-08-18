<!DOCTYPE html>
<%@page import="com.Bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category</th>
            </tr>
        
        <%
            ArrayList<ProductBean> lst = (ArrayList<ProductBean>)request.getAttribute("list");
            // If not data found then
            if(lst.size() == 0){%>
                <%= "NO DATA FOUND" %>
            <%}else{
                for(int i = 0; i< lst.size(); i++){ %>
                    <tr>
                        <td><%=lst.get(i).getPname()%></td>
                        <td><%=lst.get(i).getPrice()%></td>
                        <td><%=lst.get(i).getQty()%></td>
                        <td><%=lst.get(i).getCategory()%></td>
                    </tr>
                <%}
            }
            
        %>
        </table>
    </div>
    
</body>
</html>