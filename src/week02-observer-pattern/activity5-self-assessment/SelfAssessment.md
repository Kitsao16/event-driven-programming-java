# Activity 5: Final Self-Assessment — Observer Pattern

**Course:** Event-Driven Programming
**Topic:** Observer Design Pattern
**Activity:** Week 2 Final Self-Assessment

## Learning Outcome 1: Design and Implement the Observer Pattern

### Question 1: Draw the UML diagram of the Observer pattern. Label Subject, Observer, ConcreteSubject, ConcreteObserver.

**Answer:**

The Observer Pattern consists of four main roles:

* **Subject:** Defines methods for registering observers, removing observers, and notifying registered observers.
* **Observer:** Defines the notification or update method that concrete observers must implement.
* **ConcreteSubject:** Stores its state and the registered observers. When its state changes, it notifies the observers.
* **ConcreteObserver:** Implements the Observer interface and responds to notifications from the subject.

The relationship can be represented as follows:

```text
       +----------------------+
       |       Subject        |
       +----------------------+
       | registerObserver()   |
       | removeObserver()     |
       | notifyObservers()    |
       +----------------------+
                  ^
                  |
       +----------------------+
       |   ConcreteSubject    |
       +----------------------+
       | state                |
       | observerList         |
       +----------------------+
                  |
                  | notifies
                  v
       +----------------------+
       |      Observer        |
       +----------------------+
       | update()             |
       +----------------------+
                  ^
                  |
       +----------------------+
       |  ConcreteObserver    |
       +----------------------+
       | observer response    |
       +----------------------+
```

The diagram shows that the ConcreteSubject manages its observers and notifies them through the Observer interface. ConcreteObserver implements the update behaviour.

### Question 2: Write the Java code (from memory) for a Subject interface.

**Answer:**

```java
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
```

The Subject interface defines the operations required to manage observers and communicate state changes. Concrete subject classes implement these methods.

### Question 3: Why does the Subject need a list of observers?

**Answer:**

The Subject needs a list of observers to keep track of the objects that have registered to receive notifications. When the subject's state changes, it iterates through this list and invokes each observer's update method. This allows multiple objects to react to the same event without the subject needing to know the specific implementation of each observer.

## Learning Outcome 2: Evaluate Legacy `java.util.Observer`

### Question 4: List three problems with `java.util.Observable`.

**Answer:**

1. **Single inheritance limitation:** `Observable` is a class, not an interface. A class extending it cannot extend another class.
2. **Unspecified notification order:** The API does not guarantee the order in which observers are notified.
3. **The `setChanged()` requirement:** The programmer must call `setChanged()` before `notifyObservers()`. Forgetting this step can prevent notifications from being delivered.

Other limitations discussed in the practical include the pull-based approach to retrieving data and limited extensibility.

### Question 5: Why was this API deprecated?

**Answer:**

The `java.util.Observer` and `java.util.Observable` API was deprecated in Java 9 because of design limitations. These include the single-inheritance restriction imposed by `Observable` being a class, the need to manage the changed flag, unspecified notification order, and limited extensibility. Custom Observer interfaces and other notification mechanisms can provide more suitable designs for modern applications.

### Question 6: What is the "pull model" and why is it harder to use?

**Answer:**

In the pull model, the subject notifies observers that a change has occurred but does not necessarily pass the changed data with the notification. The observer retrieves the required information by calling getter methods on the subject. This can require additional method calls and makes the observer dependent on the subject's data-access methods.

## Learning Outcome 3: Create a Custom Event Notification System

### Question 7: What methods must a custom Subject interface provide?

**Answer:**

A custom Subject interface should provide methods to register observers, remove observers, and notify registered observers. For example:

```java
public interface DataSubject {

    void addObserver(DataObserver observer);

    void removeObserver(DataObserver observer);

    void notifyObservers();
}
```

These methods allow observers to subscribe to events, unsubscribe when they are no longer interested, and receive notifications when the subject's state changes.

### Question 8: How does the Subject notify all observers?

**Answer:**

The Subject stores registered observers in a collection, such as an `ArrayList`. When its state changes, it loops through the collection and calls the update method defined by the observer interface. Each observer then performs its own response to the notification.

For example:

```java
public void notifyObservers() {

    for (DataObserver observer : observers) {
        observer.onDataChanged(value);
    }
}
```

This approach allows different observers to respond to the same state change independently.

### Question 9: How do you prevent a memory leak when observers are no longer needed?

**Answer:**

Observers should be removed from the subject's observer list when they are no longer needed. This prevents the subject from unnecessarily retaining references to those observers. A suitable lifecycle management strategy should ensure that observers are unregistered when a display, component, or other object is closed or disposed of.

## Learning Outcome 4: Compare Different Mechanisms

### Question 10: Name four event notification mechanisms in Java.

**Answer:**

The four mechanisms covered in the practical are:

1. Custom Observer interfaces.
2. `java.util.Observer` and `java.util.Observable`.
3. `PropertyChangeListener` from `java.beans`.
4. JavaFX Properties and Bindings.

They provide different ways to implement or support notifications, depending on the application's requirements and framework.

### Question 11: Which one is best for JavaFX?

**Answer:**

JavaFX Properties and Bindings are the appropriate choice for JavaFX applications. They support reactive relationships between values and can help keep user-interface elements updated when related data changes.

### Question 12: Which one is deprecated?

**Answer:**

`java.util.Observer` and `java.util.Observable` were deprecated in Java 9. They are generally avoided in new designs in favour of custom Observer implementations or other suitable event-notification mechanisms.

## Conclusion

The Observer Pattern provides a way for a subject to notify multiple observers when its state changes. It supports loose coupling, extensibility, and separation of responsibilities. Understanding subject registration, notification, observer updates, and the differences between Java's notification mechanisms helps in designing maintainable event-driven applications.
