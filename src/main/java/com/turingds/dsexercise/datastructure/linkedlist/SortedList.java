/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.linkedlist;

/**
 *
 * @author kedk
 */
class SortedList extends LinkedList {
    
    protected void add(int i) {
        if (super.getFirst() == null) {
            this.addFirst(new Node(i));
        } else {
            Node currentNode = this.getFirst();
            Node previousNode = null;
            while (currentNode != null) {
                if (currentNode.value > i) {
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            Node nodeToAdd = new Node(i);
            if (previousNode != null) {
                nodeToAdd.setNext(currentNode);
                previousNode.setNext(nodeToAdd);
            } else {
                this.addFirst(nodeToAdd);
            }
        }
    }
    
}
