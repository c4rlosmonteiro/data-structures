package com.github.carlosmonteiro.structures.stack;

import com.github.carlosmonteiro.structures.Node;

public class Stack<T> {
    private Node<T> top;
    private int height;

    public Stack() {
        top = null;
        height = 0;
    }

    public Stack(final T value) {
        top = new Node<>(value);
        height = 1;
    }

    public void push(final T value) {
        final Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
        height++;
    }

    public T pop() {
        if (!isEmpty()) {
            final Node<T> aux = top;

            if (top.getNext() == null) {
                top = null;
            } else {
                top = top.getNext();

            }

            aux.setNext(null);

            height--;

            return aux.getValue();
        } else {
            return null;
        }
    }

    public int getHeight() {
        return height;
    }

    public boolean isEmpty() {
        return height == 0;
    }

    public String print() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Node<T> aux = top;

        while (aux != null) {
            stringBuilder.append(aux);
            aux = aux.getNext();

            if (aux != null) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");
        stringBuilder.append(" l=" + height);
        return stringBuilder.toString();
    }

    public String printWithPointers() {
        final StringBuilder stringBuilder = new StringBuilder();

        Node<T> aux = top;

        if (isEmpty()) {
            stringBuilder.append("[]");
        }

        while (aux != null) {
            stringBuilder.append("[");
            //stringBuilder.append(aux.getPrev()).append(" << ");
            stringBuilder.append(aux);
            stringBuilder.append(" >> ").append(aux.getNext());
            aux = aux.getNext();
            stringBuilder.append("]");
            if (aux != null) {
                stringBuilder.append(" ");
            }
        }

        stringBuilder
                .append(" l=").append(height)
                .append(" head=").append(top != null ? top.getValue() : null);
        return stringBuilder.toString();
    }
}
