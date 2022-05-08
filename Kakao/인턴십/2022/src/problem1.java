import java.util.*;
public class problem1 {
    static HashMap<String, Integer> sumMbti(String s, int choice, HashMap<String, Integer> mbti) {
        int number = 0;
        String subS = "";
        if(choice == 4)
            return mbti;
        if(choice > 4){
            subS = s.substring(1);
            number = choice - 4;
        }
        else if(choice < 4){
            subS = s.substring(0, 1);
            number = 4 - choice;
        }

        if(!mbti.containsKey(subS))
            mbti.put(subS, number);
        else
            mbti.replace(subS, mbti.get(subS) + number);

        return mbti;
    }
    public static String solution(String[] survey, int[] choices) {

        String answer = "";
        HashMap<String, Integer> mbti = new HashMap<String, Integer>();

        for(int i = 0; i<survey.length; i++)
            mbti = sumMbti(survey[i], choices[i], mbti);

        //R/T
        if(mbti.containsKey("R") && mbti.containsKey("T"))
        {
            answer += mbti.get("R") < mbti.get("T")? "T": "R";
        }
        else{
            answer += mbti.containsKey("T")? "T" : "R";
        }

        //C, F
        if(mbti.containsKey("C") && mbti.containsKey("F"))
        {
            answer += mbti.get("C") < mbti.get("F")? "F": "C";
        }
        else{
            answer += mbti.containsKey("F")? "F" : "C";
        }

        //J, M
        if(mbti.containsKey("J") && mbti.containsKey("M"))
        {
            answer += mbti.get("J") < mbti.get("M")? "M": "J";
        }
        else{
            answer += mbti.containsKey("M")? "M" : "J";
        }


        //A, N
        if(mbti.containsKey("A") && mbti.containsKey("N"))
        {
            answer += mbti.get("A") < mbti.get("N")? "N": "A";
        }
        else{
            answer += mbti.containsKey("N")? "N" : "A";
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] ft = {"TR", "RT", "TR"};
        int[] sc = {7, 1, 3};
        solution(ft, sc);
    }
}
