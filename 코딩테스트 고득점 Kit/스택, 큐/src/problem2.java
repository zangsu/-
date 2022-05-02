import java.util.*;
public class problem2 {
    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int turn = 0;
        int[] dup = new int[9];
        int MVP = 0;//제일 먼저 수행해야 하는 작업
        int target = priorities[location];
        for(int i : priorities) {
            queue.add(i);
            dup[i-1]++;
        }
        for(int i = 8; i>=0; i--)
        {
            if(dup[i] != 0) {
                MVP = i + 1;
                break;
            }
        }
        while(!queue.isEmpty()){
            int queueHead = queue.poll();
            if(queueHead == MVP){
                if(location != 0){
                    location--;
                    turn++;
                    dup[MVP-1]--;
                    if(dup[MVP-1] == 0)
                    {
                        for(int i = MVP-2; i>=0; i--)
                        {
                            if(dup[i] != 0) {
                                MVP = i + 1;
                                break;
                            }
                        }
                    }
                }//출력이 target이 아닌경우
                else//target이 출력 될 경우
                {
                    return turn+1;
                }
            }
            else{
                if(location == 0)
                    location = queue.size();
                else
                    location--;
                queue.add(queueHead);
            }
        }
        return turn+1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 2, 9, 3, 3};
        System.out.println(solution(numbers, 3));
    }
}
