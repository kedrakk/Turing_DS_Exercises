/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import com.turingds.dsexercise.datastructure.linkedlist.*;

/**
 *
 * @author kedk
 */
class QueueByLinkedList extends LinkedList {

    int size = 0;

    protected void enque(int i) {
        super.addLast(new Node(i));
        this.size++;
    }

    protected int size() {
        return this.size;
    }

    protected int peek() {
        return super.getFirst().getValue();
    }

    protected int dequeue() {
        if (this.size > 0) {
            Node firstNode = super.getFirst();
            super.deleteNode(firstNode.getValue());
            this.size--;
            return firstNode.getValue();
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

}
