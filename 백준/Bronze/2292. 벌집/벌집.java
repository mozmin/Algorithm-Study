import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int i = 1;
        while(sum<N){
            sum += 6*i;
            i++;
        }
        bw.write(i+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
