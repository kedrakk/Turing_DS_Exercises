/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.linkedlist;

import java.util.Iterator;

/**
 *
 * @author kedk
 */
class LinkedList implements Iterable {

    Node first;
    Node last;

    public LinkedList() {
    }

    public LinkedList(Node first) {
        this.first = first;
        this.last = first;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    public void addFirst(Node node) {
        if (this.first == null) {
            this.first = node;
            this.last = node;
        } else {
            node.setNext(first);
            this.first = node;
        }
    }

    public void addLast(Node node) {
        if (this.last == null && this.first == null) {
            this.first = node;
            this.last = node;
        } else {
            this.last.setNext(node);
            this.last = node;
        }
    }

    public Node find(int item) {
        Node currentNode = this.first;
        while (currentNode != null) {
            int currentValue = currentNode.value;
            if (currentValue == item) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public Node deleteNode(int value) {
        Node nodeToDelete = this.find(value);
        if (nodeToDelete != null) {
            if (this.first == nodeToDelete) {
                if (this.last == this.last) {
                    this.first = null;
                    this.last = null;
                } else {
                    this.first = nodeToDelete.next;
                }
                return nodeToDelete;
            }
        }
        return null;
    }

    public class ListIterator implements Iterator {

        Node current;

        public ListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Node temp = current;
            if (current != null) {
                current = current.next;
            }
            return temp;
        }

    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        first.setNext(second);
        second.setNext(third);

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(first);

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Node node = (Node) iterator.next();
            System.out.println("Item: " + node.getValue());
        }
    }

}
