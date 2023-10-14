package com.github.carlosmonteiro.structures.linkedlist;

import com.github.carlosmonteiro.structures.Node;

/**
 * linked list.
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
        final Node<T> node = new Node<>(value);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;
        length++;
    }

    public void prepend(final T value) {
        final Node<T> node = new Node<>(value);
        node.setNext(head);
        head = node;

        if (isEmpty()) {
            tail = node;
        }

        length++;
    }

    public boolean insert(final int index, final T value) {
        if (isInvalidPosition(index)) {
            return false;
        }

        if (index == 0) {
            append(value);
            return true;
        }

        if (index == length) {
            prepend(value);
            return true;
        }

        final Node<T> node = new Node<>(value);
        final Node<T> nodeAtPreviousPosition = getNode(index - 1);

        node.setNext(nodeAtPreviousPosition.getNext());
        nodeAtPreviousPosition.setNext(node);
        length++;
        return true;
    }

    public T remove(final int index) {
        if (isInvalidPosition(index) || isEmpty()) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length) {
            return removeLast();
        }

        final Node<T> nodeAtPreviousPosition = getNode(index - 1);
        final Node<T> removedNode = nodeAtPreviousPosition.getNext();
        nodeAtPreviousPosition.setNext(removedNode.getNext());
        length--;
        return removedNode.getValue();
    }

    public void reverse() {
        Node<T> previous = null;
        Node<T> actual = head;

        final Node<T> temp = tail;
        tail = head;
        head = temp;

        while (actual != null) {
            final Node<T> next = actual.getNext();
            actual.setNext(previous);
            previous = actual;
            actual = next;
        }
    }

    public T get(final int index) {
        final Node<T> node = getNode(index);

        if (node != null) {
            return node.getValue();
        } else {
            return null;
        }
    }

    private Node<T> getNode(final int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node<T> aux = head;

        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }

        return aux;
    }

    public boolean set(final int index, final T value) {
        if (isInvalidPosition(index)) {
            return false;
        }

        getNode(index).setValue(value);

        return true;
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

            if (length == 1) {
                tail = first.getNext();
            }
        }

        length--;
        return first.getValue();
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

    /**
     * Finding middle value using Floyd’s Cycle Finding Algorithm
     *
     * Floyd’s cycle finding algorithm or Hare-Tortoise algorithm is a pointer algorithm that uses only two pointers,
     * moving through the sequence at different speeds. This algorithm is used to find a loop in a linked list. It uses
     * two pointers one moving twice as fast as the other one. The faster one is called the fast pointer and the other
     * one is called the slow pointer.
     *
     * @see https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/
     */
    public T findMiddleValue() {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow != null ? slow.getValue() : null;
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
}
