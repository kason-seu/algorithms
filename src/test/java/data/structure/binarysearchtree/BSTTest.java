package data.structure.binarysearchtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void testRemoveMin() {
        BST<Integer> bst = new BST<>();

        bst.add(10);

        bst.add(12);
        bst.add(14);
        bst.add(15);

        bst.printBinarySearchTree();

        System.out.println("--------");
        bst.removeMini();

        bst.printBinarySearchTree();
    }


    @Test
    public void testRemoveMax() {
        BST<Integer> bst = new BST<>();

        bst.add(10);

        bst.add(12);
        bst.add(14);
        bst.add(15);

        bst.printBinarySearchTree();

        System.out.println("--------");
        bst.removeMax();

        bst.printBinarySearchTree();
    }

    @Test
    public void testRemoveAnyValue() {
        BST<Integer> bst = new BST<>();

        bst.add(10);

        bst.add(8);
        bst.add(16);
        bst.add(6);
        bst.add(9);
        bst.add(12);
        bst.add(20);
        bst.add(4);
        bst.add(7);
        bst.add(11);
        bst.add(14);
        bst.add(18);
        bst.add(21);

        bst.printBinarySearchTree();

        System.out.println("--------");
        bst.removeAnyValue(16);

        bst.printBinarySearchTree();
    }
}