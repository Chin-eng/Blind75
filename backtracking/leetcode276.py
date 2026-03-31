class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def backtrack(curr, index):
            if len(curr) == k:
                if sum(curr) == n:
                    ans.append(curr[:])
                return

            for num in range(index, 10):
                if num not in curr:
                    curr.append(num)
                    backtrack(curr, num+1)
                    curr.pop()
        
        ans = []
        backtrack([], 1)
        return ans
        