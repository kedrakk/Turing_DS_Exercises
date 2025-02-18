/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary.array;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class BinaryTreeWithArrayTest {

    BinaryTreeWithArray tree = new BinaryTreeWithArray();

    public BinaryTreeWithArrayTest() {
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
    public void testInsertRoot() {

        int index = tree.insert(17);
        assertEquals(0, index);
    }

    @Test
    public void testInsertLeft() {

        int index = tree.insert(17);
        assertEquals(0, index);

        index = tree.insert(15);
        assertEquals(1, index);
    }

    @Test
    public void testInsertRight() {

        tree.insert(17);
        tree.insert(15);

        int index = tree.insert(30);
        assertEquals(2, index);
    }

    @Test
    public void testInsertDepthTwo() {

        tree.insert(17);
        tree.insert(15);
        tree.insert(30);

        int index = tree.insert(13);
        assertEquals(3, index);

        index = tree.insert(16);
        assertEquals(4, index);

        index = tree.insert(18);
        assertEquals(5, index);

        index = tree.insert(35);
        assertEquals(6, index);

        index = tree.insert(19);
        assertEquals(12, index);
    }

    @Test
    public void testSearch() {
        assertEquals(0, tree.search(17));
        assertEquals(1, tree.search(15));
        assertEquals(2, tree.search(30));
        assertEquals(3, tree.search(13));
        assertEquals(4, tree.search(16));
        assertEquals(5, tree.search(18));
        assertEquals(6, tree.search(35));
        assertEquals(12, tree.search(19));
        assertEquals(-1, tree.search(28));
    }
}
