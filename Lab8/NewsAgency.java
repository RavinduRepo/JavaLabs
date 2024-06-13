// NewsAgency.java
// Class representing a news agency that notifies registered news channels about new news.
import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();  // List of registered observers.
    private List<String> topics = new ArrayList<>();  // List of news topics.

    // Method to add a new topic.
    public void addTopic(String topic) {
        topics.add(topic);
    }

    // Method to register an observer.
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // Method to remove an observer.
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // Method to notify all registered observers about new news.
    @Override
    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    // Method to post news to a specific topic.
    public void postNews(String news, String topic) {
        if (topics.contains(topic)) {
            System.out.println("News Posted: " + news);
            notifyObservers(news);
        } else {
            System.out.println("Topic not found: " + topic);
        }
    }
}
