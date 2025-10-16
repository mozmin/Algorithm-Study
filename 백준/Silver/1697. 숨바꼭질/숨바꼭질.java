
import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

// 숨바꼭질 (백준 1697번)
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
// 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
public class Main {

    final static int MAX = 1000000 + 10;
    static boolean[] visited;
    static int N, M;
    static int[] answer;

    public static void bfs(int index){
        visited[index] = true; // 루트 값 방문처리
        Queue<Integer> q = new LinkedList<>(); // 큐 생성
        q.add(index); // 루트 값 큐에 추가

        while(!q.isEmpty()){ // 큐가 비어있을 때 까지
            int next = q.poll(); // 큐에 맨 앞에 있는 값 추출하여 next 에 저장
            
            for(int i = 0; i<3; i++){
                int new_next; // 그 다음 노드 인덱스 저장하기 위한 변수 선언

                // 세가지 경우의 수
                if(i == 0) new_next = next -1;  // 1. -1 걸어감
                else if(i == 1) new_next = next +1; // 2. +1 걸어감
                else new_next = next * 2; // 3. X2 순간이동

                if(new_next >= 0 && new_next<=1000000 && !visited[new_next] ){ // 만약 해당 노드를 방문하지 않았다면
                    q.add(new_next); // 큐에 노드 추가
                    visited[new_next] = true; // 방문처리
                    answer[new_next] = answer[next] + 1; // 부모노드보다 이동횟수 +1 하여 횟수 저장
                    if(new_next == M) return; // 만약 찾고자 하는 값과 같다면 반복문 종료
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        // 배열 초기화
        visited = new boolean[MAX];
        answer = new int[MAX];

        // bfs
        bfs(N);

        bw.write(answer[M]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
