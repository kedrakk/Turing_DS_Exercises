/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.heap;

import java.util.List;

/**
 *
 * @author kedk
 */
public class HeapUtil {

    public static Boolean isMaxHeap(MaxHeap heap) {
        List<Integer> data = heap.getData();
        return isMaxHeap(data, 0);
    }

    static Boolean isMaxHeap(List<Integer> data, int currentIndex) {
        Integer current = data.get(currentIndex);
        int leftIndex = currentIndex * 2 + 1;
        int rightIndex = currentIndex * 2 + 2;

        Integer leftChild = null;
        Integer rightChild = null;
        Boolean isMax = true;
        if (leftIndex < data.size()) {
            leftChild = data.get(leftIndex);
            if (current < leftChild) {
                isMax = false;
            }
            isMax = isMax && isMaxHeap(data, leftIndex);
        }
        if (rightIndex < data.size()) {
            rightChild = data.get(rightIndex);
            if (current < rightChild) {
                isMax = false;
            }
            isMax = isMax && isMaxHeap(data, rightIndex);
        }
        return isMax;
    }
}
