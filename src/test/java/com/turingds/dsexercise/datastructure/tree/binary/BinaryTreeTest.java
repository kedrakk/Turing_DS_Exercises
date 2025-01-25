/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class BinaryTreeTest {

    BinaryTree getBinaryTree() {
        Node root = new Node(7);
        Node leftChild = new Node(6);
        Node rightChild = new Node(8);

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);

        BinaryTree binaryTree = new BinaryTree(root);
        return binaryTree;
    }

    @Test
    public void testTreeCreate() {

        BinaryTree binaryTree = getBinaryTree();

        assertEquals(7, binaryTree.root.getValue());
        assertEquals(6, binaryTree.root.getLeftChild().getValue());
        assertEquals(8, binaryTree.root.getRightChild().getValue());
    }

    @Test
    public void testSearchRootItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item = binaryTree.search(7);
        assertEquals(7, item.getValue());
    }

    @Test
    public void testSearchLeftItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item1 = binaryTree.search(6);
        assertEquals(6, item1.getValue());
    }

    @Test
    public void testSearchRightItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item2 = binaryTree.search(8);
        assertEquals(8, item2.getValue());
    }

    @Test
    public void testSearchNonExistingItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item = binaryTree.search(3);
        assertEquals(null, item);
    }
}
