public class StackOfIntegers {
    private int[] elements;
    private int size; // default 0
    public static final int DEFAULT_CAPACITY = 16;

    /** Construct a stack with the default capacity 16 */
    public StackOfIntegers() {
        this (DEFAULT_CAPACITY);
    }

    /** Construct a stack with the specified maximum capacity */
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    /** Push a new integer to the top of the stack */
    public void push(int value) {
        if (size >= elements.length) {
            // create a new array with double the size
            int[] temp = new int[elements.length * 2];
            // copy elements from the original to the temp
            System.arraycopy(elements, 0, temp, 0, elements.length);
            // assign the new array to the original
            elements = temp;
        }

        elements[size++] = value; // increments size after assigning value.
    }

    /** Return and remove the top element from the stack */
    public int pop() {
        // return the element, but this time decrement the size, so each pop
        // will decrement the size earlier, and never return the previous top stack.
        return elements[--size];
    }

    /** Return the top element from the stack */
    public int peek() {
        return elements[size - 1];
    }

    /** Test whether the stack is empty */
    public boolean empty() {
        return size == 0; // True if size is zero.
    }

    /** Return the number of elements in the stack */
    public int getSize() {
        return size;
    }
}
