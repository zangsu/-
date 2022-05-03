import java.util.*;

public class problem3 {
    static int DiffChar(String a,String b){
    String[] ca = a.split("");
    String[] cb = b.split("");
    int cnt = 0;
    for(int i = 0; i<a.length(); i++)
        if(!ca[i].equals(cb[i]))
            cnt++;
    return cnt;
}
    public static int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(begin);
        int[] path = new int[words.length];
        int targetIndex = -1;
        int cnt = 0;
        for(int i = 0; i<words.length; i++)
            if(words[i].equals(target)){
                targetIndex = i;
                break;
            }
        if(targetIndex == -1)
            return 0;
        while(!queue.isEmpty()){
            cnt++;
            int loopTime = queue.size();
            for(int i = 0; i<loopTime; i++){
                String tempString = queue.poll();
                for(int j = 0; j<words.length; j++){
                    if(path[j] != 0)
                        continue;
                    else if(DiffChar(tempString, words[j]) == 1){
                        if(j == targetIndex)
                            return cnt;
                        else{
                            queue.add(words[j]);
                            path[j] = cnt;
                        }
                    }

                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", words));
    }
}
