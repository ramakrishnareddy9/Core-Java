-> this is a reference variable in Java.
-> It refers to the current object (the object whose method/constructor is being executed).

-> this is created automatically by the JVM.
-> Can be used only in non-static context (since static belongs to class, not objects).
-> Every object has its own this.
-> this can be used in non-static method/blocks , abstract classes , interfaces

1. To refer current object’s fields
-> Removes ambiguity between instance variables and local variables/parameters.
Example :
    this.id = id;
    this.name = name;

2. To call another constructor in the same class (Constructor Chaining)
-> Must be the first statement inside a constructor.
Example :
    this("Default", 0);

3. To call current class methods
-> Useful when methods are shadowed or for better readability.
Example:
    this.display();

4. To return current object (method chaining)
-> Enables method chaining (fluent API / builder pattern).
Example :
    return this;
-> this method chaining is very important

5. To pass current object as an argument
-> Sends the current object to another method/class.
Example:
    other.method(this);

6. To access outer class instance from inner class
-> Syntax: OuterClass.this
-> Allows inner class to refer to its enclosing outer class object.
Example:
    Outer.this.x;

7. To use in synchronization (Multithreading)

-> synchronized(this) locks the current object for thread safety.
Example :
    synchronized(this) {
    // critical section
    }

-> Restrictions:
    -> Cannot be used inside static methods.
    -> Cannot assign a value to this (e.g., this = obj; is invalid).

**-> do we use this inside interface
yes, we use this inside interface but to not set instance varable but th get the details of the implemented class of the interface.