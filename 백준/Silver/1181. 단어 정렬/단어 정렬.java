import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine()); // set으로 입력받아 중복 자동 제거
        }

        // Set -> List 변환
        List<String> list = new ArrayList<>(set);

        // 길이 오름차순, 길이 같으면 사전순으로 정렬
        // 반환값 < 0 : a가 앞
        // 반환값 = 0 : 순서유지
        // 반환값 > 0 : b가 앞
        Collections.sort(list, (a,b) -> {
            if(a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String s: list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}