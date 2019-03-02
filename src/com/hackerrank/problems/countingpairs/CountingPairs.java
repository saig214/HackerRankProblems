package com.hackerrank.problems.countingpairs;

import java.util.Arrays;

/**
 * Created by prasanna-4077.
 */
class CountingPairs {
    public static int getPairsCount(int[] numbers, int requiredDifference) {

        //Sort array using internal QuickSort
        Arrays.sort(numbers);

        //Assume a lower bound and upper bound to traverse through the array and find the difference
        int lowerPointer = 0,
            upperPointer = 1,
            pairCount = 0;

        while (lowerPointer < numbers.length &&
                upperPointer < numbers.length) {

            //Skip repeated elements
            if (lowerPointer != 0 && numbers[lowerPointer] == numbers[lowerPointer-1]) {
                lowerPointer++;
                continue;
            }

            //Upper bound should always be a greater value than the lower bound since difference is positive from constraint
            if (lowerPointer >= upperPointer) {
                upperPointer = lowerPointer + 1;
                continue;
            }

            int difference = numbers[upperPointer] - numbers[lowerPointer];
            if (difference == requiredDifference) {
//                System.out.println( numbers[lowerPointer] + "," + numbers[upperPointer]);
                lowerPointer++;
                upperPointer++;
                pairCount++;
            } else if (difference > requiredDifference) {
                lowerPointer++;
            } else {
                upperPointer++;
            }
        }

        return pairCount;
    }
}
