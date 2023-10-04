package com.github.carlosmonteiro.structures.linkedlist;

import com.github.carlosmonteiro.structures.Node;

/**
 * Recursive linked list.
 *
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

        length++;
    }

    public T removeLast() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            final T value = tail.getValue();
            head = null;
            tail = null;
            length--;
            return value;
        }

        final Node<T> previous = getBefore(head, tail);

        if (previous == null) {
            return null;
        } else {
            final T last = previous.getNext().getValue();
            previous.setNext(null);
            tail = previous;
            length--;
            return last;
        }
    }

    private Node<T> getBefore(final Node<T> head, final Node<T> target) {
        if (!head.hasNext()) {
            return null;
        }

        if (head.getNext().equals(target)) {
            return head;
        } else {
            return getBefore(head.getNext(), target);
        }
    }

    public int getLength() {
        return length;
    }

    public String print() {
        return "["+print(head)+"]" + " l=" + length;
    }

    private String print(final Node<T> node) {
        if (node != null && node.hasNext()) {
            return node + "," + print(node.getNext());
        } else if (node != null) {
            return node.toString();
        } else {
            return "null";
        }
    }
}
