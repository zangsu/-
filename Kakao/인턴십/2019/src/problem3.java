import java.util.*;

public class problem3 {

    /*FindCase : 재귀적으로 구현된 매칭 경우의수를 찾는 함수.
     *
     *@param : ArrayList<String> 타입의 user아이디와 banned아이디.
     *
     * @return : banned의 첫 아이디와 각 user 아이디가 매칭되는 상황에서 나올 수 있는 모든 케이스의 수 반환
     */
    static int FindCase(ArrayList<String> user, ArrayList<String> banned){
        int caseCnt = 0;
        if(banned.size() == 0)
            return 0;
        else if(banned.size() == 1)
        {
            for(int i = 0; i<user.size(); i++){
                if(isDif(user.get(i), banned.get(0))) {
                    caseCnt++;
                }
            }
            return caseCnt;
        }
        else{
            int isMatched = 0;
            for(int i = 0; i<user.size(); i++){
                //banned 아이디와 user아이디가 매칭이 될 수 있다면, 매칭을 시킨 후 다음 케이스 탐색을 위해 매칭 된 아이디가 삭제 된 ArrayList를 재귀적으로 전달.
                if(isDif(user.get(i), banned.get(0))) {
                    isMatched = 1;
                    ArrayList<String> newUser = new ArrayList<String>();
                    ArrayList<String> newBanned = new ArrayList<String>();
                    newUser.addAll(user);
                    newBanned.addAll(banned);
                    newUser.remove(i);
                    newBanned.remove(0);
                    caseCnt += FindCase(newUser, newBanned);
                }
            }
            if(isMatched == 0)
                return 0;
        }
        return caseCnt;
    }

    /*isDif : banned된 아이디와 user 아이디를 매칭 할 수 있는지 확인 해주는 함수.
     *
     *@param : String타입의 user 아이디와 banned 아이디
     *
     * return : 매칭이 된다면 true, 아니라면 false를 반환
     */
    static boolean isDif(String user, String banned){
        if(user.length() != banned.length())
            return false;
        else{
            String[] userId = user.split("");
            String[] bannedId= banned.split("");
            for(int i = 0; i<user.length(); i++){
                if(bannedId[i].equals("*"))
                    continue;
                else{
                    if(!bannedId[i].equals(userId[i]))
                        return false;
                }
            }
        }
        return true;
    }

    /*문제 풀이 방식
     *  재귀함수로 구현.
     *  각 재귀 단계마다 banned의 가장 첫 원소에 해당 될 수 있는 user id를 매칭시킨다.
     *  다음 재귀단계로 매칭 된 원소들을 제외 한 ArrayList를 전달한다.
     *  -> 위의 단계를 반복해서 진행하다가, banned의 원소가 하나가 남았을 때는 해당 원소에 매칭될 수 있는 남은 모든 user id의 수를 반환한다.
     *
     *  위의 경우 banned안에 중복된 아이디가 있을 경우 그만큼 중복해서 경우가 카운트 된다.
     *  -> 중복된 아이디의 수가 n개라면 n!만큼의 중복되는 경우가 생긴다.
     *  이를 해결하기 위해 banned를 사전순으로 정렬시키고, 중복되는 아이디의 수를 각각 저장한 다음 마지막에 해당 케이스들을 나누어 준다.
     *
     */
    public static int solution(String[] user_id, String[] banned_id) {
        ArrayList<String> Userset = new ArrayList<String>();
        ArrayList<String> bannedSet = new ArrayList<String>();
        ArrayList<Integer> dup = new ArrayList<Integer>();
        int dupCnt = 0;

        //각 원소들을 handling하기 쉽게 만들기 위해 ArrayList에 넣는다.
        for(int i = 0; i< user_id.length; i++)
            Userset.add(user_id[i]);
        for(int i = 0; i<banned_id.length; i++)
            bannedSet.add(banned_id[i]);
        Collections.sort(bannedSet);

        //banned된 아이디 중 중복되는 원소들의 개수를 찾는다.
        for(int i = 0; i<bannedSet.size() - 1; i++)
        {
            if(bannedSet.get(i).equals(bannedSet.get(i+1)))
            {
                dupCnt++;
            }
            else if(dupCnt != 0){
                dup.add(dupCnt+1);
                dupCnt = 0;
            }
        }
        if(dupCnt != 0){
            dup.add(dupCnt+1);
            dupCnt = 0;
        }

        //재귀함수에 전달.
        int answer =  FindCase(Userset, bannedSet);

        //중복되는 case들을 해결해준다.
        for(int i = 0 ;i<dup.size(); i++)
            for(int j = dup.get(i);j>1; j--)
                answer /= j;
        return answer;
    }

    public static void main(String[] args) {
        String[] user1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned1 = { "*****", "******"};
        System.out.println(solution(user1, banned1));

    }
}
