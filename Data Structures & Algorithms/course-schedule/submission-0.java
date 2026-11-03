class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        } 

        for (int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        } 

        int[] state = new int[n];
        for (int i = 0; i < n; i++)
            if (dfs_cycle(i, graph, state)) return false;

        return true;
    }

    private boolean dfs_cycle(int node, List<Integer>[] graph, int[] state) {
        if (state[node] != 0)
        return state[node] == 1;

        state[node] = 1;
        for (int next : graph[node])
            if (dfs_cycle(next, graph, state)) return true;

        state[node] = 2;
        return false;
    }
}
