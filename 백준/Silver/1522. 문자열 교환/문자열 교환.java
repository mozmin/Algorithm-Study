import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = br.readLine();

        int result = Integer.MAX_VALUE;

        // 문자열에 a가 몇개인지 카운트
        int count_a = 0;
        for (int i = 0; i < st.length(); i++) {
            if(st.charAt(i) == 'a') count_a++;
        }

        String stst = st + st;

        for(int i = 0; i <= stst.length() - count_a; i++ ){

            int count_b = 0;
            for (int j = i; j < i + count_a; j++) {
                if(stst.charAt(j) == 'b') count_b++;
            }
            result = Math.min(result, count_b);
        }

        bw.write(result+"");

        br.close();
        bw.flush();
        bw.close();
    }
}