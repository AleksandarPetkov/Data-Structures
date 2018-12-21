package l01_List_And_DS_Complexity.customlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<E> implements Iterable<E>{

    private int myListCapacity;

    private int size;

    private E[] array;

    @SuppressWarnings("unchecked")
    public CustomList() {
        this.size = 0;
        this.myListCapacity = 2;
        this.array = (E[]) new Object[myListCapacity];
    }


    @SuppressWarnings("unchecked")
    public void add(E element) {
        if (size > myListCapacity - 1){
            this.myListCapacity *= 2;
            this.array = doubleArrayLength();
        }
        this.array[size] = element;
        this.size++;
    }

    public int getListSize(){
        return this.size;
    }

    public int getMyListCapacity(){
        return this.myListCapacity;
    }

    public E get(int index){
        if (index < 0 || index > size - 1){
            throw new IllegalArgumentException();
        }
        return array[index];
    }

    public void set(int index, E element){
        if (index < 0 || index > size - 1){
            throw new IllegalArgumentException();
        }
        this.array[index] = element;
    }

    @SuppressWarnings("unchecked")
    private E[] doubleArrayLength() {
        E[] newArray =  (E[]) new Object[myListCapacity];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        this.array =  (E[]) new Object[myListCapacity];
        for (int i = 0; i < newArray.length; i++) {
           this.array[i] = newArray[i];
        }
        return this.array;
    }


    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private final class MyListIterator implements Iterator<E>{

        private int current;

        public MyListIterator() {
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            if (current < size) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[current++];
        }
    }

}

