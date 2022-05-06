//후보키
import java.util.*;

public class probelm3 {

    //검증완료
    static HashSet<String> MakeSubset(String s, HashSet<String> set){
        if(s.length() == 1)
            return set;
        for(int i = 0; i<s.length(); i++) {
            String substring = s.substring(0, i) + s.substring(i + 1, s.length());
            set.add(substring);
            set = MakeSubset(substring, set);
        }
        return set;
    }
    static boolean isMin(String s, HashSet<String> set){
        HashSet<String> subset = new HashSet<String>();
        subset = MakeSubset(s, subset);

        Iterator itor = subset.iterator();
        while(itor.hasNext())
            if(set.contains(itor.next()))
                return false;
        return true;
    }

    static HashSet<String> CheckCandi(String[][] relation, String s, HashSet<String> set){//(relation, 만들 후보키의 길이, 지금까지의 후보키의 집합)
        //s가 최소성을 만족하지 못하는 경우
        if(!isMin(s, set))
            return set;
        //만족한다면 유일성을 확인할 차례
        else {
            HashSet<String> uniqueSet = new HashSet<String>();
            String[] checkIndex = s.split("");
            String[] checkLine = new String[relation.length];
            for (int i = 0; i < relation.length; i++) {
                checkLine[i] = "";
                for (int j = 0; j < checkIndex.length; j++) {
                    checkLine[i] += (relation[i][Integer.parseInt(checkIndex[j])] + "/");
                }
                if (!uniqueSet.contains(checkLine[i]))
                    uniqueSet.add(checkLine[i]);
                else
                    return set;
            }
        }
        set.add(s);
        return set;
    }
    public static int solution(String[][] relation) {
        String key = "";
        for(int i = 0; i<relation[0].length; i++)
            key += Integer.toString(i);
        HashSet<String> keyCand = new HashSet<String>();
        HashSet<String> Candidate = new HashSet<String>();

        keyCand = MakeSubset(key, keyCand);
        keyCand.add(key);
        //참고 : subString에 s자신은 안들어간다.

        for(int i = 1; i<=relation[0].length; i++){
            Iterator iter = keyCand.iterator();
            while(iter.hasNext()){
                String temp = iter.next().toString();
                if(temp.length() == i)
                    Candidate = CheckCandi(relation, temp, Candidate);
            }
        }

        return Candidate.size();

    }
    public static void main(String[] args) {
        String[][] relation = {{"a", "aa"},{"aa", "a"}, {"a", "a"}};
        System.out.println(solution(relation));
    }
}
