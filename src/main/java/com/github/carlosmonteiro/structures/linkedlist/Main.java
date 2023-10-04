package com.github.carlosmonteiro.structures.linkedlist;

/**
 * @author Carlos Monteiro
 */
public class Main {
    public static void main(final String [] args) {
        //append();
        removeLast();
    }

    public static void append() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        System.out.println(ll.print());
        ll.append(1);
        System.out.println(ll.print());
        ll.append(2);
        System.out.println(ll.print());
    }

    public static void removeLast() {
        System.out.println("Initial: ");

        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        System.out.println(ll.print());

        System.out.println("Removing last: ");

        Integer removed = ll.removeLast();
        System.out.println("--" + removed + " => " + ll.print());

        removed = ll.removeLast();
        System.out.println("--" + removed + " => " + ll.print());

        removed = ll.removeLast();
        System.out.println("--" + removed + " => " + ll.print());
    }
}
