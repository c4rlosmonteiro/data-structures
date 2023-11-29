package com.github.carlosmonteiro.structures.doublylinkedlist;

import com.github.carlosmonteiro.structures.Node;

/**
 * @author Carlos Monteiro
 */
public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public DoublyLinkedList(final T value) {
        final Node<T> node = new Node<T>(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void append(final T value) {
        final Node<T> node = new Node<>(value);

        if (isEmpty()) {
            head = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
        }

        tail = node;
        length++;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (length == 1) {
            final T value = tail.getValue();
            head = null;
            tail = null;
            length--;
            return value;
        }

        final Node<T> previous = tail.getPrev();

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

    public void prepend(final T value) {
        final Node<T> node = new Node<>(value);
        node.setNext(head);

        if (!isEmpty()) {
            head.setPrev(node);
        } else {
            tail = node;
        }

        head = node;

        length++;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private boolean isInvalidPosition(final int index) {
        return index < 0 || index >= length;
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

    public String printWithPointers() {
        final StringBuilder stringBuilder = new StringBuilder();

        Node<T> aux = head;

        //stringBuilder.append("[");

        if (isEmpty()) {
            stringBuilder.append("[]");
        }

        while (aux != null) {
            stringBuilder.append("[");
            stringBuilder.append(aux.getPrev()).append(" << ");
            stringBuilder.append(aux);
            stringBuilder.append(" >> ").append(aux.getNext());
            aux = aux.getNext();
            stringBuilder.append("]");
            if (aux != null) {
                stringBuilder.append(" ");
            }
        }

        //stringBuilder.append("]");
        stringBuilder
                .append(" l=").append(length)
                .append(" tail=").append(tail != null ? tail.getValue() : null)
                .append(" head=").append(head != null ? head.getValue() : null);
        return stringBuilder.toString();
    }
}
