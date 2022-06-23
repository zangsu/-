import java.util.*;

public class SDS2 {
    static class point{
        int col;
        int row;
        point(int row, int col){
            this.col = col;
            this.row = row;
        }
    }
    static class Map{
        String[][] map;
        point Greg;
        point A;
        point B;
        point C;
        point S;
        Map(int row, int col){
            map = new String[row][];
            for(int map_row = 0; map_row< row; map_row++)
                map[map_row] = new String[col];
        }
    }
    static class Greg{
        int col;
        int row;
        int status;
        int len;
        Boolean A;
        Boolean B;
        Boolean C;
        Greg(int row, int col, int status, int len){
            this.col = col;
            this.row = row;
            this.status = status;
            this.len = len;
        }
    }

    public static void Scan_Input(Scanner sc, String Line){
        int Test_Num = Integer.parseInt(Line);

        for(int test = 0; test<Test_Num; test++) {

            //입력부분
            int map_row = sc.nextInt();
            int map_col = sc.nextInt();
            Map map = new Map(map_row, map_col);

            int Greg_row = sc.nextInt()-1;
            int Greg_col = sc.nextInt()-1;
            map.Greg = new point(Greg_row, Greg_col);

            for(int row = 0; row<map_row; row++){
                String line = sc.nextLine();
                if(line.length() != map_col) {
                    row--;
                    continue;
                }
                String[] line_split = line.split("");
                //System.out.println(line);
                for(int col = 0; col<map_col; col++){
                    map.map[row][col] = line_split[col];
                    if(map.map[row][col].equals("A"))
                        map.A = new point(row, col);
                    if(map.map[row][col].equals("B"))
                        map.B = new point(row, col);
                    if(map.map[row][col].equals("C"))
                        map.C = new point(row, col);
                    if(map.map[row][col].equals("S"))
                        map.S = new point(row, col);
                }
            }


            //문제 해결 부분


            Queue<Greg> current_greg = new LinkedList<>();
            HashSet<String> path = new HashSet<>();
            path.add(Integer.toString(map.Greg.row)+ Integer.toString(map.Greg.col));
            Greg start = new Greg(map.Greg.row, map.Greg.col, 0, 0);
            start.A = false;
            start.B = false;
            start.C = false;
            current_greg.add(start);
            while(true){

                Greg now = current_greg.poll();
                if(map.map[now.row][now.col].equals("A") && now.A == false)
                {
                    now.A = true;
                    now.status ++;
                    path.clear();
                }
                if(map.map[now.row][now.col].equals("B") && now.B == false)
                {
                    now.B = true;
                    now.status ++;
                    path.clear();
                }
                if(map.map[now.row][now.col].equals("C") && now.C == false)
                {
                    now.C = true;
                    now.status ++;
                    path.clear();
                }
                if(now.status == 3 && now.col == map.S.col && now.row == map.S.row) {
                    System.out.printf("#%d %d", test+1, now.len);
                    break;
                }
                else if(now.status == 3){//'X' 상관없이 'S'만 찾아가면 되는 상황
                    if(map.S.col < now.col)
                        current_greg.add(new Greg(now.row, now.col-1, 3, now.len+1));
                    else if(map.S.col > now.col)
                        current_greg.add(new Greg(now.row, now.col+1, 3, now.len+1));
                    else{//col과 row를 한번에 고려하면 같은 거리를 가로먼저 가는 방법과 세로 먼저 가는 방법 두가지로 나뉘므로 시간절약을 위해 가로 먼저 맞추고 세로 찾아가기
                        if(map.S.row < now.row)
                            current_greg.add(new Greg(now.row-1, now.col, 3, now.len+1));
                        else if(map.S.row > now.row)
                            current_greg.add(new Greg(now.row+1 , now.col, 3, now.len+1));
                    }
                }
                else{
                    if(now.row + 1 < map_row && !map.map[now.row+1][now.col].equals("X")  && !path.contains(Integer.toString(now.row + 1)+Integer.toString(now.col))) {
                        Greg next = new Greg(now.row + 1, now.col, now.status, now.len + 1);
                        path.add(Integer.toString(now.row + 1)+Integer.toString(now.col));
                        next.A = now.A;
                        next.B = now.B;
                        next.C = now.C;
                        current_greg.add(next);
                    }
                    if(now.row >= 1 && !map.map[now.row-1][now.col].equals("X") && !path.contains(Integer.toString(now.row - 1)+Integer.toString(now.col))) {
                        Greg next = new Greg(now.row - 1, now.col, now.status, now.len + 1);
                        path.add(Integer.toString(now.row - 1)+Integer.toString(now.col));
                        next.A = now.A;
                        next.B = now.B;
                        next.C = now.C;
                        current_greg.add(next);
                    }
                    if(now.col + 1 < map_col && !map.map[now.row][now.col+1].equals("X") && !path.contains(Integer.toString(now.row)+Integer.toString(now.col+1))) {
                        Greg next = new Greg(now.row, now.col+1, now.status, now.len + 1);
                        path.add(Integer.toString(now.row) +Integer.toString(now.col+1));
                        next.A = now.A;
                        next.B = now.B;
                        next.C = now.C;
                        current_greg.add(next);
                    }
                    if(now.col >= 1 && !map.map[now.row][now.col-1].equals("X") && !path.contains(Integer.toString(now.row )+Integer.toString(now.col-1))) {
                        Greg next = new Greg(now.row, now.col-1, now.status, now.len + 1);
                        path.add(Integer.toString(now.row) +Integer.toString(now.col-1));
                        next.A = now.A;
                        next.B = now.B;
                        next.C = now.C;
                        current_greg.add(next);
                    }
                }
                System.out.println(now.row + " " + now.col + " len:"+now.len + " status:" + now.status);
                //System.out.println();
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/


            }
        }


    }
    public static void File_Input(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Line = sc.nextLine();

        if(Line.contains("txt"))
            File_Input();
        else
            Scan_Input(sc, Line);
    }
}
