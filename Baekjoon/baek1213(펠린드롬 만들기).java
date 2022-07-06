import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 팰린드롬 => 거꾸로 읽어도 제대로 읽는 것 ex) 이효리 , 리효이
        String word = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i<word.length(); i++) { // 카운트 배열 완성
            char nextWord = word.charAt(i);
            count[nextWord - 65]++;
        }

        // 홀수개 카운트
        int oddCount = 0;
        for (int i = 0; i<count.length; i++){
            if(count[i] % 2 == 1){
                oddCount++;
            }
        }

        String str = "";
        char temp = '0'; // temp는 쓰레기 값을 넣어서 초기화 시켜놓는다.

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i<count.length; i++) {
            if ( count[i] % 2 == 1 && count[i] != 1) { // 홀수지만 1이 아닌 홀수
                int cnt = count[i] / 2;
                for (int j = 0; j<cnt; j++){
                    str += (char) (i+65);
                }
                temp = (char) (i+65);
            } else if( count[i] == 1) { // 1인 경우
                temp = (char) (i+65);
            } else {
                int cnt = count[i] / 2;
                for(int j = 0; j<cnt; j++){
                    str += (char) (i+65);
                }
            }
        }

        if (temp == '0') { // 홀수인 갯수가 없었다는 것
            for (int j = str.length()-1; j>=0; j--){
                str += str.charAt(j);
            }
        } else {
            str += temp;
            for (int j = str.length()-2; j>=0; j--){
                str += str.charAt(j);
            }
        }

        System.out.println(str);

    }
}
