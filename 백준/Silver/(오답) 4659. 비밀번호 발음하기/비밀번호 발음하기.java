package Baekjoon.Silver.오답_비밀번호_발음하기_4659;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 비밀번호_발음하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Character> moum = new HashSet<>();
        moum.add('a');
        moum.add('e');
        moum.add('u');
        moum.add('i');
        moum.add('o');
        while(true){
            String st = br.readLine();
            if(st.equals("end")) break;

            // 품질 평가
            boolean check = false;

            for(int i = 0; i < st.length()-1; i++){
                char a = st.charAt(i);
                char b = st.charAt(i+1);

                if(a != 'e' && a != 'o' && a == b){
                    check = true;
                    break;
                }
            }

            // 필수 모음 확인
            Set<Character> set = new HashSet<>();
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < st.length(); i++) {
                char c = st.charAt(i);
                if(moum.contains(c)) count1++;
                else count1 = 0;
                if(!moum.contains(c)) count2++;
                else count2 = 0;
                if(count1 == 3 || count2 == 3){
                    check = true;
                    break;
                }

                set.add(c);
            }
            if(!set.contains('a') && !set.contains('e') && !set.contains('i') &&
                    !set.contains('o') && !set.contains('u')){
                check = true;
            }


            if(check) bw.write("<" + st + "> is not acceptable.\n");
            else bw.write("<" + st + "> is acceptable.\n");

        }
        br.close();
        bw.flush();
        bw.close();
    }
}
