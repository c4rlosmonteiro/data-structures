package com.github.carlosmonteiro.structures.queue;

import com.github.carlosmonteiro.structures.Node;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;

    public Queue() {
        first = null;
        last = null;
        length = 0;
    }

    public Queue(final T value) {
        initEmptyQueue(value);
    }

    public void enqueue(final T value) {
        if (isEmpty()) {
            initEmptyQueue(value);
        } else {
            final Node<T> newNode = new Node<>(value);
            last.setNext(newNode);
            last = newNode;
            length++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            final Node<T> aux = first;

            if (first.getNext() != null) {
                first = first.getNext();
            } else {
                first = null;
                last = null;
            }

            length--;
            aux.setNext(null);
            return aux.getValue();
        }
    }

    private void initEmptyQueue(final T value) {
        final Node<T> newNode = new Node<>(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public T getLast() {
        return last != null ? last.getValue() : null;
    }

    public T getFirst() {
        return first != null ? first.getValue() : null;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String print() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Node<T> aux = first;

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

        Node<T> aux = first;

        if (isEmpty()) {
            stringBuilder.append("[]");
        }

        while (aux != null) {
            stringBuilder.append("[");
            stringBuilder.append(aux);
            stringBuilder.append(" >> ").append(aux.getNext());
            aux = aux.getNext();
            stringBuilder.append("]");
            if (aux != null) {
                stringBuilder.append(" ");
            }
        }

        stringBuilder
                .append(" l=").append(length)
                .append(" first=").append(first != null ? first.getValue() : null)
                .append(" last=").append(last != null ? last.getValue() : null);
        return stringBuilder.toString();
    }
}
