import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int zeroCnt = 0;

        int max = 0;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 1) pos.add(num);
            else if (num == 1) max++; //1은 안묶이는게 최대값
            else if (num < 0) neg.add(num);
            else zeroCnt++;
        }

        Collections.sort(pos,Collections.reverseOrder()); //양수 내림차순 정렬
        Collections.sort(neg); //음수 오름차순 정렬

        for (int i = 0; i < pos.size(); i += 2) {
            if (i + 1 < pos.size()) {
                max += pos.get(i) * pos.get(i + 1);
            } else {
                max += pos.get(i);
            }
        }

        for (int i = 0; i < neg.size(); i += 2) {
            if (i + 1 < neg.size()) {
                max += neg.get(i) * neg.get(i + 1);
            } else {
                // 남은 음수가 하나일 때 0이 없으면 더하고, 0이 있으면 무시(0과 곱함)
                if (zeroCnt == 0) max += neg.get(i);
            }
        }
        System.out.println(max);
    }
}