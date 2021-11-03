package l01_List_And_DS_Complexity;

import l01_List_And_DS_Complexity.customlist.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Test MyList with Integer
        CustomList<Integer> list = new CustomList<>();

        //1. Check method Add()
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(12);
        list.add(6);
        list.add(3);
        list.add(1);

        //2. Check method getListSize()
        System.out.println("List size is: "+ list.getListSize());

        //3. Check method getMyListCapacity()
        System.out.println("List capacity is: "+list.getMyListCapacity());

        //4. Check method get()
        System.out.println("For checking method 'get()', please insert index.");
        int index = Integer.valueOf(reader.readLine());
        System.out.println("Тhe element taken is: "+ list.get(index));

        //5. Check method set()
        System.out.println("For checking method 'set()', please insert index, and new value");
        int currentIndex = Integer.valueOf(reader.readLine());
        int newValue = Integer.valueOf(reader.readLine());
        System.out.println("Before set "+ list.get(currentIndex));
        list.set(currentIndex, newValue);
        System.out.println("After set "+ list.get(currentIndex));

        //6. Check Iterable
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
