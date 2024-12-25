/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class QueueTest {

    Queue queue = new Queue();

    @Test
    public void testEnque() {
        queue.enque(100);
        assertEquals(1, queue.size());
        assertEquals(100, queue.peek());
    }

    @Test
    public void testEnque200() {
        queue.enque(200);
        assertEquals(1, queue.size());
        assertEquals(200, queue.peek());
    }

    @Test
    public void testEnqueMultipleItems() {
        queue.enque(200);
        queue.enque(300);
        assertEquals(2, queue.size());
        assertEquals(200, queue.peek());
    }

    @Test
    public void testSize() {
        queue.enque(200);
        queue.enque(300);
        queue.enque(400);
        assertEquals(3, queue.size());
    }

    @Test
    public void testDequeue() {
        queue.enque(200);
        int item = queue.dequeue();
        assertEquals(200, item);
    }

    @Test
    public void testBoundary() {
        for (int i = 0; i < 10; i++) {
            queue.enque(i);
        }
        assertEquals(10, queue.size());
        for (int i = 0; i < 10; i++) {
            int item = queue.dequeue();
            assertEquals(i, item);
        }
    }

    @Test
    public void testQueueIsFull() {
        for (int i = 0; i < 10; i++) {
            queue.enque(i);
        }
        assertEquals(10, queue.size());
        for (int i = 0; i < 10; i++) {
            int item = queue.dequeue();
            assertEquals(i, item);
        }
        RuntimeException excp = assertThrows(RuntimeException.class, () -> {
            queue.enque(100);
        });
        assertEquals("Queue is full", excp.getMessage());
    }

    @Test
    public void testQueueIsEmpty() {
        queue.enque(100);
        queue.dequeue();
        RuntimeException excp = assertThrows(RuntimeException.class, () -> {
            queue.dequeue();
        });
        assertEquals("Queue is empty", excp.getMessage());
    }
}
