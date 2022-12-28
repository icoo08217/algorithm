package 이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1920 {
    static StringTokenizer stt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        stt = new StringTokenizer(br.readLine() , " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        // key 값들
        stt = new StringTokenizer(br.readLine(), " ");

        // 정렬
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(stt.nextToken());
            // 이분 탐색
            // 결과가 있다면 1 , 없다면 0
            if(binarySearch(target) == -1) {
                sb.append(0 + "\n");
            } else {
                sb.append(1 + "\n");
            }
        }

        System.out.println(sb);

    }

    public static int binarySearch(int key) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            // 키가 중간값보다 작을떄
            if ( key < arr[mid]) {
                high = mid - 1;
            } else if ( key > arr[mid] ) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        // 찾고자 하는 값이 없을 때
        return -1;
    }

}
