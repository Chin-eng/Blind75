import java.util.Stack;

// import javax.swing.text.html.HTMLDocument.Iterator;

// 394. Decode String
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

// The test cases are generated so that the length of the output will never exceed 105.

 

// Example 1:

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:

// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:

// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
 

// Constraints:

// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].

public class Leetcode394 {
        public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        String ans = "";
                
        for (int i = 0; i < charArray.length; i++) {
            
            // System.out.println(charArray[i] == "]".charAt(0));

            if (charArray[i] == "]".charAt(0)) {
                String temp = "";
                while (stack.peek() != "[".charAt(0)) {
                    char c = stack.pop();
                    temp = temp + Character.toString(c);
                }
                // System.out.println(temp);
                stack.pop();  
                // char n = numberFromStack(stack);
                int count = numberFromStack(stack);
                String s_reversed = reverse(temp);
                
                // System.out.println(ans);
                
                // ans = ans + s_reversed.repeat(count);
                pushToStack(stack, s_reversed.repeat(count));
                // ans = fromStack(stack);
            } else {
                stack.push(charArray[i]);
            }            
        }

        System.out.println(stack);

        ans = fromStack(stack);

        return ans;
    }

    public String reverse(String s) {
        String string = "";        
        for (int i = s.length() - 1; i >= 0; i--) {
            string = string + Character.toString(s.charAt(i));
        }
        return string;
    }

    public void pushToStack(Stack stack, String s) {
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
    }

    public String fromStack(Stack stack) {
        String ans = "";
        Iterator itr = stack.iterator();
        while (itr.hasNext()) {
            ans = ans + itr.next();
        }
        return ans;
    }

    public int numberFromStack(Stack stack) {
        String number = "";
        System.out.println(stack);
        while (!stack.isEmpty() && Character.isDigit(String.valueOf(stack.peek()).charAt(0))) {
            Object object = stack.pop();
            char n = object.toString().charAt(0);
            number = number + String.valueOf(n);
        }
        
        String reversed_number = reverse(number);
        return Integer.parseInt(reversed_number);
    }
}

// time complexity worst case n(N^2)
// space complexity O(N)