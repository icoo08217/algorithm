package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(stt.nextToken());
        int M = Integer.parseInt(stt.nextToken());

        stt = new StringTokenizer(br.readLine(), " ");
        int[] trees = new int[N];

        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(stt.nextToken());

            if(max < trees[i]) { // 나무들 중 최댓값을 구한다.
                max = trees[i];
            }
        }

        while( min < max ){
            int mid = (min + max) / 2;
            long sum = 0;
            for (int tree : trees) {
                if (tree > mid) { // 조건 1 : 톱의 높이가 나무보다 짧은 경우에만 나무가 잘리고 그 나무를 챙길 수 있다.
                    sum += (tree - mid);
                }
            }

            if( sum < M) { // 최대값을 낮춰야 한다는 소리
                max = mid;
            } else { // 최소값을 올려야 한다. 하지만 mid + 1 의 값이란것을 주의하자.
                min = mid+1 ;
            }
        }

        System.out.println(min-1);

    }
}
