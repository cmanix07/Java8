package com.cmani.practice;

public class LinkedListCycleDetection {

    private Node head;
    public static class Node{
        private Node next;
        private int data;
        public Node(int data){
            this.data = data;
        }
    }

    public boolean isCyclicLikedListExist(Node head){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }

    public Node firstNodeOfCyclicList(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            slow = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;

        } else {
            return new Node(Integer.MIN_VALUE);
        }
    }


    //It will find the middle elements in linear linked list without cyclic
    public Node findMiddleNodeOfLinkedList(Node head){
        Node slow = head;
        Node fast = head;
        if(slow == null || (slow.next == null) ){
            return slow;
        }
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListCycleDetection l = new LinkedListCycleDetection();
        l.head = new Node(1);
        l.head.next = new Node(2);
        l.head.next.next = new Node(3);
        Node node = l.head.next.next.next = new Node(4);
        l.head.next.next.next.next = new Node(5);
        l.head.next.next.next.next.next = node;
        //l.head.next.next.next.next.next.next = new Node(6);;

        boolean isCyclic = l.isCyclicLikedListExist(l.head);
        System.out.println("LinkedList is a cyclic: "+isCyclic);
        System.out.println(l.firstNodeOfCyclicList(l.head).data);

    }
}
