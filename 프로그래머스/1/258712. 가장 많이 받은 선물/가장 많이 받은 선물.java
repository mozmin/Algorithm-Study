import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        
        // 변수 초기화
        int n = friends.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(friends[i], i);
        }
        
        // 누가 -> 누구에게 선물을 줬는지 기록
        int[][] list = new int[n][n];
        
        // 선물 지수
        int[] present = new int[n];
        
        // 다음 달 선물을 몇번 받아야 하는지 기록
        int[] count = new int[n];
        
        int max = Integer.MIN_VALUE;
        
    
        for(String g : gifts){
            
            String[] split = g.split(" ");
            
            int from = map.get(split[0]);
            int to = map.get(split[1]);
            
            // 선물을 준 사람을 카운팅
            list[from][to]++;
            
            // 선물 지수 계산
            present[from]++;
            present[to]--;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                
                // 선물을 더 많이 준 사람이 선물을 받아야 함
                if(list[i][j] > list[j][i]){
                    count[i]++;
                }
                else if(list[i][j] < list[j][i]){
                    count[j]++;
                }
                
                // 둘이 주고 받은 횟수가 같다면
                else{
                    // 선물 지수 비교
                    if(present[i] > present[j]){
                        count[i]++;
                    }else if(present[i] < present[j]){
                        count[j]++;
                    } 
                }
            }
        }
        
        for(int c : count){
            max = Math.max(max, c);
        }
        
        
        return max;
    }

}