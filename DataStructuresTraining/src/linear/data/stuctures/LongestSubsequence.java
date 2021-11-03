package linear.data.stuctures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        int longestSequenceCount = 0;
        int currentSequenceSize = 0;
        int biggestSequenceNumber = 0;

        for (int index = 0; index < sequence.size() - 1; index++) {

            if (sequence.get(index) == sequence.get(index + 1)){
                currentSequenceSize++;
            } else {
                currentSequenceSize = 0;
            }

            if (longestSequenceCount < currentSequenceSize){
                longestSequenceCount = currentSequenceSize;
                biggestSequenceNumber = sequence.get(index);
            }
        }

        for (int i = 0; i < longestSequenceCount + 1; i++) {
            System.out.print(biggestSequenceNumber + " ");
        }
    }
}
