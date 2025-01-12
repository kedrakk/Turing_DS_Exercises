/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

import org.junit.jupiter.api.Test;
import com.turingds.dsexercise.util.Utils;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kedk
 */
public class MergeSortTest {

    Utils utils = new Utils();
    MergeSort algo = new MergeSort();

    @Test
    public void testMerging() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] result = algo.merge(arr1, arr2);
        assertTrue(utils.isArraySorted(result));
    }

    @Test
    public void testMergingDifferentLength() {
        int[] arr1 = {1, 5};
        int[] arr2 = {2, 3, 6};
        int[] result = algo.merge(arr1, arr2);
        assertTrue(utils.isArraySorted(result));
    }

    @Test
    public void testMergingDifferentLength1() {
        int[] arr1 = {1, 5, 7, 9};
        int[] arr2 = {2, 3, 6};
        int[] result = algo.merge(arr1, arr2);
        assertTrue(utils.isArraySorted(result));
    }

    @Test
    public void testSort() {
        int[] arr = {3, 1};
        int[] result = algo.sort(arr);
        assertTrue(utils.isArraySorted(result));
    }

    @Test
    public void testSortMany() {
        int[] arr = {3, 1, 5};
        int[] result = algo.sort(arr);
        assertTrue(utils.isArraySorted(result));
    }

    @Test
    public void testSortRandom() {
        int[] arr = utils.generateRadomArray(20);
        int[] result = algo.sort(arr);
        assertTrue(utils.isArraySorted(result));
    }
}
