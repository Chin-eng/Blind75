package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 2215. Find the Difference of Two Arrays
// Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
// answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
// answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
// Note that the integers in the lists may be returned in any order.

// Example 1:
// Input: nums1 = [1,2,3], nums2 = [2,4,6]
// Output: [[1,3],[4,6]]
// Explanation:
// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].

// Example 2:
// Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
// Output: [[3],[]]
// Explanation:
// For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
// Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 

// Constraints:
// 1 <= nums1.length, nums2.length <= 1000
// -1000 <= nums1[i], nums2[i] <= 1000


public class LeetCode2215 {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<Integer> nums1_set = new HashSet<>();
        HashSet<Integer> nums2_set = new HashSet<>();
        List<Integer> nums1_temp = new ArrayList<>();
        List<Integer> nums2_temp = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1_set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            nums2_set.add(nums2[i]);
        }

        int i = 0;
        while (i < nums1.length) {
            if (!nums2_set.contains(nums1[i]) && !nums1_temp.contains(nums1[i]) ) {
                nums1_temp.add(nums1[i]);
            }
            i++;
        }

        answer.add(nums1_temp);

        int j = 0;
        while (j < nums2.length) {
            if (!nums1_set.contains(nums2[j]) && !nums2_temp.contains(nums2[j])) {
                nums2_temp.add(nums2[j]);
            }
            j++;
        }

        answer.add(nums2_temp);
        
        return answer;
    }
}

// time compelxity: O(N)
// space complexity: O(N)
