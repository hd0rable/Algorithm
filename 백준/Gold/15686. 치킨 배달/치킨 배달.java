import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int houseCnt = 0;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static ArrayList<int[]> chickenHousePos = new ArrayList<>();

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
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){ //집이라면
                    int minDistance = Integer.MAX_VALUE;
                    for(int k = 0; k <chickenHousePos.size(); k++){ //선택된 치킨집들중에서 최소 거리 구하기
                        int[] cur = chickenHousePos.get(k);
                        int x = cur[0]; int y = cur[1]; int isSelected = cur[2];
                        if(isSelected == 0) continue;
                        int result = Math.abs((i+1)-(x+1)) + Math.abs((j+1)-(y+1));
                        minDistance = Math.min(minDistance,result);
                    }
                    distanceSum += minDistance;
                }
            }
        }
        return distanceSum;
    }

}