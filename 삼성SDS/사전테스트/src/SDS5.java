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

            //문제 풀이
            Queue<point> queue = new LinkedList<point>();
            queue.add(new point(start_row, start_col));//시작 위치를 queue에 삽입
            long ans = 0;
            for(int path_len = 0; path_len<move_max; path_len++){
                int thisTimeLen = queue.size();
                for(int loopTime = 0; loopTime<thisTimeLen; loopTime++){
                    point now = queue.poll();

                    //상하이동 먼저 고려
                    if(now.row == 0)
                        ans++;
                    else{
                        if(!map[now.row-1][now.col].equals("X")) {
                            queue.add(new point(now.row - 1, now.col));
                        }
                    }//여기까지가 상하이동
                    if (now.row == row_max - 1) {
                        ans++;
                    }
                    else{
                        if(!map[now.row+1][now.col].equals("X")) {
                            queue.add(new point(now.row + 1, now.col));
                        }
                    }//여기까지가 상하이동

                    //좌우이동 고려
                    if(now.col == 0)
                        ans++;
                    else{
                        if(!map[now.row][now.col-1].equals("X")) {
                            queue.add(new point(now.row, now.col - 1));
                        }
                    }
                    if (now.col == col_max - 1) {
                        ans++;
                    }
                    else{
                        if(!map[now.row][now.col+1].equals("X")) {
                            queue.add(new point(now.row, now.col + 1));
                        }
                    }//여기까지가 좌우이동

                    //System.out.printf("%d %d\n",now.row, now.col);
                }
            }//각 이동횟수별로 queue안의 위치를 꺼내 이동함(bfs)
            System.out.printf("#%d %d\n", test+1, ans%1000000007);
        }//여기까지가 한 테스트케이스

    }
}
class point{
    int row;
    int col;
    point(int x, int y){
        this.row = x;
        this.col = y;
    }

}

