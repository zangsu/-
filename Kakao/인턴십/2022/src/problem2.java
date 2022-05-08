import java.util.*;
public class problem2 {
    static int Bfs(Queue<Integer> queue1, Queue<Integer> queue2, int sum1, int sum2, int goal, int level){
        int n1 = queue1.peek();
        int n2 = queue2.peek();
        if(sum1 + n2 == goal || sum2 + n1 == goal)
            return level + 1;
        else{

        }

        return 0;
        //임시 return
    }
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> Queue1 = new LinkedList<Integer>();
        Queue<Integer> Queue2 = new LinkedList<Integer>();
        long sum = 0, max = 0, sum1 = 0, sum2 = 0;
        for(int i : queue1) {
            Queue1.offer(i);
            sum+= i;
            sum1+= i;
            if(max < i)
                max = i;
        }

        for(int i : queue2) {
            sum+= i;
            sum2 += i;
            Queue2.offer(i);
            if(max < i)
        }
        if(max > sum/2)
            return -1;
        int answer = -2;
        return answer;
    }
}
