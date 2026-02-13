import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        // 성격 유형
        String[] list = new String[]{"R", "T", "C", "F", "J", "M", "A", "N"};
        
        // 각 유형별 점수 카운팅
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, 0);
        }
        
        // 최종 성격 유형
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < choices.length; i++){
            
            String[] split = survey[i].split("");
            String left = split[0];
            String right = split[1];
            
            // 선택한 번호 점수 계산
            int choice = choices[i];
            if(choice == 4) continue;
            if(choice > 4) map.put(right, map.get(right) + (choice-4));
            else if(choice < 4) map.put(left, map.get(left) + (4-choice));
        }
        
        for(int i = 0; i < 8; i+=2){
            
            String left = list[i];
            String right = list[i+1];
            
            if (map.get(left).equals(map.get(right))) result.add(left);
            else result.add(map.get(left) > map.get(right) ? left : right);
        }
        
        return String.join("", result);
    }
}