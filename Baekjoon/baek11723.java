import java.util.*;
import java.io.*;

// 비트 마스크 = 정수 이진수 표현을 자료구조로 쓰는 기법
// 
class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitset = 0; // 비트 마스크 연산 시 공집합으로 초기화
        // int 자료형이므로 4바이트 즉, 4 * 8bit  , 0~31까지 32개의 숫자를 표현할수 있다.

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num;

            switch (operation) {

                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bitset |= (1<<(num-1)); // OR 연산 |=
                    // (1<<(num-1)) --> 
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitset &= ~(1<<(num-1));
                    break;

                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bitset & (1<<(num-1))) == 0 ? "0\n" : "1\n");
                    break;

                case "toggle": // 있으면 없애고 , 없으면 생성 --> XOR ^ 연산
                    num = Integer.parseInt(st.nextToken());
                    bitset ^= (1<<(num-1));
                    break;

                case "all": // 모두 1로 바꾼다.
                    bitset |= ~(0);
                    break;

                case "empty": // 모두 0으로 바꾼다.
                    bitset &= ~(1);
                    break;
            }

        }

        System.out.println(sb);
    }
}