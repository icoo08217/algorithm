package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class Baek2563 { // 색종이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 색종이의 수

        int[][] map = new int[100][100]; // 도화지의 크기만큼 배열을 선언
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for(int k = y; k < y + 10; k++){
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1) count++;
            }
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
