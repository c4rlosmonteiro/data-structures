package com.github.carlosmonteiro.structures.binarytree;

public class NodeTree<T> {
    private T value;
    private NodeTree<T> right;
    private NodeTree<T> left;

    public NodeTree(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public NodeTree<T> getRight() {
        return right;
    }

    public void setRight(final NodeTree<T> right) {
        this.right = right;
    }

    public boolean hasNext() {
        return right != null || left != null;
    }

    public void setLeft(final NodeTree<T> left) {
        this.left = left;
    }

    public NodeTree<T> getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
