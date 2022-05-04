import java.util.*;

public class problem4 {
    public String[] solution(String[][] tickets) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i<tickets.length; i++) {
            list.add(tickets[i][0]);
            list.add(tickets[i][1]);
        }
        Collections.sort(list);
        for(int i = 0; i<list.size()-1; i++)
            if(list.get(i).equals(list.get(i+1)))
                list.remove(i--);
        int nodeNumber = list.size();
        int[] pathIn = new int[nodeNumber];
        int[] pathOut = new int[nodeNumber];

        for(int i = 0; i< tickets.length; i++){
            pathIn[list.indexOf(tickets[i][0])]++;
            pathOut[list.indexOf(tickets[i][1])]++;
        }
    }
}
