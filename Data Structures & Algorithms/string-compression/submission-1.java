
class Solution {

    public int compress(char[] chars) {

        int len = chars.length;
        int write = 0;
        int read = 0;

        while (read < len) {

            char current = chars[read];
            int count = 0;

            // Count consecutive occurrences
            while (read < len && chars[read] == current) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write count only if greater than 1
            if (count > 1) {

                String num = Integer.toString(count);

                for (int i = 0; i < num.length(); i++) {
                    chars[write++] = num.charAt(i);
                }
            }
        }

        return write;
    }
}
