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
public class BinaryTreeTraversalTest {

    BinaryTree tree;

    public BinaryTreeTraversalTest() {
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

    //@Test
    public void testPreOrderTraversal() {
//        BinaryTreeTraversal traversal = new PreorderTraversal(tree);
        BinaryTreeTraversal traversal = new PreorderTraversalIterative(tree);
        Iterator<Node> iterator = traversal.iterator();

        assertEquals(17, iterator.next().getValue());
        assertEquals(15, iterator.next().getValue());
        assertEquals(13, iterator.next().getValue());
        assertEquals(16, iterator.next().getValue());
        assertEquals(30, iterator.next().getValue());
        assertEquals(18, iterator.next().getValue());
        assertEquals(19, iterator.next().getValue());
        assertEquals(35, iterator.next().getValue());
    }

    @Test
    public void testInOrderTraversal() {
//        BinaryTreeTraversal traversal = new InorderTraversal(tree);
        BinaryTreeTraversal traversal = new InorderTraversalIterative(tree);
        Iterator<Node> iterator = traversal.iterator();

        assertEquals(13, iterator.next().getValue());
        assertEquals(15, iterator.next().getValue());
        assertEquals(16, iterator.next().getValue());
        assertEquals(17, iterator.next().getValue());
        assertEquals(18, iterator.next().getValue());
        assertEquals(19, iterator.next().getValue());
        assertEquals(30, iterator.next().getValue());
        assertEquals(35, iterator.next().getValue());
    }

    //@Test
    public void testPostOrderTraversal() {
        BinaryTreeTraversal traversal = new PostorderTraversal(tree);
        Iterator<Node> iterator = traversal.iterator();

        assertEquals(13, iterator.next().getValue());
        assertEquals(16, iterator.next().getValue());
        assertEquals(15, iterator.next().getValue());
        assertEquals(19, iterator.next().getValue());
        assertEquals(18, iterator.next().getValue());
        assertEquals(35, iterator.next().getValue());
        assertEquals(30, iterator.next().getValue());
        assertEquals(17, iterator.next().getValue());
    }
}
