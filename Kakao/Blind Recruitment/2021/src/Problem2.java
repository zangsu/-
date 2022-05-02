import java.sql.Array;
import java.util.*;
public class Problem2 {

    class node{
        String s;
        int count;
        node(String line){
            this.s = line;
            this.count = 0;
        }
    }
    class nodeList<E> extends ArrayList<E>{
        nodeList<E> findnode(String s){
            for(int i = 0; i<this.size(); i++){


            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<String>();//course 에 있는 수만큼의 길이의 문자열들 삽입
        ArrayList<Integer> listCount = new ArrayList<Integer>();
        ArrayList<String> ansList = new ArrayList<String>();//메뉴판 후보들 삽입
        int ListLen;

        for(int i = 0; i<orders.length; i++)
        {
            ListLen = course.length-1;
            StringBuilder sb = new StringBuilder();
            if(orders[i].length() < course[ListLen])
                continue;
            else if(orders[i].length() == course[ListLen])
            {
                if(list.contains(orders[i]) == false){
                    list.add(orders[i]);
                    listCount.add(0);
                    continue;
                }//처음나온 문자열이므로 메뉴 후보에 넣을 후보에 넣음
                else{
                    int index = list.indexOf(orders[i]);
                    if(listCount.get(index) == 0){
                        ansList.add(orders[i]);
                        listCount.remove(index);
                        listCount.add(index, 1);
                        continue;
                    }//메뉴 후보에 넣을 후보에 있으므로 메뉴 후보에 넣음
                    else
                        continue;//이미 메뉴후보에 넣은 조합이므로 넘어감
                }
            }
            else{
                for(int j = 0; j<orders[i].length(); j++){

                }

            }

        }
        String[] answer = {};
        return answer;
    }
}
