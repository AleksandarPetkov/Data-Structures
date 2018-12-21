package l01_List_And_DS_Complexity.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveOddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        List<Integer> existNumbers = new ArrayList<>();

        Integer currentNum = 0;
        int occurrences = 1;
        for (int i = 0; i < numbers.size(); i++) {
            currentNum = numbers.get(i);
            if (existNumbers.contains(currentNum)){
                continue;
            }
            existNumbers.add(currentNum);
            occurrences = 1;
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))){
                   occurrences++;
                }
            }
            if (occurrences % 2 == 0){
                result.addAll(getNumbers(occurrences, currentNum));
            }
        }

        StringBuilder printResult = new StringBuilder();
        for (Integer integer : result) {
            printResult.append(integer).append(" ");
        }
        System.out.println(printResult);
    }

    private static List<Integer> getNumbers(int occurrences, Integer currentNum) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < occurrences; i++) {
            nums.add(currentNum);
        }
        return nums;
    }
}
