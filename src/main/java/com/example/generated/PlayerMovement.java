import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerMovement extends JPanel {
    private int playerX = 100;
    private int playerY = 100;
    private final int playerSize = 20;

    public PlayerMovement() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        playerY -= 5; // Move up
                        break;
                    case KeyEvent.VK_DOWN:
                        playerY += 5; // Move down
                        break;
                    case KeyEvent.VK_LEFT:
                        playerX -= 5; // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        playerX += 5; // Move right
                        break;
                }
                repaint(); // Repaint the panel to update the player's position
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, playerSize, playerSize); // Draw the player
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Player Movement");
        PlayerMovement playerMovement = new PlayerMovement();
        frame.add(playerMovement);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        playerMovement.requestFocusInWindow(); // Request focus for key events
    }
}