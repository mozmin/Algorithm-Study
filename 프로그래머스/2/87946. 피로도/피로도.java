class Solution {
    
    static int max;
    public int solution(int k, int[][] dungeons) {
        
        max = 0;
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, visited, dungeons);
        
        return max;
    }
    
    public static void dfs(int k, int count, boolean[] visited, int[][] dungeons){
        
        max = Math.max(max, count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            
            if(k >= dungeons[i][0] && k >= dungeons[i][1]){
                visited[i] = true;
                dfs(k - dungeons[i][1], count+1, visited, dungeons);
                visited[i] = false;
            }
        }
    }
}