
class Solution {

    public boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        int n = words.length;

        // Track whether each adjacent pair is already ordered
        boolean[] sorted = new boolean[n - 1];

        // Find maximum word length
        int maxLength = 0;

        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        // Compare column by column
        for (int j = 0; j < maxLength; j++) {

            for (int i = 0; i < n - 1; i++) {

                // Already correctly ordered
                if (sorted[i]) {
                    continue;
                }

                String w1 = words[i];
                String w2 = words[i + 1];

                // First word ended: correct prefix order
                if (j >= w1.length()) {
                    sorted[i] = true;
                    continue;
                }

                // Second word ended first: invalid
                if (j >= w2.length()) {
                    return false;
                }

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (map.get(c1) > map.get(c2)) {
                    return false;
                }

                if (map.get(c1) < map.get(c2)) {
                    sorted[i] = true;
                }

                // If equal, compare next column
            }
        }

        return true;
    }
}
