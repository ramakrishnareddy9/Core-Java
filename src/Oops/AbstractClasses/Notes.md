What is an Abstract Class?
    An abstract class is a class that cannot be instantiated (you cannot create objects directly).
    It is used as a base class to be extended by other classes.
    Can have:
        Abstract methods (declared but not implemented).
        Concrete methods (with body).
        Constructors (yes, unlike interfaces).
        Fields (both static and instance).

-> Key Rules:
    Declared using the abstract keyword.
    Can have 0 or more abstract methods.
    If a class has at least one abstract method, the class itself must be abstract.
    Child classes must implement all abstract methods (unless child is also abstract).
    Supports constructors (used during object creation via subclass).
    Can have instance variables, static variables, final variables.
    Can use this and super.
    Variables : Instance + static + final allowed
    Multiple Inheritance : Not allowed
    Access Modifiers : Any (private, protected, public)

-> Use abstract class when you want to share state (fields) and some common methods among subclasses.
-> Use interface when you want to define a contract that can be applied to multiple, unrelated classes.