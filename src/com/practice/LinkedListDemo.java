package com.practice;

public class LinkedListDemo {
    public static void main(String[] args) {
        // {3, 4, 1, 2, 9}
        // edge cases:  {0, 0, 1, 2, 8}  {0, 4, 1, 2, 9} {9, 9, 9, 9, 9} {0, 0, 0, 0, 0} {0} {9} {5}
        // for convenience to try different dynamic inputs
        int[] input = {3, 4, 1, 2, 9};
        LinkedListDemo linkedList = new LinkedListDemo();
        Node root = new Node(input[0]);
        Node current = root;
        for(int i = 1; i < input.length; i++) {
            current = linkedList.add(current, input[i]);
        }
        System.out.println("Input: ");
        linkedList.print(root);
        root = linkedList.reverse(root);
        linkedList.incrementNode(root, 1);
        root = linkedList.reverse(root);
        System.out.println("Output:");
        linkedList.print(root);
    }

    public void incrementNode(Node node, int leading) {
        if(node == null || leading == 0) {
            return;
        }
        if(node.value + leading > 9){
            node.value = 0;
            if(node.next == null) {
                node.next = new Node(leading);
            } else {
                incrementNode(node.next, leading);
            }
        } else {
            node.value = node.value + leading;
        }
    }

    public Node reverse(Node node) {
        Node previous = null;
        Node current = node;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }

    public Node add(Node node, int value) {
        node.next = new Node(value);
        return node.next;
    }

    public void print(Node list) {
        while(list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
        System.out.println();
    }
}


class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
    }
}