package Queue;

import Stack.GenericArrayStack;

public class LinkedListQueue<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public LinkedListQueue() {
        size = 0;
        first = null;
        last = null;
    }

    public T first() {
        return first.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = first;
        first = first.next;
        size--;
        return temp.data;
    }

    public void reverse(LinkedListQueue<T> queue) {
        if (isEmpty()) {
            return;
        }
        GenericArrayStack<T> stack1 = new GenericArrayStack<>();
        while (!queue.isEmpty()) {
            stack1.push(queue.dequeue());
        }
        while (!stack1.isEmpty()) {
            queue.enqueue(stack1.pop());
        }
        
        

    }
}
