
import java.util.*;
import java.io.*;

class baek1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i=0; i<N; i++){
            int decimal = Integer.parseInt(st.nextToken());

            if (Decimal(decimal)) count++;
        }

        System.out.println(count);

    }

    static boolean Decimal(int n){

        boolean flag = true;

        if (n == 1) { // 1이 들어오면 소수가 아니다.
            return false;
        }
        else {

            for (int i =2; i<n; i++){
                if (n % i == 0) {
                    flag = false;
                }
            }
            return flag;
        }

    }
}


