
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
//import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author saura
 */
public class Register extends javax.swing.JFrame {
    
    int randomCode;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    Session newSession = null;
    MimeMessage mimeMessage = null;
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        agreeCKBtn = new javax.swing.JCheckBox();
        emailTxt = new javax.swing.JTextField();
        pwdTxt = new javax.swing.JPasswordField();
        confirmPwdTxt = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        codeTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        showPwdCKBtn = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assests/logo-color-new.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 362, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setText("DataShiel Security");

        jLabel2.setText("Email-ID:");

        jLabel3.setText("Password");

        jLabel4.setText("Re-enter Password:");

        jLabel5.setText("Terms & Conditions:");

        agreeCKBtn.setText("I agree");

        jLabel6.setText("Click here to View T&C");

        clearBtn.setText("Clear All");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Already have a account?");

        jLabel8.setText("Back to login");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jButton1.setText("Verify Code");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Send Code");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        showPwdCKBtn.setText("Show Password");
        showPwdCKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPwdCKBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agreeCKBtn)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(codeTxt)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showPwdCKBtn)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(confirmPwdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                        .addComponent(pwdTxt)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(clearBtn)
                        .addGap(144, 144, 144)
                        .addComponent(registerBtn)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(122, 122, 122))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(138, 138, 138))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pwdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(confirmPwdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(showPwdCKBtn)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(agreeCKBtn)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn)
                    .addComponent(registerBtn))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String email = emailTxt.getText();
        
        if(validEmail(email)){
            if(new String(pwdTxt.getPassword()).equals(new String (confirmPwdTxt.getPassword()))){
                System.out.println("Password match");
                try {
                    System.out.println("sencCode try");
                    sendCode();
                } catch (MessagingException ex) {
                    System.out.println("here");
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Password do not match");
            }
        }else{
            System.out.println("Email is invalid");
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(Integer.valueOf(codeTxt.getText()) == randomCode){
            JOptionPane.showMessageDialog(null, "Email verification success");
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Verification Code");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        
        if(new String(pwdTxt.getPassword()).equals(new String (confirmPwdTxt.getPassword()))){
            if(pwdTxt.getText().length() >= 6 ){
                if(agreeCKBtn.isSelected()){
                    //set data in db
                    sendDataToDB();
                    Login login = new Login();
                    login.setVisible(true);
                    this.setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please Agree to the Terms & Conditions");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Password Length Must Be Greater than 6 Characters");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Password Do Not Match");

        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        emailTxt.setText("");
        codeTxt.setText("");
        pwdTxt.setText("");
        confirmPwdTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void showPwdCKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPwdCKBtnActionPerformed
        // TODO add your handling code here:
        if(showPwdCKBtn.isSelected()){
            pwdTxt.setEchoChar((char) 0);
            confirmPwdTxt.setEchoChar((char) 0);
        }else{
            pwdTxt.setEchoChar('*');
            confirmPwdTxt.setEchoChar('*');
        }
    }//GEN-LAST:event_showPwdCKBtnActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
    
    public void sendDataToDB(){
        
        try{
            String query = "INSERT INTO `userInfo`(`userEmail`, `userPassword`) VALUES (?, ?)";
            con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12715285", "sql12715285", "ZIA7wJLRGu");
            pst = con.prepareStatement(query);
            pst.setString(1,emailTxt.getText());
            pst.setString(2, pwdTxt.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Register successful");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    public static boolean validEmail(String email){
        
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }
    
    public void sendCode() throws MessagingException{
        
//        try{
//            Random randome = new Random();
//            randomCode = randome.nextInt(999999);
//
//            String host = "smtp.gmail.com";
//            String user = "sdatashield@gmail.com";
//            String password = "tqga voer fdje fhqe";
//            String toUser = emailTxt.getText();
//            String subject = "Email Verification Code";
//            String message = "Your email verication Code is " + randomCode;
//            boolean sessionDebug = false;
//            Properties pros = System.getProperties();
//            pros.put("mail.smtp.auth","true");
//            pros.put("mail.smtp.starttls.enable", "true");
//            pros.put("mail.smtp.host", host);
//            pros.put("mail.smtp.port","547");
//            pros.put("mail.smtp.starttls.required", "true");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//            Session mailSession = Session.getDefaultInstance(pros, null);
//            mailSession.setDebug(sessionDebug);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(user));
//
//            InternetAddress address[] = {new InternetAddress(toUser)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setText(message);
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect(host, user, password);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            transport.close();
//
//            JOptionPane.showMessageDialog(null, "Verification code has been sent to your mail");
//            System.out.println("mail sent");
//
//
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//            System.out.println("mail not sent " + e);
//        }
        
        
        System.out.println("sendCode block");

        Register mail = new Register();
        
        mail.setupServerProperties();
        mail.draftEmail();
        mail.sendEmail();
        System.out.println("after send email");

        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agreeCKBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField codeTxt;
    private javax.swing.JPasswordField confirmPwdTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pwdTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JCheckBox showPwdCKBtn;
    // End of variables declaration//GEN-END:variables

    private void setupServerProperties() {
        System.out.println("serverProperties");

            
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        newSession = Session.getDefaultInstance(properties, null);
        
        
    }

    private MimeMessage draftEmail() throws MessagingException {

        System.out.println("draftEmail");
        
        String usermail = emailTxt.getText();
        String[] emailRecepients = {usermail};
        String emailSubject = "Test subject";
        String emailBody = "Test body";
        mimeMessage = new MimeMessage(newSession);     

//        InternetAddress address[] = {new InternetAddress(usermail)};
                        

//        for(int i=0; i<emailRecepients.length; i++){
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecepients[0]));
//        }
        System.out.println("og");
//        mimeMessage.addRecipients(Message.RecipientType.TO, address);
        
        mimeMessage.setSubject(emailSubject);
        
        
        
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "html/text");
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        System.out.println("return hora");

        return mimeMessage;
        
        
        
    }

    private void sendEmail() throws NoSuchProviderException, MessagingException {
           
        System.out.println("sendEmail");
            String user = "sdatashield@gmail.com";
           String password = "tqga voer fdje fhqe";
           String emailHost = "smtp.gmail.com";
           Transport transport = newSession.getTransport("smtp");
           transport.connect(emailHost, user, password);
           transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
           transport.close();
           System.out.println("Email send success");
           
            
    }
}
