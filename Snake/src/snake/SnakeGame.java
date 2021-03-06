package snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class SnakeGame extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static JLabel jLabel;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int SPEED = 5;

    Snake s = new Snake(10, 10, 10, 10);
    Apple apple = new Apple(Math.abs((int) (Math.random() * SnakeGame.HEIGHT - 1)), Math.abs((int) (Math.random() * SnakeGame.HEIGHT - 1)));
    Poison poison = new Poison(Math.abs((int) (Math.random() * SnakeGame.HEIGHT - 1)), Math.abs((int) (Math.random() * SnakeGame.HEIGHT - 1)));
    Timer timer = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        g.setColor(Color.red);//яблоко
        g.fillOval(apple.posX * SCALE + 4, apple.posY * SCALE + 4, SCALE - 8, SCALE - 8);
        g.setColor(Color.blue);//плохое яблоко
        g.fillOval(poison.posQ * SCALE + 4, poison.posW * SCALE + 4, SCALE - 8, SCALE - 8);

        for (int l = 1; l < s.length; l++) {
            g.setColor(Color.green);
            g.fillRect(s.sX[l] * SCALE + 3, s.sY[l] * SCALE + 3, SCALE - 6, SCALE - 6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0] * SCALE + 3, s.sY[0] * SCALE + 3, SCALE - 6, SCALE - 6);
        }

    }

    public static void main(String[] args) {
        jFrame = new JFrame("Game Snake");
        jLabel = new JLabel("Score:2");
        jFrame.add(jLabel, BorderLayout.AFTER_LAST_LINE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(WIDTH * SCALE + 6, HEIGHT * SCALE + 45);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new SnakeGame());
        jFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        s.move();
        //poison.setRandomPosition();

        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {//apple
            apple.setRandomPosition();
            s.length++;
            jLabel.setText("Score:" + s.length);

        }
        for (int l = 1; l < s.length; l++) {
            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
                apple.setRandomPosition();
            }
            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
                timer.stop();

                int reply = JOptionPane.showConfirmDialog(null, "Выйти?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.exit(0);

                } else {
                    jFrame.setVisible(false);
                    s.length = 2;
                    s.direction = 0;
                    apple.setRandomPosition();
                    jFrame.setVisible(true);
                    timer.start();
                }
            }
        }
        if ((s.sX[0] == poison.posQ) && (s.sY[0] == poison.posW)) {//blue apple
            poison.setRandomPosition();
            s.length-=4;
             
            
            if (s.length <= 1) {
                int reply = JOptionPane.showConfirmDialog(null, "Выйти?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.exit(0);

                } else {
                    jFrame.setVisible(false);
                    s.length = 2;
                    s.direction = 0;
                    apple.setRandomPosition();
                    jFrame.setVisible(true);
                    timer.start();
                }
            }

            jLabel.setText("Score:" + s.length);
        }

        repaint();

    }

    public class KeyBoard extends KeyAdapter {

        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();
            if ((key == KeyEvent.VK_UP) && (s.direction != 2)) {
                s.direction = 0;
            }
            if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) {
                s.direction = 2;
            }
            if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) {
                s.direction = 1;
            }
            if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) {
                s.direction = 3;
            }
        }

    }
}
