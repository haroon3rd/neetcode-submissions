
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengers = new int[1000];

        for (int[] mytr : trips) {
            passengers[mytr[1]] += mytr[0]; //pickup
            passengers[mytr[2]] -= mytr[0]; //drop-off
        }

        int passCount = 0;
        for (int pass : passengers) {
            passCount += pass;  // Add pickups (positive) or subtract drop-offs (negative)
            if (passCount > capacity) return false;
        }

        return true;
    }
}
