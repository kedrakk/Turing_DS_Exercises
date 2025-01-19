/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

/**
 *
 * @author kedk
 */
class QuickSort {

    public int findPivot(int[] arr) {
        return this.findPivotInArr(arr, 0, arr.length - 1);
    }

    private int findPivotInArr(int[] arr, int start, int end) {
//        int pivot = arr[end];
//        int pivotIndex = start;
//
//        for (int i = start; i < end - 1; i++) {
//            if (arr[i] <= pivot) {
//                int tmp = arr[i];
//                arr[i] = arr[pivotIndex];
//                arr[pivotIndex] = tmp;
//                pivotIndex++;
//            }
//        }
//
//        int tmp = arr[pivotIndex];
//        arr[pivotIndex] = arr[end];
//        arr[end] = tmp;
//        return pivotIndex;

        int pivot = arr[end];
        int pivotIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[pivotIndex];
                arr[pivotIndex] = arr[i];
                arr[i] = tmp;
                pivotIndex++;
            }
        }

        int tmp = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = tmp;
        return pivotIndex;
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end || start < 0) {
            return;
        } else {
            int pivotIndex = this.findPivotInArr(arr, start, end);
            sort(arr, start, pivotIndex - 1);
            sort(arr, pivotIndex + 1, end);
        }
    }
}
