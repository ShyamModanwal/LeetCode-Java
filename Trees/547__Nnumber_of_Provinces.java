class Solution {

    private void dfs(int[][] isConnected , boolean[] visit , int curr , int n)
    {
        for (int i = 0; i < n; i++)
        {
            if (isConnected[curr][i] == 1 && !visit[i])
            {
                visit[i] = true;
                dfs(isConnected , visit , i , n);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            if (!visit[i])
            {
                count++;
                dfs(isConnected , visit , i , n);
            }
        }
        return count;
        
    }
}