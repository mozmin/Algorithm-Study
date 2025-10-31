import java.util.*;

class Solution {
    // 0은 벽, 1은 길
    
    static int[] moveY = {1, -1, 0, 0};
    static int[] moveX = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        Deque<int[]> que = new ArrayDeque<>();
        
        int m = maps.length;
        int n = maps[0].length;
        
        // 시작지점 que에 삽입
        que.offer(new int[]{0, 0, 1});
        while(!que.isEmpty()){
            
            int[] poll = que.poll();
            int y = poll[0];
            int x = poll[1];
            int count = poll[2];
            
            // 종료조건
            if(y == m-1 && x == n-1) return count;
            
            for(int i = 0; i < 4; i++){
                int newY = y + moveY[i];
                int newX = x + moveX[i];
                
                if(newY >= 0 && newY < m && newX >= 0 && newX < n && maps[newY][newX] != 0){
                    que.offer(new int[]{newY, newX, count+1});
                    maps[newY][newX] = 0;
                }
            }
        }
        
        return -1;
    }

}