/*
 * 332. Reconstruct Itinerary
 *
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] 
 * represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". 
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest 
 * lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once. 
 *
 * 
 * Example 1:
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 *
 * Example 2:
 *
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 *
 * Solution: Use Backtrack and keep a hashmap
 *
 */
class Solution {
    private List<String> result = new ArrayList<>();
    private HashMap<String, TreeMap<String, Integer>> edges = new HashMap<>();
    private int target = 0;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        target = tickets.size() + 1;
        for (List<String> pair: tickets) {
            String depart = pair.get(0);
            String destination = pair.get(1);
            if (edges.containsKey(depart)) {
                if (edges.get(depart).containsKey(destination)) {
                    int count = edges.get(depart).get(destination);
                    edges.get(depart).put(destination, count + 1);
                } else {
                    edges.get(depart).put(destination, 1);
                }
            } else {
                TreeMap<String, Integer> temp = new TreeMap<>();
                temp.put(destination, 1);
                edges.put(depart, temp);
            }
        }   
            
        backTrack("JFK");
        return result;
    }
    
    private boolean backTrack(String city) {
        result.add(city);
        if (result.size() == target) {
            return true;
        }
        if (!edges.containsKey(city)) {
            result.remove(result.size() - 1);
            return false;
        }
        for (String des: edges.get(city).keySet()) {
            if (edges.get(city).get(des) > 0) {
                int count = edges.get(city).get(des);
                edges.get(city).put(des, count - 1);
                if (backTrack(des)) {
                    return true;
                }
                edges.get(city).put(des, count);
            } else {
                continue;
            }
        }
        result.remove(result.size() - 1);
        return false;
    }
}




