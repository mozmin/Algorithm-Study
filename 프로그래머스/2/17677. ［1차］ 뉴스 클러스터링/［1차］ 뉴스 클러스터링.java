import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
class Solution {
    
    public static ArrayList<String> parseString(String str){
        
        String st = str.toLowerCase();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < str.length()-1; i++){
            
            if(Pattern.matches("^[a-z]{2}$", st.substring(i, i+2))){
                list.add(st.substring(i, i+2));
            }
        }
        
        return list;
    }
    public int solution(String str1, String str2) {
        
        ArrayList<String> list1 = parseString(str1);
        ArrayList<String> list2 = parseString(str2);
        
        // 복사본
        ArrayList<String> copy = new ArrayList<>(list2);
        int count = 0;
        int list1Size = list1.size();
        int list2Size = list2.size();
        
        for(String s : copy){
            
            if(list1.contains(s)){
                list1.remove(s);
                count++;
            }
        }
        
        int plusCount = list1Size + list2Size - count;
        
        if (plusCount == 0) {
            return 65536; // A, B 모두 공집합인 경우
        }
        
        double jaccard = (double) count / plusCount;
        return (int) (jaccard * 65536);
    }
}