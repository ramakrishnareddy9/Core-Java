1. Static Variables (Class Variables):
    Shared by all objects of the class.
    Only one copy exists in memory (at class level).

2. Static Methods
    Can be called without creating objects.
    Can access static variables directly, but not instance variables.
    ** Rule: Static methods cannot use this or super.

3. Static Blocks
    Run once when the class is loaded into memory.
    Used for static initialization.

