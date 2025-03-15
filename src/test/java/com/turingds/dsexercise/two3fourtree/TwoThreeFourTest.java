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

    TwoThreeFourTree tree = new TwoThreeFourTree();

//    @Test
//    public void testInsertBaseCase() {
//        tree.insert(100);
//
//        Node root = tree.getRoot();
//        assertEquals(100, root.keys[0]);
//        assertEquals(2, root.noOfNode);
//    }
//
//    @Test
//    public void testInsertSmallBaseCase() {
//        tree.insert(100);
//        tree.insert(90);
//
//        Node root = tree.getRoot();
//        assertEquals(90, root.keys[0]);
//        assertEquals(100, root.keys[1]);
//        assertEquals(3, root.noOfNode);
//    }
//
//    @Test
//    public void testInsertLargeBaseCase() {
//        tree.insert(100);
//        tree.insert(120);
//
//        Node root = tree.getRoot();
//        assertEquals(100, root.keys[0]);
//        assertEquals(120, root.keys[1]);
//        assertEquals(3, root.noOfNode);
//    }
//
//    @Test
//    public void testInsertSmallBaseCaseFour() {
//        tree.insert(100);
//        tree.insert(150);
//        Node insertedNode = tree.insert(120);
//
//        assertEquals(100, insertedNode.keys[0]);
//        assertEquals(120, insertedNode.keys[1]);
//        assertEquals(150, insertedNode.keys[2]);
//        assertEquals(4, insertedNode.noOfNode);
//    }
//
//    @Test
//    public void testSplitInsertBaseCase() {
//        tree.insert(100);
//        tree.insert(150);
//        tree.insert(120);
//        Node insertedNode = tree.insert(200);
//        Node parent = insertedNode.parent;
//        assertEquals(120, parent.keys[0]);
//
//        Node child0 = parent.children.get(0);
//        assertEquals(100, child0.keys[0]);
//
//        Node child1 = parent.children.get(1);
//        assertEquals(150, child1.keys[0]);
//        assertEquals(200, child1.keys[1]);
//    }
//
//    @Test
//    public void testInsertSplitCaseAndChild1() {
//        tree.insert(100);
//        tree.insert(150);
//        tree.insert(120);
//        tree.insert(200);
//        Node insertedNode = tree.insert(201);
//
//        Node parent = insertedNode.parent;
//        assertEquals(120, parent.keys[0]);
//        assertEquals(2, parent.noOfNode);
//        assertEquals(2, parent.children.size());
//
//        Node child0 = parent.children.get(0);
//        assertEquals(100, child0.keys[0]);
//
//        Node child1 = parent.children.get(1);
//        assertEquals(150, child1.keys[0]);
//        assertEquals(200, child1.keys[1]);
//        assertEquals(201, child1.keys[2]);
//    }
//
//    @Test
//    public void testInsertSplitCaseAndChild2() {
//        tree.insert(100);
//        tree.insert(150);
//        tree.insert(120);
//        tree.insert(200);
//        tree.insert(201);
//        Node insertedNode = tree.insert(202);
//
//        Node parent = insertedNode.parent;
//        assertEquals(120, parent.keys[0]);
//        assertEquals(200, parent.keys[1]);
//
//        Node child0 = parent.children.get(0);
//        assertEquals(100, child0.keys[0]);
//
//        Node child1 = parent.children.get(1);
//        assertEquals(150, child1.keys[0]);
//
//        Node child2 = parent.children.get(2);
//        assertEquals(201, child2.keys[0]);
//        assertEquals(202, child2.keys[1]);
//    }
//
//    @Test
//    public void testInsertSplitCaseAndChild3() {
//        tree.insert(100);
//        tree.insert(150);
//        tree.insert(120);
//        tree.insert(200);
//        tree.insert(201);
//        tree.insert(202);
//        tree.insert(101);
//        tree.insert(102);
//        Node insertedNode = tree.insert(103);
//
//        Node parent = insertedNode.parent;
//        System.out.println("parent"+parent);
//        assertEquals(101, parent.keys[0]);
//        assertEquals(120, parent.keys[1]);
//        assertEquals(200, parent.keys[2]);
//    }
    @Test
    public void testInsertSplitCaseAndParentUpLvl3() {
        tree.insert(100);
        tree.insert(150);
        tree.insert(120);
        tree.insert(200);
        tree.insert(201);
        tree.insert(203);
        tree.insert(204);
        Node insertedNode = tree.insert(205);

        Node root = tree.getRoot();
        assertEquals(200, root.keys[0]);

        Node child0 = root.children.get(0);
        assertEquals(120, child0.keys[0]);

        Node child1 = root.children.get(1);
        assertEquals(203, child1.keys[0]);

        Node searchNode = root.searchForInsert(206, tree);

        Node lvl1Child0 = child0.children.get(0);
        assertEquals(100, lvl1Child0.keys[0]);

        Node lvl1Child1 = child0.children.get(1);
        assertEquals(150, lvl1Child1.keys[0]);

        Node lvl1Child10 = child1.children.get(0);
        assertEquals(201, lvl1Child10.keys[0]);
        
        Node lvl1Child11 = child1.children.get(1);
        assertEquals(204, lvl1Child11.keys[0]);
        assertEquals(205, lvl1Child11.keys[1]);
    }
}
