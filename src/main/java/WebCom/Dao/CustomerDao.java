package WebCom.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utility.DbConnection;

import WebCom.Bean.CustomerBean;

public class CustomerDao {
    public void customerData(CustomerBean cb){
        try{
            Connection db = DbConnection.getConnection();
            PreparedStatement pst = db.prepareStatement("INSERT INTO CUSTOMER(FIRST_NAME, LAST_NAME, EMAIL, PHONE, PASSWORD) VALUES (?,?,?,?,?)");
            pst.setString(1,cb.getFname());
            pst.setString(2,cb.getLname());
            pst.setString(3,cb.getEmail());
            pst.setString(4,cb.getPnum());
            pst.setString(5,cb.getPass());

            pst.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();

        }

    }
    
}
