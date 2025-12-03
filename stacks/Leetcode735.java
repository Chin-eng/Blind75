package stacks;

import java.util.Stack;


// 735. Asteroid Collision
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

// Example 1:

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:

// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
// Example 3:

// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
// Example 4:

// Input: asteroids = [3,5,-6,2,-1,4]​​​​​​​
// Output: [-6,2,4]
// Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side, the asteroid 2 makes the asteroid -1 explode and then continues going right, without reaching asteroid 4.
 

// Constraints:

// 2 <= asteroids.length <= 104
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0

public class Leetcode735 {
        public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < asteroids.length) {
            boolean alive = true; 
            while (stack != null && asteroids[i] < 0) {
                if (stack.size() > 0) {
                    int latest = stack.peek();

                    if (latest < 0) {
                        break; 
                    }

                    if (latest > Math.abs(asteroids[i])) {
                        alive = false;
                        break;
                    } else if (latest == Math.abs(asteroids[i])) {
                        alive = false;
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    break;
                  }
                }

            if (alive == true) {
                stack.push(asteroids[i]);
            }     
            i++;    
        }

        int j = 0;
        int[] ans = new int[stack.size()];
        Iterator itr = stack.iterator();
        
        while (itr.hasNext()) {
            Object value = itr.next();
            ans[j] = (Integer) value;
            j++; 
        }

        return ans;
    }
    
}

// time complexity O(N^2)
// space complexity O(N)