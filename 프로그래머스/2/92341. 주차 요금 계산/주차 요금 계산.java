import java.io.*;
import java.util.*;

class Solution {
    
    public static int parseTime(String time){
        
        String[] parseTime = time.split(":");
        int hour = Integer.parseInt(parseTime[0]);
        int minute = Integer.parseInt(parseTime[1]);
        
        return hour*60 + minute;
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int partTime = fees[2];
        int partFee = fees[3];
        
        Map<String, Integer> totalMap = new TreeMap<>();
        Map<String, Integer> inMap = new HashMap<>();
        
        for(String s : records){
            
            String[] input = s.split(" ");
            
            int curTime = parseTime(input[0]);
            String carNumber = input[1];
            String value = input[2];
            
            if(value.equals("IN")){
                inMap.put(carNumber, curTime);
            }else{
                
                int inTime = inMap.remove(carNumber);
                
                int parkingTime = curTime - inTime;
                
                totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + parkingTime);
            }
        }
        
        int lastTime = parseTime("23:59");
        // 출차 기록이 없는 차량 추출
        for(Map.Entry<String, Integer> entry : inMap.entrySet()){
            String carNumber = entry.getKey();
            int inTime = entry.getValue();
            
            int parkingTime = lastTime - inTime;
            totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + parkingTime);
        }
        
        int[] answer = new int[totalMap.size()];
        int i = 0;
        
        for (int totalTime : totalMap.values()) {
            // 기본 시간 이내인 경우
            if (totalTime <= baseTime) {
                answer[i] = baseFee;
            } else {
                // 기본 시간 초과인 경우
                int overTime = totalTime - baseTime;
                // 초과 요금 계산 (올림 처리가 중요)
                int overFee = (int) Math.ceil((double) overTime / partTime) * partFee;
                answer[i] = baseFee + overFee;
            }
            i++;
        }
        
        return answer;
    }
}