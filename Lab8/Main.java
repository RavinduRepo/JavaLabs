// Main.java
// Class to test the implementation of the Observer pattern.
public class Main {
    public static void main(String[] args) {
        // Create a news agency.
        NewsAgency agency = new NewsAgency();
        
        // Add topics to the news agency.
        agency.addTopic("Sports");
        agency.addTopic("Politics");

        // Create news channels.
        NewsChannel channel1 = new NewsChannel("Channel 1");
        NewsChannel channel2 = new NewsChannel("Channel 2");

        // Register news channels with the news agency.
        agency.registerObserver(channel1);
        agency.registerObserver(channel2);

        // Post news to the topics.
        agency.postNews("Breaking news in Sports!", "Sports");
        agency.postNews("New political development!", "Politics");

        // Remove a news channel.
        agency.removeObserver(channel1);

        // Post more news to see the effect of removal.
        agency.postNews("More sports news", "Sports");
    }
}
