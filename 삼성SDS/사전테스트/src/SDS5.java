import java.util.*;

public class SDS5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Test_num = sc.nextInt();
        for(int test = 0; test<Test_num; test++)
        {
            //입력 단계
            int row_max = sc.nextInt();
            int col_max = sc.nextInt();
            int move_max = sc.nextInt();
            int start_row = -1;
            int start_col = -1;

            String[][] map = new String[row_max][];
            for(int row = 0; row<row_max; row++){
                String Input = sc.nextLine();
                if(Input.equals(""))
                {
                    row--;
                    continue;
                }
                if(Input.contains("S"))
                {
                    start_row = row;
                    start_col = Input.indexOf("S");
                }
                map[row] = Input.split("");
            }//여기까지 입력

            //데이터 전처리
            Block[][] map_prev = new Block[row_max][];
            Block[][] map_next = new Block[row_max][];
            for (int row = 0; row < row_max; row++) {
                map_prev[row] = new Block[col_max];
                map_next[row] = new Block[col_max];
                for(int col = 0; col<col_max; col++){
                    if(row == 0 || row == row_max-1)
                    {
                        if (col == 0 || col == col_max - 1) {
                            map_prev[row][col] = new Block(-1, -1, "Corner");
                            map_next[row][col] = new Block(-1, -1, "Corner");
                        }
                        else {
                            map_prev[row][col] = new Block(-1, -1, "Side");
                            map_next[row][col] = new Block(-1, -1, "Side");
                        }
                    }
                    else {

                        map_prev[row][col] = new Block(-1, -1);
                        map_next[row][col] = new Block(-1, -1);
                    }
                }
            }

            //문제 풀이
            //시작 변경전 map은 map_prev-> 번갈아가면서 사용

            long ans = 0;
            map_prev[start_row][start_col].len = 0;
            map_prev[start_row][start_col].path_num = 0;

            for (int move = 0; move < move_max; move++) {
                if(move%2 == 0){//짝수일때는 prev를 보면서 next를 업데이트
                    ;
                }
                else{//홀수일 대는 next를 보면서 prev를 업데이트
                    ;
                }
            }

        }//여기까지가 한 테스트케이스

    }
    long getLength(Block[][] map){
        return 0;
    }

}
class Block{
    int len;
    int path_num;
    String loc = "";//in, side, corner로 구분
    Block(int x, int y){
        this.len = x;
        this.path_num = y;
        this.loc = "in";
    }
    Block(int x, int y, String loc){
        this.len = x;
        this.path_num = y;
        this.loc = loc;
    }
    Block(String wall){
        this.loc = wall;
    }


}


