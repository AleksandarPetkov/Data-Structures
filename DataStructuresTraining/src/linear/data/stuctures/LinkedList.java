package linear.data.stuctures;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private int size;
    private Node head;
    private Node tail;

    /***
     *                  EXAMPLE
        HEAD            Sequence                  TAIL
                 23 11 42 12 32 09 74 12 45 15
       addFirst                                AddLast
       removeFirst                             RemoveLast
     */

    public void addFirst(E item) {
        Node old = head;
        this.head = new Node(item);
        this.head.setNext(old);

        if (size == 0){
            tail = head;
        }

        size++;
    }

    public void addLast(E item) {
        Node old = this.tail;
        this.tail = new Node(item);

        if (size == 0){
            this.head = tail;
        } else {
            old.setNext(tail);
        }
        size++;
    }

    public E removeFirst() {
        if (size == 0){
            throw new UnsupportedOperationException();
        }

        E value = this.head.value;
        //Detach first Note  add attach second Node
        this.head = this.head.next;

        size--;
        if (size == 0){
            this.tail = null;
        }

        return value;
    }

    public E removeLast() {
        if (size == 0){
            throw new UnsupportedOperationException();
        }

        E value = this.tail.value;

        if (size == 1){
            this.head = this.tail = null;
        } else {
            Node newTail = getSecondToLast();
            this.tail = newTail;
            newTail.setNext(null);
        }

        return value;
    }

    private Node getSecondToLast() {
        Node current = head;
        //Check the Node before Tail with .next() != tail
        while (current.next != tail){
            current = current.next;
        }
        return current;
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Custom Iterator
    private class LinkedListIterator implements Iterator<E>{
        private Node current;

        private LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public E next() {
            E value = this.current.value;
            this.current = this.current.next;
            return value;
        }
    }
}
