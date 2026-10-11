# Week 2: Observer Pattern Summary

## Introduction

The Observer Pattern is a behavioural design pattern that establishes a
one-to-many relationship between a subject and its observers. When the
subject's state changes, registered observers are notified and can
respond. It is important in event-driven programming because separate
parts of a program can react to changes without the subject directly
managing each component.

## Structure of the Pattern

The pattern has four main roles. The **Subject** defines operations for
registering, removing, and notifying observers. The **Observer** defines
the update method that observers implement. The **ConcreteSubject**
stores the state and maintains a collection of registered observers. The
**ConcreteObserver** implements the Observer interface and decides what
to do when it receives a notification.

In Java, the subject may store observers in a collection such as an
`ArrayList`. When the state changes, the subject calls a notification
method that loops through the collection and invokes each observer's
update method.

## Push and Pull Models

In the **push model**, the subject passes changed data directly to
observers as part of the notification. In the **pull model**, the
subject signals that something changed and observers retrieve the
information they need through the subject's methods. Push makes supplied
data immediately available; pull allows observers to choose which
information to retrieve.

## Advantages

The main advantage of the Observer Pattern is **loose coupling**. The
subject communicates through an observer interface rather than depending
on specific display classes. This makes it easier to add or remove
observers without rewriting the subject. It also separates
responsibilities because each observer determines how to respond. For
example, a weather station can notify current-conditions, statistics,
and forecast displays when new measurements arrive.

## Java Notification Mechanisms

The practical compares custom Observer interfaces, the legacy
`java.util.Observer`/`Observable` API, `PropertyChangeListener`, and
JavaFX Properties/Bindings. The legacy Observer API was deprecated in
Java 9 and has design limitations, including the inheritance restriction
and its notification model. `PropertyChangeListener` is used with
JavaBeans and Swing, while JavaFX Properties and Bindings are designed
for JavaFX applications. A custom Observer interface is useful when a
plain Java application needs a notification mechanism tailored to its
requirements.

## Conclusion

The Observer Pattern helps build flexible and maintainable event-driven
applications. It enables one subject to notify multiple observers while
reducing direct dependencies between components. Knowing how to register
and remove observers, notify them, and select an appropriate
notification mechanism helps developers design systems that are easier
to extend, test, and maintain.