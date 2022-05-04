import java.lang.reflect.Array;
import java.util.*;
public class problem3 {
    public int[] solution(String[] gems) {
        HashSet<String> gemSet = new HashSet<String>();
        for(int i = 0; i<gems.length; i++)
            gemSet.add(gems[i]);
        ArrayList<String> gemList = new ArrayList<String>();
        gemList.addAll(gemSet);
        for(int i = 0; i<gemList.size(); i++)
            System.out.println(gemList.get(i));
        int[] answer = {};
        return answer;
    }
}
