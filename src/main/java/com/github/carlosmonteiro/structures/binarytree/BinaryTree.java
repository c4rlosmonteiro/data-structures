package com.github.carlosmonteiro.structures.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {
    private NodeTree<T> root;
    private int height;

    public BinaryTree(final T value) {
        root = new NodeTree<>(value);
        height++;
    }

    public BinaryTree() {

    }

    public boolean insert(final T value) {
        Objects.requireNonNull(value);

        final NodeTree<T> newNode = new NodeTree<>(value);

        if (root == null) {
            root = newNode;
            height++;
            return true;
        } else {
            NodeTree<T> actual = root;
            int h = 1;

            while (true) {
                if (value.compareTo(actual.getValue()) > 0) {
                    if (actual.getRight() != null) {
                        actual = actual.getRight();
                        h++;
                    } else {
                        actual.setRight(newNode);
                        height = Math.max(height, h + 1);
                        return true;
                    }
                } else if (value.compareTo(actual.getValue()) < 0) {
                    if (actual.getLeft() != null) {
                        actual = actual.getLeft();
                        h++;
                    } else {
                        actual.setLeft(newNode);
                        height = Math.max(height, h + 1);
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    private NodeTree<T> newNode(final T value) {
        return new NodeTree<>(value);
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        } else {
            int h = height;
            final StringBuilder str = new StringBuilder();
            ArrayList<NodeTree<T>> levelNodes = new ArrayList<>();
            levelNodes.add(root);

            while (!levelNodes.isEmpty()) {
                appendNTimes(str, "\t", h);

                final ArrayList<NodeTree<T>> newLevelNodes = new ArrayList<>();

                for (final NodeTree<T> node : levelNodes) {
                    if (node == null) {
                        appendNTimes(str, "\t", 2);
                    } else {
                        str.append(node.getValue());
                        appendNTimes(str, "\t", 2);

                        if (node.getLeft() != null) {
                            newLevelNodes.add(node.getLeft());
                        } else {
                            newLevelNodes.add(null);
                        }

                        if (node.getRight() != null) {
                            newLevelNodes.add(node.getRight());
                        } else {
                            newLevelNodes.add(null);
                        }
                    }
                }

                h--;
                levelNodes = newLevelNodes;
                str.append("\n");
            }

            return "h(" + height + ")" + "\n" + str.toString();
        }
    }

    public void appendNTimes(final StringBuilder stringBuilder, final String text, final int n) {
        stringBuilder.append(String.valueOf(text).repeat(Math.max(0, n)));
    }
}
