import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. PriorityQueue를 생성 (낮은 숫자가 우선순위를 갖는 Min-Heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 2. 모든 스코빌 지수를 큐에 추가
        for (int s : scoville) {
            pq.add(s);
        }
        
        // 3. 큐의 가장 작은 값(peek)이 K보다 작은 동안 반복
        while (pq.peek() < K) {
            
            // 4. [Edge Case] 섞을 음식이 2개 미만이면 불가능
            if (pq.size() < 2) {
                return -1; // -1 반환
            }
            
            // 5. 가장 맵지 않은 두 음식을 꺼냄
            int first = pq.poll();
            int second = pq.poll();
            
            // 6. 공식에 따라 새로운 스코빌 지수 계산
            int newScoville = first + (second * 2);
            
            // 7. 새로 만든 음식을 다시 큐에 추가
            pq.add(newScoville);
            
            // 8. 섞은 횟수 증가
            answer++;
        }
        
        // 9. 루프를 통과했다면 모든 음식이 K 이상이 된 것
        return answer;
    }
}