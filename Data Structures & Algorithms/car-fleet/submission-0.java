// public class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n = position.length;
//         int[][] pair = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             pair[i][0] = position[i];
//             pair[i][1] = speed[i];
//         }
//         Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

//         int fleets = 1;
//         double prevTime = (double)(target - pair[0][0]) / pair[0][1];
//         for (int i = 1; i < n; i++) {
//             double currTime = (double)(target - pair[i][0]) / pair[i][1];
//             if (currTime > prevTime) {
//                 fleets++;
//                 prevTime = currTime;
//             }
//         }
//         return fleets;
//     }
// }

class Solution {
    /* Sort the position array. change the speed array accordingly.
        Now, for each i, check when the car is reaching. if it reaching faster than previous one, it will join the fleet. If this car is reaching after the last fleet, it will form a new fleet. 
    */
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i=0; i<position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, 
            (a,b)->Integer.compare(b[0],a[0])
            );

        //int [] time = new int[position.length];
        float curMax = -1;
        int group=0;
        for(int i=0; i<position.length; i++){
            int pos = pair[i][0]; 
            int spd = pair[i][1];
            float time = ((float)target-pos)/spd;
            if(time>curMax){
                group++;
                curMax=time;
            } 
        }
        return group;

    }


}