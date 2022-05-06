//오픈채팅방
import java.util.*;
public class problem1 {

    public String[] solution(String[] record) {
        ArrayList<String> AnswerMessage = new ArrayList<String>();
        HashMap<String, String> table = new HashMap<String, String>(record.length);
        for(int i = 0; i<record.length; i++)
        {
            String[] message = record[i].split(" ");
            if(message[0].equals("Leave"))
                continue;
            else
                table.put(message[1], message[2]);
        }

        for(int i = 0; i<record.length; i++)
        {
            String[] message = record[i].split(" ");
            if(message[0].equals("Change"))
                continue;
            String line = table.get(message[1]) + "님이 ";
            if(message[0].equals("Enter"))
                line+="들어왔습니다.";
            else
                line+= "나갔습니다.";
            AnswerMessage.add(line);
        }
        return AnswerMessage.toArray(new String[AnswerMessage.size()]);
    }

    //다른사람 코드를 보다보니 해시맵보다 클래스를 쓴 풀이가 더 좋다는 의견이 많던데, 왜그런걸까
}
