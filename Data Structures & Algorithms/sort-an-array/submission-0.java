
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int[] temporaryArray = new int[nums.length];
        mergeSort(nums, temporaryArray, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int[] temporaryArray,
                           int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        // Sort the left half.
        mergeSort(nums, temporaryArray, left, middle);

        // Sort the right half.
        mergeSort(nums, temporaryArray, middle + 1, right);

        // Merge both sorted halves.
        merge(nums, temporaryArray, left, middle, right);
    }

    private void merge(int[] nums, int[] temporaryArray,
                       int left, int middle, int right) {
        int leftIndex = left;
        int rightIndex = middle + 1;
        int mergedIndex = left;

        // Compare elements from both halves.
        while (leftIndex <= middle && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temporaryArray[mergedIndex++] = nums[leftIndex++];
            } else {
                temporaryArray[mergedIndex++] = nums[rightIndex++];
            }
        }

        // Copy any remaining elements from the left half.
        while (leftIndex <= middle) {
            temporaryArray[mergedIndex++] = nums[leftIndex++];
        }

        // Copy any remaining elements from the right half.
        while (rightIndex <= right) {
            temporaryArray[mergedIndex++] = nums[rightIndex++];
        }

        // Copy the merged section back into the original array.
        for (int index = left; index <= right; index++) {
            nums[index] = temporaryArray[index];
        }
    }
}
