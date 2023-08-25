package WebCom.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.DbConnection;

import WebCom.Bean.LoginBean;

public class LoginDao {
    public boolean customerLogin(LoginBean lb) throws SQLException{
        // Connect to database
        Connection db = DbConnection.getConnection();
        // Query to execute: Check if user exists in database or not
        PreparedStatement pst = db.prepareStatement("SELECT * FROM CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?");
        pst.setString(1, lb.getEmail());
        pst.setString(2, lb.getPass());

        // Execute Query
        ResultSet rs = pst.executeQuery();
        // Check if execution of query returned something
        if(rs.next()){
            return true;
        }
        return false;
    }
}
