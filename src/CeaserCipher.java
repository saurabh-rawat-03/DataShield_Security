
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class CeaserCipher extends javax.swing.JPanel {
    
    private PanelLoading loading;
    static final String ALPHA="ABCDEFGHIJKLMNOPQRSTUVQXYZ";
    static final String alpha="abcdefghijklmnopqrstuvwxyz";
    


    int key;
    public CeaserCipher(String key) {
        loading = new PanelLoading();
        this.key = Integer.parseInt(key);

        initComponents();
        
        outputBtn.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        encryptBtn = new javax.swing.JButton();
        outputBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caeser Cipher");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Plain Text");

        jTextArea1.setBackground(new java.awt.Color(230, 245, 241));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(75, 175, 152));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Select file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cipher Text");

        jTextArea2.setBackground(new java.awt.Color(230, 245, 241));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        encryptBtn.setBackground(new java.awt.Color(75, 175, 152));
        encryptBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        encryptBtn.setForeground(new java.awt.Color(0, 0, 0));
        encryptBtn.setText("Encrypt");
        encryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptBtnActionPerformed(evt);
            }
        });

        outputBtn.setBackground(new java.awt.Color(75, 175, 152));
        outputBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        outputBtn.setForeground(new java.awt.Color(0, 0, 0));
        outputBtn.setText("Save file");
        outputBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(encryptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(outputBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(encryptBtn)
                    .addComponent(outputBtn))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void outputBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputBtnActionPerformed
        try {
            // TODO add your handling code here:

            JFileChooser chooser = new JFileChooser();
            int a = chooser.showSaveDialog(this);

            if(a == JFileChooser.APPROVE_OPTION){

                File f = chooser.getSelectedFile();
                FileWriter fw = new FileWriter(f);
                fw.write(jTextArea2.getText());
                fw.close();
            }

            JOptionPane.showMessageDialog(null, "File saved Successfully");
        } catch (IOException ex) {
            Logger.getLogger(CeaserCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_outputBtnActionPerformed

    private void encryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptBtnActionPerformed
        // TODO add your handling code here:

        String data = jTextArea1.getText();

        loading();

        String res = encrypt(data, key);

        jTextArea2.setText(res);

        outputBtn.setEnabled(true);

    }//GEN-LAST:event_encryptBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();

        try {
            Scanner in = new Scanner(f);
            String data = "";
            while(in.hasNext()){
                data += in.nextLine();
            }

            jTextArea1.setText(data);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error reading the file");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    
    private String encrypt(String plain, int key){
       
//        int len = data.length();
        
        
//        String output="";
        
        int n = plain.length();
        String c=""; //String to store the encrypted data

        for(int i=0;i<n;i++){
            char b;
            char a=plain.charAt(i);
            int x;

            //To check if character is in UpperCase
            if(Character.isUpperCase(a)){
                x=ALPHA.indexOf(a);
                if(x!=-1){
                    x=(x+key)%26;//To produce the character according to the key
                    if(x<0){
                        x=x+26;
                    }
                }
                b=ALPHA.charAt(x);
                c=c+b;
            }

            //To check if character is in LowerCase
            else if(Character.isLowerCase(a)){
                x=alpha.indexOf(a);
                if(x!=-1){
                    x=(x+key)%26;//To produce the character according to the key
                    if(x<0){
                        x=x+26;
                    }
                }
                b=alpha.charAt(x);
                c=c+b;
            }
            
            //To check if the plaintext contains any special character
            else {
                c = c + plain.charAt(i);
//                c="Invalid";
            }
        }

        return c;
//        return output;
    }
    
    
    private void loading(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                loading.setVisible(true);
                
                try{
                    Thread.sleep(5000);
                    loading.setVisible(false);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
                
            }
        }).start();
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton encryptBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton outputBtn;
    // End of variables declaration//GEN-END:variables
}
