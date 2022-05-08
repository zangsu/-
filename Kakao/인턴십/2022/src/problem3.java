//3. 알고력
import java.util.*;

public class problem3 {
    /*static int dfs(int myAl, int myCo, int maxAl, int maxCo, int[][] problems) {
        if(myAl >= maxAl && myCo >= maxCo)
            return 0;
        //이번 타임에서 추가적으로 발생한 시간만 계산해서 return 하자.
        //내가 부족한 알고, 코딩력
        int needMaxAl = (maxAl > myAl) ? maxAl - myAl: 0;
        int needMaxCo = (maxCo > myCo)? maxCo - myCo : 0;
        int minTime = needMaxAl + needMaxCo; //minTime 은 시간만으로 부족한 능력을 채우는데 걸리는 시간.
        for(int i = 0; i<problems.length; i++){
            int needAl =  (problems[i][0]-myAl) > 0?  (problems[i][0]-myAl) : 0;//각 문제를 풀기 위해 시간을 투자해 올려야 하는 능력들
            int needCo = (problems[i][1] - myCo)>0? (problems[i][1] - myCo) : 0;
            int needTIme =needAl + needCo + problems[i][4];//각 문제를 풀기 전 필요한 시간 + 푸는데 걸리는 시간
            int partMyAl = myAl >= problems[i][0]? myAl + problems[i][2]: problems[i][0]+ problems[i][2]; //풀고 나서 나의 능력치
            int partMyCo = myCo >= problems[i][1]? myCo + problems[i][3]: problems[i][1]+ problems[i][3];

            //각 문제를 풀고 나서도 아직 부족하다면, 문제를 더 푼다.
            if(partMyAl < maxAl | partMyCo < maxCo) {
                needTIme = dfs(partMyAl, partMyCo, maxAl, maxCo, problems) + needTIme;
            }
            if(needTIme < minTime)
                minTime = needTIme;
        }
        return minTime;
    }*/
    /* 지금까지 걸린 총 시간을 반환
     *
     */
    static int dfs(int nowAl, int nowCo, int maxAl, int maxCo, int time, int[][] problem, int Min){
        //시간만 쓸 때.
        if(nowAl >= maxAl && nowCo >= maxCo)
            return time;
        else if(Min < time)//이후 과정을 반복하는 것이 의미없음
            return Min;
        int needAl = nowAl < maxAl? maxAl-nowAl: 0;//내 알고력이 필요 알고력보다 작다면 그 차이만큼, 아니라면 0만큼의 시간이 필요
        int needCo = nowCo < maxCo? maxCo-nowCo: 0;//내 알고력이 필요 알고력보다 작다면 그 차이만큼, 아니라면 0만큼의 시간이 필요
        int minTime = time +  needAl + needCo;
        for(int i = 0; i<problem.length; i++)//각 문제를 한 문제 풀고나서의 알코력과 시간
        {
            int ntsAl = nowAl < problem[i][0] ? problem[i][0] - nowAl : 0; //문제를 풀 기 위해 알고력을 높여야 하는 시간
            int ntsCo = nowCo < problem[i][1] ? problem[i][1] - nowCo : 0;
            int ntsTime = ntsAl + ntsCo;
            //문제를 풀기 직전의 나의 상태
            int solAl = nowAl < problem[i][0] ? problem[i][0] : nowAl;
            int solCo = nowCo < problem[i][1] ? problem[i][1] : nowCo;

            if (solAl >= maxAl && solCo >= maxCo) {
                if (time + ntsTime < minTime)
                    minTime = time + ntsTime;
            }
            //문제를 풀고 나서의 상태
            else{
                    int nextTime = dfs(solAl+ problem[i][2], solCo + problem[i][3], maxAl, maxCo, time + ntsTime + problem[i][4], problem, minTime);
                    if(minTime > nextTime)
                        minTime = nextTime;
                }
        }

        return minTime;
    }
    public static int solution(int alp, int cop, int[][] problems) {
        int maxAl = 0, maxCo = 0, time = 0;
        for(int i = 0; i<problems.length; i++){
            if(problems[i][0] > maxAl)
                maxAl = problems[i][0];
            if (problems[i][1] > maxCo)
                maxCo = problems[i][1];
        }
        int needAl = maxAl >alp? maxAl-alp : 0;
        int needCo = maxCo >cop? maxCo-cop : 0;

        int MinTime = (maxAl - alp) + (maxCo - cop);
        time = dfs(alp, cop, maxAl, maxCo, 0,  problems, MinTime);
        MinTime = MinTime < time?  MinTime:  time;
        return MinTime;
    }

    public static void main(String[] args) {
        int[][] problem = {{90, 90, 0, 0, 100}, {0, 1, 90, 90, 10}, {0, 1, 90, 89, 1}};
        System.out.println(solution(0, 0, problem));
    }
}
