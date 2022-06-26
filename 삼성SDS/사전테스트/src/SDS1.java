//마당 잔디 깎기

import java.io.*;
import java.util.*;
public class SDS1 {

    //public static void Scan_Input(BufferedReader br, int Test_num) throws IOException {
    public static void Scan_Input(Scanner sc, int Test_num){
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test = 0; test<Test_num; test++){
            //입력부분

            /*String Input_line = br.readLine();
            //String[] line_split = Input_line.split(" ");
            StringTokenizer tokenizer = new StringTokenizer(Input_line);
            int row = Integer.parseInt(tokenizer.nextToken());
            int col = Integer.parseInt(tokenizer.nextToken());
            int day = Integer.parseInt(tokenizer.nextToken());*/
            int row = sc.nextInt();
            int col = sc.nextInt();
            int day = sc.nextInt();
            int idx = 0;
            Integer[] grass_prev = new Integer[row*col];
            //LinkedList<Integer> grass_prev = new LinkedList<Integer>();
            int[] oil = new int[day];
            //LinkedList<Integer> oil = new LinkedList<Integer>();
            /*for(int N = 0; N<row; N++){
                Input_line = br.readLine();
                tokenizer = new StringTokenizer(Input_line);
                while(tokenizer.hasMoreTokens())
                    grass_prev[idx++] = Integer.parseInt(tokenizer.nextToken());
                   // grass_prev.add(Integer.parseInt(tokenizer.nextToken()));
            }
            Input_line = br.readLine();
            tokenizer = new StringTokenizer(Input_line);
            while(tokenizer.hasMoreTokens())
                oil.add(Integer.parseInt(tokenizer.nextToken()));*/
            for(int i = 0; i<row * col; i++)
                grass_prev[i] = sc.nextInt();
            for(int i = 0; i<day; i++)
                oil[i] = sc.nextInt();
            //여기까지가 입력

            //데이터 전처리
            Arrays.sort(grass_prev, Collections.reverseOrder());
            //Collections.sort(grass_prev, Collections.reverseOrder());
            //Queue<Integer> grass = grass_prev;

            //문제 풀이
            long ans = 0;
            idx = 0;
            for(int D = 0; D<day; D++)
            {
                for(int day_work = 0; day_work<oil[D]; day_work++){
                //for(int day_work = 0; day_work<oil.get(D); day_work++){
                    int cut_grass = grass_prev[idx]+D;
                    grass_prev[idx] = D * (-1);
                    //int cut_grass = grass.poll() + D;
                    ans += cut_grass * (D+1);
                    if(idx == row*col - 1)
                        idx = 0;
                    else
                        idx++;
                    //grass.add(D * -1);
                }
            }

            System.out.printf("#%d %d\n", test+1, ans);
            /*bw.write("#" + (test+1));
            bw.write(" "+ans);
            bw.flush();
            bw.close();*/

        }//여기까지가 하나의 test_case
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = sc.nextLine();
        //String Input = br.readLine();

        if(Input.contains("txt"));
        else
            Scan_Input(sc, Integer.parseInt(Input));
            //Scan_Input(br, Integer.parseInt(Input));

    }
}
