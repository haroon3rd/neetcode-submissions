class Solution {
    
    /*
    We will use a stack to keep track of local maxima. each entry in stack represent a local maxima.
    the bottom most element should be the global maxima.
    travers through the indexes, and push them to stack. Before pushing an index to stack, pop indexes whose temperatures are less than current index temp. calculate distance accordingly.
    after exhausting the array, pop remaining indexes from stack and assign 0 to result array for those indexes.  
    */
    public int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< temperatures.length; i++){
            while( (!stack.isEmpty()) 
                && temperatures[stack.peek()] <  temperatures[i]){
                    int j = stack.pop();
                    result[j] = i-j; // distance from j to current index
            }
            stack.push(i);
        }
        // while(!stack.isEmpty()){
        //     int j = stack.pop();
        //     result[j]=0;
        // }
        return result;
    }
}
