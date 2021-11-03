package linear.data.stuctures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T>{

    private int capacity;
    private int currentSize;
    private T[] array;

    private DynamicArray(){
        this.capacity = 2;
        currentSize = 0;
        this.array = (T[]) new Object[capacity];
    }

    public void add(T element){
        if (currentSize >= capacity){
            this.array = doubleArrayCapacity();
        }

        array[currentSize] = element;
        currentSize = array.length;
    }

    public T get(int position){
        if (position < 0 && position > currentSize - 1){
            throw new IndexOutOfBoundsException();
        }
       return array[position];
    }

    public void set(int position,T element){
        if (position < 0 && position > currentSize - 1){
            throw new IndexOutOfBoundsException();
        }
         array[position] = element;
    }

    private T[] doubleArrayCapacity() {
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    private final class MyListIterator implements Iterator<T>{

        private int current;

        public MyListIterator() {
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            if (current < currentSize) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentSize++];
        }
    }
}




