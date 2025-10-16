import java.io.*;
class Solution {
    public String solution(String new_id){
        // 1단계 소문자로 변환
        String answer = new_id.toLowerCase();
        // 2단계 조건 외 문자 제거
        answer = answer.replaceAll("[^\\w\\d\\-\\.]", "");
        // 3단계 연속된 .. 제거
        answer = answer.replaceAll("\\.{2,}", ".");
        // 4단계 양 끝에 . 제거
        answer = answer.replaceAll("^\\.+|\\.+$", "");
        // 5단계 빈 문자열 처리
        if(answer.isEmpty()){
            answer = "a";
        }
        // 6단계 길이 16자 이상일시 15자s로 반환
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, 14);
            }
        }
        // 7단계 길이 2자 이하일시 끝에 문자 <3 까지 반복
        while(answer.length() <= 2) {
            char c = answer.charAt(answer.length()-1);
            answer += c;
        }

        return answer;
    }
}