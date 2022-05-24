/**
 * 1146. Snapshot Array
 * 
 * Implement a SnapshotArray that supports the following interface:
 *
 * - SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
 * - void set(index, val) sets the element at the given index to be equal to val.
 * - int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * - int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 * 
 * Example 1:
 *
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation: 
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 * 
 * Solution: Use a treemap array, each element of which is recording the changes to an index
 * Maintain a current snap id variable which is used to update the value before a snap
 * To get value of a snap id, use floorentry to get the nearest snap shot of which there are value changes
 * 
 * The TreeMap.floorEntry() method is used to obtain the key-value pair associated with the greatest key 
 * less than or equal to the given key in the parameter present in the map currently. 
 * If no such key is present in the TreeMap, it returns null.
 * 
 **/
class SnapshotArray {
    // Use treemap array to record the change
    // Take advantage of the feature of floorentry
    // When there is a call to snap, only update the snap_id
    // Based on the floorentry, we can get the latest value which is nearest to the snapid
    TreeMap<Integer, Integer>[] treeMaps;
    int snapId = 0;
    
    public SnapshotArray(int length) {
        treeMaps = new TreeMap[length]; // For each element there is a treemap
        for (int i = 0; i < length; i++) {
            treeMaps[i] = new TreeMap<Integer, Integer>();
            treeMaps[i].put(0, 0); // For each value, snap 0 is 0
        }
    }
    
    public void set(int index, int val) {
        treeMaps[index].put(snapId, val); // Update the value of index of current snap id
    }
    
    public int snap() {
        return snapId++; // Return the current id and add id by 1
        // Later update will be based on the new snap id
    }
    
    public int get(int index, int snap_id) {
        return treeMaps[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
 * 
