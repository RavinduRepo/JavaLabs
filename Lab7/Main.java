import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a new instance of the game frame
        GameFrame gameFrame = new GameFrame();
        gameFrame.setTitle("TicTacToe"); // Set title of the game frame
        gameFrame.setSize(600, 600); // Set size of the game frame
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        gameFrame.setLocationRelativeTo(null); // Center the game frame on the screen
        gameFrame.setVisible(true); // Make the game frame visible
    }
}
