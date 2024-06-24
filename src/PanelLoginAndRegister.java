
import Classes.ModelLogin;
import Classes.ModelUser;
import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;


public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private ModelUser user;
    private ModelLogin dataLogin;

    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(ModelLogin dataLogin) {
        this.dataLogin = dataLogin;
    }
    
    public ModelUser getUser(){
        return user;
    }
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
    }
    
    
    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        
        
        MyTextField txtUsers = new MyTextField();
        txtUsers.setPrefixIcon(new ImageIcon(getClass().getResource("/Assests/user.png")));
        txtUsers.setHint("Name");
        
        MyTextField txtEmails = new MyTextField();
        txtEmails.setPrefixIcon(new ImageIcon(getClass().getResource("/Assests/mail.png")));
        txtEmails.setHint("Email");
        
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Assests/pass.png")));
        txtPassword.setHint("Password");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("Sign Up");

        
        register.add(txtUsers, "w 60%");
        register.add(txtEmails, "w 60%");
        register.add(txtPassword,"w 60%");
        register.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUsers.getText().trim();
                String email = txtEmails.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                
                user = new ModelUser(0, userName, email, password);
            }
        });
        
    }
    
    private void initLogin(ActionListener eventLogin){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
//        
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        
        MyTextField txtEmails = new MyTextField();
        txtEmails.setPrefixIcon(new ImageIcon(getClass().getResource("/Assests/mail.png")));
        txtEmails.setHint("Email");
        
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/Assests/pass.png")));
        txtPassword.setHint("Password");
        
        JButton cmdForget = new JButton("Forgot Password?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 20));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("Sign In");
        cmd.setBorderPainted(false);
        
        
        login.add(label);
        login.add(txtEmails, "w 60%");
        login.add(txtPassword, "w 60%");
        login.add(cmdForget);
        login.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmails.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                
                dataLogin = new ModelLogin(email, password);
            }
        });
        
        
    }
    
    public void showRegister(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
