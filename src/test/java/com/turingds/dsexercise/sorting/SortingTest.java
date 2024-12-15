/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.turingds.dsexercise.sorting;

import com.turingds.dsexercise.util.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kedk
 */
public class SortingTest {

    Utils utils = new Utils();
//    SortingAlgorithm sortingAlgo = new BubbleSorting();
//    SortingAlgorithm sortingAlgo = new SelectionSorting();
    SortingAlgorithm sortingAlgo = new InsertionSorting();

    @Test
    public void testSort() {

        int[] arr = {3, 2, 1};
        sortingAlgo.sort(arr);

        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testSingleElementSort() {
        int[] arr = {3};
        sortingAlgo.sort(arr);

        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testEmptyElementSort() {
        int[] arr = {};
        sortingAlgo.sort(arr);

        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testDoubleElementSort() {
        int[] arr = {3, 1};
        sortingAlgo.sort(arr);

        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testRandomElementSort() {
        int[] arr = utils.generateRadomArray(20);
        System.out.println("Original: "+utils.arrayToString(arr));
        
        sortingAlgo.sort(arr);
        System.out.println("Sorted: "+utils.arrayToString(arr));
        
        assertTrue(utils.isArraySorted(arr));
    }

}
