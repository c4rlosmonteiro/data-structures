package com.github.carlosmonteiro.structures.linkedlist;

import com.github.carlosmonteiro.structures.Node;

/**
 * @author Carlos Monteiro
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(final T value) {
        final Node<T> node = new Node<T>(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void append(final T value) {
        final Node<T> node = new Node<T>(value);

        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }

        length += 1;
    }

    public String print() {
        return "["+print(head)+"]";
    }

    private String print(Node<T> node) {
        if (node.hasNext()) {
            return node + "," + print(node.getNext());
        } else {
            return node.toString();
        }
    }
}
