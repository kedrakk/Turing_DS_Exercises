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
public class StackByLinkedList extends LinkedList {

    int size = 0;

    public StackByLinkedList() {
        super();
    }

    public void push(int i) {
        super.addLast(new Node(i));
        this.size++;
    }

    public int size() {
        return size;
    }

    public int peek() {
        return super.getLast().getValue();
    }

    void deleteLast() {
        Node lastNode = super.getLast();
        Node current = super.getFirst();
        Node previous = null;

        while (current != lastNode) {
            previous = current;
            current = current.getNext();
        }

        if (previous != null) {
            previous.setNext(null);
        }
        super.last = previous;

    }

    public int pop() {
        Node lastNode = super.getLast();
        this.deleteLast();
        this.size--;
        return lastNode.getValue();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
