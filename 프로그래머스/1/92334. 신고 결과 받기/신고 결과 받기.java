import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 중복 신고 방지를 위한 Set
        Set<String> set = new HashSet<>();
        
        // 신고를 기록하기 위한 Map
        Map<String, Integer> map = new HashMap<>();
        
        // 신고당한 사람들 리스트
        ArrayList<String> banned = new ArrayList<>();
        
        // 신고 기록
        for(String s : report){
            if(set.add(s)){
                String[] split = s.split(" ");
                String to = split[1];
                map.put(to, map.getOrDefault(to, 0) + 1);
            }
        }
        
        for(String i : id_list){
            if (map.containsKey(i) && map.get(i) >= k){
                banned.add(i);
            }
        }
        
        for(String b : banned){
            
            for(int i = 0; i < id_list.length; i++){
                if(set.contains(id_list[i] + " " + b)){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}