import java.util.*;
import java.io.*;

public class baek2583 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int M , N , K ;
    static int map[][];
    static int x1 , x2 , y1 , y2;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static ArrayList<Integer> List;
    static int count , nx, ny;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int a = x1; a < x2; a++) {
                for (int b = y1; b < y2; b++) {
                    map[a][b] = 1;
                }
            }
        }

        List = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count=0;
                    dfs(i, j);
                    List.add(count);
                }
            }
        }
        System.out.println(List.size());
        Collections.sort(List);

        for (Integer item : List) {
            System.out.print(item + " ");
        }
    }

    static void dfs(int x, int y) {
        map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

}
