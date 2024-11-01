package com.github.carlosmonteiro.structures.leetcode.stack;

import com.github.carlosmonteiro.structures.Node;

/**
 * Stack: Sort Stack ( ** Interview Question)
 * The sortStack method takes a single argument, a Stack object.  The method should sort the elements in the stack in ascending order (the lowest value will be at the top of the stack) using only one additional stack.  The function should use the pop, push, peek, and isEmpty methods of the Stack object.
 *
 * This will use the Stack class we created in these coding exercises:
 *
 * To sort the stack, you should create a new, empty stack to hold the sorted elements.  Then, while the original stack is not empty, you should remove the top element from the original stack and compare it to the top element of the sorted stack.  If the top element of the sorted stack is greater than the current element, you should move the top element of the sorted stack back to the original stack until the current element is in the correct position.  Finally, you should add the current element to the sorted stack.
 *
 * Once all the elements have been sorted, you should copy the sorted elements from the sorted stack to the original stack in the correct order.
 *
 * Overall, the function should have a time complexity of O(n^2), where n is the number of elements in the original stack, due to the nested loops used to compare the elements.  However, the function should only use one additional stack, which could be useful in situations where memory is limited.
 */
public class SortStackMain {

    /**
     * Overall, the function should have a time complexity of O(n^2),
     * where n is the number of elements in the original stack, due to
     * the nested loops used to compare the elements.  However, the
     * function should only use one additional stack, which could be
     * useful in situations where memory is limited.
     */
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();

        if (!stack.isEmpty() && stack.size() > 1) {
            Integer item = stack.pop();

            while (item != null) {
                if (auxStack.isEmpty()) {
                    auxStack.push(item);

                    if (!stack.isEmpty()) {
                        item = stack.pop();
                    } else {
                        item = null;
                    }
                } else {
                    // >= to final stack being ASC or <= to final stack being DESC
                    if (item >= auxStack.peek()) {
                        auxStack.push(item);

                        if (!stack.isEmpty()) {
                            item = stack.pop();
                        } else {
                            item = null;
                        }
                    } else {
                        stack.push(auxStack.pop());
                    }
                }
            }
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }
}
