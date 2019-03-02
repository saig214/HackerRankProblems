package com.hackerrank.problems.arraysum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prasanna-4077.
 */
public class MinimumUniqueArraySumRunner {
    public static void main(String[] args) {
        List<String> testFilePathList = Arrays.asList(
                "src/com/hackerrank/problems/arraysum/test/TestCase1.txt",
                "src/com/hackerrank/problems/arraysum/test/TestCase2.txt",
                "src/com/hackerrank/problems/arraysum/test/TestCase3.txt",
                "src/com/hackerrank/problems/arraysum/test/TestCase4.txt",
                "src/com/hackerrank/problems/arraysum/test/TestCase5.txt"
        );

        testFilePathList.stream()
                        .map(MinimumUniqueArraySumRunner::getData)
                        .map(MinimumUniqueArraySum::getMinimumUniqueSum)
                        .forEach(System.out::println);
    }

    private static int[] getData(String filePath) {
        System.out.println("Running " + filePath);
        int[] lines = new int[0];
        try {
            lines = Files.lines(Paths.get(filePath))
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .toArray();
        } catch (IOException e) {
            System.out.println("Exception in getting file -> " + filePath);
        }
        return lines;
    }

}
