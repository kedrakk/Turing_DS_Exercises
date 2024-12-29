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
public class LinkedListIteratorTest {

    @Test
    public void testIterator() {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        first.setNext(second);
        second.setNext(third);

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(first);

        Iterator iterator = linkedList.iterator();
        assertEquals(first, iterator.next());
        assertEquals(second, iterator.next());
        assertEquals(third, iterator.next());
    }
}
