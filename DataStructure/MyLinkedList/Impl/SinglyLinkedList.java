package org.beerwaroff.DataStructure.MyLinkedList.Impl;

import org.beerwaroff.DataStructure.MyLinkedList.MyLinkedList;

public class SinglyLinkedList implements MyLinkedList {
    private int size;
    private Node head;
    private Node tail;
    private static class Node {
        private final int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }

        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        else if (index == 0) return head.val;
        else if (index == size - 1) return tail.val;
        else return getNode(index).val;
    }

    public void addAtHead(int val) {
        if (size ++ == 0) head = tail = new Node(val);
        else head = new Node(val, head);
    }

    public void addAtTail(int val) {
        if (size ++ == 0) head = tail = new Node(val);
        else tail = tail.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        else if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            Node prev = head;
            for (int i = 1; i < index; i ++) prev = prev.next;
            prev.next = new Node(val, prev.next);
            size ++;
        }

    }

    public void deleteAtIndex(int index) {
        Node prev = head;
        if (index > size - 1 || index < 0) return;
        else if (index == 0) {
            head = head.next;
            size --;
        } else if (index == size - 1) {
            for (int i = 1; i < size - 1; i ++) prev = prev.next;
            tail = prev;
            size --;
        } else {
            for (int i = 1; i < index; i ++) prev = prev.next;
            prev.next = prev.next.next;
            size --;
        }
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        int i = 0;
        Node current = head;
        while (i ++ != index) current = current.next;
        return current;
    }
}
