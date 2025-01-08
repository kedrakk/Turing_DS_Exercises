/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.linkedlist;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class LinkedListTest {

    @Test
    public void testInsertFirst() {
        LinkedList linkedList = new LinkedList();
        Node first = new Node(10);
        linkedList.addFirst(first);

        Node second = new Node(20);
        linkedList.addFirst(second);

        Node third = new Node(30);
        linkedList.addFirst(third);

        Iterator iterator = linkedList.iterator();
        assertEquals(third, iterator.next());
        assertEquals(second, iterator.next());
        assertEquals(first, iterator.next());
    }

    @Test
    public void testInsertFirstIterate() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 9; i++) {
            linkedList.addFirst(new Node(i + 1));
        }

        Iterator iterator = linkedList.iterator();
        for (int i = 9; i < 0; i--) {
            Node currentNode = (Node) iterator.next();
            assertEquals(i, currentNode.getValue());
        }

    }

    @Test
    public void testInsertLast() {
        LinkedList linkedList = new LinkedList();
        Node first = new Node(10);
        linkedList.addLast(first);

        Node second = new Node(20);
        linkedList.addLast(second);

        Node third = new Node(30);
        linkedList.addLast(third);

        Iterator iterator = linkedList.iterator();

        assertEquals(first, iterator.next());
        assertEquals(second, iterator.next());
        assertEquals(third, iterator.next());
    }

    @Test
    public void testInsertLastIterate() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 9; i++) {
            linkedList.addLast(new Node(i + 1));
        }

        Iterator iterator = linkedList.iterator();
        for (int i = 0; i < 9; i++) {
            Node currentNode = (Node) iterator.next();
            assertEquals(i + 1, currentNode.getValue());
        }
    }

    public void testFirstAndLastMixed() {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(new Node(20));
        linkedList.addFirst(new Node(10));
        linkedList.addLast(new Node(30));
        linkedList.addFirst(new Node(5));
        //5->10->20->30

        Iterator iterator = linkedList.iterator();

        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertEquals(20, ((Node) iterator.next()).getValue());
        assertEquals(30, ((Node) iterator.next()).getValue());
    }

    @Test
    public void testFind() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 4; i++) {
            linkedList.addFirst(new Node((i + 1) * 10));
        }

        assertNotNull(linkedList.find(10));
        assertEquals(10, linkedList.find(10).getValue());
        assertEquals(20, linkedList.find(20).getValue());
        assertEquals(30, linkedList.find(30).getValue());
    }

    @Test
    public void testFindNegative() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 4; i++) {
            linkedList.addFirst(new Node((i + 1) * 10));
        }

        assertNull(linkedList.find(100));
    }

    @Test
    public void testFirstDeleteInOneItem() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Node(10));

        Node itemToDelete = linkedList.deleteNode(10);
        assertEquals(10, itemToDelete.getValue());
    }

    @Test
    public void testFirstDeleteInManyItems() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Node(30));
        linkedList.addFirst(new Node(20));
        linkedList.addFirst(new Node(10));

        Node itemToDelete = linkedList.deleteNode(10);
        assertEquals(10, itemToDelete.getValue());
        assertEquals(20, linkedList.getFirst().getValue());
    }

    @Test
    public void testMiddleDelete() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Node(30));
        linkedList.addFirst(new Node(20));
        linkedList.addFirst(new Node(10));

        Node itemToDelete = linkedList.deleteNode(20);
        assertEquals(20, itemToDelete.getValue());
    }

    @Test
    public void testDeleteLastNode() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Node(40));
        linkedList.addFirst(new Node(30));
        linkedList.addFirst(new Node(20));
        linkedList.addFirst(new Node(10));

        Node itemToDelete = linkedList.deleteNode(40);
        assertEquals(40, itemToDelete.getValue());

        Iterator iterator = linkedList.iterator();
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertEquals(20, ((Node) iterator.next()).getValue());
        assertEquals(30, ((Node) iterator.next()).getValue());
        assertFalse(iterator.hasNext());
        assertEquals(30, linkedList.getLast().getValue());
    }

    @Test
    public void testDeleteRandomMultiple() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new Node(70));
        linkedList.addFirst(new Node(60));
        linkedList.addFirst(new Node(50));
        linkedList.addFirst(new Node(40));
        linkedList.addFirst(new Node(30));
        linkedList.addFirst(new Node(20));
        linkedList.addFirst(new Node(10));

        linkedList.deleteNode(10);
        assertEquals(20, linkedList.getFirst().getValue());

        linkedList.deleteNode(50);

        linkedList.deleteNode(70);
        assertEquals(60, linkedList.getLast().getValue());

        Iterator iterator = linkedList.iterator();
        assertEquals(20, ((Node) iterator.next()).getValue());
        assertEquals(30, ((Node) iterator.next()).getValue());
        assertEquals(40, ((Node) iterator.next()).getValue());
        assertEquals(60, ((Node) iterator.next()).getValue());
        assertFalse(iterator.hasNext());
    }

}
