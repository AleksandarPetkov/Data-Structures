package l02_LinkedList_Stacks_Queues;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(7);
        list.addFirst(13);
        list.addFirst(27);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
