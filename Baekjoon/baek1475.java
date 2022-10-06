import java.util.*;
import java.io.*;

class baek1475{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        String roomNum = br.readLine(); // 방번호
        int[] numSet = new int[10];
        for (char c : roomNum.toCharArray()) {
            int num = c -'0';
            if (num == 9) {
                num = 6;
            }
            numSet[num]++;
        }

        numSet[6] = numSet[6]/2 + numSet[6]%2;

        Arrays.sort(numSet);

        System.out.println(numSet[9]);

    }
}