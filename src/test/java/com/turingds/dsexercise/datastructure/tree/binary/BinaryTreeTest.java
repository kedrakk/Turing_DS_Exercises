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
        Node root = new Node(17);
        Node firstleftChild = new Node(13);
        Node rightChild = new Node(18);

        root.setLeftChild(firstleftChild);
        root.setRightChild(rightChild);
        
        firstleftChild.setLeftChild(new Node(10));
        firstleftChild.setRightChild(new Node(15));

        BinaryTree binaryTree = new BinaryTree(root);
        return binaryTree;
    }

    @Test
    public void testTreeCreate() {

        BinaryTree binaryTree = getBinaryTree();

        assertEquals(17, binaryTree.root.getValue());
        assertEquals(13, binaryTree.root.getLeftChild().getValue());
        assertEquals(18, binaryTree.root.getRightChild().getValue());
    }

    @Test
    public void testSearchRootItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item = binaryTree.search(17);
        assertEquals(17, item.getValue());
    }

    @Test
    public void testSearchLeftItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item1 = binaryTree.search(13);
        assertEquals(13, item1.getValue());
    }

    @Test
    public void testSearchRightItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item2 = binaryTree.search(18);
        assertEquals(18, item2.getValue());
    }
    
    @Test
    public void testSearchSecondLevelLeftChild() {
        BinaryTree binaryTree = getBinaryTree();
        Node item2 = binaryTree.search(15);
        assertEquals(15, item2.getValue());
    }

    @Test
    public void testSearchNonExistingItem() {
        BinaryTree binaryTree = getBinaryTree();
        Node item = binaryTree.search(16);
        assertEquals(null, item);
    }
}
