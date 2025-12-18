import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // num,cnt 숫자,빈도횟수
        ArrayList<Integer> index = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            index.add(list.get(i));
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }

        Collections.sort(list,(o1,o2) ->{
            if(map.get(o1) == map.get(o2)) //빈도수가 같을 경우 원래 입력순서 유지
                return index.indexOf(o1) - index.indexOf(o2);
            return Integer.compare(map.get(o2),map.get(o1)); //빈도수가 다를 경우 빈도수 기준으로 내림차순 정렬
        });

        StringBuilder sb = new StringBuilder();
        for(int i : list)
            sb.append(i).append(' ');
        System.out.println(sb);
    }

}