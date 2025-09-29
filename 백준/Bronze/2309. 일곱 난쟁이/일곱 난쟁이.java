import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9]; // 입력 배열
        int sum = 0;
        for (int i = 0; i <9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i]; // 아홈명 난쟁이들의 합
        }

        outer:
        for(int i = 0; i<8; i++){
            for(int j = i+1; j<9; j++){
                if(sum - arr[i] - arr[j] == 100){ // 아홉명에서 두명을 제외한 일곱 난쟁이들의 합이 100
                    arr[i] = arr[j] = -1; // 해당하지않는 난쟁이들의 키를 쓰레기값으로
                    Arrays.sort(arr); //정렬
                    break outer;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<9; i++){ //쓰레기값 제외한 진짜 난쟁이들의 키 출력
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }
}