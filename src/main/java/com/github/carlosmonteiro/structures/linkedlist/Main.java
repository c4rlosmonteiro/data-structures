package com.github.carlosmonteiro.structures.linkedlist;

/**
 * @author Carlos Monteiro
 */
public class Main {
    public static void main(final String [] args) {
        System.out.println("Recursive version ========");
        //appendR();
        //removeLastR();
        System.out.println("Normal version ========");
        //append();
        //removeLast();
        //prepend();
        //removeFirst();
        //get();
        //set();
    }

    public static void set() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        System.out.println(ll.print());
        System.out.println("set(0) -> " + ll.set(0, 990));
        System.out.println("set(-1) -> " + ll.set(-1, -991));
        System.out.println("set(5) -> " + ll.set(5, 995));
        System.out.println("set(2) -> " + ll.set(2, 992));
        System.out.println("set(4) -> " + ll.set(4, 994));
        System.out.println(ll.print());

        final LinkedList<Integer> ll2 = new LinkedList<>(0);
        ll2.removeFirst();
        System.out.println(ll2.print());
        System.out.println("set(-1) -> " + ll2.set(-1, -991));
        System.out.println("set(0) -> " + ll2.set(0, 990));
        System.out.println("set(1) -> " + ll2.set(1, 991));
        System.out.println(ll2.print());
    }

    public static void get() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        System.out.println(ll.print());
        System.out.println("get(0) -> " + ll.get(0));
        System.out.println("get(-1) -> " + ll.get(-1));
        System.out.println("get(5) -> " + ll.get(5));
        System.out.println("get(2) -> " + ll.get(2));
        System.out.println("get(4) -> " + ll.get(4));

        final LinkedList<Integer> ll2 = new LinkedList<>(0);
        ll2.removeFirst();
        System.out.println(ll2.print());
        System.out.println("get(-1) -> " + ll2.get(-1));
        System.out.println("get(0) -> " + ll2.get(0));
        System.out.println("get(1) -> " + ll2.get(1));
    }

    public static void removeFirst() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        System.out.println(ll.print());
        System.out.println("removed -> " + ll.removeFirst());
        System.out.println(ll.print());
        System.out.println("removed -> " + ll.removeFirst());
        System.out.println(ll.print());
        System.out.println("append -> 1, 2");
        ll.append(1);
        ll.append(2);
        System.out.println(ll.print());
    }

    public static void prepend() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        System.out.println(ll.print());
        ll.prepend(-1);
        System.out.println(ll.print());

        final LinkedList<Integer> ll2 = new LinkedList<>(0);
        ll2.removeLast();
        System.out.println(ll2.print());
        ll2.prepend(0);
        System.out.println(ll2.print());
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

    public static void appendR() {
        final LinkedListR<Integer> ll = new LinkedListR<>(0);
        System.out.println(ll.print());
        ll.append(1);
        System.out.println(ll.print());
        ll.append(2);
        System.out.println(ll.print());
    }

    public static void removeLastR() {
        System.out.println("Initial: ");

        final LinkedListR<Integer> ll = new LinkedListR<>(0);
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
