import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        //que.add(prices[0]); // 초기값
        for(int i = 0; i < n; i++){
            
            while(!que.isEmpty() && prices[i] < prices[que.peek()]){
                
                int idx = que.pop();
                answer[idx] = i - idx;
                
            }
            
            que.push(i);
        }
        
        while(!que.isEmpty()){
                
            int idx = que.pop();
            answer[idx] = n - 1 - idx;
                
        }
        return answer;
    }
}