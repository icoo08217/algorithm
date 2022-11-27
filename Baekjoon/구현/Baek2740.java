package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class Baek2740 { // 행렬 곱셈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        int[][] arr1 = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr1[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        str = new StringTokenizer(br.readLine()); // M * K
        M = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int[][] arr2 = new int[M][K];

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arr2[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int[][] arr3 = new int[N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int temp = 0;
                for (int k = 0; k < M; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                sb.append(temp + " ");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
