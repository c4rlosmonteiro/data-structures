package com.github.carlosmonteiro.structures.leetcode.stack;

public class ReverseStringMain {
    public static String reverseString(final String string) {
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }
}
