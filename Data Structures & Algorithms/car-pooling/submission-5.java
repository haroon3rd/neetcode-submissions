
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<Integer> passengers = new ArrayList<>(
            Collections.nCopies(1001, 0)
        );

        for (int[] mytr : trips) {
            passengers.set(mytr[1],
                passengers.get(mytr[1]) + mytr[0]); // pickup

            passengers.set(mytr[2],
                passengers.get(mytr[2]) - mytr[0]); // drop-off
        }

        int passCount = 0;

        for (int pass : passengers) {
            passCount += pass; // pickup, drop-off

            if (passCount > capacity) return false;
        }

        return true;
    }
}

