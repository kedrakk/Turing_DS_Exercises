/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.util;

import com.turingds.dsexercise.datastructure.tree.binary.BinaryTree;
import com.turingds.dsexercise.datastructure.tree.binary.BinaryTreeTraversal;
import com.turingds.dsexercise.datastructure.tree.binary.InorderTraversal;
import com.turingds.dsexercise.datastructure.tree.binary.Node;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kedk
 */
public class TreeUtils {

    public static boolean isBinarySearchTree(BinaryTree tree) {
        BinaryTreeTraversal traversal = new InorderTraversal(tree);
        Iterator<Node> iterator = traversal.iterator();

        ArrayList<Node> arrayList = new ArrayList<>();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }

        Node first = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            Node next = arrayList.get(i);
            if (first.getValue() < next.getValue()) {
                first = next;
            } else {
                return false;
            }
        }

        return true;
    }
}
