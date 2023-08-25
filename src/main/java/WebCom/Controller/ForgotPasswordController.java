package WebCom.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Message;




@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("email_phone"); // This can be email or phone number
        String otpCode = generateOtpCode(); // Generate your OTP code here
        
        // Initialize Twilio API with your credentials
        Twilio.init("AC23246cf0ea6e9482537403e237c5f326", "a3341a6d62f6c0026074747fab591c68");
        
        // Determine if the user input is an email or a phone number
        boolean isEmail = isEmail(userInput);
        
        if (isEmail) {
            // Send OTP code via email (implement email sending logic here)
            sendOtpEmail(userInput, otpCode);
        } else {
            // Send OTP code via SMS using Twilio
            Message message = Message.creator(
                new PhoneNumber(userInput),
                new PhoneNumber("YOUR_TWILIO_PHONE_NUMBER"),
                "Your OTP code is: " + otpCode
            ).create();
            
            // You can handle the Twilio response as needed
        }
        
        // Store the OTP code or some hash of it along with user's data for verification later
    }
    
    private boolean isEmail(String input) {
        // Implement your logic to detect if the input is an email address
        // You might use regular expressions or other methods to validate email format
        // Return true if it's an email, false if it's not
        return input.contains("@"); // Simplified example
    }
    
    private void sendOtpEmail(String email, String otpCode) {
        // Implement your email sending logic here
        // You might use JavaMail API or other libraries to send emails
        // Include the OTP code in the email body
    }
    
    private String generateOtpCode() {
        // Generate a random numeric OTP code
        // You can use libraries like java.util.Random or java.security.SecureRandom
        // to generate random numbers
        return "123456"; // Replace with your actual OTP generation logic
    }
     

}
