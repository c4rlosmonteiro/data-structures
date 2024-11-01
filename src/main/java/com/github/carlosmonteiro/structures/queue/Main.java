package com.github.carlosmonteiro.structures.queue;

import com.github.carlosmonteiro.structures.stack.Stack;

public class Main {

    public static void main(final String[] args) {
        final Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("My queue example: " + queue.printWithPointers());
    }
}
