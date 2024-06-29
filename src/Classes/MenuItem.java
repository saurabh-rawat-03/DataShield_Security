
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import raven.effect.RippleEffect;


public class MenuItem extends JButton{
    
    private RippleEffect rippleEffect;
    
    private BufferedImage shadow;
    private int shadowWidth;
    private int shadowSize=10;
    
    private int index;
    private boolean subMenuAble;
    private float animate;

    public float getAnimate() {
        return animate;
    }

    public void setAnimate(float animate) {
        this.animate = animate;
    }
    
    //submenu
    
    private int subMenuIndex;
    private int length;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSubMenuAble() {
        return subMenuAble;
    }

    public void setSubMenuAble(boolean subMenuAble) {
        this.subMenuAble = subMenuAble;
    }

    public int getSubMenuIndex() {
        return subMenuIndex;
    }

    public void setSubMenuIndex(int subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public MenuItem(String name, int index, boolean subMenuAble){
        super(name);
        this.index = index;
        this.subMenuAble = subMenuAble;
        setContentAreaFilled(false);
        setForeground(new Color(230, 230, 230));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(9, 10, 9, 10));
        setIconTextGap(10);
        rippleEffect= new RippleEffect(this);
        rippleEffect.setRippleColor(new Color(220, 220, 220));
        
    }
    
    private void createShadowImage(){
        int width = getWidth();
        int height = 5;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle2D.Double(0, 0, width, height));
        shadow = new ShadowRenderer(shadowSize, 0.2f, Color.BLACK).createShadow(img);
        g2.dispose();
        
    }
    
    public void initSubMenu(int subMenuIndex, int length){
        this.subMenuIndex = subMenuIndex;
        this.length = length;
//        setContentAreaFilled(false);
        setBorder(new EmptyBorder(9, 33, 9, 10));
        setBackground(new Color(18, 99, 63));
        setOpaque(true);
    } 

    @Override
    protected void paintComponent(Graphics g) {
 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(length != 0){
            g2.setColor(new Color(43, 141, 98));
            
            if(subMenuIndex == 1){
                g2.drawImage(shadow, -shadowSize, -20, null);
                g2.drawLine(18, 0, 18, getHeight());
                g2.drawLine(18, getHeight()/2, 26, getHeight()/2);
            }else if(subMenuIndex == length  - 1){
                g2.drawImage(shadow, -shadowSize, getHeight()-6, null);
                g2.drawLine(18, 0, 18, getHeight()/2);
                g2.drawLine(18, getHeight()/2, 26, getHeight()/2); 
            }else {
                g2.drawLine(18, 0, 18, getHeight());
                g2.drawLine(18, getHeight()/2, 26, getHeight()/2);                 
            }
        }else if(subMenuAble){
            g2.setColor(getForeground());
            int arrowWidth = 8;
            int arrowHeight = 4;
            Path2D p = new Path2D.Double();
            p.moveTo(0, arrowHeight * animate);
            p.lineTo(arrowWidth /2 , (1f - animate) * arrowHeight);
            p.lineTo(arrowWidth, arrowHeight * animate);
            g2.translate(getWidth() - arrowWidth -15, (getHeight() - arrowHeight) / 2);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.draw(p);
        }
        
        g2.dispose();
        rippleEffect.reder(g, new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        
                
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        createShadowImage();
    }
    
    
   
    
}
