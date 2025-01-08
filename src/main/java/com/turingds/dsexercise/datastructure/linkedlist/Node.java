/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.linkedlist;

/**
 *
 * @author kedk
 */
public class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public void setNext(Node node) {
        this.next = node;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public Node getNext(){
        return this.next;
    }
}
