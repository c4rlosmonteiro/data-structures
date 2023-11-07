package com.github.carlosmonteiro.structures.linkedlist;

import com.github.carlosmonteiro.structures.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

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

    //TODO - change to private
    public Node<T> getNode(final int index) {
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

    /**
     * Check if it has loop using Floyd’s Cycle Finding Algorithm
    */
    public boolean hasLoop() {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * This is an exercise that doesn't consider the existence of the length attribute.
     */
    public T findKthFromEnd(final int k) {
        Node<T> slow = head;
        Node<T> fast = head;

        int distance = 1;

        while (fast != null && fast.getNext() != null) {
            if (distance < k) {
                distance++;
            } else {
                slow = slow.getNext();
            }

            fast = fast.getNext();
        }

        if (distance == k) {
            return slow.getValue();
        } else {
            return null;
        }
    }

    /**
     * Note: this linked list class does NOT have a tail which will make this method easier to implement.
     */
    public void removeDuplicates() {
        Node<T> previous = null;
        Node<T> current = head;
        final Set<T> occurrence = new HashSet<>();

        while (current != null) {
            Node<T> next = current.getNext();

            if (occurrence.contains(current.getValue())) {
                length--;
                previous.setNext(next);

                if (next == null) {
                    tail = previous;
                }
            } else {
                occurrence.add(current.getValue());
                previous = current;
            }

            current = next;
        }
    }

    public int binaryToDecimal() {
        int exp = length - 1;
        int decimal = 0;
        Node<T> aux = head;

        while (aux != null) {
            decimal += Math.pow(2, exp) * (Integer) aux.getValue();
            exp--;
            aux = aux.getNext();
        }

        return decimal;
    }


    /**
     * Given a value x this method will to rearrange the linked list such that all nodes with a
     * value less than x come before all nodes with a value greater than or equal to x.
     */
    public void partitionList(final T x, Comparator<T> comparator) {
        Node<T> gtThanX = null;
        Node<T> gtThanXHead = null;
        Node<T> ltThanX = null;
        Node<T> ltThanXHead = null;
        Node<T> aux = head;

        if (aux != null) {
            while (aux != null) {
                if (comparator.compare(aux.getValue(), x) < 0) {
                    boolean isNull = ltThanX == null;
                    ltThanX = appendTwoNodes(ltThanX, aux);

                    if (ltThanXHead == null) {
                        ltThanXHead = ltThanX;
                    }

                    if (!isNull) {
                        ltThanX = ltThanX.getNext();
                    }
                } else {
                    boolean isNull = gtThanX == null;
                    gtThanX = appendTwoNodes(gtThanX, aux);

                    if (gtThanXHead == null) {
                        gtThanXHead = gtThanX;
                    }

                    if (!isNull) {
                        gtThanX = gtThanX.getNext();
                    }
                }

                aux = aux.getNext();
            }

            if (gtThanX != null) {
                tail = gtThanX;
                gtThanX.setNext(null);
            } else {
                tail = ltThanX;
                ltThanX.setNext(null);
            }

            appendTwoNodes(ltThanX, gtThanXHead);

            if (ltThanXHead != null) {
                head = ltThanXHead;
            } else {
                head = gtThanXHead;
            };
        }
    }

    private Node<T> appendTwoNodes(Node<T> a, Node<T> b) {
        if (a == null) {
            a = b;
            return a;
        } else if (b == null) {
            b = a;
            return b;
        } else {
            a.setNext(b);
            return a;
        }
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

    /**
     * Added for test purpose, will be removed.
     */
    public Node<T> getFirst() {
        return getNode(0);
    }

    /**
     * Added for test purpose, will be removed.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Added for test purpose, will be removed.
     */
    public Node<T> getLast() {
        return getNode(length - 1);
    }

    /**
     * Added for test purpose, will be removed.
     */
    public Node<T> getTail() {
        return tail;
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
