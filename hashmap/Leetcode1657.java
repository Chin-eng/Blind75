package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 1657. Determine if Two Strings Are Close
// Two strings are considered close if you can attain one from the other using the following operations:

// Operation 1: Swap any two existing characters.
// For example, abcde -> aecdb
// Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
// For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
// You can use the operations on either string as many times as necessary.

// Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

// Example 1:

// Input: word1 = "abc", word2 = "bca"
// Output: true
// Explanation: You can attain word2 from word1 in 2 operations.
// Apply Operation 1: "abc" -> "acb"
// Apply Operation 1: "acb" -> "bca"
// Example 2:

// Input: word1 = "a", word2 = "aa"
// Output: false
// Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
// Example 3:

// Input: word1 = "cabbba", word2 = "abbccc"
// Output: true
// Explanation: You can attain word2 from word1 in 3 operations.
// Apply Operation 1: "cabbba" -> "caabbb"
// Apply Operation 2: "caabbb" -> "baaccc"
// Apply Operation 2: "baaccc" -> "abbccc"
 

// Constraints:

// 1 <= word1.length, word2.length <= 105
// word1 and word2 contain only lowercase English letters.

public class Leetcode1657 {
        public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> word1_map = new HashMap<>();
        HashMap<Character, Integer> word2_map = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            int count = 0;
            if (word1_map.containsKey(word1.charAt(i))) {
                count = word1_map.get(word1.charAt(i));
            }
            word1_map.put(word1.charAt(i), count + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            int count = 0;
            if (word2_map.containsKey(word2.charAt(i))) {
                count = word2_map.get(word2.charAt(i));
            }
            word2_map.put(word2.charAt(i), count + 1);
        }

        System.out.println(word1_map);
        System.out.println(word2_map);

        List<Integer> word1_values = new ArrayList<>(word1_map.values());
        List<Integer> word2_values = new ArrayList<>(word2_map.values());

        return sort(word1_values).equals(sort(word2_values)) && word1_map.keySet().equals(word2_map.keySet());
    }


    public List<Integer> sort(List<Integer> arrayList) {

        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i+1; j < arrayList.size(); j++) {
                if (arrayList.get(i) > arrayList.get(j)) {
                    Integer temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }

        return arrayList;
    }
}

// worst case: O(N)
// best case: O(N)
// space complexity: O(N)
