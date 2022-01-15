/**
 * 406. Queue Reconstruction by Height
 * 
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). 
 * Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front 
 * who have a height greater than or equal to hi.
 *
 * Reconstruct and return the queue that is represented by the input array people. 
 * The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the 
 * attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 * 
 * Example 1:
 * 
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * Explanation:
 * Person 0 has height 5 with no other people taller or the same height in front.
 * Person 1 has height 7 with no other people taller or the same height in front.
 * Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
 * Person 3 has height 6 with one person taller or the same height in front, which is person 1.
 * Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
 * Person 5 has height 7 with one person taller or the same height in front, which is person 1.
 * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
 * 
 * Example 2:
 *
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * 
 * Solution: Sort the height, make highest to shortest. Then insert the p to p[1] position, to guarantee that only p[1] people
 * in front. Greedy method.
 * 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // --------Sort-height-first-then-number-------------
        // --------like-7,0-7,1-6,1-5,0-5,2-4.4--------------
        // ------directly-insert-node-to-p[1]-position-------
        Arrays.sort(people, (int[] a, int[] b) -> {
           if (a[0] == b[0]) {
               return a[1] - b[1];
           } else {
               return b[0] - a[0];
           }
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p: people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);
        // -----------Self-Brute-----------------------
        // Node head = new Node();
        // Node curr = head.next;
        // Arrays.sort(people, (int[] a, int[] b) -> {
        //     if (a[1] == b[1]) {
        //         return b[0] - a[0];
        //     } else {
        //         return a[1] - b[1];
        //     }
        // });
        // for (int[] p: people) {
        //     int h = p[0];
        //     int count = p[1];
        //     Node prev = head;
        //     while (curr!= null && count > 0) {
        //         if (curr.val[0] < h) {
        //             prev = curr;
        //             curr = curr.next;
        //         } else {
        //             count--;
        //             prev = curr;
        //             curr = curr.next;
        //         }
        //     }
        //     if (curr != null) {
        //         while (curr.val[0] < h) {
        //             prev = curr;
        //             curr = curr.next;
        //         }
        //     }
        //     prev.next = new Node(p, curr);
        //     curr = head.next;
        // }
        // int[][] result = new int[people.length][2];
        // int index = 0;
        // while (curr != null) {
        //     result[index] = curr.val;
        //     curr = curr.next;
        //     index++;
        // }
        // return result;
    }
}

class Node {
    int[] val;
    Node next;
    public Node() {}
    public Node(int[] val) {
        this.val = val;
    }
    public Node(int[] val, Node next) {
        this.val = val;
        this.next = next;
    }
}



