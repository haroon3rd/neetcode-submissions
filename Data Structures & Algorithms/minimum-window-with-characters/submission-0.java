
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Count characters required by t
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int charCount = target.size();
        int validChar = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Check if c is in t and expand the window
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).intValue() == target.get(c).intValue()) {
                    validChar++;
                }
            }


            // Shrink while the window is valid
            while (validChar == charCount) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (target.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);

                    if (window.get(leftChar) < target.get(leftChar)) {
                        validChar--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
            ? ""
            : s.substring(start, start + minLen);
    }
}

