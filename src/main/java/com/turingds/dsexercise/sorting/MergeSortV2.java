/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

/**
 *
 * @author kedk
 */
class MergeSortV2 {

    public void merge(int[] arr, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        int length = right - left + 1;

        int[] result = new int[arr.length];
        while (i <= middle && j <= right) {
            if (arr[i] == arr[j] || arr[i] < arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }
        while (i <= middle) {
            result[k++] = arr[i++];
        }

        while (j <= right) {
            result[k++] = arr[j++];
        }
        
        System.arraycopy(result, left, arr, left, length);
    }

    public void mergeSort(int[] arr, int left, int middle, int right) {
        if (left != right) {
            
            int firstMiddle = (left + middle) / 2;
            this.mergeSort(arr, left, firstMiddle, middle);

            int secondMiddle = (middle + 1 + right) / 2;
            this.mergeSort(arr, middle + 1, secondMiddle, right);

            this.merge(arr, left, middle, right);
        } else {

            //single item, already sorted
            return;
        }
    }

    public void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;
        this.mergeSort(arr, left, middle, right);
    }

}
