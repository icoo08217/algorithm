import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        LinkedList<Integer> list = new LinkedList<Integer>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 리스트 생성
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        int index = 0; // 리스트에서 삭제할 요소를 참조할 인덱스 변수

        sb.append("<");

        while(list.size()>1){ // list의 크기가 K보다 작아질 경우를 대비하여 list의 사이즈로 나누어 주어야한다.
            index = (index + (K-1)) % list.size();

            sb.append(list.remove(index)).append(", ");
        }

        // list에 하나만 남아있다. 그것을 더해서 같이 출력하자.
        sb.append(list.remove()).append(">");
        System.out.println(sb);

    }
}
