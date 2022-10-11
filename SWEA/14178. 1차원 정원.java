import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution4
{
    public static void main(String args[]) throws Exception
    {
        
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
                 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
             */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int N = sc.nextInt();
            int D = sc.nextInt();
            int result;

            result = N / (2*D+1);
            if(  (N % (2*D+1))  != 0) {
                result += 1;
            }
            System.out.println("#"+ test_case +  " "+result);
        }
    }
}