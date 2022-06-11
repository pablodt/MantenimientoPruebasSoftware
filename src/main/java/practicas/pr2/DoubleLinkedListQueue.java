package practicas.pr2;

import java.util.LinkedList;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;

    public DoubleLinkedListQueue() {
        first = null;
        last = null;
    }

    @Override
    public void append(DequeNode<T> node) {
        if (size() == 0) {

        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {

    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public DequeNode<T> peekFirst() {
        return null;
    }

    @Override
    public DequeNode<T> peekLast() {
        return null;
    }

    @Override
    public int size() {
        if (first.isLastNode()) {
            return 0;
        }
        return doSize(first);
    }

    private int doSize(DequeNode<T> node) {
        return node.isLastNode() ? 1 : 1 + doSize(node.getNext());
    }
}
