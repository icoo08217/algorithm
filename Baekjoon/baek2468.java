import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int[][] Area;
    public static int[][] transArea;
    public static boolean[][] check;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int count ,  N;
    public static int Max = 1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 100; i++) {

            transArea = new int[N][N];
            count = 0;
            check = new boolean[N][N];

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (Area[a][b] > i){
                        transArea[a][b] = 1;
                    } else {
                        transArea[a][b] = 0;
                    }
                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (transArea[a][b] == 1 && !check[a][b]) {
                        search(a, b);
                        count++;
                    }
                }
            }
            Max = Math.max(Max, count);
        }
        System.out.println(Max);
    }

    public static void search(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (transArea[nx][ny] == 1 && !check[nx][ny]) {
                    search(nx, ny);
                }
            }
        }
    }
}