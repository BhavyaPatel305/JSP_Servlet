package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.ProductBean;
import com.utility.DbConnection;

public class ProductDao {
    public void productData(ProductBean bn){
        
        
        try {
            // Get the connection
            Connection conn = DbConnection.getConnection();

            // Execute query in database
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PRODUCTS(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY, PRODUCT_CATEGORY) VALUES (?,?,?,?)");
            pstmt.setString(1, bn.getPname());
            pstmt.setString(2, bn.getPrice());
            pstmt.setString(3, bn.getQty());
            pstmt.setString(4, bn.getCategory());

            // Run the query
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
