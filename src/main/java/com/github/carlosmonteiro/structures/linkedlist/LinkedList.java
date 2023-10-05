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
        Node<T> aux = head;

        while (aux.hasNext()) {
            if (aux.getNext().equals(target)) {
                return aux;
            }

            aux = aux.getNext();
        }

        return null;
    }

    public int getLength() {
        return length;
    }

    public String print() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Node<T> aux = head;

        while (aux != null) {
            stringBuilder.append(aux);
            aux = aux.getNext();

            if (aux != null) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");
        stringBuilder.append(" l=" + length);
        return stringBuilder.toString();
    }
}
