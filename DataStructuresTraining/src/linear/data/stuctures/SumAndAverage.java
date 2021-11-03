package linear.data.stuctures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAndAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        double sum = numbers.stream().mapToInt(Integer::intValue).sum();
        double average = sum / numbers.size();
        System.out.println(sum + " " + average);
    }
}
