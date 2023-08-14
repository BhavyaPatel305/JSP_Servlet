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
        <%
            String pname = (String)request.getAttribute("pname");
            String price = (String)request.getAttribute("price");
            String qty = (String)request.getAttribute("qty");
            String category = (String)request.getAttribute("category");
        %>
        <form action="productController">
            <div>
                <h1>Enter Product Details</h1>
                <div>
                    Product Name: <input type="text" name="pname" />
                    <%= pname==null? "":pname %>
                    Product Price: <input type="text" name="price" />
                    <%= price == null ? "" : price%>
                    Product Qty: <input type="text" name="qty" />
                    <%= qty == null ? "" : qty%>
                    Product Category: <input type="text" name="category" />
                    <%= category == null ? "" : category%>
                </div>
                <div>
                    <input type="submit" value="SUBMIT" />
                </div>
            </div>
        </form>
        
        
        <script src="" async defer></script>
    </body>
</html>