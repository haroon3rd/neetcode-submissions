class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        if (matchsticks.length < 4 || sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);

        int n = matchsticks.length;

        if (matchsticks[n - 1] > target) {
            return false;
        }

        int[] sides = new int[4];

        return backtrack(matchsticks, n - 1, sides, target);
    }

    private boolean backtrack(
            int[] sticks, int index, int[] sides, int target) {

        if (index < 0) {
            return sides[0] == target
                && sides[1] == target
                && sides[2] == target
                && sides[3] == target;
        }

        int stick = sticks[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target) {
                continue;
            }

            sides[i] += stick;

            if (backtrack(sticks, index - 1, sides, target)) {
                return true;
            }

            sides[i] -= stick;

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}