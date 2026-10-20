
class Solution {

    public int compress(char[] chars) {

        int len = chars.length;
        int finOut = 0;
        int visited = 0;

        while (visited < len) {
            char current = chars[visited];
            int count = 0;

            // Consecutive count
            while (visited < len && chars[visited] == current) {
                visited++;
                count++;
            }
            chars[finOut++] = current;
            
            if (count > 1) {
                String num = Integer.toString(count);
                for (int i = 0; i < num.length(); i++) {
                    chars[finOut++] = num.charAt(i);
                }
            }
        }

        return finOut;
    }
}
