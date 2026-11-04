
class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int bill : bills) {

            if (bill == 5) { // No change needed
                five++;
            }
            else if (bill == 10) { // Need to return $5
                if (five == 0) return false;
                five--;
                ten++;
            }
            else { // bill == 20, Prefer $10 + $5 as change
                //twenty++;   //not needed
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
