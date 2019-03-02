package com.hackerrank.problems.superstack;

/**
 * Created by prasanna-4077.
 *
 * Skeletal Interface for the basic methods required for building a SuperStack
 */

interface IntegerSuperStack {

    /**
     *  Pushes an element to the top of the stack
     *
     *  @param element the item to be pushed onto this stack.
     */
    void push( int element );

    /**
     *  Removes the element at the top of the stack
     */
    void pop();

    /**
     * Add k to each of the bottom elements of the
     * stack.
     *
     * @param element element which is to be added
     * @param rowLimit limiting row from the bottom of the stack
     */
    void inc( int element, int rowLimit );

    /**
     * Get the topmost element of the stack
     */
    int getLast();

}
