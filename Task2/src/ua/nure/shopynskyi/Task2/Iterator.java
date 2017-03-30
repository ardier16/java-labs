package ua.nure.shopynskyi.Task2;


public interface Iterator extends java.util.Iterator<Object> {

    // Returns true if the iteration has more elements
    boolean hasNext();

    // Returns the next element in the iteration
    Object next();

    // Removes the last element returned by this iterator
    // This method can be called only once per call to next()
    // Method throws IllegalStateException if:
    // (1) the next method has not yet been called, or
    // (2) the remove method has already been called after the last call to the next method
    void remove();
}