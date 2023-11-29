package com.github.carlosmonteiro.structures.linkedlist;

import com.github.carlosmonteiro.structures.doublylinkedlist.DoublyLinkedList;

/**
 * @author Carlos Monteiro
 */
public class Main2 {
    public static void main(final String[] args) {
        //System.out.println("Recursive version ========");
        //appendR();
        //removeLastR();
        System.out.println("Normal version ========");
        //append();
        removeLast();
        //prepend();
        //removeFirst();
        //get();
        //set();
        //insert();
        //remove();
        //reverse();
        //findMiddleValue();
        //findKthFromEnd();
        //partitionList();
        //removeDuplicates();
        //binaryToDecimal();
        //reverserBetween();
    }

    public static void reverserBetween() {
        final LinkedList<Integer> ll = new LinkedList<>(1);
        ll.append(2);
        ll.append(3);
        //ll.append(4);
        //ll.append(5);

        System.out.println("original -> " + ll.print());

        ll.reverseBetween(0,2);

        System.out.println("reversed -> " + ll.print());
    }

    public static void binaryToDecimal() {
        final LinkedList<Integer> ll = new LinkedList<>(1);

        ll.append(0);
        ll.append(1);

        System.out.println("original -> " + ll.print());
        System.out.println("decimal -> " + ll.binaryToDecimal());
    }

    public static void removeDuplicates() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(0);
        ll.append(1);

        System.out.println("original -> " + ll.print());

        ll.removeDuplicates();

        System.out.println("new -> " + ll.print());

        System.out.println("head -> " + ll.getHead().hashCode());
        System.out.println("first -> " + ll.getNode(0).hashCode());

        System.out.println("tail -> " + ll.getTail().hashCode());
        System.out.println("last -> " + ll.getNode(ll.getLength() - 1).hashCode());

    }

    public static void partitionList() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(3);
        ll.append(2);
        ll.append(1);
        ll.append(5);
        ll.append(4);

        System.out.println("original -> " + ll.print());

        ll.partitionList(10, Integer::compareTo);

        System.out.println("new -> " + ll.print());
    }

    public static void findKthFromEnd() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);

        ll.findKthFromEnd(2);
    }


    public static void findMiddleValue() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.removeFirst();
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(0);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(1);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(2);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(3);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(4);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(5);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(6);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
        ll.append(7);
        System.out.println("["+ll.print()+"] middle -> " + ll.findMiddleValue());
    }

    public static void reverse() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        System.out.println(ll.print());
        System.out.println("reverse");
        ll.reverse();
        System.out.println(ll.print());
        System.out.println("reverse");
        ll.reverse();
        System.out.println(ll.print());

        final LinkedList<Integer> ll2 = new LinkedList<>(0);
        ll2.removeFirst();
        System.out.println("empty ===========" + ll2.print());
        System.out.println(ll2.print());
        ll2.reverse();

        final LinkedList<Integer> ll3 = new LinkedList<>(0);
        System.out.println("1 item ========= " + ll3.print());
        ll3.reverse();
        System.out.println(ll3.print());
        ll3.reverse();
        System.out.println(ll3.print());
        System.out.println("add more one [+]");
        ll3.append(991);
        System.out.println(ll3.print());


        final LinkedList<Integer> ll4 = new LinkedList<>(0);
        ll4.append(1);
        System.out.println("2 item ========= " + ll4.print());
        ll4.reverse();
        System.out.println(ll4.print());
        ll4.reverse();
        System.out.println(ll4.print());
        System.out.println("add more one [+]");
        ll4.append(992);
        System.out.println(ll4.print());
    }

    public static void remove() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        System.out.println(ll.print());
        System.out.println("remove(2) -> " + ll.remove(2));
        System.out.println(ll.print());
        System.out.println("remove(0) -> " + ll.remove(0));
        System.out.println(ll.print());
        System.out.println("remove(2) -> " + ll.remove(2));
        System.out.println(ll.print());
        System.out.println("remove(2) -> " + ll.remove(2));
        System.out.println(ll.print());
        System.out.println("remove(-1) -> " + ll.remove(-1));
        System.out.println(ll.print());
        System.out.println("remove(0) -> " + ll.remove(0));
        System.out.println(ll.print());
        System.out.println("remove(0) -> " + ll.remove(0));
        System.out.println(ll.print());
        System.out.println("remove(0) -> " + ll.remove(0));
        System.out.println(ll.print());

    }

    public static void insert() {
        final LinkedList<Integer> ll = new LinkedList<>(0);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        System.out.println(ll.print());
        System.out.println("");
        System.out.println("insert(2, 992) -> " + ll.insert(2, 992));
        System.out.println(ll.print());
        System.out.println("insert(0, 990) -> " + ll.insert(0, 990));
        System.out.println(ll.print());
        System.out.println("insert(6, 996) -> " + ll.insert(6, 996));
        System.out.println(ll.print());
        System.out.println("insert(9, 999) -> " + ll.insert(9, 999));
        System.out.println(ll.print());
        System.out.println("insert(-1, -991) -> " + ll.insert(-1, -991));
        System.out.println(ll.print());
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
        final DoublyLinkedList<Integer> ll = new DoublyLinkedList<>(0);
        System.out.println(ll.printWithPointers());
        ll.append(1);
        System.out.println(ll.printWithPointers());
        ll.append(2);
        System.out.println(ll.printWithPointers());
    }

    public static void removeLast() {
        System.out.println("Initial: ");

        final DoublyLinkedList<Integer> ll = new DoublyLinkedList<>(0);
        ll.append(1);
        System.out.println(ll.printWithPointers());

        System.out.println("Removing last: ");

        Integer removed = ll.removeLast();
        System.out.println("--" + removed + " => " + ll.printWithPointers());

        removed = ll.removeLast();
        System.out.println("--" + removed + " => " + ll.printWithPointers());

        removed = ll.removeLast();
        System.out.println("--" + removed + " => " + ll.printWithPointers());
    }
}
