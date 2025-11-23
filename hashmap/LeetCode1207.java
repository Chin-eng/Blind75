package hashmap;

import java.util.HashMap;
import java.util.HashSet;

// 1207. Unique Number of Occurrences
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

// Example 1:

// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
// Example 2:

// Input: arr = [1,2]
// Output: false
// Example 3:

// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
 

// Constraints:

// 1 <= arr.length <= 1000
// -1000 <= arr[i] <= 1000


public class LeetCode1207 {
        public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurences = new HashMap<>();
        HashSet<Integer> values = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (occurences.containsKey(arr[i])) {
                count = occurences.get(arr[i]);
            }
            occurences.put(arr[i], count+1);
        }

        for (int value : occurences.values()) {
            if (values.contains(value)) {
                return false;
            }
            values.add(value);
        }

        return true;
    }
}

// worst case : O(n)
// best case : O(n)
// space complexity: O(n)