/**
 * @author Carlos Monteiro
 */
import com.github.carlosmonteiro.structures.Node;

import java.util.HashSet;
import java.util.Set;


public class LinkedListUdemy {

    private Node head;
    private Node tail;
    private int length;

    public static void main(String [] args) {
        LinkedListUdemy list = new LinkedListUdemy(1);
        list.append(2); list.append(3); list.append(4); list.append(5);
        list.printList();

        list.reverseBetween(1, 3);
        System.out.println("------");
        list.printList();
    }

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListUdemy(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void swapFirstLast() {
        if (length >= 2) {
            final Integer headValue = head.value;
            head.value = tail.value;
            tail.value = headValue;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void reverseBetween(final int startIndex, final int endIndex) {
        final int previousIndex = startIndex - 1;
        final Node beforeReversedNode = getNode(Math.max(previousIndex, 0));
        Node nodeToReverse  = previousIndex < 0 ? beforeReversedNode : beforeReversedNode.next;
        Node reversedPart = null;
        Node firstReversedNode = null;

        for (int i = Math.max(previousIndex, 0); i < endIndex && nodeToReverse != null; i++) {
            final Node nextNodeToReverse = nodeToReverse.next;

            if (reversedPart != null) {
                nodeToReverse.next = reversedPart;
                reversedPart = nodeToReverse;
            } else {
                reversedPart = nodeToReverse;
                nodeToReverse.next = null;
                firstReversedNode = nodeToReverse;
            }

            nodeToReverse  = nextNodeToReverse;
        }

        if (previousIndex >= 0) {
            beforeReversedNode.next = reversedPart;
        } else {
            head = reversedPart;
        }

        if (firstReversedNode != null) {
            firstReversedNode.next = nodeToReverse;
        }
    }

    public void reverse() {
        Node previous = null;
        Node actual = head;

        while (actual != null) {
            Node next = actual.next;
            actual.next = previous;
            actual.prev = next;
            previous = actual;
            actual = next;
        }

        final Node aux = tail;
        tail = head;
        head = aux;
    }

    public boolean isPalindrome() {
        if (length == 1 || isEven()) {
            return allSameValues();
        }

        final int middleNodeIndex = (length / 2);
        final Node middleNode = getNode(middleNodeIndex);

        Node left = middleNode.prev;
        Node right = middleNode.next;

        while (right != null && left != null) {
            if (left.value != right.value) {
                return false;
            }

            right = right.next;
            left = left.prev;
        }

        return true;
    }

    private boolean isEven() {
        return length % 2 == 0;
    }

    public Node getNode(final int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node aux = head;

        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux;
    }

    private boolean allSameValues() {
        Node aux = head;

        while (aux != null && aux.next != null) {
            if (aux.value != aux.next.value) {
                return false;
            }

            aux = aux.next;
        }

        return true;
    }


    // WRITE THE REMOVEDUPLICATES METHOD HERE //
    //                                        //
    //                                        //
    //                                        //
    //                                        //
    ////////////////////////////////////////////

}


