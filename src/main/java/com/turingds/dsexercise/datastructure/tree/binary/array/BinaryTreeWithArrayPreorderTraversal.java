/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary.array;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kedk
 */
public class BinaryTreeWithArrayPreorderTraversal implements Iterable<Integer> {

    BinaryTreeWithArray binaryTree;
    ArrayList<Integer> arrayList;

    public BinaryTreeWithArrayPreorderTraversal(BinaryTreeWithArray tree) {
        this.binaryTree = tree;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public void traversePreOrder() {
        int rootIndex = 0;
        this.traversePreOrderAction(rootIndex);
    }

    void traversePreOrderAction(int nodeIndex) {
        Integer current = this.binaryTree.tree[nodeIndex];
        if (current != null) {
            this.arrayList.add(current);
        } else {
            return;
        }

        int leftIndex = nodeIndex * 2 + 1;
        this.traversePreOrderAction(leftIndex);

        int rightIndex = nodeIndex * 2 + 2;
        this.traversePreOrderAction(rightIndex);
    }

    class TreeIterator implements Iterator<Integer> {

        int currentIndex = 0;

        TreeIterator() {
            arrayList = new ArrayList<>();
            traversePreOrder();
        }

        @Override
        public boolean hasNext() {
            return currentIndex <= arrayList.size() - 1;
        }

        @Override
        public Integer next() {
            return arrayList.get(currentIndex++);
        }

    }

}
