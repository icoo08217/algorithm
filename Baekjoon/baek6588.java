
import java.util.*;
import java.io.*;

class Main{

    public static boolean[] decimal_boolean;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime();

        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n ==0) break;

            int result = isPossible(n);

            if (result > 0) {
                sb.append(n + " = " + result + " + " + (n - result)).append('\n');
            } else {
                sb.append("Goldbach's conjecture is wrong.");
            }

        }

        System.out.println(sb);

    }

    public static int isPossible(int n) {
        for (int i = 1; i<= n/2; i++){
            int a = i;
            int b = n - i;
            if (decimal_boolean[a] && decimal_boolean[b]) return a;
        }

        return -1;
    }

    static void prime(){

        decimal_boolean = new boolean[1000001];

        //초기화
        for (int i=2;i<=1000000; i++){
            decimal_boolean[i] = true;
        }

        for (int i=2; i<=1000000; i++){
            if (!decimal_boolean[i]) continue;

            //이미 지워진 숫자가 아니라면 , 그 배수부터 출발하여 가능한 모든 숫자 지우기
            //이미 지워진 숫자는 false로 표기한다. --> true 인 값은 소수이다.
            for (int j=2*i ; j<=1000000; j+=i){
                decimal_boolean[j] = false;
            }
        }
    }


}