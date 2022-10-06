
import java.util.*;
import java.io.*;

class baek10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int location[] = new int[26]; // 처음 나타난 위치를 나타낼 배열.

        // location의 초기값들을 모두 -1로 설정한다.
        for (int i=0; i<location.length; i++){
            location[i] = -1;
        }

        String input = br.readLine();

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if (location[ c - 97] == -1)
                location[c - 97] = i;
        }

        for (int i : location) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);


    }
}


