//등산로
import java.util.*;
public class problem4 {
    static int findPath( HashSet<Integer> in, HashSet<Integer> top, int current, HashSet<Integer> visited, int[][] path){
        if(in.contains(current))
            return 0;
        visited.add(current);
        int minPath = 50000;
        for(int i = 0; i<path.length; i++){//근처 경로 전부 탐색 -> 근처 경로를 중심으로 하는 가장 작은 path 찾기
           /* if(path[i][0] == current && !visited.contains(path[i][0]))//근처 경로들에 대해서
            {
                if(findPath(in, top, path[i][0] , visited, path) == 0)//등산로 입구에 도달 ->
                {
                    if(minPath == -1)
                        minPath = path[i][2];
                    else
                        if(minPath > path[i][2])
                            minPath = path[i][2];
                }
                else{

                }
            }
            else if(path[i][1] == current){

            }*/
            if(path[current][i] != 0 && !visited.contains(i)){
                if(minPath == 50000) {
                    if (in.contains(i)) {
                        if (path[current][i] < minPath)
                            minPath = path[current][i];
                    } else {
                        if (minPath > Math.max(path[current][i], findPath(in, top, i, visited, path))) {
                            minPath = findPath(in, top, i, visited, path) > path[current][i] ? findPath(in, top, i, visited, path) : path[current][i];
                        }
                    }
                }
                else if(in.contains(i)) {
                    if (path[current][i] < minPath)
                        minPath = path[current][i];
                }
                else{
                    if(minPath > Math.max(path[current][i], findPath(in, top, i, visited, path))){
                        minPath = findPath(in, top, i, visited, path) > path[current][i]? findPath(in, top, i, visited, path): path[current][i];
                    }
                }

            }
        }

        return minPath;

    }
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        HashMap<String, Integer> path = new HashMap<String, Integer>();
        HashSet<Integer> in = new HashSet<Integer>();
        HashSet<Integer> top = new HashSet<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int i : gates)
            in.add(i);
        for(int i : summits)
            top.add(i);
        /*for(int[] s : paths){//각 경로를 5-4 : 2 , 4-5 : 2 처럼 출발점과 도착점, 거리 순으로 저장
            String a = Integer.toString(s[0]) + "-" + Integer.toString(s[1]);
            String b = Integer.toString(s[1]) + "-" + Integer.toString(s[0]);
            path.put(a, s[2]);
            path.put(b, s[2]);
        }*/

        int[][] list = new int[paths.length][paths.length];
        for(int  i = 0; i<paths.length; i++){
           if(list[paths[i][0]][paths[i][1]] == 0){
               list[paths[i][0]][paths[i][1]] = paths[i][2];
           }
            if(list[paths[i][1]][paths[i][0]] == 0){
                list[paths[i][1]][paths[i][0]] = paths[i][2];
            }
        }
        int min = 5000, minNode = 0;
        Iterator iter = top.iterator();
        while(iter.hasNext()){
            int node = (int)iter.next();
            if(min == -1)
                min = findPath(in, top, node, visited, list);
            else{
                if(min > findPath(in, top, node, visited, list)) {
                    min = findPath(in, top, node, visited, list);
                    minNode = node;
                }
            }
        }

        int[] answer =   {minNode, min};
        return answer;
    }

    public static void main(String[] args) {
        int[][] path = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gate = {1, 3};
        int[] sub = {5};

        int[] answer = solution(6, path,gate, sub);
        for(int i : answer)
            System.out.println(i);
    }
}
