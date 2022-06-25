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
                        if (col == 0 || col == col_max - 1)
                            map_prev[row][col] = new Block(0, 0, "Corner");
                        else
                            map_prev[row][col] = new Block(0, 0, "Side");
                    }
                    else
                        map_prev[row][col] = new Block(0, 0);
                }
            }

            //문제 풀이


        }//여기까지가 한 테스트케이스

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


}


