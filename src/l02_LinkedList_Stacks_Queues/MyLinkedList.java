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

    public T removeFirst(){
        if (size == 0){
            throw new UnsupportedOperationException();
        }

        Node oldHead = this.head;
        this.head = this.head.next;

        this.size--;
        if (this.size == 0){
            this.tail = null;
        }

        return oldHead.value;
    }

    public T removeLast(){

        if (this.size == 0){
            throw new UnsupportedOperationException();
        }

        Node oldTail = this.tail;

        if (this.size == 1){
            this.head = null;
            this.tail = null;
        } else {
            Node node = this.getSecondToLast();
            node.next = null;
            this.tail = node;
        }
        this.size--;

        return oldTail.value;
    }

    private Node getSecondToLast() {
        Node current = head;
        while (current.next != tail){
            current = current.next;
        }
        return current;
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
