/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.recursion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class FactorialTest {

    Factorial fact = new Factorial();

    @Test
    public void testZeroFactorial() {
        assertEquals(1, fact.factorial(0));
        assertEquals(1, fact.factorial(1));
        assertEquals(2, fact.factorial(2));
        assertEquals(6, fact.factorial(3));
//        int result = fact.factorial(100000);
    }

}
