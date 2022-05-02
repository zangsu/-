import java.util.*;

public class problem1 {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> retAns = new ArrayList<Integer>();
        int StackTop = 0;
        while(StackTop < progresses.length){
            int cnt = 0;
            int times = (int)Math.ceil((100 - progresses[StackTop])%speeds[StackTop]) + (100 - progresses[StackTop])/speeds[StackTop];
            for(int i = StackTop; i<progresses.length; i++)
                progresses[i] += speeds[i]*times;
            while(StackTop < progresses.length){
                if(progresses[StackTop] >= 100) {
                    cnt++;
                    StackTop++;
                }
                else
                    break;
            }
            retAns.add(cnt);
        }

        int[] answer = new int[retAns.size()];
        for(int i = 0; i<retAns.size(); i++)
            answer[i] = retAns.get(i);
        return answer;
        //return speeds;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = solution(progresses, speeds);
        for(int i : answer)
            System.out.println(i);
    }
}
