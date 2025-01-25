/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

import com.turingds.dsexercise.util.Utils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class RadixSortTest {
    
    RadixSort algo = new RadixSort();
    Utils utils = new Utils();

    //@Test
    public void testDigitLength() {
        int[] arr = {100, 2000, 4};
        int digitLength = algo.getDigitlength(arr);
        assertEquals(4, digitLength);
        
        int digitLength1 = algo.getDigitlength(new int[]{100, 200, 1});
        assertEquals(3, digitLength1);
    }

    //@Test
    public void testGetDigitAtIndex() {
        assertEquals(3, algo.getDitiAtIndex(3, 0));
        assertEquals(0, algo.getDitiAtIndex(3, 2));
        assertEquals(0, algo.getDitiAtIndex(3, 3));
        
        assertEquals(1, algo.getDitiAtIndex(13, 1));
        assertEquals(1, algo.getDitiAtIndex(123, 2));
        assertEquals(0, algo.getDitiAtIndex(123, 3));
        assertEquals(2, algo.getDitiAtIndex(123, 1));
        assertEquals(3, algo.getDitiAtIndex(123, 0));
        assertEquals(9, algo.getDitiAtIndex(9857, 3));
    }
    
    @Test
    public void testSort() {
        int[] arr = {9, 8, 3, 7, 5, 6, 4, 1};
        arr = algo.sort(arr);
        assertTrue(utils.isArraySorted(arr));
    }
    
    @Test
    public void testSortWithRandomData() {
        int[] arr = utils.generateRadomArray(20);
        arr = algo.sort(arr);
        assertTrue(utils.isArraySorted(arr));
    }
}
