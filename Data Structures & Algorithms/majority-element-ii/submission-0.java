class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidateOne = 0;
        int candidateTwo = 0;

        int countOne = 0;
        int countTwo = 0;

        // Phase 1: Find two potential majority candidates.
        for (int num : nums) {
            if (countOne > 0 && num == candidateOne) {
                countOne++;
            } else if (countTwo > 0 && num == candidateTwo) {
                countTwo++;
            } else if (countOne == 0) {
                candidateOne = num;
                countOne = 1;
            } else if (countTwo == 0) {
                candidateTwo = num;
                countTwo = 1;
            } else {
                countOne--;
                countTwo--;
            }
        }

        // Phase 2: Verify the candidates.
        countOne = 0;
        countTwo = 0;

        for (int num : nums) {
            if (num == candidateOne) {
                countOne++;
            } else if (num == candidateTwo) {
                countTwo++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        if (countOne > threshold) {
            result.add(candidateOne);
        }

        if (countTwo > threshold) {
            result.add(candidateTwo);
        }

        return result;
    }
}
