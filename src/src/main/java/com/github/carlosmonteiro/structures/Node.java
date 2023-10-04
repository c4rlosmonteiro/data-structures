package com.github.carlosmonteiro.structures;

/**
 * @author Carlos Monteiro
 */
public final class Node<T> {
    private T value;
    private Node<T> next;

    public Node(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(final Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
