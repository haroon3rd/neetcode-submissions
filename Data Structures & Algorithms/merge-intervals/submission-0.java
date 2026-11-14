class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // If result is empty, add first interval
            if (result.isEmpty()) {
                result.add(interval);
                continue;
            }

            // Get the last merged interval
            int[] last = result.get(result.size() - 1);

            // Check if intervals overlap
            if (interval[0] <= last[1]) {

                // Merge by extending the end
                last[1] = Math.max(last[1], interval[1]);

            } else {
                // No overlap, add new interval
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

