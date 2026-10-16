
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Precompute palindromic substrings
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j - i <= 2) || dp[i + 1][j - 1];
                }
            }
        }

        // Each state stores a partial partition and its next index
        List<List<String>> result = new ArrayList<>();
        List<List<String>> paths = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();

        paths.add(new ArrayList<>());
        positions.add(0);

        while (!paths.isEmpty()) {
            int last = paths.size() - 1;
            List<String> current = paths.remove(last);
            int start = positions.remove(last);

            if (start == n) {
                result.add(current);
                continue;
            }

            for (int end = n - 1; end >= start; end--) {
                if (dp[start][end]) {
                    List<String> next = new ArrayList<>(current);
                    next.add(s.substring(start, end + 1));

                    paths.add(next);
                    positions.add(end + 1);
                }
            }
        }

        return result;
    }
}

