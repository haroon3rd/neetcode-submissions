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

        int[] edge = new int[4];

        return backtrack(matchsticks, n - 1, edge, target);
    }

    private boolean backtrack(
            int[] sticks, int index, int[] edge, int target) {

        if (index < 0) {
            return edge[0] == target
                && edge[1] == target
                && edge[2] == target
                && edge[3] == target;
        }

        int stick = sticks[index];

        for (int i = 0; i < 4; i++) {
            if (edge[i] + stick > target) {
                continue;
            }

            edge[i] += stick;

            if (backtrack(sticks, index - 1, edge, target)) {
                return true;
            }

            edge[i] -= stick;

            if (edge[i] == 0) {
                break;
            }
        }

        return false;
    }
}