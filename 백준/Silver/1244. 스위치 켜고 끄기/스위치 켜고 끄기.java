
import java.io.*;
import java.util.*;

/**
 * 스위치 켜고 끄기
 * @author jmmo0722
 *
 */

public class Main {
	static int index;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		
		// 스위치 입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		// 학생 수 및 스위치 입력
		int student = Integer.parseInt(br.readLine());
		for(int i = 0; i < student; i++) {
			str = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(str.nextToken());
			int number = Integer.parseInt(str.nextToken());
			
			switch(gender) {
			case 1:
				for(int x = 1; x <= n; x++) {
					if(x % number == 0) {
						arr[x-1] = (arr[x-1] == 1) ? 0 : 1;
					}
				}
				break;
			case 2:
				number--;  // 배열 인덱스 맞추기 위해 -1
				index = 0;
				while (number - index >= 0 && number + index < n && arr[number - index] == arr[number + index]) {
				    index++;
				}
				index--;  // 마지막 index는 범위를 벗어나므로 -1

				for (int x = number - index; x <= number + index; x++) {
				    arr[x] = (arr[x] == 1) ? 0 : 1;
				}
				break;
				
			}
		}
		for (int i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
            if ((i + 1) % 20 == 0) {
                bw.newLine();
            }
        }
		
		br.close();
		bw.flush();
		bw.close();
	}
}
