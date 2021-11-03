package l01_List_And_DS_Complexity.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAndAvarage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        double average = (double) sum / numbers.size();

        System.out.println(String.format("Sum=%d, Average=%.2f", sum, average));
    }
}
