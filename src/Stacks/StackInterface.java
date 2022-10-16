package Stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public interface StackInterface<T> {
    /** Adds a new entry to the top of this stack.
     @param newEntry  An object to be added to the stack. */
    public void push(T newEntry);

    /** Removes and returns this stack's top entry.
     @return  The object at the top of the stack.
     @throws EmptyStackException if the stack is empty before the operation. */
    public T pop();

    /** Retrieves this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty. */
    public T peek();

    /** Detects whether this stack is empty.
     @return  True if the stack is empty. */
    public boolean isEmpty();

    /** Removes all entries from this stack. */
    public void clear();

    public void display();


    /** takes a stack and removes every instance of the minimum value, and then returns the minimum value
     * runs in O(N)
     *
     * @param s the stack to remove the minimum from
     * @return the value of the minimum
     */
    public int removeMin(Stack s);

    /** takes a stack and returns true if it is sorted in ascending order bottom to top
     * false if it is not
     * runs in O(N)
     *
     * @param s the stack to check
     * @return returns true if sorted, false if not - empty stacks are considered sorted
     */
    public boolean isSorted(Stack s);

}