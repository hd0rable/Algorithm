import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>(); //장르, 총 스트리밍 횟수
        Map<String, List<Integer>> idxMap = new HashMap<>(); //장르, 장르별 인덱스
        int n = genres.length;
        for(int i=0; i<n; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            idxMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }
        
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((a,b) -> {
            return genreMap.get(b) - genreMap.get(a); //장르 별 카운팅 많은 순으로 정렬
        });
        
        List<Integer> answer = new ArrayList<>();
        
        for(String genre : genreList){
            List<Integer> songList = idxMap.get(genre);
            songList.sort((a,b) -> {
                if(plays[a] == plays[b])
                    return a-b; //재생횟수 같으면 인덱스 작은 순
                else
                    return plays[b] - plays[a]; //노래 재생횟수 많은 순으로 정렬
            });
            for(int i=0; i<Math.min(2,songList.size()); i++){
                answer.add(songList.get(i));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}