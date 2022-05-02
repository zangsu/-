import java.net.Inet4Address;
public class Problem4 {
    public class node<T, K> {
        T cost;
        K pastDirection;
        node<T,K> up;
        node<T,K> down;
        node<T,K> left;
        node<T,K> right;

    }
    public class SinglyLinkedLIst<T, K>{
        node<T,K> head;
        node<T,K> tail;
        int min;
        SinglyLinkedLIst(){
            this.head = null;
            this.tail= null;
        }

        //addLIst
        public void addUp(T value){
            node<T, K> x = new node<T, K>();
            tail.up = x;
            x.up = null;
            x.down = null;
            x.left = null;
            x.right = null;
            tail = x;
        }
        public void addDown(T value){
            node<T, K> x = new node<T, K>();
            tail.down = x;
            x.up = null;
            x.down = null;
            x.left = null;
            x.right = null;
            tail = x;
        }
    }

    public int solution(int[][] board) {

        SinglyLinkedLIst<Integer, Character> tree = new SinglyLinkedLIst<>();

        int answer = 0;
        return answer;
    }

}
