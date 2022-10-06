import java.util.*;
import java.io.*;

class baek10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count[] = new int[26]; // 각 알파벳을 세어줄 행렬

        String input = br.readLine();

        for (int i=0; i< input.length(); i++){
            char c = input.charAt(i);
            // 'a' 의 인트형 수는 97이다.
            count[c - 97]++;
        }

        for(int cnt : count){
            sb.append(cnt).append(' ');
        }

        System.out.println(sb);
    }
}


