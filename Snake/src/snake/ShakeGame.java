
package snake;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static snake.ShakeGame.WIDTH;

public class ShakeGame extends JPanel {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    
    public ShakeGame(){
        
    }
    public void paint(Graphics g){
        g.setColor(color(40,70 ,50));
        g.fillRect( 0, 0,WIDTH*SCALE, HEIGHT*SCALE);
        g.setColor(color(255,216,0));
        
        for (int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE ){
            g.drawLine(xx, 0, xx, HEIGHT*SCALE); 
                
        }
         for (int yy = 0; yy <= WIDTH*SCALE; yy+=SCALE ){
            g.drawLine(0,yy , WIDTH*SCALE, yy);
         }
    }  
    public Color color (int red,int green,int blue){
        return new Color(red, green, blue);
    }
    
    
public static void main(String[] args) {   
        JFrame f= new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false); 
        f.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+30);
        f.setLocationRelativeTo(null); 
        f.add(new ShakeGame());
        f.setVisible(true);
        
    }
    
}
