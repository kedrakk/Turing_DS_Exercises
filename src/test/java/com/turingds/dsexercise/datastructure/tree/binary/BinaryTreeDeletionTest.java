/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

import com.turingds.dsexercise.util.TreeUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class BinaryTreeDeletionTest {

    BinaryTree tree;

    public BinaryTreeDeletionTest() {
        Node root = new Node(17);
        tree = new BinaryTree(root);

        tree.insert(15);
        tree.insert(30);
        tree.insert(13);
        tree.insert(16);
        tree.insert(18);
        tree.insert(35);
        tree.insert(19);
    }

    @Test
    public void testSuccessor() {
        Node successor = tree.getSuccessorOf(17);
        assertEquals(18, successor.getValue());
    }

    //@Test
    public void testSuccessor2() {
        Node root = new Node(17);
        tree = new BinaryTree(root);

        tree.insert(75);
        tree.insert(62);
        tree.insert(87);
        tree.insert(93);

        Node successor = tree.getSuccessorOf(75);
        assertEquals(87, successor.getValue());
    }

    @Test
    public void testIsBinarySearchTree() {
        assertTrue(TreeUtils.isBinarySearchTree(tree));
    }

    @Test
    public void testDeleteLeaf() {
        Node deletedNode = this.tree.deleteNode(13);
        assertEquals(13, deletedNode.getValue());
        assertTrue(TreeUtils.isBinarySearchTree(tree));

        Node searchDeletedNode = this.tree.search(13);
        assertEquals(null, searchDeletedNode);
    }

    @Test
    public void testDeleteCase1() {
        Node root = new Node(17);
        tree = new BinaryTree(root);
        tree.insert(15);

        Node deletedNode = this.tree.deleteNode(17);
        assertEquals(17, deletedNode.getValue());
        assertTrue(TreeUtils.isBinarySearchTree(tree));

        Node searchDeletedNode = this.tree.search(17);
        assertEquals(null, searchDeletedNode);
    }
}
