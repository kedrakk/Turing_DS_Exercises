/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kedk
 */
public class StackDSTest {

    Stack stack = new Stack(10);

    @Test
    public void testPush() {
        stack.push(100);
        assertEquals(1, stack.size());

        int element = stack.peek();
        assertEquals(100, element);
    }

    @Test
    public void testMultiplePush() {
        stack.push(200);
        stack.push(300);
        assertEquals(2, stack.size());

        int element = stack.peek();
        assertEquals(300, element);
    }
    
    @Test
    public void testPop() {
        stack.push(100);
        
        int size = stack.size();

        int element = stack.pop();
        
        assertEquals(100, element);
        assertEquals(size-1, stack.size());
    }
    
    @Test
    public void testMultiplePop() {
        stack.push(100);
        stack.push(200);
        
        int size = stack.size();

        int element = stack.pop();
        assertEquals(200, element);
        
        element = stack.pop();
        assertEquals(100, element);
        
        assertEquals(size-2, stack.size());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
    }
}
