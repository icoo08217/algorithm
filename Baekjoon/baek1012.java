import java.util.*;
import java.io.*;

class Main{

    static int dx[] = {0,-1,0,1};
    static int dy[] = {1,0,-1,0};
    static int cnt;
    static int map[][];
    static boolean check[][];
    static int M , N , K ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            cnt = 0;
            str = new StringTokenizer(br.readLine());
            M = Integer.parseInt(str.nextToken()); // 배추밭의 가로길이
            N = Integer.parseInt(str.nextToken()); // 배추밭의 세로길이
            K = Integer.parseInt(str.nextToken()); // 배추가 심어져있는 위치의 갯수

            map = new int[M][N];
            check = new boolean[M][N];

            for (int j=0; j<K; j++){
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());

                map[x][y] = 1;
            }

            for (int mapX =0; mapX < M; mapX++) {
                for (int mapY = 0; mapY < N; mapY++){
                    if (map[mapX][mapY] == 1 && !check[mapX][mapY]){
                        cnt++;
                        dfs(mapX,mapY);
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void dfs(int i , int j){
        check[i][j] = true;

        for (int k=0; k<dx.length; k++){
            int nX = i + dx[k];
            int nY = j + dy[k];

            if (nX >= 0 && nX < M && nY >= 0 && nY < N){
                if (!check[nX][nY] && map[nX][nY] ==1){
                    dfs(nX,nY);
                }

            }
        }
    }
}