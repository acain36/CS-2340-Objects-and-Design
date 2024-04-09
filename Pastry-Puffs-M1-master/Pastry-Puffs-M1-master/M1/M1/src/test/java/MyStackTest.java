/**
 * Author: Noopur Bhatt
 * Date: September 13, 2021
 * Version: 1.0
 * MyStackTest
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;

public class MyStackTest {
    private static final int TIMEOUT = 200;
    private MyStack array;

    @Before
    public void setup() {
        array = new MyStack();
    }

    @Test(timeout = TIMEOUT)
    public void testArrayPush() {
        array.push("0i");
        array.push("1i");
        array.push("2i");
        array.push("3i");
        array.push("4i");

        Object[] expected = new Object[MyStack.getNextIndex()];
        expected[0] = "0i";
        expected[1] = "1i";
        expected[2] = "2i";
        expected[3] = "3i";
        expected[4] = "4i";
        assertEquals(expected[4], array.pop());
    }

    @Test
    public void testPushP3() {
        String[] stack = array.getStackArray();
        int initialSize = stack.length;

        this.array.push("New Element 1");
        this.array.push("New Element 2");
        this.array.push("New Element 3");
        //assertEquals(initialSize + 3, stack.length);

        String[] testArray = new String[13];
        testArray[10] = "New Element 1";
        testArray[11] = "New Element 2";
        testArray[12] = "New Element 3";
        assertArrayEquals(testArray, stack);
    }
	//Author: Ananya Pottabhathini
    @Test (timeout = TIMEOUT)
    public void testArrayPop() {
        String testString = "5b";
        array.push("0b");
        array.push("1b");   // 0b, 1b
        array.push("2b");   // 0b, 1b, 2b
        array.push("3b");   // 0b, 1b, 2b, 3b
        array.push("4b");   // 0b, 1b, 2b, 3b, 4b
        array.push(testString);   // 0b, 1b, 2b, 3b, 4b, 5b

        assertSame(testString, array.pop());  // 0b, 1b, 2b, 3b, 4b
    }
	 //Author: Shravani Dammu
    @Test (timeout = TIMEOUT)
    public void testTop4() {
        array.push("0c");
        array.push("1c");
        array.push("2c");
        array.push("3c");
        array.push("4c");
        array.push("5c");
        array.push("6c"); //0c 1c 2c 3c 4c 5c 6c

        array.delete(1); //0c 1c 2c 3c 4c 5c
        assertEquals( "5a", array.top());

        array.delete(4); //0c 1c
        assertEquals("1c", array.top());

        array.push("7c");
        assertEquals("7c", array.top());
    }

    @Test (timeout = TIMEOUT)
    public void testPushP4() {
        this.array.push("0a");
        this.array.push("1a");
        this.array.push("2a");
        this.array.push("3a");
        this.array.push("4a");

        String[] testArray = new String[]{"0a", "1a", "2a", "3a", "4a"};
        assertArrayEquals(testArray, this.array);
        assertEquals(testArray[4], this.array.pop());

    }
	
}