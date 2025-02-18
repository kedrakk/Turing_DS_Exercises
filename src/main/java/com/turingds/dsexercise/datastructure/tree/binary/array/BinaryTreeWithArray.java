/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary.array;

/**
 *
 * @author kedk
 */
public class BinaryTreeWithArray {

    Integer[] tree = new Integer[50];

    public int insert(int item) {
        int index = 0;
        Integer current = tree[index];
        while (current != null) {
            if (item < current) {
                index = index * 2 + 1;
                current = tree[index];
            } else if (item > current) {
                index = index * 2 + 2;
                current = tree[index];
            }
        }
        tree[index] = item;
        return index;
    }

    public int search(int item) {
        int index = 0;
        Integer current = tree[index];

        while (current != null) {
            if (current == item) {
                return index;
            } else if (item < current) {
                index = index * 2 + 1;
                current = tree[index];
            } else if (item > current) {
                index = index * 2 + 2;
                current = tree[index];
            }
        }

        return -1;
    }

}
