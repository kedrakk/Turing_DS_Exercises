/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

/**
 *
 * @author kedk
 */
class MergeSort {

    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                result[k++] = arr1[i++];
                result[k++] = arr2[j++];
            } else if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    public int[] sort(int[] arr) {
        if (arr.length > 1) {
            int middle = arr.length / 2;
            int[] arr1 = new int[middle];
            int k = 0;
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = arr[k++];
            }
            int[] arr2 = new int[arr.length - middle];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = arr[k++];
            }
            int[] result = this.merge(arr1, arr2);
            return result;
        }
        return new int[]{arr[0]};
    }

}
