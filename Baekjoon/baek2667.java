import java.util.*;
import java.io.*;

class baek2667{

    static int map[][]; // 지도
    static boolean visited[][]; //방문 여부
    static int n; // 지도의 크기
    static int count = 1; // 총 단지 수
    static int row[] = {0,0,-1,1}; // row
    static int col[] = {-1,1,0,0}; // col

    public static void dfs(int i, int j){
        map[i][j] = count; // 방문한 집 표시
        visited[i][j] = true; // 방문한 집 체크

        // 상하좌우로 이동하며 탐색
        for(int k=0; k<row.length; k++){
            int i_row = i + row[k];
            int j_col = j + col[k];

            // 배열의 범위를 벗어나지 않는 범위 내에서 탐색
            if (i_row >= 0 && i_row < n && j_col >= 0 && j_col < n){
                if (map[i_row][j_col] == 1 && visited[i_row][j_col] == false){ // 집이 있으면서 방문하지 않은 곳
                    dfs(i_row,j_col);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0; i<n; i++){ // 지도 채워넣기
            String mapRow = br.readLine();
            for (int j=0; j<n; j++){
                int house = mapRow.charAt(j) - '0'; // charAt(j) 로 추출된 1은 문자 '1' 이다. 그러므로 '0'을 빼주어 숫자 1로 만들어주기 위한 코드.
                map[i][j] = house;
            }
        }


        visited = new boolean[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] == 1 && visited[i][j] == false){ // 집이 있으면서 방문하지 않은 곳
                    dfs(i,j); // 재귀함수이므로 더이상 주변에 같은 수를 가진 단지가 없을때 까지 실행한다.
                    count++;
                }
            }
        }
        System.out.println(count - 1); // 총 단지 수
        // 단지 내 집의 수
        int result[] = new int[count];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] != 0){
                    result[map[i][j]]++;
                }
            }
        }

        Arrays.sort(result);
        for (int i=1; i<result.length; i++){
            System.out.println(result[i]);
        }

    }
}