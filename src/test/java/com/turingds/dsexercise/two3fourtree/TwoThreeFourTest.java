/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.two3fourtree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class TwoThreeFourTest {

    @Test
    public void testInsertBaseCase() {
        TwoThreeFourTree tree = new TwoThreeFourTree();
        tree.insert(100);

        Node root = tree.getRoot();
        assertEquals(100, root.keys[0]);
        assertEquals(2, root.noOfNode);
    }

    @Test
    public void testInsertSmallBaseCase() {
        TwoThreeFourTree tree = new TwoThreeFourTree();
        tree.insert(100);
        tree.insert(90);

        Node root = tree.getRoot();
        assertEquals(90, root.keys[0]);
        assertEquals(100, root.keys[1]);
        assertEquals(3, root.noOfNode);
    }
    
    @Test
    public void testInsertLargeBaseCase() {
        TwoThreeFourTree tree = new TwoThreeFourTree();
        tree.insert(100);
        tree.insert(120);

        Node root = tree.getRoot();
        assertEquals(100, root.keys[0]);
        assertEquals(120, root.keys[1]);
        assertEquals(3, root.noOfNode);
    }
}
