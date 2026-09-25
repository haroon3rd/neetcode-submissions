class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            int tempMin = min;
            int tempMax = max;

            min = Math.min(n, Math.min(n * tempMin, n * tempMax));
            max = Math.max(n, Math.max(n * tempMin, n * tempMax));

            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}