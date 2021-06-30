package com.cmani.practice;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumberOfList {
    public static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val=val;
        }
        ListNode(){}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum =0;
        ListNode resultNode = new ListNode();
        ListNode current = resultNode;
        while(l1 !=null || l2 != null){
            int x =0;
            int y =0;
            if(l1 != null){
                x = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                y= l2.val;
                l2 = l2.next;
            }
            sum = x+y+carry;

            int mod = sum % 10;
            System.out.println("mod: "+mod+ "sum "+sum+" carry "+carry);
            current.next =  new ListNode(mod);
            current = current.next;
            carry = (sum >= 10) ? 1 : 0;


        }
        if(carry ==1){
            current.next = new ListNode(carry);
        }
        return resultNode.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    
        ListNode resultNode = new AddTwoNumberOfList().addTwoNumbers(l1,l2);
        while(null != resultNode ){
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

}
