import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;
    private ScoreboardPanel scoreboardPanel;

    // Constructor to initialize game frame and panels
    public GameFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize main menu panel, game panel, and scoreboard panel
        mainMenuPanel = new MainMenuPanel(this);
        gamePanel = new GamePanel(this);
        scoreboardPanel = new ScoreboardPanel(this);

        // Add panels to main panel with card layout
        mainPanel.add(mainMenuPanel, "MainMenu");
        mainPanel.add(gamePanel, "Game");
        mainPanel.add(scoreboardPanel, "Scoreboard");

        setContentPane(mainPanel); // Set main panel as content pane
        cardLayout.show(mainPanel, "MainMenu"); // Show main menu panel initially
        getContentPane().setBackground(new Color(224, 255, 255)); // Set background color to light cyan
    }

    // Show game panel
    public void showGamePanel() {
        cardLayout.show(mainPanel, "Game");
    }

    // Show main menu panel
    public void showMainMenuPanel() {
        cardLayout.show(mainPanel, "MainMenu");
    }

    // Show scoreboard panel
    public void showScoreboardPanel() {
        scoreboardPanel = new ScoreboardPanel(this); // Reload scoreboard panel
        mainPanel.add(scoreboardPanel, "Scoreboard"); // Add scoreboard panel to main panel
        cardLayout.show(mainPanel, "Scoreboard"); // Show scoreboard panel
    }

    // Set player names in game panel
    public void setPlayerNames(String player1, String player2) {
        gamePanel.setPlayerNames(player1, player2);
    }
}
