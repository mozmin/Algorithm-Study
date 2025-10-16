
import java.io.*;
import java.util.*;

// 경비원
public class Main {

    static int[] position;
    static int n;
    static int sum;
    static int w, h;
    public static void maxLength(){

        for (int i = 0; i <=n; i++) {
            int c1 = Math.abs(position[n] - position[i]);
            int c2 = (2 * w + 2 * h) - position[i] + position[n];
            int c3 = (2 * w + 2 * h) - position[n] + position[i];

            int min = Math.min(c1, c2);
            sum += Math.min(min, c3);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        w = Integer.parseInt(str.nextToken());
        h = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(br.readLine());

        sum = 0;
        int d = 0;
        int pos = 0;
        position = new int[n+1];

        for (int i = 0; i <= n; i++) {
            str = new StringTokenizer(br.readLine());
            d= Integer.parseInt(str.nextToken());
            pos = Integer.parseInt(str.nextToken());

            if(d == 2) position[i] = pos;
            else if(d == 4) position[i] = w + (h-pos);
            else if(d == 1) position[i] = (w+h) + (w-pos);
            else if(d == 3) position[i] = (2*w + h) + pos;
        }

        maxLength();

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
