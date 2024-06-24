package Classes;

import Classes.DatabaseConnection;
import Classes.ModelUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;


public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public void insertUser(ModelUser user) throws SQLException {
        PreparedStatement p = con.prepareStatement("INSERT INTO `userInfo`(`userName`, `userEmail`, `userPassword`, `verifyCode`) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();
        p.setString(1, user.getUserName());
        p.setString(2, user.getEmail());
        p.setString(3, user.getPassword());
        p.setString(4, code);
       p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.next();
        int userID = r.getInt(1);
        r.close();
        p.close();
        user.setUserID(userID);
        user.setVerifyCode(code);
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("SELECT `userID` FROM `userInfo` WHERE verifyCode=? limit 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("SELECT `userID` FROM `userInfo` WHERE userName = ? and Status = 'Verified' limit 1");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("SELECT `userID` FROM `userInfo` WHERE userEmail = ? and Status = 'Verified' limit 1");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = con.prepareStatement("UPDATE `userInfo` SET `verifyCode`='' ,`Status`='Verified' WHERE  userID = ? limit 1");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = con.prepareStatement("SELECT `userID` FROM `userInfo` WHERE userID = ? and verifyCode = ? limit 1");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }
    
    
    public void sendDataToDB(ModelUser user) throws SQLException{

        String query = "INSERT INTO `userInfo`(`userName`, `userEmail`, `userPassword`, `verifyCode`) VALUES (?, ?, ?, ?)";
//        Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12715285", "sql12715285", "ZIA7wJLRGu");
        PreparedStatement pst = con.prepareStatement(query);
        String code = generateVerifyCode();
        pst.setString(1, user.getUserName());
        pst.setString(2,user.getEmail());
        pst.setString(3, user.getPassword());
        pst.setString(4, code);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Register successful");
            
        
    }
}