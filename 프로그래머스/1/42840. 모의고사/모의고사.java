import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int f = 0;
        int s = 0;
        int t = 0;
        
        int f_count = 0;
        int s_count = 0;
        int t_count = 0;
        for(int i = 0; i < answers.length; i++){
            
            f = i % first.length;
            s = i % second.length;
            t = i % third.length;
            
            if(answers[i] == first[f]) f_count++;
            if(answers[i] == second[s]) s_count++;
            if(answers[i] == third[t]) t_count++;
                
        }
        
        int max = Math.max(f_count, s_count);
        max = Math.max(max, t_count);
        
        System.out.println(max + "");
        
        if(max == f_count) list.add(1);
        if(max == s_count) list.add(2);
        if(max == t_count) list.add(3);
            
        return list.stream().mapToInt(i -> i).toArray();
    }
}