import java.util.*;
import java.io.*;

class baek2606{

    static int n; //정점의 개수
    static int m; //간선의 개수
    static int[][] check; // 간선의 연결 상태를 나타낼 이차원배열
    static boolean[] visited; // 각 정점을 방문했는지를 나타낼 배열
    static int cnt=0;

    static int dfs(int i){
        visited[i] = true;// 방문 했음.
        for (int j=1; j<=n; j++){
            if (check[i][j] == 1 && visited[j] == false){
                cnt++;
                dfs(j);
            }
        }

        return cnt;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        check = new int[n+1][n+1];

        // check 배열 채우기
        for (int i=0; i<m; i++){
            str = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(str.nextToken());
            int node2 = Integer.parseInt(str.nextToken());

            check[node1][node2] = check[node2][node1] = 1;
        }

        visited = new boolean[n+1];



        System.out.println(dfs(1));

    }




}