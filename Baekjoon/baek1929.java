import java.util.*;
import java.io.*;

class baek1929{

    public static boolean[] decimal_boolean;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        // M ~ N 까지의 숫자 중에 소수를 구하고 그 수를 출력하자.

        decimal_boolean = new boolean[N+1]; // 배열은 초기화 당시 모든 값이 false로 초기화 된다.
        decimal();

        for (int i = M; i<=N; i++){
            if (!decimal_boolean[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);


    }

    static void decimal(){
        // true = 소수 아님 , false = 소수
        decimal_boolean[0] = decimal_boolean[1] = true; // 0,1 은 소수에서 제외

        for (int i=2; i<= Math.sqrt(decimal_boolean.length); i++){
            if (decimal_boolean[i]) continue;
            for (int j= i*i ; j < decimal_boolean.length; j+=i) {
                decimal_boolean[j] = true;
            }
        }
    }


}