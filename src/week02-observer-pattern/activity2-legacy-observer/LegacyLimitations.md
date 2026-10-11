# Limitations of java.util.Observer and java.util.Observable
## Limitation 1: Single Inheritance
Explain: Why is it a problem that Observable is a CLASS, not an INTERFACE?
## Your answer: 
Java permits a class to extend only one direct superclass. Therefore, a class that extends Observable cannot also extend another class. This restricts inheritance choices and can make the design less flexible.
## Limitation 2: Cannot Change the Notification Order
Explain: In what order are observers notified? Can you control this?
## Your answer: 
legacy Observable API does not guarantee a particular observer notification order. The program should not rely on observers being notified in registration order. If a specific order is required, a custom notification mechanism can explicitly define that order.
## Limitation 3: setChanged() is Confusing
Explain: Why must you call setChanged() before notifyObservers()?
## Your answer: 
The legacy notification method sends notifications only when the changed flag is set. Forgetting setChanged() can therefore prevent observers from receiving updates even when the underlying measurements have changed.
## Limitation 4: Pull Model by Default
Explain: How does the observer get the data? Is this efficient?
## Your answer: 
In the supplied example, notifyObservers() does not pass the weather measurements. The observer receives the observable reference in its update() method and retrieves the data through getter methods. This may require extra method calls and make the observer depend on the subject's getters, although pulling can be useful when observers need different subsets of information.
## Limitation 5: Deprecated Since Java 9
Explain: Why did Java deprecate these classes?
## Your answer: 
Java deprecated Observable and Observer in Java 9 because of design limitations, including single-inheritance restrictions, unspecified notification order, the need to manage the changed flag, and limitations in extensibility and notification design. Modern code can use alternatives such as custom observer interfaces or PropertyChangeListener, depending on the application's requirements.
Hint: The reasons include:
• Observable is a class, so you cannot extend any other class
• Observers are notified in an unspecified order
• setChanged() is easy to forget — observers silently don't get notified
• Observers must pull data from the Observable (extra method calls)
• The API is not thread-safe and not extensible