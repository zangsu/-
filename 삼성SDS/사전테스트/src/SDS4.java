//DP인것같아서 빠르게 달려옴

/*
내일 일어나면 할 일
1. 두번쨰 입력이 각 라인의 정거장 수임을 고려해 다시 input 짜기.
2.DP -> 환승 횟수를 하나씩 늘려가면서 해당 라인에 end가 있으면 break
따지고 보니까 DP는 아니었는지도,,,
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class SDS4 {
    public static void Scan_Input(BufferedReader br, int Test_num) throws IOException {
        for(int test = 0; test<Test_num; test++){

            //입력단계
            String input_line = br.readLine();
            String[] line_split = input_line.split(" ");
            int stop_num = Integer.parseInt(line_split[0]);
            int line_num = Integer.parseInt(line_split[1]);
            int start_stop = Integer.parseInt(line_split[2]);
            int end_stop = Integer.parseInt(line_split[3]);
            int[] line_len = new int[line_num];

            input_line = br.readLine();
            line_split = input_line.split(" ");
            for(int line = 0; line<line_num; line++)
                line_len[line] = Integer.parseInt(line_split[line]);

            int[][] subway = new int[line_num][];
            for(int line = 0; line<line_num; line++){
                subway[line] = new int[line_len[line]];
                input_line = br.readLine();
                line_split = input_line.split(" ");
                for(int stop = 0; stop<line_len[line]; stop++)
                    subway[line][stop] = Integer.parseInt(line_split[stop]);
            }//입력 완료

            //데이터 전처리
            int[][] contained_line = new int[stop_num+1][];
            for(int stop = 1; stop<=stop_num; stop++)
                contained_line[stop] = new int[line_num];//해당 정거장이 몇호선에 위치했는지 저장
            for(int line = 0; line<line_num; line++)
            {
                for(int stop : subway[line]){
                    contained_line[stop][line] = 1;//포함된 호선은 1로 저장
                }
            }
            HashSet<Integer> visited_line = new HashSet<Integer>();//방문한 호선 저장

            //문제풀이
            int find = 0;
            Queue<Integer> next_line = new LinkedList<Integer>();//다음번에 방문 할 호선 큐
            for(int start_line = 0; start_line<line_num; start_line++)
            {
                if(contained_line[start_stop][start_line] == 1) {
                    for(int stop : subway[start_line]) {
                        if (stop == end_stop) {
                            find = 1;//시작한 정거장의 노선에 도착 정거장이 있는경우}
                            start_line = line_num;
                            break;
                        }
                    }
                    next_line.add(start_line);
                    visited_line.add(start_line);
                }
            }//시작 정거장이 위치한 호선 추가

            int time = 0;
            while(find == 0 && !next_line.isEmpty()){
                int thistime_loop = next_line.size();
                for (int loop = 0; loop < thistime_loop; loop++) {
                    int thistime_line = next_line.poll();
                    for (int stop : subway[thistime_line]) {
                        if(end_stop == stop)
                        {
                            find = 1;
                            loop = thistime_loop;
                            break;
                        }
                        else{
                            for(int line = 0; line<line_num; line++){
                                if(contained_line[stop][line] == 1 &&!visited_line.contains(line)){
                                    visited_line.add(line);
                                    next_line.add(line);
                                }
                            }
                        }
                    }
                }//각 환승횟수의 case 종료

                if(find == 0)
                    time++;
            }

            if(find == 1)
                System.out.printf("#%d %d\n", test+1, time);
            else
                System.out.printf("#%d -1\n", test+1);


        }//여기까지가 한 테스트케이스
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line.contains("txt"))
            ;
        else
            Scan_Input(br, Integer.parseInt(line));
    }
}
