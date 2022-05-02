import java.util.*;
public class problem1 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack[] game = new Stack[board[0].length];
        Stack<Integer> bag = new Stack<Integer>();
        for(int i = 0; i<board[0].length; i++)
            game[i] = new Stack<Integer>();

        for(int i = board.length-1; i>=0;i--){
            for(int j = 0; j<board[0].length; j++)
                if(board[i][j] != 0)
                    game[j].push(board[i][j]);
        }//게임기 stack배열로 구성

        for(int i = 0; i<moves.length; i++)
        {
            if(game[moves[i]-1].empty())
                continue;
            int number = (int)game[moves[i]-1].pop();
            if(bag.size() == 0)
                bag.push(number);
            else{
                if(number == bag.peek()){
                    answer+=2;
                    bag.pop();
                }
                else
                    bag.push(number);
            }
        }
        return answer;
    }
}
