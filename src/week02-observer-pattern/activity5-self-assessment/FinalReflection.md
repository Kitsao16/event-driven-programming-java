# Week 2 Final Reflection: Observer Pattern

The Observer Pattern is a behavioural design pattern that allows a
subject to notify multiple registered observers whenever its state
changes. It is important because it reduces tight coupling, improves
maintainability, and makes it easier to add new components without
changing the subject's implementation. The pattern relates to
event-driven programming because components can respond to events
through notifications rather than relying on direct calls between
specific classes. Through this practical, I learned how to implement
custom Subject and Observer interfaces, manage observer registration,
and compare push and pull notification models. For a plain Java project
with custom requirements, I would choose a custom Observer
implementation because it gives me control over how observers are
registered and notified. For a JavaFX application, I would consider
JavaFX Properties and Bindings because they support reactive updates in
JavaFX user interfaces.