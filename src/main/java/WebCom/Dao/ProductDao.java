package WebCom.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utility.DbConnection;

import WebCom.Bean.DeleteProductBean;
import WebCom.Bean.ProductBean;

public class ProductDao {
    public void addNewProduct(ProductBean bn) throws SQLException{
        // Connect with Database
        Connection db = DbConnection.getConnection();
        // Query to execute: Insert new product into product database
        PreparedStatement pst = db.prepareStatement("INSERT INTO PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_ORIGINAL_PRICE, PRODUCT_IMAGE_URL, PRODUCT_VIDEO_URL, PRODUCT_DESCRIPTION, PRODUCT_SPECIFICATION, PRODUCT_REVIEWS_CNT, PRODUCT_AVG_RATING, PRODUCT_IN_STOCK, PRODUCT_STOCK_QTY, PRODUCT_SHIPPING_INFO, PRODUCT_CATEGORY, PRODUCT_SIZE_CHART_GUIDE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pst.setString(1, bn.getP_name());
        pst.setString(2, bn.getP_price());
        pst.setString(3, bn.getP_original_price());
        pst.setString(4, bn.getP_image_url());
        pst.setString(5, bn.getP_video_url());
        pst.setString(6, bn.getP_description());
        pst.setString(7, bn.getP_specification());
        pst.setString(8, bn.getP_reviews());
        pst.setString(9, bn.getP_avg_rating());
        pst.setString(10, bn.getP_in_stock());
        pst.setString(11, bn.getP_shipping_info());
        pst.setString(12, bn.getP_category());
        pst.setString(13, bn.getP_size_chart());

        // Execute Query
        pst.executeUpdate();
    }

    public void deleteProduct(DeleteProductBean db) throws SQLException{
        // Connect with Database
        Connection dpb = DbConnection.getConnection();
        // Query to execute: Delete product from product database
        PreparedStatement pst = dpb.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_ID = (?)");
        pst.setString(1, db.getP_id());

        // Execute Query
        pst.executeUpdate();
    }
}
