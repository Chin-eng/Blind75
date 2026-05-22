class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def backtrack(index, curr, currSum):
            if sum(curr) == target:
                ans.append(curr[:])
                return
            
            for j in range(index, len(candidates)):
                num = candidates[j]
                if currSum + num <= target:
                    curr.append(num)
                    backtrack(j, curr, currSum + num)
                    curr.pop()
 
        ans = []
        backtrack(0, [], 0)
        return ans