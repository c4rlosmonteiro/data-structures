package com.github.carlosmonteiro.structures.hashtable;

import com.github.carlosmonteiro.structures.binarytree.NodeTree;

public class HTNode<T> {
    private String key;
    private T value;
    private HTNode<T> next;

    public HTNode(final String key, final T value) {
        this.key = key;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public HTNode<T> getNext() {
        return next;
    }

    public void setNext(final HTNode<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
