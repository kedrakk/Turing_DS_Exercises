/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class PostorderTraversalTest {

    BinaryTree tree;

    @Test
    public void testBaseCase() {
        Node root = new Node(17);
        tree = new BinaryTree(root);
        tree.insert(15);
        tree.insert(30);

        BinaryTreeTraversal traversal = new PostorderTraversalIterative(tree);
        Iterator<Node> iterator = traversal.iterator();

        assertEquals(15, iterator.next().getValue());
        assertEquals(30, iterator.next().getValue());
        assertEquals(17, iterator.next().getValue());
        assertEquals(false, iterator.hasNext());
    }
    
    @Test
    public void testCaseOne() {
        Node root = new Node(17);
        tree = new BinaryTree(root);
        tree.insert(15);

        BinaryTreeTraversal traversal = new PostorderTraversalIterative(tree);
        Iterator<Node> iterator = traversal.iterator();

        assertEquals(15, iterator.next().getValue());
        assertEquals(17, iterator.next().getValue());
        assertEquals(false, iterator.hasNext());
    }
    
    @Test
    public void testCaseTwo() {
        Node root = new Node(17);
        tree = new BinaryTree(root);
        tree.insert(30);

        BinaryTreeTraversal traversal = new PostorderTraversalIterative(tree);
        Iterator<Node> iterator = traversal.iterator();

        assertEquals(30, iterator.next().getValue());
        assertEquals(17, iterator.next().getValue());
        assertEquals(false, iterator.hasNext());
    }
}
