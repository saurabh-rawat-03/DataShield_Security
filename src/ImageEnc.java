import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImageEnc extends javax.swing.JPanel {

    public static final double A = 1.4;
    public static final double B = 1.0;
    public static final double C = 0.3;
    
    BufferedImage img;
    BufferedImage encImage;
    String encOutputPath;
    public ImageEnc() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Image Encryption");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("The following image encryption uses Henon Chaotic map to encrypt and decrypt the image input");

        jButton1.setText("Select file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save Encrypted Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(133, 133, 133)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();
        
        try {
            img = ImageIO.read(f);
            encImage = encrypt(img);

        } catch (IOException ex) {
            Logger.getLogger(ImageEnc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try {
            JFileChooser chooser = new JFileChooser();
            int a = chooser.showSaveDialog(this);

            if(a == JFileChooser.APPROVE_OPTION){
                File f = chooser.getSelectedFile();
                encOutputPath = f.getAbsolutePath() + ".jpg";
                System.out.println(encOutputPath);
                ImageIO.write(encImage, "jpg", new File(encOutputPath));
                JOptionPane.showMessageDialog(null, "File saved Successfully");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CeaserCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    public static BufferedImage encrypt(BufferedImage image) {
        // Get image dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // Extract RGB components from the image
        int[][][] components = getComponents(image, width, height);

        // Generate the Henon map scrambled matrix
        int[][][] scrambled = genHenonMap(width, height);

        // XOR operation between the image components and the Henon map
        int[][][] resultantMatrix = new int[width][height][3];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < 3; k++) {
                    resultantMatrix[i][j][k] = scrambled[i][j][k] ^ components[i][j][k];
                }
            }
        }

        // Create a new image with the encrypted data
        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int r = resultantMatrix[x][y][0];
                int g = resultantMatrix[x][y][1];
                int b = resultantMatrix[x][y][2];
                resultImage.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }
        return resultImage;
    }
    
    // Method for extracting RGB components from image
    private static int[][][] getComponents(BufferedImage image, int width, int height) {
        int[][][] components = new int[width][height][3];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                components[i][j][0] = (rgb >> 16) & 0xFF;
                components[i][j][1] = (rgb >> 8) & 0xFF;
                components[i][j][2] = rgb & 0xFF;
            }
        }
        return components;
    }

    // Method for generating the Henon map scrambled matrix
    private static int[][][] genHenonMap(int width, int height) {
        double x = 0.1;
        double y = 0.1;

        int N = Math.max(width, height);
        int iterations = width * height * 3;
        int[][][] scrambled = new int[width][height][3];

        for (int i = 0; i < iterations; i++) {
            double xN = (1 - A * x * x + y) % N;
            double yN = (B * x + C) % N;

            x = xN;
            y = yN;

            //Normalization
            // Ensure values are within the range 0-255 
            int intXN = Math.abs((int) (xN * 255) % 256);
            int intYN = Math.abs((int) (yN * 255) % 256);

            //Find color, row, and column indices
            int color = i % 3;
            int row = (i / 3) / width;
            int col = (i / 3) % width;

            // XOR operation 
            scrambled[row][col][color] = intXN ^ intYN;
        }
        return scrambled;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
