package programmers.완전탐색;

import java.util.HashSet;
import java.util.Iterator;

public class 소수_찾기 {

    public static void main(String[] args) {
        Solution_소수_찾기 solution = new Solution_소수_찾기();

        String numbers = "17";
        System.out.println(solution.solution(numbers));
    }
}

class Solution_소수_찾기 {
    HashSet<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {

        int[] decimal = new int[numbers.length()];
        int answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            int number = c - '0';
            decimal[i] = number;
        }
        // decimal ==> {1, 7} ==> 얘들로 만들수 있는 모든 조합의 수를 list 에 저장. ex) 1 , 7 , 17 , 71
        // 그리고 리스트의 모든 요소들이 소수인지를 판단하자. 1 제외
        // 1 . 모든 조합의 수를 만들자
        recursive("", numbers);

        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            // 2 . 소수인지 판단. (에라토스테네스 체 사용) 소수라면 count++
            if(isPrime(number)){
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(int n) {
        // 0과 1은 소수가 아니다.
        if (n == 0 || n == 1) {
            return false;
        }
        // 2. 에라토스테네스의 체에서 limit 을 계산한다.
        int limit = (int) Math.sqrt(n);

        // 3. 에라토스테네스의 에 따라 limit 까지만 배수 여부를 확인한다.
        for (int i = 2; i < limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void recursive(String comb, String others) { // comb : 현재 조합 , others : 남은 숫자
        // 1. 현재 조합을 set에 추가해준다.
        if (!comb.equals("")){
            numberSet.add(Integer.valueOf(comb));
        }
        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i<others.length(); i++){
            recursive(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1));
        }
    }
}