package 문자열;

import java.io.*;

public class Baek10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 30의 배수가 되려면 ?
        // 1. 맨 뒤에 0이 하나이상 있어야한다.
        // 2. 모든 자리수를 더해보면 그 수들 또한 3의 배수여야 한다.

        // 0이 존재하지 않으면 30의 배수가 될 수 없다. -1 출력

        String str = br.readLine();
        long strlen = str.length();

        int[] numCntArr = new int[10];
        int sum = 0; // 모든 자리수를 더할 변수

        for (int i = 0; i < strlen; i++) {
            int tmp = Integer.parseInt(str.substring(i, i + 1));
            numCntArr[tmp] ++;
            sum += tmp;
        }

        if (sum % 3 != 0 || !str.contains("0")) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }

        for (int i = 9; i >= 0; i--) {
            while(numCntArr[i] > 0) {
                sb.append(i);
                numCntArr[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
