class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        myDict = Counter(nums)
        return any(v > 1 for v in myDict.values())