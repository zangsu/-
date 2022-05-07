//완주하지 못한 선수
import java.util.*;
public class problem1 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> user = new HashMap<String, Integer>();
        String answer = "";
        for(String s : completion){
            if(user.containsKey(s)){
                int num = user.get(s)+1;
                user.replace(s, num);
            }
            else
                user.put(s, 1);
        }

        for(String s : participant){
            if(!user.containsKey(s)) {
                answer = s;
                break;
            }
            else if(user.get(s) == 1)
                user.remove(s);
            else{
                int num = user.get(s)-1;
                user.replace(s, num);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden" };
        String[] comp = {"eden", "kiki"};
        solution(part, comp);
    }
}
