// NewsChannel.java
// Class representing a news channel that receives news updates.
public class NewsChannel implements Observer {
    private String name;  // Name of the news channle

    // Constructor to initialize the news channel with a name.
    public NewsChannel(String name) {
        this.name = name;
    }

    // Method to update the news channel with new news.
    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}
