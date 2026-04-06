import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        ArrayList<Member> list= new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Member(x,y));
        }

        StringBuilder sb = new StringBuilder();
        // 모든 사람 i에 대해
        for (int i = 0; i < n; i++) {
            int rank = 1; // 기본 등수는 1등부터 시작

            // 다른 모든 사람 j와 비교
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // j가 i보다 확실히 덩치가 큰 경우에만 등수 증가
                if (list.get(j).weight > list.get(i).weight &&
                        list.get(j).height > list.get(i).height) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.print(sb);
    }

    public static class Member{
        int weight;
        int height;

        Member(int w, int h){
            this.weight = w;
            this.height = h;
        }

    }

}
