package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<ProductBean> getAllProducts() {
		// return users
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		try {
			Connection connection = DbConnection.getConnection();

			PreparedStatement pstmt = connection.prepareStatement("select * from products");
			ResultSet rs = pstmt.executeQuery();// select

			while (rs.next()) {

				int pId = rs.getInt("PRODUCT_ID");
				String pname = rs.getString("PRODUCT_NAME");
				String price = rs.getString("PRODUCT_PRICE");
				String qty = rs.getString("PRODUCT_QTY");
                String category = rs.getString("PRODUCT_CATEGORY");

				ProductBean u = new ProductBean();
				u.setPId(pId);
                u.setPname(pname);
                u.setPrice(price);
                u.setQty(qty);
                u.setCategory(category);


				products.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

    public ArrayList<ProductBean> SearchProducts(String productName) {
		// return users
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		try {
			Connection connection = DbConnection.getConnection();

			PreparedStatement pstmt = connection.prepareStatement("select * from products where PRODUCT_NAME = ?");
            pstmt.setString(1, productName);
            
			ResultSet rs = pstmt.executeQuery();// select

			while (rs.next()) {

				int pId = rs.getInt("PRODUCT_ID");
				String pname = rs.getString("PRODUCT_NAME");
				String price = rs.getString("PRODUCT_PRICE");
				String qty = rs.getString("PRODUCT_QTY");
                String category = rs.getString("PRODUCT_CATEGORY");

				ProductBean u = new ProductBean();
				u.setPId(pId);
                u.setPname(pname);
                u.setPrice(price);
                u.setQty(qty);
                u.setCategory(category);


				products.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
    
}
