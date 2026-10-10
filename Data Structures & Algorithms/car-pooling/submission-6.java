

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> passengers = new HashMap<>();

        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            passengers.put(from, passengers.getOrDefault(from, 0) + num);
            passengers.put(to, passengers.getOrDefault(to, 0) - num);
        }

        List<Integer> locations = new ArrayList<>(passengers.keySet());
        Collections.sort(locations);

        int count = 0;

        for (int location : locations) {
            count += passengers.get(location);

            if (count > capacity) return false;
        }

        return true;
    }
}


