/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.linkedlist;

import java.util.Iterator;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class SortedListTest {

    SortedList sortedList = new SortedList();

    @Test
    public void addLargeFirst() {
        sortedList.add(10);
        sortedList.add(5);

        Iterator iterator = sortedList.iterator();
        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
    }

    @Test
    public void addSmallFirst() {
        sortedList.add(5);
        sortedList.add(7);

        Iterator iterator = sortedList.iterator();
        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(7, ((Node) iterator.next()).getValue());
    }

    @Test
    public void addMultipleFirst() {
        sortedList.add(5);
        sortedList.add(10);
        sortedList.add(2);

        Iterator iterator = sortedList.iterator();
        assertEquals(2, ((Node) iterator.next()).getValue());
        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void addMultipleLast() {
        sortedList.add(5);
        sortedList.add(10);
        sortedList.add(20);

        Iterator iterator = sortedList.iterator();

        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertEquals(20, ((Node) iterator.next()).getValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void addMultipleEqual() {
        sortedList.add(5);
        sortedList.add(10);
        sortedList.add(10);
        sortedList.add(20);
        sortedList.add(5);

        Iterator iterator = sortedList.iterator();

        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertEquals(20, ((Node) iterator.next()).getValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void addMultipleMiddle() {
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(10);

        Iterator iterator = sortedList.iterator();

        assertEquals(5, ((Node) iterator.next()).getValue());
        assertEquals(6, ((Node) iterator.next()).getValue());
        assertEquals(10, ((Node) iterator.next()).getValue());
        assertFalse(iterator.hasNext());
    }

    public void testWithRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int item = random.nextInt(100);
            sortedList.add(item);
        }

        Iterator iterator = sortedList.iterator();
        int previous = Integer.MIN_VALUE;

        while (iterator.hasNext()) {
            Node node = (Node) iterator.next();
            assertTrue(previous <= node.getValue());
            previous = node.getValue();
        }
    }

}
