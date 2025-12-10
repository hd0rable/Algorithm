import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static ArrayList<int[]> chickenHousePos = new ArrayList<>();
    static ArrayList<int[]> selectCH = new ArrayList<>();
    static ArrayList<int[]> housePos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) housePos.add(new int[]{i,j});
                if(arr[i][j] == 2)
                    chickenHousePos.add(new int[]{i,j}); //치킨집 좌표 x,y
            }
        }
        bt(0,0);
        System.out.println(min);
    }

    static void bt(int selectCnt,int at){
        if(selectCnt == m){
            int distanceSum = calculateDistanceSum();
            min = Math.min(distanceSum,min);
            return;
        }

        for(int i=at; i<chickenHousePos.size(); i++){
            selectCH.add(chickenHousePos.get(i)); // 선택
            bt(selectCnt+1,i+1);
            selectCH.remove(chickenHousePos.get(i)); // 선택 해제
        }
    }

    static int calculateDistanceSum(){
        int distanceSum = 0;
        for (int[] ch : housePos) {
            int hx = ch[0]; int hy = ch[1];
            int minDistance = Integer.MAX_VALUE;
            for (int[] cc : selectCH) { //선택된 치킨집들중에서 최소 거리 구하기
                int cx = cc[0]; int cy = cc[1];
                int result = Math.abs(hx - cx) + Math.abs(hy - cy);
                minDistance = Math.min(minDistance, result);
            }
            distanceSum += minDistance;
        }
        return distanceSum;
    }
}