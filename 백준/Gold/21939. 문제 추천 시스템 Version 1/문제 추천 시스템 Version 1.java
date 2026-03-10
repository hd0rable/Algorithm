//https://www.acmicpc.net/problem/21939
import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem>{
    int id, level;

    Problem(int id, int level){
        this.id = id;
        this.level = level;
    }

    @Override
    public int compareTo(Problem o){
        if(this.level != o.level)
            return this.level - o.level; //난이도 오름차순
        return this.id - o.id; // 난이도 같으면 문제번호 오름차순
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        TreeSet<Problem> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>(); //문제번호, 난이도
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Problem(p,l));
            map.put(p, l);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd){
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 1) sb.append(set.last().id);
                    else sb.append(set.first().id);
                    sb.append('\n');
                    break;
                case "add" :
                    int p1 = Integer.parseInt(st.nextToken());
                    int l1 = Integer.parseInt(st.nextToken());
                    set.add(new Problem(p1, l1));
                    map.put(p1, l1);
                    break;
                case "solved" :
                    int p2 = Integer.parseInt(st.nextToken());
                    int l2 = map.get(p2);
                    set.remove(new Problem(p2, l2));
                    map.remove(p2);
                    break;
            }
        }
        System.out.println(sb);
    }
}
