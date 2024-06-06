import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    public MainMenuPanel(GameFrame gameFrame) {
        setLayout(new BorderLayout());

        setBackground(new Color(224, 255, 255)); // Set background color to light cyan

        // Title label
        JLabel title = new JLabel("TicTacToe", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size
        title.setForeground(new Color(70, 130, 180)); // Set text color to steel blue
        add(title, BorderLayout.NORTH); // Add title label to the top of the panel

        // Play button
        JButton playButton = new JButton("Play Game");
        playButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        playButton.setBackground(new Color(176, 224, 230)); // Set background color to powder blue
        playButton.setForeground(new Color(25, 25, 112)); // Set text color to midnight blue
        playButton.addActionListener(e -> {
            // Open dialog to input player names when play button is clicked
            String player1 = JOptionPane.showInputDialog(this, "Enter Player 1 Name:");
            String player2 = JOptionPane.showInputDialog(this, "Enter Player 2 Name:");

            // If both player names are provided, start the game
            if (player1 != null && player2 != null && !player1.isEmpty() && !player2.isEmpty()) {
                gameFrame.setPlayerNames(player1, player2); // Set player names in the game frame
                gameFrame.showGamePanel(); // Switch to the game panel
            }
        });
        
        // Scoreboard button
        JButton scoreboardButton = new JButton("View Scoreboard");
        scoreboardButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        scoreboardButton.setBackground(new Color(176, 224, 230)); // Set background color to powder blue
        scoreboardButton.setForeground(new Color(25, 25, 112)); // Set text color to midnight blue
        scoreboardButton.addActionListener(e -> gameFrame.showScoreboardPanel()); // Show scoreboard when clicked

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(224, 255, 255)); // Set background color to light cyan
        buttonPanel.add(playButton); // Add play button to button panel
        buttonPanel.add(scoreboardButton); // Add scoreboard button to button panel

        add(buttonPanel, BorderLayout.CENTER); // Add button panel to the center of the panel
    }
}
