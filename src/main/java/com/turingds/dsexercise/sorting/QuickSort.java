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
        int tmpPivotIndex = 0;
        int leftIndex = tmpPivotIndex + 1;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            while (leftIndex < arr.length - 1 && arr[leftIndex] < arr[tmpPivotIndex]) {
                leftIndex++;
            }
            while (rightIndex > tmpPivotIndex + 1 && arr[rightIndex] > arr[tmpPivotIndex]) {
                rightIndex--;
            }
            int tmp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = tmp;
        }

        if (arr[tmpPivotIndex] > arr[leftIndex]) {
            int tmp = arr[leftIndex];
            arr[leftIndex] = arr[tmpPivotIndex];
            arr[tmpPivotIndex] = tmp;

            return leftIndex;
        }

        return tmpPivotIndex;
    }

}
