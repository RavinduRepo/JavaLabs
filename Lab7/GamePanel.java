import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GamePanel extends JPanel {
    private GameFrame gameFrame;
    private JButton[][] buttons;
    private Player player1, player2;
    private JLabel player1Label, player2Label, statusLabel;
    private int turnCount;
    private boolean player1Turn;

    public GamePanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());

        setBackground(new Color(224, 255, 255)); // Set background color to light cyan

        // Score panel to display player names and scores
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(new Color(224, 255, 255)); // Set background color to light cyan
        player1Label = new JLabel();
        player2Label = new JLabel();
        player1Label.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        player2Label.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        player1Label.setForeground(new Color(70, 130, 180)); // Set text color to steel blue
        player2Label.setForeground(new Color(70, 130, 180)); // Set text color to steel blue
        scorePanel.add(player1Label); // Add player 1 label to score panel
        scorePanel.add(player2Label); // Add player 2 label to score panel
        add(scorePanel, BorderLayout.NORTH); // Add score panel to the top of the panel

        // Game board panel with buttons
        JPanel gameBoard = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60)); // Set font and size
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(new Color(176, 224, 230)); // Set background color to powder blue
                buttons[i][j].setForeground(new Color(25, 25, 112)); // Set text color to midnight blue
                buttons[i][j].addActionListener(new ButtonClickListener(i, j)); // Add action listener to buttons
                gameBoard.add(buttons[i][j]); // Add button to game board panel
            }
        }
        add(gameBoard, BorderLayout.CENTER); // Add game board panel to the center of the panel

        // Control panel with status label and end game button
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(224, 255, 255)); // Set background color to light cyan
        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        statusLabel.setForeground(new Color(70, 130, 180)); // Set text color to steel blue
        controlPanel.add(statusLabel); // Add status label to control panel

        // End game button to end the current game
        JButton endGameButton = new JButton("End Game");
        endGameButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        endGameButton.setBackground(new Color(176, 224, 230)); // Set background color to powder blue
        endGameButton.setForeground(new Color(25, 25, 112)); // Set text color to midnight blue
        endGameButton.addActionListener(e -> {
            // Display final scores when end game button is clicked
            String message = String.format("%s: %d\n%s: %d",
                    player1.getName(), player1.getScore(),
                    player2.getName(), player2.getScore());
            JOptionPane.showMessageDialog(this, message, "Final Scores", JOptionPane.INFORMATION_MESSAGE);
            gameFrame.showMainMenuPanel(); // Switch to main menu panel
        });

        controlPanel.add(endGameButton); // Add end game button to control panel
        add(controlPanel, BorderLayout.SOUTH); // Add control panel to the bottom of the panel
    }

    // Set player names for the game
    public void setPlayerNames(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        player1Label.setText(player1.getName() + ": " + player1.getScore()); // Update player 1 label
        player2Label.setText(player2.getName() + ": " + player2.getScore()); // Update player 2 label
        resetBoard(); // Reset the game board
    }

    // Reset the game board
    private void resetBoard() {
        turnCount = 0;
        player1Turn = true;
        statusLabel.setText(player1.getName() + "'s turn (X)"); // Display player 1's turn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(""); // Clear button text
                buttons[i][j].setEnabled(true); // Enable buttons
            }
        }
    }

    // Update player scores
    private void updateScores() {
        player1Label.setText(player1.getName() + ": " + player1.getScore()); // Update player 1 label
        player2Label.setText(player2.getName() + ": " + player2.getScore()); // Update player 2 label
    }

    // Check game status to determine winner or draw
    private void checkGameStatus() {
        String winner = getWinner();
        if (winner != null) {
            if (winner.equals("X")) {
                player1.incrementScore(); // Increment player 1's score
               
                JOptionPane.showMessageDialog(this, player1.getName() + " (X) wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                saveResultToFile(player1.getName() + " (X) wins!"); // Save game result to file
            } else if (winner.equals("O")) {
                player2.incrementScore(); // Increment player 2's score
                JOptionPane.showMessageDialog(this, player2.getName() + " (O) wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                saveResultToFile(player2.getName() + " (O) wins!"); // Save game result to file
            }
            updateScores(); // Update player scores
            resetBoard(); // Reset the game board
        } else if (turnCount == 9) {
            JOptionPane.showMessageDialog(this, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            saveResultToFile("It's a draw!"); // Save game result to file
            resetBoard(); // Reset the game board
        } else {
            statusLabel.setText((player1Turn ? player1.getName() + "'s turn (X)" : player2.getName() + "'s turn (O)")); // Display player's turn
        }
    }

    // Determine the winner of the game
    private String getWinner() {
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().isEmpty() &&
                buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText())) {
                return buttons[i][0].getText(); // Return winning symbol
            }
        }

        for (int j = 0; j < 3; j++) {
            if (!buttons[0][j].getText().isEmpty() &&
                buttons[0][j].getText().equals(buttons[1][j].getText()) &&
                buttons[1][j].getText().equals(buttons[2][j].getText())) {
                return buttons[0][j].getText(); // Return winning symbol
            }
        }

        if (!buttons[0][0].getText().isEmpty() &&
            buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText())) {
            return buttons[0][0].getText(); // Return winning symbol
        }

        if (!buttons[0][2].getText().isEmpty() &&
            buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText())) {
            return buttons[0][2].getText(); // Return winning symbol
        }

        return null; // Return null if there's no winner
    }

    // Save game result to file
    private void saveResultToFile(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scoreboard.txt", true))) {
            writer.write(player1.getName() + " vs " + player2.getName() + ": " + result); // Write game result to file
            writer.newLine(); // Write a new line
        } catch (IOException e) {
            e.printStackTrace(); // Print exception stack trace if an error occurs
        }
    }

    // Action listener for game buttons
    private class ButtonClickListener implements ActionListener {
        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[x][y].getText().isEmpty()) {
                buttons[x][y].setText(player1Turn ? "X" : "O"); // Set symbol based on player turn
                buttons[x][y].setEnabled(false); // Disable button
                turnCount++; // Increment turn count
                player1Turn = !player1Turn; // Toggle player turn
                checkGameStatus(); // Check game status
            }
        }
    }
}
