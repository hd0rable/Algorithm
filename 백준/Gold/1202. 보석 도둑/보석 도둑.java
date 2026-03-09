import java.io.*;
import java.util.*;
class Jewelry implements Comparable<Jewelry>{
    int mass;
    int value;

    Jewelry(int mass,int value) {
        this.mass = mass;
        this.value = value;
    }

    @Override
    public int compareTo(Jewelry o){
        // 가격 내림차순
        if(this.value != o.value){
            return o.value-this.value;
        }
        //무게 오름차순(가벼운거 부터)
        return this.mass-o.mass;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(m, v);
        }
        Arrays.sort(jewelries);

        TreeMap<Integer, Integer> bags = new TreeMap<>();
        while (k-- > 0) {
            int c = Integer.parseInt(br.readLine());
            bags.put(c, bags.getOrDefault(c, 0) + 1);
        }

        long totalValue = 0;
        for (Jewelry j : jewelries) {
            // 이 보석의 무게보다 크거나 같은 가방 중 가장 작은 무게 찾기
            Integer weight = bags.ceilingKey(j.mass);

            if (weight != null) {
                totalValue += j.value;
                // 가방 하나 사용 (개수 줄이기)
                if (bags.get(weight) == 1) {
                    bags.remove(weight);
                } else {
                    bags.put(weight, bags.get(weight) - 1);
                }
            }
        }
        System.out.print(totalValue);
    }
}
