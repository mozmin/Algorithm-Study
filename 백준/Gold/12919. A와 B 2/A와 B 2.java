import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();
        boolean result = false;

        Deque<String> que = new ArrayDeque<>();

        // t에서 s로 역방향
        que.add(t);

        while(!que.isEmpty()){

            String curString = que.poll();

            if(curString.equals(s)){
                result = true;
                break;
            }

            // 뒤가 A면은 A를 삭제
            int curStringSize = curString.length();
            if(curStringSize-1 >= 0 && curString.charAt(curStringSize-1) == 'A'){
                String StringA = curString.substring(0, curStringSize-1);
                que.offer(StringA);
            }

            // 앞쪽이 B라면 B 삭제 후 뒤집기
            StringBuilder sb = new StringBuilder();
            if(curStringSize-1 >= 0 && curString.charAt(0) == 'B'){
                String StringB = curString.substring(1, curStringSize);
                for(int i = StringB.length()-1; i >= 0; i--) sb.append(StringB.charAt(i));

                String reverseBString = sb.toString();
                que.offer(reverseBString);
            }
        }

        bw.write(result ? "1" : "0");
        br.close();
        bw.flush();
        bw.close();
    }
}
