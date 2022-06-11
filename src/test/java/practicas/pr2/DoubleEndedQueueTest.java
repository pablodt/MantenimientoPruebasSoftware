package practicas.pr2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    @Test
    public void appendShouldAddANodeAtTheEndOfTheQueue() {
        // Paso 1: Crear objeto mock
        DoubleEndedQueue doubleEndedQueue = Mockito.mock(DoubleEndedQueue.class);

        DequeNode<Integer> dequeNode1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> dequeNode2 = new DequeNode<>(20, null, null);
        DequeNode<Integer> dequeNode3 = new DequeNode<>(30, null, null);

        // Paso 2: Definir comportamiento


        // Paso 3: Ejecución

        // Paso 4: Verificación
    }

}