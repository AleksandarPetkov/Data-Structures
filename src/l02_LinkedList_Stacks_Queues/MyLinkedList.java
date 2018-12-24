package l02_LinkedList_Stacks_Queues;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
    }

    public void addFirst(T item){
        Node oldHead = this.head;

        this.head = new Node(item);
        this.head.next = oldHead;

        if (size == 0){
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(T value){
        Node oldTail = this.tail;

        this.tail = new Node(value);
        
        if (size == 0){
            this.head = this.tail;
        } else {
            oldTail.next = this.tail;
        }
        this.size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Create Node
    private class Node{
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    //Create Iterator
    private class LinkedListIterator implements Iterator<T>{

        private Node current;

        private LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            T value = this.current.value;
            this.current = this.current.next;
            return value;
        }
    }


}
