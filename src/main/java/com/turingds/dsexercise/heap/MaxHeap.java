/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.heap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kedk
 */
class MaxHeap {

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
    private List<Integer> data = new ArrayList<>();

    public void insert(Integer item) {
        this.data.add(item);
        this.heapify();
    }

    void heapify() {
        int n = this.data.size();
        int currentIndex = n / 2 - 1;
        while (currentIndex >= 0) {
            int parent = this.data.get(currentIndex);
            int largestIndex = currentIndex;
            int leftIndex = currentIndex * 2 + 1;
            int rightIndex = currentIndex * 2 + 2;

            Integer leftChild = null;
            Integer rightChild = null;
            if (leftIndex < data.size()) {
                leftChild = this.data.get(leftIndex);
                if (leftChild > parent) {
                    largestIndex = leftIndex;
                }
            }
            if (rightIndex < data.size()) {
                rightChild = this.data.get(rightIndex);
                if (rightChild > parent) {
                    largestIndex = rightIndex;
                }
            }

            Integer tmp = this.data.get(currentIndex);
            Integer largest = this.data.get(largestIndex);

            this.data.set(currentIndex, largest);
            this.data.set(largestIndex, tmp);

            currentIndex--;
        }
    }

    void delete(int item) {
        int indexToDelete = this.data.indexOf(item);
        if (indexToDelete != -1) {
            if (isLeaf(indexToDelete)) {
                System.out.println("Remove leaf");
                this.data.remove(indexToDelete);
            } else {
                int lastIndex = this.data.size() - 1;
                int lastItem = this.data.get(lastIndex);

                this.data.set(indexToDelete, lastItem);
                this.data.remove(lastIndex);
            }
            this.heapify();
        }
    }

    Integer peek() {
        return this.data.get(0);
    }

    Boolean isLeaf(int index) {
        int n = this.data.size();
        int internalNode = n / 2 - 1;
        return internalNode > index;
//        int leftIndex = index * 2 + 1;
//        int rightIndex = index * 2 + 2;

//        Integer leftChild = null;
//        Integer rightChild = null;
//        if (leftIndex < data.size()) {
//            leftChild = this.data.get(leftIndex);
//        }
//        if (rightIndex < data.size()) {
//            rightChild = this.data.get(rightIndex);
//        }
//        return leftChild == null && rightChild == null;
    }

}
