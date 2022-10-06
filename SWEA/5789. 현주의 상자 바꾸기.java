import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution3
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int box[] = new int[n+1];

            for (int i = 1; i <= q; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                for (int j = L; j <= R; j++) {
                    box[j] = i;
                }
            }

            sb.append("#" + test_case + " ");
            for (int k = 1; k<=n; k++) {
                sb.append(box[k] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        }
    }
