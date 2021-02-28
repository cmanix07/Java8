package com.cmani.practice;

public class CircularLinkedListMinAndMax {
    Node head;
    Node tail;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head=newNode;
        }else{
            tail.next=newNode;
        }
        tail=newNode;
        tail.next=head;
    }

    public void display(){
        Node current = head;
        System.out.println("------ Start:: Displaying the nodes in list ------");
        while (null != current && current != tail ){
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("------ End:: Displaying the nodes in list ------");
    }

    public void findMinAndMaxNode(){
        Node current = head;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (null != current && current != tail ){
            if(current.data < min){
                min = current.data;
            }else if(current.data > max) {
                max=current.data;
            }
            current=current.next;
        }
        System.out.println("Minimum Value of list: "+min+" And maximum value of list: "+max);
    }

    public static void main(String[] args) {
        CircularLinkedListMinAndMax c = new CircularLinkedListMinAndMax();
        c.addNode(10);
        c.addNode(20);
        c.addNode(100);
        c.addNode(200);
        c.addNode(5);
        c.addNode(150);
        c.addNode(50);

        c.display();
        c.findMinAndMaxNode();

    }

}
