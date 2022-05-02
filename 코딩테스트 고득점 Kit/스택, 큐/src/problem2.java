import java.util.*;
public class problem2 {
    public static int solution(int[] priorities, int location) {
        int target = priorities[location];//타겟의 중요도.
        int[] dup = new int[9];//각 중요도 별 작업개수 저장
        int FirstJob = 0;//나보다 중요도가 높은 작업들의 개수 저장
        int FirstLocation = location;//target의 첫 위치
        int turn = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i : priorities){
            queue.add(i);
            dup[i-1]++;
        }
        for(int i = target; i<9; i++)
            FirstJob += dup[i];
        for(int i = 0; i<priorities.length; i++)
        {
            int queueHead = queue.poll();
            if(FirstJob != 0) {//중요도 높은 게 있는경우
                if (queueHead > target) {
                    turn++;
                    FirstJob--;

                    if (i < FirstLocation)
                        location--;
                }
                else
                    queue.add(queueHead);
            }
            else{//중요도 높은게 없는경우
                if(queueHead== target){
                    if(i != FirstLocation) {
                        turn++;
//                        if(i < FirstLocation)
//                            location--;
                    }
                    else
                        return turn+1;
                }
                else{
                    queue.add(queueHead);
                }
            }
        }
        for(int i = 0; i<location; i++)
        {
            if(queue.isEmpty())
                break;
            int queueHead = queue.poll();
            if(queueHead == target)
                turn++;
        }
        return turn+1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 2, 9, 3, 3};
        System.out.println(solution(numbers, 3));
    }
}
