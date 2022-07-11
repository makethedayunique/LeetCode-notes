/**
 * 160. Intersection of Two Linked Lists
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
 * If the two linked lists have no intersection at all, return null.
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * 
 * Note that the linked lists must retain their original structure after the function returns.
 * 
 * 8Custom Judge:
 * 
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * 
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. 
 * If you correctly return the intersected node, then your solution will be accepted.
 * 
 * Example 1:
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. 
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * 
 * Example 2:
 *
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. 
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * 
 * Solution:
 * Two pointers: Compare ListA + ListB and ListB + ListA, find the intersection node
 * Hint: null = null
 * 
 **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /** Solution 1 **/
        // Go through one way and store all the passed nodes in a hashset
        // Start from the other one, go through all the nodes and check
        // which one is in the hashset of another list
        /**
        HashSet<ListNode> setA = new HashSet<>();
        
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        // Otherwise, doesn't find this intersection
        return null;
        **/
        
        /** Solution 2 **/
        // Two Pointers: go through these two and find their length difference
        // Set one pointer to the difference of the longer list
        // And another pointer to the head of the shorter list
        // Start iterating and comparing to find the intersection
        // Just compare lista+listb and listb+lista
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        // If null == null, they will also break out from the loop
        return pA;
    }
}


