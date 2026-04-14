#### Lesson 5 introduced the Diamond Problem that must be handled by any language that supports multiple inheritance. Java SE 8 now supports “behavioral” multiple inheritance (but not “data” multiple inheritance). Explain how features of Java 8 handle the Diamond Problem by considering two scenarios:

- Java avoids the diamond problem in classes by disallowing multiple inheritance.
- In interfaces (Java 8), ambiguity from default methods is resolved by forcing the implementing class to override the method explicitly.
