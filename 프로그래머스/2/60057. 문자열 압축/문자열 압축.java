import java.util.*;

class Solution {
    public int solution(String s) {
				//✅ 압축된 문자열 길이들 중 가장 짧은 길이를 반환한다.
        int result = s.length();
        for (int l = 1; l <= s.length() / 2; l++) {
            result = Math.min(result, compress(s, l));
        }
        return result;
    }
    
    int compress(String text, int length) {
				//✅ 현재 압축 단위에 따라 문자열을 나눈다.
        List<String> words = new ArrayList<>();
        for (int i = 0; i < text.length(); i += length) {
            words.add(text.substring(i, Math.min(text.length(), i + length)));
        }
        StringBuilder compressed = new StringBuilder();
        String prevWord = "";
        int count = 0;
        for (String word : words) {
						//✅ 이전 부분 문자열과 현재 부분 문자열을 비교한다.
            if (word.equals(prevWord)) {
								//✅ 만약 같다면, 이전 부분 문자열의 중복 개수를 1 증가시킨다.
                count++;
            } else {
								//✅ 만약 다르다면, 이전 부분 문자열의 중복 개수와 문자열을 압축 문자열에 이어붙인다.
                if (count > 1) {
                    compressed.append(String.valueOf(count));
                }
                compressed.append(prevWord);
								//✅ 현재 부분 문자열을 이전 부분 문자열로 지정하고, 중복 개수를 1로 설정한다.
                prevWord = word;
                count = 1;
            }
        }
				//✅ 마지막 부분 문자열을 처리한다.
        if (count > 1) {
            compressed.append(String.valueOf(count));
        }
        compressed.append(prevWord);
        return compressed.toString().length();
    }
}