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
public class SearchTwoThreeFourTest {

    TwoThreeFourTree tree = new TwoThreeFourTree();

    @Test
    public void testSearchSingleNode() {
        Node node = new Node();
        node.insert(120, tree);

        Node searchNode = node.search(120);
        assertEquals(node, searchNode);
    }

    @Test
    public void testSearchBaseCase() {
        Node node = new Node();
        node.insert(120, tree);
        node.insert(150, tree);
        node.insert(90, tree);

        Node searchNode = node.search(90);
        assertEquals(node, searchNode);
    }

    @Test
    public void testSearchNegativeCase() {
        Node node = new Node();
        node.insert(120, tree);
        node.insert(150, tree);
        node.insert(100, tree);

        Node searchNode = node.search(90);
        assertEquals(null, searchNode);
    }

    @Test
    public void testSearchLevel1Depth() {
        Node parent = new Node();
        parent.insert(120, tree);

        Node child0 = new Node();
        child0.insert(100, tree);
        child0.parent = parent;

        Node child1 = new Node();
        child1.insert(150, tree);
        child1.parent = parent;

        parent.children.add(child0);
        parent.children.add(child1);

        Node searchNode = parent.search(150);
        assertEquals(child1, searchNode);
    }

    @Test
    public void testSearchLevel1DepthLeftSide() {
        Node parent = new Node();
        parent.insert(120, tree);

        Node child0 = new Node();
        child0.insert(100, tree);
        child0.parent = parent;

        Node child1 = new Node();
        child1.insert(150, tree);
        child1.parent = parent;

        parent.children.add(child0);
        parent.children.add(child1);

        Node searchNode = parent.search(100);
        assertEquals(child0, searchNode);
    }

    @Test
    public void testSearchLevel1ThreeTree() {
        Node parent = new Node();
        parent.insert(120, tree);
        parent.insert(150, tree);

        Node child0 = new Node();
        child0.insert(100, tree);
        child0.parent = parent;

        Node child1 = new Node();
        child1.insert(125, tree);
        child1.parent = parent;

        Node child2 = new Node();
        child2.insert(151, tree);
        child2.parent = parent;

        parent.children.add(child0);
        parent.children.add(child1);
        parent.children.add(child2);

        Node searchNode = parent.search(100);
        assertEquals(child0, searchNode);

        Node searchNode1 = parent.search(125);
        assertEquals(child1, searchNode1);

        Node searchNode2 = parent.search(151);
        assertEquals(child2, searchNode2);
    }

    @Test
    public void testSearchLevel1FourTree() {
        Node parent = new Node();
        parent.insert(120, tree);
        parent.insert(150, tree);
        parent.insert(200, tree);

        Node child0 = new Node();
        child0.insert(100, tree);
        child0.parent = parent;

        Node child1 = new Node();
        child1.insert(125, tree);
        child1.parent = parent;

        Node child2 = new Node();
        child2.insert(151, tree);
        child2.parent = parent;

        Node child3 = new Node();
        child3.insert(205, tree);
        child3.parent = parent;

        parent.children.add(child0);
        parent.children.add(child1);
        parent.children.add(child2);
        parent.children.add(child3);

        Node searchNode = parent.search(100);
        assertEquals(child0, searchNode);

        Node searchNode1 = parent.search(125);
        assertEquals(child1, searchNode1);

        Node searchNode2 = parent.search(151);
        assertEquals(child2, searchNode2);

        Node searchNode3 = parent.search(205);
        assertEquals(child3, searchNode3);
    }

    @Test
    public void testDepth3() {
        /**
         * [205] [150] [215,300] [120] [200] [210] [250] [310,350]
         *
         */
        Node parent = new Node();
        parent.insert(205, tree);

        Node level1child0 = new Node();
        level1child0.insert(150, tree);
        level1child0.parent = parent;

        Node level1child1 = new Node();
        level1child1.insert(215, tree);
        level1child1.insert(300, tree);
        level1child1.parent = parent;

        parent.children.add(level1child0);
        parent.children.add(level1child1);

        Node level2child0 = new Node();
        level2child0.insert(120, tree);
        level2child0.parent = level1child0;

        Node level2child1 = new Node();
        level2child1.insert(200, tree);
        level2child1.parent = level1child0;

        level1child0.children.add(level2child0);
        level1child0.children.add(level2child1);

        Node rightlevel1child0 = level1child1;

        Node rightlevel2child0 = new Node();
        rightlevel2child0.insert(210, tree);
        rightlevel2child0.parent = rightlevel1child0;

        Node rightlevel2child1 = new Node();
        rightlevel2child1.insert(250, tree);
        rightlevel2child1.parent = rightlevel1child0;

        Node rightlevel2child2 = new Node();
        rightlevel2child2.insert(310, tree);
        rightlevel2child2.insert(350, tree);
        rightlevel2child2.parent = rightlevel1child0;

        rightlevel1child0.children.add(rightlevel2child0);
        rightlevel1child0.children.add(rightlevel2child1);
        rightlevel1child0.children.add(rightlevel2child2);

        Node searchNode = parent.search(350);
        assertEquals(rightlevel2child2, searchNode);

        searchNode = parent.search(310);
        assertEquals(rightlevel2child2, searchNode);

        searchNode = parent.search(120);
        assertEquals(level2child0, searchNode);

        searchNode = parent.search(210);
        assertEquals(rightlevel2child0, searchNode);

        searchNode = parent.searchForInsert(351, tree);
        System.out.println("Search node for insert ==>" + searchNode);
        assertEquals(rightlevel2child2, searchNode);
        assertTrue(searchNode.isLeaf());

        searchNode = parent.searchForInsert(214, tree);
        System.out.println("Search node for insert ==>" + searchNode);
        assertEquals(rightlevel2child0, searchNode);
        assertTrue(searchNode.isLeaf());
    }
}
