package practicas.pr2;

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
            first = node;
            last = node;
        } else {
            if (first == last) {
                last = node;
                last.setPrevious(first);
                first.setNext(last);
            } else {
                last.setNext(node);
                node.setPrevious(last);
                last = node;
            }
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if (size() == 0) {
            first = node;
            last = node;
        } else {
            if (first == last) {
                first.setNext(last);
                first.setPrevious(node);
                node.setNext(first);
                first = node;
            } else {
                first.setPrevious(node);
                node.setNext(node);
                first = node;
            }
        }
    }

    @Override
    public void deleteFirst() {
        if (size() != 0) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.getNext();
                first.setPrevious(null);
            }
        }
    }

    @Override
    public void deleteLast() {
        if (size() != 0) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                last = last.getPrevious();
                last.setNext(null);
            }
        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        return last;
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }
        return doSize(first);
    }

    private int doSize(DequeNode<T> node) {
        return node.isLastNode() ? 1 : 1 + doSize(node.getNext());
    }
}
