package com.hackerrank.problems.arraysum;

import java.util.Arrays;

/**
 * Created by prasanna-4077.
 */
public class MinimumUniqueArraySum {
    public static int getMinimumUniqueSum(int[] numbers) {

        //Sort array using internal QuickSort
        Arrays.sort(numbers);

        int sum = numbers[0],
            currentMinimum = numbers[0];

        //Loop once through the numbers, incrementing the sum each time a duplicate value is found
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > currentMinimum) {
                sum += numbers[i];
                currentMinimum = numbers[i];
            } else {
                sum += ++currentMinimum;
            }
        }
        return sum;
    }
}
