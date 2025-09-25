import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        // 중복 제거
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i].equals(arr[j])) {
                    String temp = arr[j];
                    arr[j] = arr[N - 1];
                    arr[N - 1] = temp;
                    N--;
                    j--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            // 최소길이를 가지고있는 스트링의 인덱스
            int flag = i;
            // 최소값
            int min = arr[i].length();
            for (int j = i + 1; j < N; j++) {
                // 순서대로 최소값보다 작을경우 최소값 갱신
                if(min > arr[j].length()){
                    min = arr[j].length();
                    flag = j;
                }
                // 길이가 같을경우 사전순으로
                else if(min == arr[j].length()){
                    flag = arr[j].compareTo(arr[flag]) < 0  ? j : flag ;
                }
            }
            // 반복문이 끝나고 나면 스트링의 길이가 가장 짧은 스트링이 앞에오도록 자리바꿈
            String temp = arr[i];
            arr[i]= arr[flag];
            arr[flag] = temp;
        }

        for (int i = 0; i < N; i++) {
           sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}