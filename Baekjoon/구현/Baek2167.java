package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class Baek2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        // 배열 만들기
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(str.nextToken());
                arr[i][j] = tmp;
            }
        }

        // K 구하기
        str = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(str.nextToken());

        // K 동안 i , j , x , y 범위로 값 더하기
        for (int a = 0; a < K; a++) {
            str = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(str.nextToken());
            int j = Integer.parseInt(str.nextToken());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());

            int sum = 0;

            for (int b = i-1; b <= x-1; b++){
                for (int c = j-1; c <= y-1; c++){
                    sum += arr[b][c];
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
