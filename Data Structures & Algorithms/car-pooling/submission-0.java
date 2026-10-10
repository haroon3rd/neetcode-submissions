
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengers = new int[1001];

        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            passengers[from] += num;
            passengers[to] -= num;
        }

        int currentPassengers = 0;

        for (int change : passengers) {
            currentPassengers += change;

            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}
