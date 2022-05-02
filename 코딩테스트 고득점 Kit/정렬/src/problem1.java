public class problem1 {
    static int[] QuickSort(int[] array, int Pstart, int Pend){
    int start = Pstart, end = Pend;
    if(( end - start) == 0)
        return array;
    else if(( end - start) == 1)
    {
        if(array[start] > array[end]){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            return array;
        }
        else
            return array;
    }
    int pivot = end;
    end--;
    while(true){
        while(array[start] < array[pivot] && start < end){
            start++;
        }
        while(array[end] > array[pivot] && end >  start)
            end--;
        if(start > end){
            int temp = array[start];
            array[start] =array[pivot];
            array[pivot] = temp;
            array = QuickSort(array, start, pivot-1);
            array = QuickSort(array, pivot+1, end);
            return array;
            //이렇게 하면 각 재귀호출에서 반대편 결과가 저장이 안되나?
        }
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        start++;
        end--;
    }
}
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int len = commands[i][1] - commands[i][0] + 1;

            int[] subArray = new int[len];
            for (int j = 0; j < len; j++)
                subArray[j] = array[commands[i][0] + j];
            subArray = QuickSort(subArray, 0, len - 1);
            answer[i] = subArray[commands[i][2]];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4,4,1} , {1, 7, 3}};
        System.out.println(solution(array, commands));
    }
}
