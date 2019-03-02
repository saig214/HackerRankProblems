package com.hackerrank.problems.countingpairs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prasanna-4077.
 */
class CountingPairsRunner {
    public static void main(String[] args) {
        List<String> testFilePathList = Arrays.asList(
                "src/com/hackerrank/problems/countingpairs/test/TestCase1.txt",
                "src/com/hackerrank/problems/countingpairs/test/TestCase2.txt",
                "src/com/hackerrank/problems/countingpairs/test/TestCase3.txt",
                "src/com/hackerrank/problems/countingpairs/test/TestCase4.txt",
                "src/com/hackerrank/problems/countingpairs/test/TestCase5.txt"
        );

        testFilePathList.forEach(CountingPairsRunner::getPairs);
    }

    private static void getPairs(String filePath) {
        System.out.println("Running " + filePath);
        List<String> numbersAsString = new ArrayList<>();
        int difference = -1;

        //Buffered reader used since there is a need to retrieve first and last lines separately
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            //Get size of array
            String line = br.readLine();
            int size = Integer.parseInt(line);

            //read till size
            int lineCount = 0;
            while ((lineCount++ < size) && (line = br.readLine()) != null) {
                numbersAsString.add(line);
            }

            //Get required difference
            difference = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Exception in getting file -> " + filePath);
        }

        int[] numbers = numbersAsString.stream()
                                       .mapToInt(Integer::valueOf)
                                       .toArray();

        int pairsCount = CountingPairs.getPairsCount(numbers, difference);
        System.out.println(pairsCount);
    }
}
