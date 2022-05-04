import java.util.*;

public class problem3 {
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
    public static int solution(String[] user_id, String[] banned_id) {
        ArrayList<String> Userset = new ArrayList<String>();
        ArrayList<String> bannedSet = new ArrayList<String>();
        ArrayList<Integer> dup = new ArrayList<Integer>();
        int dupCnt = 0;



        for(int i = 0; i< user_id.length; i++)
            Userset.add(user_id[i]);
        for(int i = 0; i<banned_id.length; i++)
            bannedSet.add(banned_id[i]);
        Collections.sort(bannedSet);
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
        int answer =  FindCase(Userset, bannedSet);
        for(int i = 0 ;i<dup.size(); i++)
            for(int j = dup.get(i);j>1; j--)
                answer /= j;
        return answer;
    }

    public static void main(String[] args) {
        String[] user1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned1 = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user1, banned1));

    }
}
