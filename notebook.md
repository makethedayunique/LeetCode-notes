##### Queue

offer() - add to the last
poll() - remove the first
peek() - get the first

##### Stack

push() - add the the first
pop() - remove the first
peek() - get the first

**150 - Evaluate Reverse Polish Notation**
This is how computer compute, using postfix notation

##### **Full binary tree**

A binary tree is a full binary tree if every node has 0 or 2 children

```
             18
           /    \   
         15     20    
        /  \       
      40    50   
    /   \
   30   50
                  18
            /     \  
          40       30  
                   /  \
                 100   40
```

##### **Complete binary tree**

A binary tree is a complete binary tree if all the levels are completely filled except possibly the last level  and the last level has all keys as left as possible.

```
               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40


               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40
     /  \   /
    8   7  9
```

##### Binary tree Traversal

DFS
    Inorder Traversal
    Preorder Traversal
    Postorder Traversal

BFS
    level order traversal

Stacks can be used to achieve the DFS
Queues can be used to achieve the BFS

###### BackPack Problem

01 BackPack

N items and a backpack with capacity W, every item weight[i] and value[i]

Every item can only be used once, How can we make the largest value

Solution 1:

2-D dp array 01 backpack: dp[i][j] represents the maximum value by taking items from [0,i] range and putting in a backpack with capacity with j

dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])

dp[i][0] = 0

dp[0][j] = value[0] if j > weight[0] else 0

Outer loop: items  Inner loop: weight

```java
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int wLen = weight.length, value0 = 0;
        //Identify the dp array
        int[][] dp = new int[wLen + 1][bagSize + 1];
        //Initialize: when capacity is 0, always 0
        //Initialize: when capacity < 0-th weight, value = value[0]
        for (int i = 0; i <= wLen; i++){
            dp[i][0] = value0;
        }
        //Loop order
        for (int i = 1; i <= wLen; i++){
            for (int j = 1; j <= bagSize; j++){
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //print the dp array
        for (int i = 0; i <= wLen; i++){
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
```

Solution 2:

1-D dp array (rolling array)

Only use the one dimensional array

dp[j] = max(dp[j], dp[j-weight[i]] + value[i])

But looping order is from back to front

```java
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //Identify the dp array
        int[] dp = new int[bagWeight + 1];
        //First items, then capacity
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){ // Notice the order
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //print the dp array
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }
```

Complete BackPack

Every item can be used for infinite times

So we need to adjust the inner and outer loop and traversal order

from front to back

```java
// First items then backpack
for(int i = 0; i < weight.size(); i++) { // traverse item
    for(int j = weight[i]; j < bagWeight ; j++) { // traverse backpack
        dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
}
```