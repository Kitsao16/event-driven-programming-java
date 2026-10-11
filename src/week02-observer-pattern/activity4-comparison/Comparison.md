# Comparison of Event Notification Mechanisms in Java

| Feature                              | Custom Observer           | java.util.Observer              | PropertyChangeListener                      | JavaFX Bindings                |
|--------------------------------------|---------------------------|---------------------------------|---------------------------------------------|--------------------------------|
| Push or Pull?                        | Both possible             | Pull                            | Push (carries old and new values)           | Push                           |
| Is it deprecated?                    | No                        | Yes (Java 9+)                   | No                                          | No                             |
| Requires inheritance?                | No (interface)            | Yes (class)                     | No                                          | No                             |
| Thread-safe?                         | Depends on implementation | No general guarantee            | Depends on usage and synchronization        | Depends on framework and usage |
| Automatically generates boilerplate? | No                        | No                              | Yes, via PropertyChangeSupport              | Yes                            |
| Best for                             | Custom systems            | Existing legacy code            | JavaBeans and property-change notifications | JavaFX applications            |
| Can have multiple listeners?         | Yes                       | Yes                             | Yes                                         | Yes                            |
| Can be typed to send data?           | Yes                       | No (Object)                     | Yes, though generics are not typical        | Yes                            |
| Recommended today?                   | Yes, when appropriate     | Generally avoid for new designs | Yes, when suitable                          | Yes, for JavaFX applications   |
## Which One Should You Use?

- For a plain Java project with custom needs: Custom Observer.
- For a JavaFX application: JavaFX Bindings.
- For legacy code using JavaBeans: PropertyChangeListener.
- Avoid java.util.Observer and Observable in new designs because they are deprecated.
