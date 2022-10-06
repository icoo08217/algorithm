package programmers;

import java.util.Arrays;

public class Hindex {

    public static void main(String[] args) {
        Solution_Hindex solution = new Solution_Hindex();
        int[] citations = new int[] {3,0,6,1,5};
        System.out.println(solution.solution(citations));
    }
}
class Solution_Hindex {
    public int solution(int[] citations) {

        int h_index = 0;
        int n = citations.length;

        Arrays.sort(citations); // 오름차순 정렬

        for (int i = 0; i < n; i++) {
            int h = n - i; // i 일때 가질수 있는 가장 큰 논문 편수

            if (citations[i] >= h) { // 인용된 횟수 >= i일때 가질수 있는 가장 큰 논문 횟수(해당 논문)
                h_index = h;
                break; // h는 점점 작아지므로 해당 조건을 만족하는 수가 최대값이다.
            }
        }
        return h_index;
    }
}

//class Solution_Hindex {
//    public int solution(int[] citations) {
//
//        int n = citations.length; // 논문의 수
//        // citations = 발표한 논문의 인용 횟수를 담은 배열
//        int answer = 0;
//
//        for (int h : citations) {
//            int cnt = 0;
//            for (int i = 0; i < citations.length; i++) {
//                if ( h >= citations[i]){
//                    cnt++;
//                }
//            }
//            if (cnt >= h){
//                answer = Math.max(h , answer);
//            }
//        }
//        return answer;
//    }
//}