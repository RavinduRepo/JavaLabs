import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreboardPanel extends JPanel {
    public ScoreboardPanel(GameFrame gameFrame) {
        setLayout(new BorderLayout());

        setBackground(new Color(224, 255, 255)); // Set background color to light cyan

        JLabel title = new JLabel("Scoreboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size
        title.setForeground(new Color(70, 130, 180)); // Set text color to steel blue
        add(title, BorderLayout.NORTH); // Add title label to the top of the panel

        JTextArea scoreArea = new JTextArea();
        scoreArea.setEditable(false);
        scoreArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        scoreArea.setForeground(new Color(70, 130, 180)); // Set text color to steel blue
        scoreArea.setBackground(new Color(224, 255, 255)); // Set background color to light cyan

        try (BufferedReader reader = new BufferedReader(new FileReader("scoreboard.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scoreArea.append(line + "\n"); // Append game result to text area
            }
        } catch (IOException e) {
            scoreArea.setText("No game results found."); // Display message if no game results are found
        }

        JScrollPane scrollPane = new JScrollPane(scoreArea);
        add(scrollPane, BorderLayout.CENTER); // Add scroll pane with text area to the center of the panel

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        backButton.setBackground(new Color(176, 224, 230)); // Set background color to powder blue
        backButton.setForeground(new Color(25, 25, 112)); // Set text color to midnight blue
        backButton.addActionListener(e -> gameFrame.showMainMenuPanel()); // Switch to main menu panel when button is clicked

        add(backButton, BorderLayout.SOUTH); // Add back button to the bottom of the panel
    }
}
