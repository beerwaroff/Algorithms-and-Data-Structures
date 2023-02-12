package org.beerwaroff.DataStructure.MyLinkedList.Impl;

import org.beerwaroff.DataStructure.MyLinkedList.MyLinkedList;

public class DoublyLinkedList implements MyLinkedList {

    private int size;
    private Node head;
    private Node tail;
    private static class Node {
        int val;
        Node prev;
        Node next;

        private Node(int val) {
            this.val = val;
        }

        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        private Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        else if (index == 0) return head.val;
        else if (index == size - 1) return tail.val;
        else return getNode(index).val;
    }

    public void addAtHead(int val) {
        if (size ++ == 0) head = tail = new Node(val);
        else {
            head = new Node(val, null, head);
            head.next.prev = head;
        }
    }

    public void addAtTail(int val) {
        if (size ++ == 0) head = tail = new Node(val);
        else {
            tail = new Node(val, tail, null);
            tail.prev.next = tail;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        else if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            Node prev = getNode(index).prev;
            prev.next = new Node(val, prev, prev.next);
            prev.next.next.prev = prev.next;
            size ++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) return;
        else if (index == 0) {
            head = head.next;
            size --;
        } else if (index == size - 1) {
            tail = tail.prev;
            size --;
        } else {
            Node prev = getNode(index).prev;
            prev.next = prev.next.next;
            prev.next.prev = prev;
            size --;
        }
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 1; i <= index; i ++) {
            current = current.next;
        }
        return current;
    }
}
