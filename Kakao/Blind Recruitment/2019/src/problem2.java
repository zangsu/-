//실패율
import java.util.*;
public class problem2 {
    public static int[] solution(int N, int[] stages) {
        ArrayList<Double> failList = new ArrayList<Double>();
        ArrayList<Integer> stageList = new ArrayList<Integer>();
        int[] answer = new int[N];
        HashMap<Integer, Double> stageMap = new HashMap<Integer, Double>();
        for(int i : stages)
            stageList.add(i);
        for(int i = 1; i<=N; i++)
            if(!stageList.contains(i)) {
                stageMap.put(i, 0.0);
                failList.add(0.0);
            }
        Collections.sort(stageList);
        int StageCnt = 1;
        int ArriveUser = stageList.size();
        int i = 0, newUser = stageList.size();
        for(; i<stageList.size()-1; i++){
            if(stageList.get(i) == stageList.get(i+1))
                StageCnt++;
            else
            {
                double fail = (double)StageCnt/newUser;
                newUser = stageList.size() - (i+1);
                stageMap.put(stageList.get(i), fail);
                failList.add(fail);
                StageCnt = 1;
            }
        }
        double fail = (double)StageCnt/(ArriveUser-1-i+StageCnt);
        stageMap.put(stageList.get(i), fail);
        failList.add(fail);
        StageCnt = 1;

        Collections.sort(failList);

        int cnt = 0;
        i = failList.size()-1;
        for(; i>=0; i--)
        {
            if(i >0 && failList.get(i).equals(failList.get(i-1)))
                continue;
            for(int j = 1; j<=N; j++){
                if(cnt >= answer.length)
                    break;
                if(stageMap.get(j).equals(failList.get(i))){
                    answer[cnt++] = j;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] stages = {1,2,3,4,5,6,7};
        int[] answer = solution(8, stages);
        for(int i : answer)
            System.out.println(i);
    }
}
