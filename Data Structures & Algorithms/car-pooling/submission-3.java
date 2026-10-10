
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengers = new int[1000];

        for (int[] t : trips) {
            passengers[t[1]] += t[0];
            passengers[t[2]] -= t[0];
        }

        int count = 0;
        for (int p : passengers) {
            count += p;
            if (count > capacity) return false;
        }

        return true;
    }
}
