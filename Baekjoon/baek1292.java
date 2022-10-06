import java.util.*;
import java.io.*;

public class baek1292 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;
    public static int index , sum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int arr[] = new int[1001];
        index = 1;

        // 수열 채워넣기
        for (int i = 1; i<=1000; i++){
            for (int j=1; j<=i; j++) {
                if (index > 1000) break;
                arr[index] = i;
                index++;
            }
        }
        // 결과 값 도출
        sum = 0;
        for (int i = A; i<=B; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
