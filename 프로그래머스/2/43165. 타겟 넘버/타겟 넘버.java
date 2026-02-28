import java.io.*;
import java.util.*;

class Solution {
    
    static int count;
    public int solution(int[] numbers, int target) {
        
        count = 0;
        
        dfs(1, numbers[0], numbers, target);
        dfs(1, -numbers[0], numbers, target);
        
        return count;
    }
    
    public static void dfs(int index, int sum, int[] numbers, int target){
        
        if(index > numbers.length-1 && sum == target){
            count++;
        }
        
        if(index > numbers.length-1) return;

        dfs(index+1, sum+numbers[index], numbers, target);
        dfs(index+1, sum-numbers[index], numbers, target);
        
    } 
}