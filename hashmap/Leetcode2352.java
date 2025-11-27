package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// 2352. Equal Row and Column Pairs
// Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

// A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

// Example 1:


// Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
// Output: 1
// Explanation: There is 1 equal row and column pair:
// - (Row 2, Column 1): [2,7,7]
// Example 2:


// Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
// Output: 3
// Explanation: There are 3 equal row and column pairs:
// - (Row 0, Column 0): [3,1,2,2]
// - (Row 2, Column 2): [2,4,2,2]
// - (Row 3, Column 2): [2,4,2,2]

public class Leetcode2352 {
    public int equalPairs(int[][] grid) {
    Map<Integer, List<Integer>> rows = new HashMap<>();
    Map<Integer, List<Integer>> columns = new HashMap<>();

    for (int i = 0; i < grid.length; i++) {
        List<Integer> list = Arrays.stream(grid[i]).boxed().collect(Collectors.toList());
        rows.put(i, list);
    }

    for (int i = 0; i < grid.length; i++) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < grid.length; j++) {
            Integer number = grid[j][i];
            list.add(number);
        }
        columns.put(i, list);
    }

    int ans = 0;
    for(Map.Entry<Integer, List<Integer>> entry_row : rows.entrySet()) {
        List<Integer> array_row = entry_row.getValue();
        for (Map.Entry<Integer, List<Integer>> entry_column : columns.entrySet()) {
            List<Integer> array_column = entry_column.getValue();
            if (array_row.equals(array_column)) {
                ans++;
            }
        }
    }

    return ans;
}
}

// time complexity O(N^2)
// space compelxity o(N)
