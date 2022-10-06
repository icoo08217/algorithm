import java.util.*;
import java.io.*;

class baek5052 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            int n = Integer.parseInt(br.readLine());
            String[] phoneNum = new String[n];

            for (int i=0; i<n; i++){
                phoneNum[i] = br.readLine();
            }
            Arrays.sort(phoneNum); // 오름차순 정렬

            if (isConsistent(n , phoneNum)) { // true가 반환 되면 YES
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isConsistent(int n , String[] phoneNum){
        for (int i=0; i<n-1; i++){
            // 배열을 오름차순 정렬함으로써 접두어의 관계는 바로 뒤 숫자와 관계가 있을 것으로 판단된다.
            // 결과적으로 , 일관성이 있는지 확인하려면 phoneNum[i+1]이 phoneNum[i] 을 접두어로 가지고 있는지 확인 하면 됨.
            // String 클래스의 startsWith 메소드 사용. -> return true 일 경우 접두어로 사용한다라는 뜻.
            if (phoneNum[i+1].startsWith(phoneNum[i])){ // 접두어 인지 판단
                return false;
            }
        }
        return true;
    }
}