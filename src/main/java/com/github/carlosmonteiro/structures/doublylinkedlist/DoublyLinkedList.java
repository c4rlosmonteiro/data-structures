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

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        final Node<T> first = head;

        if (first.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = first.getNext();
            head.setPrev(null);

            if (length == 1) {
                tail = first.getNext();
            }
        }

        length--;
        return first.getValue();
    }

    public T get(final int index) {
        final Node<T> node = getNode(index);

        if (node != null) {
            return node.getValue();
        } else {
            return null;
        }
    }

    public boolean set(final int index, final T value) {
        if (isInvalidPosition(index)) {
            return false;
        }

        getNode(index).setValue(value);

        return true;
    }

    public boolean insert(final int index, final T value) {
        if (isInvalidPosition(index)) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        final Node<T> node = new Node<>(value);
        final Node<T> nodeAtPosition = getNode(index);
        final Node<T> nodeAtPreviousPosition = nodeAtPosition.getPrev();

        nodeAtPosition.setPrev(node);
        node.setNext(nodeAtPreviousPosition.getNext());
        nodeAtPreviousPosition.setNext(node);
        node.setPrev(nodeAtPreviousPosition);

        length++;
        return true;
    }

    private Node<T> getNode(final int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node<T> aux;

        if (index <= length / 2) {
            aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
        } else {
            aux = tail;
            for (int i = length - 1; i > index; i--) {
                aux = aux.getPrev();
            }
        }

        return aux;
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
