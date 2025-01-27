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
public class BinaryTreeInsertTest {

    //@Test
    public void testInsertLeft() {
        Node root = new Node(17);
        BinaryTree bTree = new BinaryTree(root);

        Node insertedNode = bTree.insert(15);
        assertEquals(insertedNode, root.getLeftChild());
        assertEquals(root, insertedNode.getParent());
    }

    //@Test
    public void testInsertRight() {
        Node root = new Node(17);
        BinaryTree bTree = new BinaryTree(root);

        Node insertedNode = bTree.insert(18);
        assertEquals(insertedNode, root.getRightChild());
        assertEquals(root, insertedNode.getParent());
    }

    @Test
    public void testInsertLeftLevel2() {
        Node root = new Node(17);
        BinaryTree bTree = new BinaryTree(root);

        Node firstLeftChild = bTree.insert(15);
        Node insertedRightNode = bTree.insert(16);
        Node insertedLeftNode = bTree.insert(13);

        assertEquals(firstLeftChild, insertedRightNode.getParent());
        assertEquals(firstLeftChild, insertedLeftNode.getParent());
        assertEquals(insertedRightNode, firstLeftChild.getRightChild());
        assertEquals(insertedLeftNode, firstLeftChild.getLeftChild());
    }
}
