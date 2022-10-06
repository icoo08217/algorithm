import java.util.*;
import java.io.*;

class baek2108{
    
    static public int avg(int[] arr){
        double sum = 0;
        double result =0;
        for(int i : arr){
            sum+=i;
        }
        result = Math.round(sum / arr.length);
        return (int)Math.ceil(result);
    }
    
    static public int median(int[] arr){
        int middle_index = arr.length / 2;
        
        return arr[middle_index];
    }
    
    // 최빈값
    static public int mode(int[] arr){
        int cnt[] = new int [8001]; 
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE; // 최빈값을 찾기위한 비교변수
		for(int x:arr) {
			
			if(x<0) { // 음수의 경우 4000을 더해서 해당 인덱스를 증가
				cnt[Math.abs(x)+4000]++;
			}else cnt[x]++; // 나머지는 인덱스만 증가
           
		}
		
		int index =0; // 최빈값 
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]!=0 && cnt[i]>max) {	//카운트 배열에서 최빈값을 찾는다.			
				max = cnt[i]; // 
				index = i;				
			}
		}
        // max가 갱신되어서 왔다 (최빈값으로)
		for(int i=0;i<cnt.length;i++) {
			int x=i;
			if(cnt[i]==max) { // 카운트 배열의 값들과 최빈값과 일치하면,
				if(i>4000) { // 4000이상은 음수를 바꿔준것이므로 다시 원래의 숫자로 바꿔준다
					x-=4000;
					x*=-1;
					arrayList.add(x); // 어레이 리스트에 추가
				}else
					arrayList.add(i); // 나머지는 그냥 i값을 추가
			}
		}
		Collections.sort(arrayList); // 추가 된 최빈값들이 다수 존재하면 오름차순 정렬
		
		if(arrayList.size()>1) return arrayList.get(1); // 최빈값이 여러개 존재한다면, 가장 작은 숫자에서 두 번째 숫자를 반환
		else return arrayList.get(0); // 그외에는 그냥 최빈값을 반환
    }
    
    static public int range(int[] arr){
        int min = arr[0];
        int max = arr[arr.length-1];
        
        return max-min;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        // arr 배열은 입력된 수를 차례대로 배열에 넣은것
        // arr 배열은 오름차순 정렬
        Arrays.sort(arr);
        
        System.out.println(avg(arr));
        System.out.println(median(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));
        
    }
}