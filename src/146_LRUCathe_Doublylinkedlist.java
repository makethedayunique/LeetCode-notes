/**
 * 146. LRU Cache
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * 
 * Solution:
 * Since there is requirement that both get and put method should run O(1) time complexity
 * We need to determine the nodes in the list, and use a doublylinkedlist ot store those nodes so that put, get, and delete
 * can be done in O(1) time
 * 
 */
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    private int capacity;
    private int count;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        head.prev = null;
        tail.next = null;
    }
    
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(Node node) {
        // Move this node to the front
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public int get(int key) {        
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        removeNode(node);
        moveToHead(node);
        // Return the value
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            moveToHead(node);
        } else {
            if (count == capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                Node node = new Node();
                node.key = key;
                node.value = value;
                moveToHead(node);
                cache.put(key, node);
            } else {
                Node node = new Node();
                node.key = key;
                node.value = value;
                moveToHead(node);
                cache.put(key, node);
                count++;
            }
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

