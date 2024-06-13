// Subject.java
// Interface for the subject in the Observer pattern.
public interface Subject {
    // Method to register an observer.
    void registerObserver(Observer o);
    
    // Method to remove an observer.
    void removeObserver(Observer o);
    
    // Method to notify all registered observers.
    void notifyObservers(String news);
}
