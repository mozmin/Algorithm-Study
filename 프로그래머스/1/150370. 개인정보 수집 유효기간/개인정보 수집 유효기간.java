import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> list = new ArrayList<>();
        String[] splitToday = today.split("\\.");
        int totalToday = Integer.parseInt(splitToday[0]) * 28 * 12
            + Integer.parseInt(splitToday[1]) * 28 
            + Integer.parseInt(splitToday[2]); 
            
        Map<String, Integer> map = new HashMap<>();
        for(String t : terms){
            String[] split = t.split(" ");
            int i = Integer.parseInt(split[1]) * 28;
            map.put(split[0], i);
        }
        
        int count = 1;
        for(String p : privacies){
            String[] arr = p.split(" ");
            String[] date = arr[0].split("\\.");
            
            int total = Integer.parseInt(date[0]) * 28 * 12
                + Integer.parseInt(date[1]) * 28 
                + Integer.parseInt(date[2])
                + map.get(arr[1]);
            
            if(totalToday >= total) list.add(count);
            
            count++;
        }
 
        return list.stream().mapToInt(i -> i).toArray();
    }
}