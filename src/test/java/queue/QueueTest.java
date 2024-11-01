package queue;

import com.github.carlosmonteiro.structures.queue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QueueTest {

    @Test
    public void shouldEnqueueItem() {
        final Queue<Integer> queue = new Queue<>();

        assertEquals(0, queue.getLength());
        assertNull(queue.getLast());
        assertNull(queue.getFirst());

        queue.enqueue(1);
        assertEquals(1, queue.getLength());
        assertEquals(1, queue.getLast());
        assertEquals(1, queue.getFirst());

        queue.enqueue(2);
        assertEquals(2, queue.getLength());
        assertEquals(2, queue.getLast());
        assertEquals(1, queue.getFirst());

        queue.enqueue(3);
        assertEquals(3, queue.getLength());
        assertEquals(3, queue.getLast());
        assertEquals(1, queue.getFirst());
    }

    @Test
    public void shouldDequeueItem() {
        final Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.getLength());
        assertEquals(2, queue.getFirst());
        assertEquals(3, queue.getLast());


        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.getLength());
        assertEquals(3, queue.getFirst());
        assertEquals(3, queue.getLast());

        assertEquals(3, queue.dequeue());
        assertEquals(0, queue.getLength());
        assertNull(queue.getFirst());
        assertNull(queue.getLast());

        assertNull(queue.dequeue());
        assertEquals(0, queue.getLength());
        assertNull(queue.getFirst());
        assertNull(queue.getLast());
    }
}
