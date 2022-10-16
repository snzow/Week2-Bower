package Stacks;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 A class of stacks whose entries are stored in an array.
 @author Frank M. Carrano and Timothy M. Henry
 @version 5.1
 */
public final class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty

    public void clear()
    {
        checkIntegrity();

        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        } // end while
        //	Assertion: topIndex is -1
    } // end clear

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException ("ArrayStack object is corrupt.");
    } // end checkIntegrity

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity

    // Doubles the size of the array stack if it is full
    // Precondition: checkIntegrity has been called.
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    public void display () {           //print the stack elements
        for(int i = topIndex; i>=0;i--) {
            System.out.print(stack[i] + " ");
        }
    }
    public int removeMin(Stack s) {
        Stack copy = (Stack) s.clone();
        int min = (int)copy.pop();
        for (int i = 0; i < s.size() - 1; i++){
            int toCompare = (int)copy.pop();
            if (toCompare < min){
                min = toCompare;
            }
        }
        for (int i = 0; i < s.size(); i++){
            int toSave = (int)s.pop();
            if(toSave > min){
                copy.add(toSave);
            }
        }
        for (int i = 0; i < copy.size(); i++){
            s.add(copy.pop());
        }
        return min;
    }

    public boolean isSorted(Stack s){

    }


} // end ArrayStack
