import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> db = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        
        for(String s : record){
            
            String[] input = s.split(" ");
            String type = input[0];
            String userId = input[1];
            
            // "Enter" 또는 "Change"일 때만 이름 업데이트.
            if(type.equals("Enter") || type.equals("Change")){
                String name = input[2];
                db.put(userId, name);
            }
            
            if(type.equals("Enter") || type.equals("Leave")){
                String[] str = new String[2];
                str[0] = type;
                str[1] = userId;
                list.add(str);
            }
            
            
        }
        
        // 출력
        ArrayList<String> output = new ArrayList<>();
        for(String[] s : list){
        
            String type = s[0];
            String userId = s[1];
            
            if(type.equals("Enter")){
                String name = db.get(userId);
                output.add(name + "님이 들어왔습니다.");
            }else{
                String name = db.get(userId);
                output.add(name + "님이 나갔습니다.");
            }
        }
        
        return output.toArray(String[]::new);
    }
}