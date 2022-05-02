import java.util. *;
public class problem1 {

    /*isPrime : 전달받은 숫자에 대해 소수인지 확인
     * 입력 인자가 String인 이유는 02처럼 0으로 시작하는 숫자의 경우 0을 보존하기 위해서임
     **/
    static boolean isPrime(String snumber){
        if(snumber.charAt(0) == '0')
            return false;
        int number = Integer.parseInt(snumber);
        if(number == 1 || number == 0)
            return false;
        else if(number == 2)
            return true;
        else{
            for(int i = 2; i< number/2 + 1; i++){
                if(number % i == 0)
                    return false;
            }
        }
        return true;
    }
    /*FindPrime : 주어진 숫자에 사용 가능한 숫자를 하나씩 앞에 붙여 가며 소수인지 확인.
     *idea : 전달 받은 숫자가 소수인지 확인.
     *       숫자를 순서대로 하나씩 붙이고, numList에서 해당 수를 뺀 수배열과 숫자가 붙은 새로운 숫자를 재귀함수에 전달.
     *       재귀함수의 끝엔 해당 재귀호출까지의 모든 경우의 합을 return
     *
     *@param :  int[] numList - 사용 가능한 숫자들이 들어있는 숫자배열
     *         int number - 숫자들을 붙일 타겟넘버
     *
     *@return : 해당수에서 남은 숫자들을 붙여 만들 수 있는 소수의 수
     **/
    static int FindPrime(ArrayList<String> numList, String number){

        int cnt = 0;
        if(isPrime(number))
            cnt++;
        if(number.equals("2")|| number.equals("5") || number.equals("0"))
            return cnt;
        else if(numList.isEmpty())
            return cnt;
        else{
            for(int i = 0; i<numList.size(); i++){
                if (i < numList.size() - 1 && numList.get(i).equals(numList.get(i + 1))){
                    continue;
                }
                else{
                    ArrayList<String> newList = new ArrayList<String>();
                    newList.addAll(numList);
                    String newNumber = numList.get(i) + number;
                    newList.remove(i);
                    cnt += FindPrime(newList, newNumber);
                }
            }
            return cnt;
        }
    }


    public static int solution(String numbers) {
        ArrayList<String> numList = new ArrayList<String>();
        String[] array = numbers.split("");
        //여기서부터 숫자 배열 만들기 시작
        //int[] numList = new int[numbers.length()];
        for(int i = 0; i<numbers.length(); i++)
            numList.add(array[i]);
        //numList안에는 사용 할 수 있는 숫자가 중복을 포함하여 저장되었다.
        Collections.sort(numList);
        int answer = 0;

        for(int i = 0; i<numList.size(); i++){
            if (i < numList.size() - 1 && numList.get(i).equals(numList.get(i + 1))){
                continue;
            }
            else{
                ArrayList<String> newList = new ArrayList<String>();
                newList.addAll(numList);
                newList.remove(i);
                answer += FindPrime(newList, numList.get(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("101"));
    }
}
