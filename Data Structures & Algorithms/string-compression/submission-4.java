class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        int finOut = 0;
        int visited = 0;

        while (visited < len) {
            char cur = chars[visited];
            int count = 0;

            // Consecutive count
            while (visited < len && chars[visited] == cur) {
                visited++;
                count++;
            }
            chars[finOut++] = cur;
            
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
