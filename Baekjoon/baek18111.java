import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N , M , B ;
    static int time , inventory;
    static int ansT , ansH;
    static int[][] house ;
    static int min = Integer.MAX_VALUE;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        house = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, house[i][j]);
                min = Math.min(min, house[i][j]);
            }
        }

        ansT = Integer.MAX_VALUE; // 결과 값 (시간)
        ansH = 0; // 층

        for (int i = min; i <= max; i++) { // 최소층 부터 최대 층까지

            time = 0;
            inventory = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    //차이
                    int diff = house[j][k] - i;

                    if ( diff > 0) { // 제거해야됨 . 시간이 2
                        time += Math.abs(diff) * 2;
                        inventory += Math.abs(diff); // 인벤토리에 더해진다.
                    } else if ( diff < 0) { // 추가해줘야됨 . 시간이 1
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if (inventory < 0) {
                continue;
            }

            if (ansT >= time) {
                ansT = time;
                ansH = i;
            }
        }

        System.out.println(ansT + " " + ansH);
    }


}
