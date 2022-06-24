//마당 잔디 깎기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class SDS1 {

    public static void Scan_Input(BufferedReader br, int Test_num) throws IOException {

        for(int test = 0; test<Test_num; test++){
            //입력부분
            String Input_line = br.readLine();
            String[] line_split = Input_line.split(" ");
            int row = Integer.parseInt(line_split[0]);
            int col = Integer.parseInt(line_split[1]);
            int day = Integer.parseInt(line_split[2]);

            LinkedList<Integer> grass_prev = new LinkedList<Integer>();
            LinkedList<Integer> oil = new LinkedList<Integer>();
            for(int N = 0; N<row; N++){
                Input_line = br.readLine();
                line_split = Input_line.split(" ");
                for(String grass_len : line_split)
                    grass_prev.add(Integer.parseInt(grass_len));
            }
            Input_line = br.readLine();
            line_split = Input_line.split(" ");
            for(int D = 0; D<day; D++)
                oil.add(Integer.parseInt(line_split[D]));
            //여기까지가 입력

            //데이터 전처리
            Collections.sort(grass_prev, Collections.reverseOrder());
            Queue<Integer> grass = grass_prev;

            //문제 풀이
            long ans = 0;
            for(int D = 0; D<day; D++)
            {
                for(int day_work = 0; day_work<oil.get(D); day_work++){
                    int cut_grass = grass.poll() + D;
                    ans += cut_grass * (D+1);
                    grass.add(D * -1);
                }
            }

            System.out.printf("#%d ", test+1);
            System.out.println(ans);

        }//여기까지가 하나의 test_case
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Input = br.readLine();

        if(Input.contains("txt"));
        else
            Scan_Input(br, Integer.parseInt(Input));

    }
}
