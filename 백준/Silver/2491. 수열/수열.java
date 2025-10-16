
import java.io.*;
import java.util.*;

/**
 * 수열
 * @author jmmo0722
 *
 */

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		
		int result = Integer.MIN_VALUE;
		
		// 증가 확인
		int increase_cnt = 1;
		for(int i = 1; i < n; i++) {
			
			// 만약 이전 값보다 크거나 같다면
			if(arr[i-1] <= arr[i]) {
				increase_cnt++;
			}
			// 만약 이전 값보다 작다면
			else if(arr[i-1] > arr[i]) {
				increase_cnt = 1;
			}
			result = Math.max(result, increase_cnt);
		}
		
		// 감소 확인
		int decrease_cnt = 1;
		for(int i = 1; i < n; i++) {
			
			// 만약 이전 값보다 작거나 같다면
			if(arr[i-1] >= arr[i]) {
				decrease_cnt++;
			}
			// 만약 이전 값보다 크다면
			else if(arr[i-1] < arr[i]) {
				decrease_cnt = 1;
			}
			result = Math.max(result, decrease_cnt);
		}
		
		if(n == 1) {
			result = 1;
		}
		
		bw.write(result + "");
		br.close();
		bw.flush();
		bw.close();
	}
}
