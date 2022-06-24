//DP인것같아서 빠르게 달려옴

/*
내일 일어나면 할 일
1. 두번쨰 입력이 각 라인의 정거장 수임을 고려해 다시 input 짜기.
2.DP -> 환승 횟수를 하나씩 늘려가면서 해당 라인에 end가 있으면 break
따지고 보니까 DP는 아니었는지도,,,
 */
import javax.sound.sampled.Line;
import java.awt.geom.NoninvertibleTransformException;
import java.util.*;
public class SDS4 {
    public static void Scan_Input(Scanner sc, int Test_num){
        for(int test = 0; test<Test_num; test++){
            //입력단계
            int stop_num = sc.nextInt();
            int s_line = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            int[] line_len = new int[s_line];
            for(int line = 0; line<s_line; line++)
                line_len[line] = sc.nextInt();

            //LinkedList<LinkedList> subway_set = new LinkedList<>();
            //LinkedList<Integer>[] subway_set = new LinkedList[s_line];
            for(int line = 0; line<s_line; line++){
                //subway_set[line] = new LinkedList<Integer>();
                //subway_set.add(line,new LinkedList<Integer>());
                for(int stop = 0; stop<line_len[line]; stop++)
                    //subway_set.get(line).add(stop,sc.nextInt());
                    //subway_set[line].add(sc.nextInt());
            }

            //문제풀이단계


            //각 정류장이 어느어느 호선에 속해있는지 저장

            //Collection 배열을 만들어 풀어보았지만, 구현이 잘 안됨
            /*{LinkedList<LinkedList> contained_line = new LinkedList<>();
            contained_line.add(0, null);
            for(int stop = 1; stop<=stop_num; stop++)
                contained_line.add(stop, new LinkedList<Integer>());

            //각 호선을 돌면서 호선 안의 정류장들이 해당 호선에 포함되어 있음을 저장(호선 : 0호선부터)
            for(int line = 0; line<s_line; line++){
                LinkedList<Integer> now_line = subway_set.get(line);
                for(int stop = 0; stop<now_line.size(); stop++){
                    int now_stop = now_line.get(stop);
                    contained_line.get(now_stop).add(line);
                }
            }

            int time = 0;
            //int[]Change_time = new int[s_line];
            Queue<Integer> ChangeStop = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();

            for(int line = 0; line<s_line; line++){
                if(subway_set.get(line).contains(start)) {
                    //Change_time[line] = 0;//해당 라인은 환승 없이 갈 수 있는 구역
                    visited.add(line);//확인 한 호선은 다시 확인 안함
                    ChangeStop.add(line);//다음번 환승 가능 호선 계산
                }
            }
            int find = 0;
            while(find == 0){

                time++;
                //이번 환승동안 갈 수 있는 호선 순회
                int time_len = ChangeStop.size();
                for(int i = 0; i<time_len; i++){
                    //now_line 은 이번 환승때 방문하는 호선들 하나씩 불러옴
                    int now_line = ChangeStop.poll();
                    //이번 호선에 목적지가 포함되어 있으면 종료
                    if(subway_set.get(now_line).contains(end)){
                        find = 1;
                        break;
                    }
                    else{
                        visited.add(now_line);
                        //호선 내의 정류장 순회하면서 다음 환승 라인 추가
                        LinkedList<Integer> loop_line = subway_set.get(now_line);
                        for(int stop = 1; stop<=loop_line.size(); stop++){
                            LinkedList<Integer> temp = contained_line.get(stop);
                            for(int loop = 0; loop<temp.size();loop++){
                                int containline = temp.get(loop);
                                if(!visited.contains(containline)){
                                    visited.add(containline);
                                    ChangeStop.add(containline);
                                }
                            }
                        }
                    }
                }
            }
            System.out.printf("#%d %d", test+1, time-1);
        }*/
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if(line.contains("txt"))
            ;
        else
            Scan_Input(sc, Integer.parseInt(line));
    }
}
