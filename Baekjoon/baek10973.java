import java.util.*;
import java.io.*;

class baek10873 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(arr)) {
            for (int i : arr) {
                sb.append(i + " ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    public static boolean nextPermutation(int arr[]) {
        int i = arr.length-1;
        while(i>0 && arr[i] > arr[i-1]){
            i--;
        }

        if (i == 0){ // 마지막 순열인 경우
            return false;
        }

        int j = arr.length-1;
        while (arr[i - 1] < arr[j]) {
            j--;
        }
        swap(arr, i - 1, j);

        j = arr.length-1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}