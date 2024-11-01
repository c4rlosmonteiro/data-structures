package com.github.carlosmonteiro.structures.stack;

public class Main {

    public static void main(final String[] args) {
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        System.out.println("My stack example: " + stack.printWithPointers());

    }
}
