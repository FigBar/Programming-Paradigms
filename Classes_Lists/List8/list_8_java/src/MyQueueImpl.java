import java.util.ArrayList;

public class MyQueueImpl<E> implements MyQueue<E> {

    private ArrayList<E> cyclicQueue;
    private int f;
    private int r;
    private int size;

    public MyQueueImpl(int size) {
        this.f = 0;
        this.r = 0;
        this.size = size + 1;
        this.cyclicQueue = new ArrayList<>(size + 1);
        for (int i = 0; i < this.size ; i++) {
            cyclicQueue.add(null);
        }
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull()) {
            throw new FullException("MyQueueImpl: enqueue");
        } else {
            cyclicQueue.set(r, x);
            r = (r + 1) % size;
        }

    }

    @Override
    public void dequeue() {
        if (r != f)
            f = (f + 1) % size;
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("MyQueueImpl: first");
        } else {
            return cyclicQueue.get(f);
        }
    }

    @Override
    public boolean isEmpty() {
        return (r == f);
    }

    @Override
    public boolean isFull() {
        return (r + 1) % size == f;
    }
}
