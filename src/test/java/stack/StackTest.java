package stack;

import com.github.carlosmonteiro.structures.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void shouldPushItem() {
        final Stack<Integer> stack = new Stack<>();

        assertEquals(0, stack.getHeight());
        assertTrue(stack.isEmpty());

        stack.push(1);

        assertEquals(1, stack.getHeight());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void shouldPopItem() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.getHeight());

        assertEquals(2, stack.pop());
        assertEquals(1, stack.getHeight());

        assertEquals(1, stack.pop());
        assertEquals(0, stack.getHeight());

        assertNull(stack.pop());
        assertEquals(0, stack.getHeight());
    }
}
