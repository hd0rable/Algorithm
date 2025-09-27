import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 비교보다 단순 숫자 비교가 더 빠름
        String line =  br.readLine();
        String[] token = line.split(" ");
        int[] arr = new int[8];
        for(int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(token[i]);
        }

        boolean ascending = true;
        boolean descending = true;

        // Arrays.equals가 배열 전체 비교이므로, 최악 8회 비교
        // 정수 배열선언시, 배열 한번 순회만으로도 가능하다.
        for(int i = 0; i < 7; i++){
            if(arr[i] > arr[i+1]) ascending = false;
            else if(arr[i] < arr[i+1]) descending = false;
        }

        if(ascending) System.out.println("ascending");
        else if(descending) System.out.println("descending");
        else System.out.println("mixed");

    }
}