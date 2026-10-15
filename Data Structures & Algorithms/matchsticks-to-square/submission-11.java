class Solution {
    int[] matchsticks;
    int[] sides = new int[4];

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;

        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }

        if (matchsticks.length < 4 || sum % 4 != 0) {
            return false;
        }

        int length = sum / 4;

        Arrays.sort(matchsticks);

        int n = matchsticks.length;
        if (matchsticks[n - 1] > length) {
            return false;
        }

        return backtrack(n - 1, length);
    }

    boolean backtrack(int i, int target) {
        if (i < 0) {
            return true;
        }

        for (int side = 0; side < 4; side++) {
            if (sides[side] + matchsticks[i] <= target) {
                sides[side] += matchsticks[i];
                if (backtrack(i - 1, target)) {
                    return true;
                }
                sides[side] -= matchsticks[i];
            }
            if (sides[side] == 0) {
                break;
            }
        }

        return false;
    }
}