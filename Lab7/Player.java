public class Player {
    private String name;
    private int score;

    // Constructor to initialize player with a name
    public Player(String name) {
        this.name = name;
        this.score = 0; // Initialize score to 0
    }

    // Get player name
    public String getName() {
        return name;
    }

    // Get player score
    public int getScore() {
        return score;
    }

    // Increment player score
    public void incrementScore() {
        score++;
    }
}
