package practicas.pr2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleEndedQueueTest {

    @Test
    public void appendShouldAddANodeAtTheEndOfTheQueue() {
        DoubleEndedQueue<Integer> doubleEndedQueue = new DoubleLinkedListQueue<Integer>();
        DoubleEndedQueue<Integer> spyDoubleEndedQueue = Mockito.spy(doubleEndedQueue);

        DequeNode<Integer> dequeNode1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> dequeNode2 = new DequeNode<>(20, null, null);
        DequeNode<Integer> dequeNode3 = new DequeNode<>(30, null, null);

        spyDoubleEndedQueue.append(dequeNode1);
        spyDoubleEndedQueue.append(dequeNode2);
        spyDoubleEndedQueue.append(dequeNode3);

        Mockito.verify(spyDoubleEndedQueue).append(dequeNode1);
        Mockito.verify(spyDoubleEndedQueue).append(dequeNode2);
        Mockito.verify(spyDoubleEndedQueue).append(dequeNode3);

        Mockito.verify(spyDoubleEndedQueue, Mockito.times(3)).append(Mockito.any());
        assertEquals(3, spyDoubleEndedQueue.size());

        Mockito.when(spyDoubleEndedQueue.size()).thenReturn(100);
        assertEquals(100, spyDoubleEndedQueue.size());
    }

}