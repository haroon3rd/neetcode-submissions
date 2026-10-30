class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        //store String Order into a HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int j = 0;

            // Compare characters until they differ
            while (j < w1.length() && j < w2.length()) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    if (map.get(c1) > map.get(c2)) {
                        return false;
                    }

                    break;
                }

                j++;
            }

            // Handle prefix case
            if (j == Math.min(w1.length(), w2.length())
                && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }
        
}