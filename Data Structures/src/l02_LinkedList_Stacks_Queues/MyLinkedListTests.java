package l02_LinkedList_Stacks_Queues;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTests {

    @Test
    public void addFirstShouldIncreaseCount() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);

        Assert.assertEquals(1, list.getSize());
    }

    @Test
    public void addLastShouldIncreaseCount() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(1);

        Assert.assertEquals(1, list.getSize());
    }

    @Test
    public void addFirstShouldAddElement() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);

        for (Integer item : list) {
            Assert.assertEquals(Integer.valueOf(1), item);
        }
    }

    @Test
    public void AddLastShouldAddElement() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(1);

        for (Integer item : list) {
            Assert.assertEquals(Integer.valueOf(1), item);
        }
    }

    @Test
    public void addFirstMultipleElementsShouldAddElement() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        int expected = 99;
        for (Integer item : list) {
            Assert.assertEquals(expected--, list.getSize());
        }
    }

    @Test
    public void addLastMultipleElementsShouldAddElement() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        int expected = 0;
        for (Integer item : list) {
            Assert.assertEquals(expected++, list.getSize());
        }
    }

    @Test
    public void removeFirstSingleElementShouldDecreaseCount() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst();

        Assert.assertEquals(1, list.getSize());
    }

    @Test
    public void RemoveLastSingleElementShouldDecreaseCount() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeLast();

        Assert.assertEquals(1, list.getSize());
    }

    @Test
    public void RemoveFirstMultipleElementsShouldRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assert.assertEquals(i, list.removeFirst());
        }

        Assert.assertEquals(0, list.getSize());
    }

    @Test
    public void RemoveLastMultipleElementsShouldRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assert.assertEquals(i, list.removeLast());
        }

        Assert.assertEquals(0, list.getSize());
    }

}
