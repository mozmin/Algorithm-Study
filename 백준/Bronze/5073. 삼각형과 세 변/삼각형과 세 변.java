import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;
        while(true){
            str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            if(a == 0 && b == 0 && c == 0){break;}

            if( a >= b+c || b >= a+c || c >= a+b){
                bw.write("Invalid\n");
            }
            else{
                if (a == b && b == c){
                    bw.write("Equilateral\n");
                }
                else if (a == b || b == c || c == a ){
                    bw.write("Isosceles\n");
                }
                else{
                    bw.write("Scalene\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}