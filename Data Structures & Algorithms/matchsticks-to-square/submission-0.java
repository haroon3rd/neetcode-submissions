class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        return solve(matchsticks, 0, new int[4], sum / 4);
    }

    private boolean solve(int[] sticks, int index, int[] sides, int target) {
        if (index == sticks.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + sticks[index] <= target) {
                sides[i] += sticks[index];

                if (solve(sticks, index + 1, sides, target)) {
                    return true;
                }

                sides[i] -= sticks[index];
            }
        }

        return false;
    }
}