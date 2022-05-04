//4. 경주로 건설
import java.util.*;
public class problem4 {
    class node{
        int row;
        int col;
        String dir;//hor or ver or both

        node(int a, int b){
            this.row = a;
            this.col = b;
        }
    }
    public int solution(int[][] board) {
        Queue<node> queue = new LinkedList<node>();
        queue.add(new node(0, 0));
        int[][] cost = new int[board.length][board.length];

        while(!queue.isEmpty()){
            node currentNode = queue.poll();

        }

        int answer = 0;
        return answer;
    }
}
