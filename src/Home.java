
import Classes.ModelUser;
import java.awt.Color;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author saura
 */
public class Home extends javax.swing.JFrame {
    
    private DrawerController drawer;
    private final ModelUser user;
    
    public Home(ModelUser user) {
        this.user = user;
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 255));
        lblUser.setText(user.getUserName());
        
        homeDashboard.setVisible(true);
        myAccount.setVisible(false);
        encryption.setVisible(false);
        decryption.setVisible(false);
        
        
        menuHeader hm = new menuHeader();
        hm.userEmailLbl.setText(lblUser.getText());
        drawer = Drawer.newDrawer(this)
                .header(new menuHeader())
                .separator(2, new Color(90, 90, 90))
                .background(new Color(90, 90, 90))
                .backgroundTransparent(0.8f)
                .drawerWidth(300)
                .enableScroll(true)                
                
                .addChild(new DrawerItem("Home").icon(new ImageIcon(getClass().getResource("/Assests/data.png"))).build())
                .addChild(new DrawerItem("My Account").icon(new ImageIcon(getClass().getResource("/Assests/data.png"))).build())
                .addChild(new DrawerItem("Encrypt").icon(new ImageIcon(getClass().getResource("/Assests/data.png"))).build())
                .addChild(new DrawerItem("Decrypt").icon(new ImageIcon(getClass().getResource("/Assests/data.png"))).build())
                
                .addFooter(new DrawerItem("Logout").icon(new ImageIcon(getClass().getResource("/Assests/data.png"))).build())
                
                .event(new EventDrawer() {
            @Override
            public void selected(int i, DrawerItem item) {
//                System.out.println(i);
                if(i == 0){
                    homeDashboard();
                }else if(i == 1){
                    myaccount();
                }else if(i == 2){
                    encryption();
                }else if(i == 3){
                    decryption();
                }else if(i == 4){
                    System.out.println("Logout");
                }
            }
        })
                   
                
                .build();
        
    }
    
    private void homeDashboard(){
        drawer.hide();

        System.out.println("My Account");
        myAccount.setVisible(false);
        encryption.setVisible(false);
        decryption.setVisible(false);
        homeDashboard.setVisible(true);
    }
    
    private void myaccount(){
        System.out.println("My Account");
                    drawer.hide();

        myAccount.setVisible(true);
        encryption.setVisible(false);
        decryption.setVisible(false);
        homeDashboard.setVisible(false);

        
        useridlbl.setText(String.valueOf(user.getUserID()));
        useremaillbl.setText(user.getEmail());
        usernamelbl.setText(user.getUserName());
    }   
    
    private void encryption(){
        System.out.println("Encrypt");
                    drawer.hide();

        myAccount.setVisible(false);
        encryption.setVisible(true);
        decryption.setVisible(false);
        homeDashboard.setVisible(false);

    }
    
    private void decryption(){
        System.out.println("Decrypt");
                    drawer.hide();

        myAccount.setVisible(false);
        encryption.setVisible(false);
        decryption.setVisible(true);
        homeDashboard.setVisible(false);

        
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        homeDashboard = new javax.swing.JPanel();
        myTextField4 = new com.raven.swing.MyTextField();
        myAccount = new javax.swing.JPanel();
        myTextField1 = new com.raven.swing.MyTextField();
        usernamelbl = new com.raven.swing.MyTextField();
        useremaillbl = new com.raven.swing.MyTextField();
        useridlbl = new com.raven.swing.MyTextField();
        encryption = new javax.swing.JPanel();
        myTextField3 = new com.raven.swing.MyTextField();
        decryption = new javax.swing.JPanel();
        myTextField2 = new com.raven.swing.MyTextField();
        menu = new com.raven.swing.Button();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("DataShield Security");

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("user name");

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        homeDashboard.setBackground(new java.awt.Color(255, 255, 255));

        myTextField4.setText("Home Page");

        javax.swing.GroupLayout homeDashboardLayout = new javax.swing.GroupLayout(homeDashboard);
        homeDashboard.setLayout(homeDashboardLayout);
        homeDashboardLayout.setHorizontalGroup(
            homeDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeDashboardLayout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(myTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(466, Short.MAX_VALUE))
        );
        homeDashboardLayout.setVerticalGroup(
            homeDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(461, Short.MAX_VALUE))
        );

        jLayeredPane1.add(homeDashboard, "card5");

        myAccount.setBackground(new java.awt.Color(255, 255, 255));

        myTextField1.setText("My Account");

        usernamelbl.setText("userName");

        useremaillbl.setText("userEmail");

        useridlbl.setText("userId");

        javax.swing.GroupLayout myAccountLayout = new javax.swing.GroupLayout(myAccount);
        myAccount.setLayout(myAccountLayout);
        myAccountLayout.setHorizontalGroup(
            myAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAccountLayout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addGroup(myAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myAccountLayout.createSequentialGroup()
                        .addGroup(myAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(useridlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(415, Short.MAX_VALUE))
                    .addGroup(myAccountLayout.createSequentialGroup()
                        .addComponent(useremaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        myAccountLayout.setVerticalGroup(
            myAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAccountLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(useridlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(usernamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(useremaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        jLayeredPane1.add(myAccount, "card4");

        encryption.setBackground(new java.awt.Color(255, 255, 255));

        myTextField3.setText("Encryption");
        myTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout encryptionLayout = new javax.swing.GroupLayout(encryption);
        encryption.setLayout(encryptionLayout);
        encryptionLayout.setHorizontalGroup(
            encryptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptionLayout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(myTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(506, Short.MAX_VALUE))
        );
        encryptionLayout.setVerticalGroup(
            encryptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(myTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
        );

        jLayeredPane1.add(encryption, "card2");

        decryption.setBackground(new java.awt.Color(255, 255, 255));

        myTextField2.setText("Decryption");

        javax.swing.GroupLayout decryptionLayout = new javax.swing.GroupLayout(decryption);
        decryption.setLayout(decryptionLayout);
        decryptionLayout.setHorizontalGroup(
            decryptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decryptionLayout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        decryptionLayout.setVerticalGroup(
            decryptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decryptionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );

        jLayeredPane1.add(decryption, "card3");

        menu.setForeground(new java.awt.Color(0, 0, 0));
        menu.setText("|||");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Welcome ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myTextField3ActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // TODO add your handling code here:
        if(drawer.isShow()){
            drawer.hide();
        }else{
            drawer.show();
        }
    }//GEN-LAST:event_menuActionPerformed


    
    public static void main(ModelUser user) {
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel decryption;
    private javax.swing.JPanel encryption;
    private javax.swing.JPanel homeDashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblUser;
    private com.raven.swing.Button menu;
    private javax.swing.JPanel myAccount;
    private com.raven.swing.MyTextField myTextField1;
    private com.raven.swing.MyTextField myTextField2;
    private com.raven.swing.MyTextField myTextField3;
    private com.raven.swing.MyTextField myTextField4;
    private com.raven.swing.MyTextField useremaillbl;
    private com.raven.swing.MyTextField useridlbl;
    private com.raven.swing.MyTextField usernamelbl;
    // End of variables declaration//GEN-END:variables
}
