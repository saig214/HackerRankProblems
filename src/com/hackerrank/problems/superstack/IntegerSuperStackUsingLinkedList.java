package com.hackerrank.problems.superstack;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by prasanna-4077.
 */

//Implementation of SuperStack
public class IntegerSuperStackUsingLinkedList implements IntegerSuperStack {

    //LinkedList is preferred here due to O(1) complexity for most use cases.
    private LinkedList<Integer> baseList = new LinkedList<>();

    @Override
    public void push(int element) {
        baseList.addLast(element);
    }

    @Override
    public void pop() {
        baseList.removeLast();
    }

    @Override
    public void inc(int element, int rowLimit) {
        //ListIterator is used since calling get in a linked list is costly
        ListIterator<Integer> listIterator = baseList.listIterator();
        int row = 0;

        // listIterator.hasNext() check can be removed, since rowLimit < row is guaranteed by constraint

        while ( row < rowLimit ) {
            int value = listIterator.next();
            listIterator.set(value + element);
            row++;
        }
    }

    @Override
    public int getLast() {
//        System.out.println(baseList);
        if (baseList.size() == 0) {
            return -1;
        } else {
            return baseList.getLast();
        }
    }
}
