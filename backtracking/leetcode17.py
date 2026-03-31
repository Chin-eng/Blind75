class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        hashmap = {
            2: ["a", "b", "c"],
            3: ["d", "e", "f"],
            4: ["g", "h", "i"],
            5: ["j", "k", "l"],
            6: ["m", "n", "o"],
            7: ["p", "q", "r", "s"],
            8: ["t", "u", "v"],
            9: ["w", "x", "y", "z"]
        }

        nums = [int(c) for c in digits]

        if len(digits) == 1:
            return hashmap[int(digits[0])]
        
        def backtrack(curr, index):

            if len(curr) == len(nums):
                ans.append("".join(curr[:]))
                return

            for num in range(index, len(nums)):
                for c in hashmap[nums[num]]:
                    curr.append(c)
                    backtrack(curr, num+1)
                    curr.pop()

        ans = []
        backtrack([], 0)
        return ans

        