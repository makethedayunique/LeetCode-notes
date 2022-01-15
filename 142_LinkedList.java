/*
 * 142. Linked List Cycle II
 * Given the head of a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can 
 * be reached again by continuously following the next pointer. Internally, 
 * pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). 
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
         * Very hard question
         * Step1: 
         * Two pointers fast and slow to find if they will meet
         * If meet, it means there must be a circle
         * If not, then vice versa
         * Step2:
         * Two pointers start from the meet point and the head
         * Two pointers move with one step each time they will finally meet
         * The meeting point is the node to be returned
         * There are many mathematic principals behind
         * resource: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0142.环形链表II.md
        */
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            
            if (slow == fast) {
                break;
            }
        }
        slow = head; // Reset slow pointer to the head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}