package l02_LinkedList_Stacks_Queues;

public class MyArrayStack<T> {

    private static final int INITIAL_CAPACITY = 8;

    private T[] elements;
    private int size;

    public MyArrayStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void push(T element){
        this.elements[this.size] = element;
        this.size += 1;
        if (this.elements.length <= this.size) {
            this.grow();
        }
    }

    public T pop(){
        if (this.size == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        this.size -= 1;
        T element = this.elements[this.size];
        this.elements[this.size] = null;
        return element;
    }

    public T peek(){
        if (this.size == 0) {
            throw new IllegalArgumentException("No elements in Stack");
        }
        return this.elements[this.size];
    }

    public int getSize() {
        return size;
    }

    public T[] getElements() {
        return elements;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[this.size * 2];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.elements[i];
        }
        this.elements = newArray;
    }
}
