package com.github.carlosmonteiro.structures.leetcode.queue;

import com.github.carlosmonteiro.structures.leetcode.stack.Stack;

/**
 * Queue Using Stacks: Enqueue ( ** Interview Question)
 * Implement the Enqueue Method for a Queue using Two Stacks
 *
 * Description:
 *
 * In this assignment, you are tasked with implementing the enqueue method for a custom queue class called MyQueue using two stacks, stack1 and stack2.
 *
 * A queue is a data structure that follows the First-In-First-Out (FIFO) principle, meaning that the first element added to the queue will be the first one to be removed. Your implementation must maintain the FIFO order of elements in the queue using two stacks.
 *
 * Your task is to implement the following method:
 *
 * public void enqueue(int value)
 *
 * This method takes an integer value as input and adds it to the queue.
 *
 * Note: You are not allowed to use any data structures other than the provided stacks (stack1 and stack2).
 *
 * Example:
 *
 * MyQueue q = new MyQueue();
 * q.enqueue(1);
 * q.enqueue(2);
 * q.enqueue(3);
 *
 *
 * After these operations, the queue should have the following elements in order: 1, 2, 3.
 */
public class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        return !isEmpty() ? stack1.pop() : null;
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
