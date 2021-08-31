package app.Queue;

public interface IQueue<T> {
    public void offer(T elt);
    public void poll();
    T peek();
    public int size();
    public boolean isEmpty();
}
