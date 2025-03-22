/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.heap;

import com.turingds.dsexercise.util.Utils;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class HeapTest {

    MaxHeap heap = new MaxHeap();

    @Test
    public void testHeapMaxHeapBaseCase() {
        Integer[] data = {10};
        heap.setData(Arrays.asList(data));
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapMaxHeapRoot() {
        Integer[] data = {10, 9, 8};
        heap.setData(Arrays.asList(data));
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapMaxHeapLevel1() {
        Integer[] data = {10, 9, 8, 7, 5, 7, 6};
        heap.setData(Arrays.asList(data));
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapMaxHeapNegativeCase() {
        Integer[] data = {10, 11, 8, 7, 5, 7, 6};
        heap.setData(Arrays.asList(data));
        assertFalse(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapMaxHeapNegativeCase2() {
        Integer[] data = {10, 9, 8, 7, 5, 7, 10};
        heap.setData(Arrays.asList(data));
        assertFalse(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapifyBaseCase() {
        heap.insert(9);
        heap.insert(10);
        heap.insert(15);
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapifyComplexCase() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testHeapifyRandomase() {
        Utils util = new Utils();
        int arr[] = util.generateRadomArray(15);

        for (int item : arr) {
            heap.insert(item);
        }
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testDeleteLeaf() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);

        heap.delete(1);
        heap.delete(2);
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testDeleteNonLeaf() {
        heap.insert(10);
        heap.insert(9);
        heap.insert(8);

        heap.delete(10);
        assertTrue(HeapUtil.isMaxHeap(heap));
    }

    @Test
    public void testDeleteNonLeafCase2() {
        heap.insert(10);
        heap.insert(9);
        heap.insert(8);

        heap.delete(10);
        assertTrue(HeapUtil.isMaxHeap(heap));
        assertEquals(9, heap.peek());
    }
}
