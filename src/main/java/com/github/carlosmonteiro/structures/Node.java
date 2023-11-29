package com.github.carlosmonteiro.structures;

/**
 * @author Carlos Monteiro
 */
public final class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

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

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
