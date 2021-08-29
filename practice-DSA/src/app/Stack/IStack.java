package app.Stack;

public interface IStack<T> {
    public void push(T elt);
    public void pop();
    public T peek();
    public int size();
    public boolean isEmpty();
}
