/**
 * Example from the "Pragmatic Unit Testing in Java with JUnit"
 * book by Andrew Hunt and David Thomas
 */

public class MyStack {
    private String[] stack;
    private static int next_index;

    public MyStack() {
        stack = new String[10];
        next_index = 0;
    }

    public String pop() {
        return stack[--next_index];
    }

    // Delete n items from the stack en-masse
    public void delete(int n) {
        next_index -= n;
    }

    public void push(String string) {
        stack[next_index++] = string;
    }

    public String top() {
        return stack[next_index - 1];
    }

    public static int getNextIndex() {
        return next_index;
    }

    public String[] getStackArray() {
        return stack;
    }
}
