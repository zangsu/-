//위장
import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class problem3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clo = new HashMap<String, Integer>();
        for(String[] s : clothes){
            if(!clo.containsKey(s[1]))
                clo.put(s[1], 1);
            else
                clo.replace(s[1], clo.get(s[1])+1);
        }
        for(Integer i : clo.values())
            answer*= i+1;
        return answer-1;
    }
}
