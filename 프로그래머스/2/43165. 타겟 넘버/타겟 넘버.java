import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{numbers[0], 0});
        que.add(new int[]{-numbers[0], 0});
        
        while(!que.isEmpty()){
            int[] poll = que.poll();    
            int curSum = poll[0];
            int curIndex = poll[1];
            
            if(curSum == target && curIndex == numbers.length-1){
                answer++;
            }
            
            if(curIndex < numbers.length-1){
                que.offer(new int[]{curSum + (numbers[curIndex+1]), curIndex+1});
                que.offer(new int[]{curSum + (-numbers[curIndex+1]), curIndex+1});
            }
        }
        
        return answer;
    }
}