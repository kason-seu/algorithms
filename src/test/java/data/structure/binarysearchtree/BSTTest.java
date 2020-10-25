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
}