package Stack;

public class GenericArrayStack <T> {
    private T[] a;
    private int top;

    public GenericArrayStack(int capacity) {
        a = (T[]) new Object[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T item) {
        a[++top] = item;
    }

    public T pop() {
        top--;
        return a[top];
    }

    public void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < top; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i <= top; i++) {
            s += a[i].toString();
        }
        return s;
    }
}


package Stack;


public class QueueWithTwoStacks<T> {
    private GenericArrayStack<T> stack1 = new GenericArrayStack<T>;
    private GenericArrayStack<T> stack2 = new GenericArrayStack<T>;

    public void enqueue(T data) {
        stack1.push(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        
        return stack2.pop();
    }
    

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
