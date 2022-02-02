/**
 * Change in a Foreign Currency
 * 
 * You likely know that different currencies have coins and bills of different denominations. 
 * In some currencies, it's actually impossible to receive change for a given amount of money. 
 * For example, Canada has given up the 1-cent penny. If you're owed 94 cents in Canada, 
 * a shopkeeper will graciously supply you with 95 cents instead since there exists a 5-cent coin.
 * 
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of money targetMoney. Both the denominations and target amount will be given in generic units of that currency.
 * 
 * Signature
 * 
 * boolean canGetExactChange(int targetMoney, int[] denominations)
 * 
 * Input
 * 1 ≤ |denominations| ≤ 100
 * 1 ≤ denominations[i] ≤ 10,000
 * 1 ≤ targetMoney ≤ 1,000,000
 * 
 * Output
 * Return true if it's possible to receive exactly targetMoney given the available denominations, and false if not.
 * 
 * Example 1
 * 
 * denominations = [5, 10, 25, 100, 200]
 * targetMoney = 94
 * output = false
 * 
 * Every denomination is a multiple of 5, so you can't receive exactly 94 units of money in this currency.
 * 
 * Example 2
 * 
 * de nominations = [4, 17, 29]
 * targetMoney = 75
 * output = true
 * 
 * You can make 75 units with the denominations [17, 29, 29].
 * 
 * Solution: Dynamic Programming as a knapsack problem, Or use recurssion
 * 
 */
import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  boolean canGetExactChange(int targetMoney, int[] denominations) {
    // Write your code here
    // This is a knapsack question
    // THe capacity of the package is the target money
    // The items are the denominations which can be used multiple times
    // ------------------------Solution-Dynamic-Programming--------------------
    boolean[][] dp = new boolean[denominations.length + 1][targetMoney + 1];
    for (int i = 0; i <= denominations.length; i++) dp[i][0] = true;
    
    for (int i = 1; i <= denominations.length; i++) {
      for (int j = 1; j<= targetMoney; j++) {
        if (j >= denominations[i - 1]) dp[i][j] = dp[i][j - denominations[i - 1]] || 
                                              dp[i - 1][j] || dp[i - 1][j - denominations[i - 1]];
        else dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[denominations.length][targetMoney];

    // -----------------------Recurssion----------------------------------------
    return recursive(targetMoney, denominations);
  }
  
  boolean recursive(int target, int[] arr) {
    boolean result = false;
    for (int i = 0; i < arr.length; i++) {
      if (target > arr[i]) {
        result = result || recursive(target - arr[i], arr);
      } else if (target == arr[i]) {
        return true;
      } else {
        continue;
      }
    }
    return result;
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected); 
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
  
  public void run() {
    int target_1 = 94;
    int arr_1[] = {5, 10, 25, 100, 200};
    boolean expected_1 = false;
    boolean output_1 = canGetExactChange(target_1, arr_1); 
    check(expected_1, output_1); 

    int target_2 = 75;
    int arr_2[] = {4, 17, 29};
    boolean expected_2 = true;
    boolean output_2 = canGetExactChange(target_2, arr_2); 
    check(expected_2, output_2); 
    
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
