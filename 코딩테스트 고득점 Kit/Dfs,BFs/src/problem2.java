import java.util.*;
public class problem2 {

    public int solution(int n, int[][] computers) {//n은 결국 computers.length아닌가
        int[] conn = new int[computers.length];
        int answer = 0;
        for (int i = 0; i < computers.length; i++) {//upper triangle에서 row탐색
            if (conn[i] == 0)//새로운 네트워크
            {
                Queue<Integer> queue = new LinkedList<Integer>();//Queue가 인터페이슨데, 굳이 Queue로 정의를 시작할 필요 있나? 걍 LinkedList로 정의 시작하는게 맞지 않나 그럼
                queue.add(i);
                conn[i] = 1;
                answer++;

                //Bfs 구현
                while(queue.isEmpty() == false){
                    int node = queue.poll();
                    for(int j = node+1; j<computers.length; j++)
                        if(computers[node][j] ==1 && conn[j] == 0) {
                            queue.add(j);
                            conn[j] = 1;
                        }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = { {1,1,0}, {1,1,1}, {0,1,1}};
        //System.out.println(solution(3,computers));

    }
}
