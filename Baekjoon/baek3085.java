import java.util.*;
import java.io.*;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static char[][] board; // 맵
    public static int N; // 맵 크기
    public static int max = 0; // 먹을 수 있는 최대 사탕 갯수

    // 두 문자를 교환하는 메소드
    public static void swap(char a, char b) {
        char temp = a;
        a = b;
        b = temp;
    }

    // 가로로 , 세로로 비교하면서 먹을 수 있는 사탕의 최대 갯수 찾기
    public static void arrCheck(){
        // 가로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                // 이전 사탕과 동일 한 경우 -> 계속 먹는다.
                if (board[i][j] == board[i][j+1]){
                    count++;
                }
                // 이전과 다른 사탕인 경우 -> 새로 먹어야하므로 1로 초기화
                else {
                    count = 1; // 새로 새야함.
                }
                // 사탕 최대 갯수 저장
                max = Math.max(max, count);
            }
        }

        // 세로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                }
                else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 가로 사탕 교환 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char temp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = temp;

                arrCheck(); // 체크

                temp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = temp;

            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {

                char temp = board[j][i];
                board[j][i] = board[j + 1][i];
                board[j + 1][i] = temp;
                arrCheck();

                temp = board[j][i];
                board[j][i] = board[j + 1][i];
                board[j + 1][i] = temp;
                

            }
        }
        System.out.println(max);
    }
}