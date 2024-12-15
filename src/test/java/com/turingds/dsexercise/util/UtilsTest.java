/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.turingds.dsexercise.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kedk
 */
public class UtilsTest {

    @Test
    public void testZeroElementArray() {
        Utils utils = new Utils();
        int[] arr = {};
        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testOneElementArray() {
        Utils utils = new Utils();
        int[] arr = {1};
        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testMultipleElementArray() {
        Utils utils = new Utils();
        int[] arr = {1, 2, 5, 7};
        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testMultipleElementNegativeCase() {
        Utils utils = new Utils();
        int[] arr = {1, 2, 5, 7, 0};
        assertFalse(utils.isArraySorted(arr));
    }
}
