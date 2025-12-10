import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static ArrayList<int[]> chickenHousePos = new ArrayList<>();
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
                    chickenHousePos.add(new int[]{i,j,0}); //치킨집 좌표 x,y 선택되었는지 여부(0,1)
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
            int[] cur = chickenHousePos.get(i);
            int x = cur[0]; int y = cur[1];
            chickenHousePos.set(i,new int[]{x,y,1}); // 선택 표시
            bt(selectCnt+1,i+1);
            chickenHousePos.set(i,new int[]{x,y,0}); // 선택 해제
        }
    }

    static int calculateDistanceSum(){
        int distanceSum = 0;
        for(int i = 0; i <housePos.size(); i++){
            int[] ch = housePos.get(i);
            int hx = ch[0]; int hy = ch[1];
            int minDistance = Integer.MAX_VALUE;
            for(int j = 0; j <chickenHousePos.size(); j++){ //선택된 치킨집들중에서 최소 거리 구하기
                int[] cch = chickenHousePos.get(j);
                int cx = cch[0]; int cy = cch[1]; int isSelected = cch[2];
                if(isSelected == 0) continue;
                int result = Math.abs((hx+1)-(cx+1)) + Math.abs((hy+1)-(cy+1));
                minDistance = Math.min(minDistance,result);
            }
            distanceSum += minDistance;
        }
        return distanceSum;
    }

}