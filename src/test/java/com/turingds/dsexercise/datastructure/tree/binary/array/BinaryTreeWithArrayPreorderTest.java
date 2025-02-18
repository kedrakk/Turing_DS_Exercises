/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary.array;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class BinaryTreeWithArrayPreorderTest {

    BinaryTreeWithArray tree = new BinaryTreeWithArray();

    public BinaryTreeWithArrayPreorderTest() {
        tree.insert(17);
        tree.insert(15);
        tree.insert(30);
        tree.insert(13);
        tree.insert(16);
        tree.insert(18);
        tree.insert(35);
        tree.insert(19);
    }

    @Test
    public void testPreorderTraversal() {
        BinaryTreeWithArrayPreorderTraversal traversal = new BinaryTreeWithArrayPreorderTraversal(tree);
        Iterator<Integer> iterator = traversal.iterator();
        assertEquals(17, iterator.next());
        assertEquals(15, iterator.next());
        assertEquals(13, iterator.next());
        assertEquals(16, iterator.next());
        assertEquals(30, iterator.next());
        assertEquals(18, iterator.next());
        assertEquals(19, iterator.next());
        assertEquals(35, iterator.next());
    }
}
