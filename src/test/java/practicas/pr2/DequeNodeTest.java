package practicas.pr2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {

    private DequeNode<Integer> dequeNode;

    @BeforeEach
    public void startUp() {
        dequeNode = new DequeNode<>(5, null, null);
    }


}