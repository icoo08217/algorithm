package programmers.완전탐색;

public class 피로도 {
    public static void main(String[] args) {
        Solution_피로도 solution = new Solution_피로도();
        int k = 80;
        int[][] dungeons = new int[][] {{80,20},{50,40},{30,10}} ;
        System.out.println(solution.solution(k , dungeons));
    }
}

class Solution_피로도 {
    static boolean[] visited;
    static int answer = -1;

    public int solution(int k, int[][] dungeons) { // 유저의 현재 피로도 k , dungeons : 던전별 "최소 필요 피로도" , "소모 피로도"
        /**
        순서
        1. DFS(백트래킹)
        2. dfs로 던전 순서 정하기( 현재 피로도로 돌 수 있는 던전만 선택 )
        3. dfs를 돌면서 최대값 갱신
        **/
        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return answer; // User 가 탐험할 수 있는 최대 던전 수
    }

    public void dfs(int k , int[][] dungeons , int stage){

        answer = Math.max(answer, stage);

        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k && visited[i] == false) {
                visited[i] = true;
                dfs(k - dungeons[i][1] , dungeons , stage + 1);
                visited[i] = false;
            }
        }
    }
}