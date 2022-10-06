import java.util.*;
import java.io.*;

class baek1476 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()); // 1 15
        int S = Integer.parseInt(st.nextToken()); // 1 28
        int M = Integer.parseInt(st.nextToken()); // 1 19

        int e = 1;
        int s = 1;
        int m = 1;

        int year = 1;

        while(true){

            if (E == e && S == s && M == m){
                break;
            }
            
            e++;
            s++;
            m++;
            
            if ( e > 15 ){
                e = 1;
            }

            if ( s > 28) {
                s = 1;
            }

            if ( m > 19){
                m = 1;
            }
            year++;
        }

        System.out.println(year);


    }
}


