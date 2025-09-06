BuilderPatterns.java

What it shows: fluent APIs via interfaces where a default method returns this for chaining (a mini “builder pattern”).

Typical structure you wrote (conceptually):
    interface Builder<T> with a default method like T setName(String name) that returns (T) this.
    class User implements Builder<User> with possibly more setters and a small main.

How this is used:
    Inside the interface default method, this refers to the implementing object (e.g., a User instance).
    Returning (T) this enables chaining: new User().setName("Rama").setAge(21)...

Execution flow:
    1. new User() creates the implementing object.
    2. Call setName("Rama") defined in the interface; this is the User object.
    3. The method returns this, so you can call the next method immediately.

Expected output (example):
    Setting name: Rama
    (+ whatever your subsequent chained calls print)

Why it matters:
    This is how many fluent APIs work (think StringBuilder, some Spring DSLs, config builders).

Gotchas & tips:
    The (T) this cast relies on the class implementing Builder<User>. If you forget the generic or implement wrongly, you’ll get cast warnings/errors.
    Keep builder-style methods side-effect free except for setting fields; return this.

DefaultMethods.java

What it shows: using this inside interface default methods.

Typical structure:
    interface Vehicle with default void printInfo().
    Implementations: class Car implements Vehicle, class Bike implements Vehicle.
    In main, create Vehicle v1 = new Car(); v1.printInfo(); etc.

How this is used:
    In printInfo(), this.getClass().getSimpleName() prints the concrete type (Car, Bike), even though we’re inside the interface.

Execution flow:
    1. new Car() creates a Car.
    2. printInfo() (default method) runs on the Vehicle reference, but this is the Car object.
    3. Prints the concrete type.

Expected output:
    I am a vehicle of type: Car
    I am a vehicle of type: Bike


Why it matters:
    Default methods let interfaces ship behavior without forcing every implementer to re-implement it.
    this inside default methods is fully polymorphic.

Gotchas:
    You can’t use this in static interface methods (no instance).
    If multiple interfaces provide the same default method, the class must resolve the conflict (see next file).



MultipleInterfaceConflictResolution.java

What it shows: resolving default method conflicts when implementing multiple interfaces with the same method signature.

Typical structure:
    interface A { default void show(){...} }
    interface B { default void show(){...} }
    class C implements A, B { @Override public void show(){ A.super.show(); B.super.show(); ... } }

How this is used:
    Not strictly required to resolve the conflict, but often used to print the current class (this.getClass().getSimpleName()), clarifying which type resolved it.

Execution flow:
    1. C obj = new C();
    2. obj.show() must resolve conflict explicitly in C.
    3. Inside C.show(), you call A.super.show() then B.super.show(); optionally print something about this.

Expected output:
    From A
    From B
    Resolved by: C


Why it matters:
    Realistic when mixing traits/capabilities from multiple interfaces.
    You learn how to call a specific parent interface method via X.super.method().

Gotchas:
    If you don’t override the method in C, it won’t compile due to ambiguity.
    You cannot do super.show() (no single parent class) — must qualify: A.super.show() or B.super.show().


PrivateMethods.java

What it shows: private methods in interfaces (Java 9+) and using this inside them.

Typical structure:
    interface Logger with private void log(String msg) and a default void info(String msg) that calls log(msg).
    class Service implements Logger and a main that calls new Service().info("Started service");

How this is used:
    Inside log(...), this still refers to the implementing instance (Service).
    You may log this.getClass().getSimpleName().

Execution flow:
    1. Service s = new Service();
    2. s.info("Started service") calls default info(...).
    3. info(...) calls private log(...) inside the interface; this is the Service instance.

Expected output:
    Log: Started service from Service

Why it matters:
    Private interface methods let you refactor shared logic used by multiple default methods without exposing them to implementers.
    Keeps default methods DRY and tidy.

Gotchas:
    Private methods in interfaces are not visible to implementers; they are only callable from other interface methods.
    Requires Java 9+.



ThisFromInterfaceMethods.java

What it shows: passing this from an interface default method to some handler — a common callback/event pattern.

Typical structure:
    interface Clickable { default void click(Handler h){ h.handle(this); } }
    class Button implements Clickable {}
    class Handler { void handle(Clickable c){ ... } }
    main calls new Button().click(new Handler());

How this is used:
    In the default method, this is the concrete Button instance.
    You hand this to the handler so it knows which object fired the event.

Execution flow:
    1. new Button() creates the implementer.
    2. .click(handler) runs the interface default method.
    3. handler.handle(this) passes the current button; handler can branch by type or query state.

Expected output (example):  
    Handling click from Button


Why it matters:
    Mirrors UI/event systems: the event source (the component) is passed to a listener/handler.
    Cleanly decouples the event producer from the consumer.

Gotchas:
    Be careful about exposing mutable state through the handler; define clear contracts for what the handler can do with the passed object.
    If your interface is generic, you can type the handler more strongly (e.g., Handler<? super Clickable> or Handler<Button> patterns).

Quick comparison (when this is available in interfaces)
 ✅ default methods: yes
 ✅ private methods (Java 9+): yes
 ❌ static methods: no (this doesn’t exist)
 ❌ constructors: interfaces don’t have them