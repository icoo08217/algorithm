import java.util.*;
import java.io.*;

class Main{

    // 변수
    static int[][] check;
    static boolean[] visited;
    static int n; // 정점의 개수
    static int m; // 간선의 개수
    static int v; // 탐색을 시작할 정점의 번호
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n= Integer.parseInt(st.nextToken()); // 정점의 개수
        m= Integer.parseInt(st.nextToken()); // 간선의 개수
        v= Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        check = new int[1001][1001];
        visited = new boolean[1001]; // 초기값 false 초기화

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            check[x][y] = check[y][x] = 1; // 간선끼리 연결이 되어있다.
        }

        dfs(v); // dfs 호출
        System.out.println();

        visited = new boolean[1001]; // bfs를 위해 초기값 false 초기화

        bfs(); // bfs 호출

    }

    public static void dfs(int v){
        visited[v] = true; // 방문 여부 갱신
        System.out.print(v + " ");

        for (int i=1; i<=n; i++){
            if (check[v][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v); // 시작점 넣기
        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()){
            int temp = queue.poll();

            for (int j=1; j<=n; j++){
                if (check[temp][j] == 1 && visited[j] == false){
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }

    }
}