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
public class MergeSortV2Test {

    MergeSortV2 v2Algo = new MergeSortV2();
    Utils utils = new Utils();

    @Test
    public void testSortMany() {
        int[] arr = {3, 1, 5, 7, 2, 4};
        v2Algo.sort(arr);
        assertTrue(utils.isArraySorted(arr));
    }

    @Test
    public void testMergeSortV2() {
        int[] arr = {1, 2, 10, 3, 4, 8};
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;

        v2Algo.merge(arr, left, middle, right);
        assertTrue(utils.isArraySorted(arr));//1,2,3,4,8,10
    }

    @Test
    public void testMergeSortV2Simple() {
        int[] arr = {1, 2, 5};
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;

        v2Algo.merge(arr, left, middle, right);
        assertTrue(utils.isArraySorted(arr));//1,2,3,4,8,10
    }

    @Test
    public void testSortRandom() {
        int[] arr = utils.generateRadomArray(14);
        v2Algo.sort(arr);
        assertTrue(utils.isArraySorted(arr));
    }
}
