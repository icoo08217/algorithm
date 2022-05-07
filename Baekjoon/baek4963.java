import java.util.*;
import java.io.*;

public class Main {

    public static int H , W ;
    public static int[][] island;
    public static boolean[][] check;
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int count; // 섬의 갯수

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) { // 종료
                System.exit(0);
            }

            island = new int[H][W];
            check = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0; //섬 초기화

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (island[i][j] == 1 && !check[i][j]){
                        search(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void search(int x, int y) {
        check[x][y] = true;

        //8방향 확인
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 안에 있고, 배열값이 1, check가 true 인것들
            if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                if (island[nx][ny] == 1 && !check[nx][ny]) {
                    search(nx, ny);
                }
            }
        }
    }
}
