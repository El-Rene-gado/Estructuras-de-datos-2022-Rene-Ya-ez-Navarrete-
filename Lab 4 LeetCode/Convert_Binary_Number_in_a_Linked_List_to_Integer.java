/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package lab.pkg4.leetcode;

/**
 *
 * @author Rene Yañez
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int cont = head.val;
        while (head.next != null) {
            cont = cont * 2 + head.next.val;
            head = head.next;    
        }
        return cont;
    }
}
