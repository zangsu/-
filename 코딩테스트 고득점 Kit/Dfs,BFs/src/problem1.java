import java.util.*;
public class problem1 {
    //static int cnt = 0;
    static int getTarget(ArrayList<Integer> numbers, int subIndex, int Sum, int Target, int cnt){
        int partcnt = 0;
        for(int i = subIndex; i<numbers.size(); i++){
            int prevSum = Sum;
            ArrayList<Integer> newNumbers = new ArrayList<Integer>();
            newNumbers.addAll(numbers);
            prevSum = prevSum-(newNumbers.get(i) * 2);
            if(prevSum < Target)
                continue;
            else if(prevSum == Target)
                cnt+= 1;
            else {
                newNumbers.remove(i);
                if(newNumbers.size() == 1)
                    continue;
                cnt += getTarget(newNumbers, i, prevSum, Target, partcnt);

            }
        }
        return cnt;
    }
    public static int solution(int[] numbers, int target) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i<numbers.length; i++) {
            array.add(i, numbers[i]);
            sum+= numbers[i];
        }
        cnt = getTarget(array, 0, sum, target, cnt);

        return cnt;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,1};
        System.out.println(solution(array, 3));
    }
}
