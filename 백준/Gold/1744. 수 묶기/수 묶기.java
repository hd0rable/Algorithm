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

        Queue<Integer> queue = new ArrayDeque<>();
        for(int num : pos){
            if(queue.isEmpty()) queue.add(num); //양수라면 정렬했을때 큰값끼리 묶여서 곱하는게 최대
            else max += (queue.poll()*num);
        }
        if(!queue.isEmpty()) max += queue.poll(); //양수가 홀수일경우 짝이맺어지지못한 양수 처리

        for(int num : neg){
            if(queue.isEmpty()) queue.add(num);
            else max += (queue.poll()*num);
        }
        if(!queue.isEmpty()) {
            if(zeroCnt <= 0)  max += queue.poll(); //음수가 홀수일경우 짝이맺어지지못한 음수 처리 0이 있다면 상쇄됨
        }
        System.out.println(max);
    }
}