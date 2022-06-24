//마당 잔디 깎기

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Grass{
    int N;
    int M;
    int D;
    HashMap<Integer, Integer> grass = new HashMap<>();
    LinkedList<Integer> grass_len= new LinkedList<>();//잔디 길이를 오름차순으로 정렬해\
    LinkedList<Integer> Oil = new LinkedList<>();

    void Grass_clear(){
        this.grass.clear();
        this.grass_len.clear();
        this.Oil.clear();
    }

}
public class SDS1 {

    public static void SDS1_Input(Scanner sc, String T, Grass grass){
        int Test_Num = Integer.parseInt(T);

        for(int i = 0; i<Test_Num; i++ ){
            grass.Grass_clear();

            grass.N = sc.nextInt();
            grass.M = sc.nextInt();
            grass.D = sc.nextInt();
            long ans = 0;



            /*for(int row = 0; row<grass.N; row++){
                for(int col = 0; col<grass.M; col++){
                    int block_grass = sc.nextInt();//각 구역의 잔디 길이를 입력받음

                    //잔디의 길이를 grass_len에, 해당 잔디 길이의 개수를 grass에 입력.
                    if(grass.grass_len.contains(block_grass) == false) {
                        grass.grass_len.add(block_grass);
                        grass.grass.put(block_grass, 1);
                    }
                    else
                        grass.grass.put(block_grass, grass.grass.get(block_grass)+1);
                }
            }*/

            //기름 입력
            for(int day = 0; day < grass.D; day++)
                grass.Oil.add(sc.nextInt());

            //잔디의 길이를 내림차순으로 정렬
            Collections.sort(grass.grass_len,Collections.reverseOrder());

            System.out.printf("#%d ", i+1);
            Cal_ans(grass);
        }
    }

    public static void Cal_ans(Grass grass){
        long ans = 0;

        for(int day = 1; day <= grass.D; day++){//하루씩 날 진행행
            for (int oil = grass.Oil.get(day - 1); oil>0; oil--) {
                int Longest_grass = grass.grass_len.get(0);
                if (grass.grass.get(Longest_grass) == 1) {
                    grass.grass.remove(Longest_grass);
                    grass.grass_len.remove(0);
                } else
                    grass.grass.put(Longest_grass, grass.grass.get(Longest_grass) - 1);


                ans = ans + (day * (Longest_grass + day - 1));
            }
            //grass클래스 안의 잔디 길이들을 날이 지남에 따라 변경하지 않을것이기 때문에 잘려진 잔디에 대한 길이도 그 점을 고려해서 클래스에 추가하기
            grass.grass_len.add(grass.grass_len.size(), 1-day);
            grass.grass.put(1 - day, grass.Oil.get(day-1));

        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Grass grass = new Grass();
        String line = sc.nextLine();
            SDS1_Input(sc, line, grass);

    }
}
