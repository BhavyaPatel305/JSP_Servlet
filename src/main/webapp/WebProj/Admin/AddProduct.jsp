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
        <div>
            <h1>ADD NEW PRODUCT</h1>
        </div>
        <div>
            <form action="AddProductController">
                <!--Product Name-->
                <label for="p_name">ENTER PRODUCT NAME: </label>
                <input type="text" id="p_name" name="p_name">

                <!--Product Price-->
                <label for="p_price">ENTER PRODUCT PRICE: </label>
                <input type="text" id="p_price" name="p_price">

                <!--Product Original Price-->
                <label for="p_original_price">ENTER PRODUCT ORIGINAL PRICE: </label>
                <input type="text" id="p_original_price" name="p_original_price">

                <!--Product Image Url-->
                <label for="p_image_url">ENTER PRODUCT IMAGE URL: </label>
                <input type="text" id="p_image_url" name="p_image_url">

                <!--Product Video URL-->
                <label for="p_video_url">ENTER PRODUCT VIDEO URL: </label>
                <input type="text" id="p_video_url" name="p_video_url">

                <!--Product Description-->
                <label for="p_description">ENTER PRODUCT DESCRIPTION: </label>
                <input type="text" id="p_description" name="p_description">

                <!--Product Specification-->
                <label for="p_specification">ENTER PRODUCT SPECIFICATION: </label>
                <input type="text" id="p_specification" name="p_specification">

                <!--Product Reviews-->
                <label for="p_reviews">ENTER PRODUCT REVIEWS: </label>
                <input type="text" id="p_reviews" name="p_reviews">

                <!--Product Avg Rating-->
                <label for="p_avg_rating">ENTER PRODUCT AVG RATING: </label>
                <input type="text" id="p_avg_rating" name="p_avg_rating">

                <!--Product In Stock: Radio Button-->
                <label for="p_in_stock">ENTER PRODUCT IN STOCK: </label>
                <input type="radio" id="p_in_stock" name="p_in_stock" value="true">TRUE
                <input type="radio" id="p_in_stock" name="p_in_stock" value="false">FALSE

                <!--Product Shipping Info-->
                <label for="p_shipping_info">ENTER PRODUCT SHIPPING INFO: </label>
                <input type="text" id="p_shipping_info" name="p_shipping_info">

                <!--Product Category-->
                <label for="p_category">ENTER PRODUCT CATEGORY: </label>
                <input type="text" id="p_category" name="p_category">

                <!--Product Size Chart-->
                <label for="p_size_chart">ENTER PRODUCT SIZE CHART: </label>
                <input type="text" id="p_size_chart" name="p_size_chart">

                <!--Submit Button-->
                <input type="submit" value="SUBMIT">
            </form>
        </div>
        
        <script src="" async defer></script>
    </body>
</html>