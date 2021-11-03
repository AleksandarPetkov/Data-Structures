package linear.data.stuctures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class RemoveOddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> results = new ArrayList<>();
        Set<Integer> alreadyOccurs = new HashSet<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            
            int currentNumber = numbers.get(i);
            int count = 1;

            for (int j = i + 1; j < numbers.size(); j++) {
                int nextNumber = numbers.get(j);
                if (currentNumber == nextNumber){
                    count++;
                }
            }

            if ((count % 2 == 0) && (addIfNoAlreadyExist(alreadyOccurs, currentNumber))){
                for (int j = 0; j < count; j++) {
                    results.add(currentNumber);
                }
            }
            alreadyOccurs.add(currentNumber);
        }

        results.forEach(System.out::print);
    }

    private static boolean addIfNoAlreadyExist(Set<Integer> alreadyOccurs, int currentNumber) {
       return !alreadyOccurs.contains(currentNumber);
    }
}
