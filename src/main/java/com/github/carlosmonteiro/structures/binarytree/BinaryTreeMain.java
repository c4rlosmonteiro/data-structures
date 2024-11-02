package com.github.carlosmonteiro.structures.binarytree;

public class BinaryTreeMain {

    public static void main(final String [] args) {
        final BinaryTree<Integer> bt = new BinaryTree<>();
        System.out.println("After adding 50");
        bt.insert(50);
        //System.out.println(bt);

        System.out.println("After adding 75");
        bt.insert(75);
        //System.out.println(bt);

        System.out.println("After adding 75");
        bt.insert(25);
        //System.out.println(bt);

        System.out.println("After adding 100");
        bt.insert(100);
        //System.out.println(bt);

        System.out.println("After adding 55");
        bt.insert(55);
        //System.out.println(bt);

        System.out.println("After adding 55");
        bt.insert(15);
        //System.out.println(bt);

        System.out.println("After adding 55");
        bt.insert(45);
        //System.out.println(bt);

        System.out.println("Final \n______________________");
        System.out.println(bt);

    }
 }
