import java.util.ArrayList;

public class level2 {

    /*
     * 수 연산 method
     *
     * @param : String n1  : 연산에 사용 될 숫자 1
     *          String cal : 연산 부호
     *          String n2  : 연산에 사용 될 숫자 2
     * @return : long타입의 cal에 따른 결과값
     */
    static long Calculate(String n1, String cal, String n2){
        if(cal.equals("+"))
            return Long.parseLong(n1) + Long.parseLong(n2);
        else if(cal.equals("*"))
            return Long.parseLong(n1) * Long.parseLong(n2);
        else
            return Long.parseLong(n1) - Long.parseLong(n2);
    }

    /*
     * Array내에서 특정 우선순위에 해당하는 연산을 하는 method
     *
     * 방법:
     * ArrayList를 입력받아 처음부터 탐색하다가 i번째 에서 특정 연산자를 만나면 계산.
     *  ->i-1번째 수와 i+1번째 수를 계산하여 다시 삽입 ( i-1:i+1 번째 원소 삭제 후 계산결과 i-1번째에 삽입      *
     *
     * @param : ArrayList list : 중위표기 연산식이 수와 연산자 끼리 split되어 있는 array
     *          String[] cal : 연산자가 우선순위 순서대로 저장되어 있는 배열
     *          int index : 몇번째 우선순위의 연산자를 계산할 건지 표시되어 있는 정수
     * @return : index번째의 연산이 완료가 된 중위표기 연산식 ArrayList list
     */
    static ArrayList<String> StringCal(ArrayList<String> list, String[] cal, int index){
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(cal[index])){
                long number = Calculate(list.get(i - 1), list.get(i), list.get(i + 1));
                for(int j = 0; j<3; j++)
                    list.remove(i-1);
                list.add(i-1, Long.toString(number));
                i--;
            }
        }
        return list;
    }
    public long solution(String expression) {
        ArrayList<String> array = new ArrayList<String>();
        int Len = expression.length();
        long answer = 0;
        //각각 순서대로 (*+-, *-+, +*-, +-*, -+*, -*+)
        int number = 0;
        for(int i = 0; i<Len; i++)
        {
            //-- 문자열 파싱 --
            if(Character.isDigit(expression.charAt(i)) == true)
                number = number*10 + Character.getNumericValue(expression.charAt(i));
            else{
                array.add(Integer.toString(number));
                array.add(Character.toString(expression.charAt(i)));
                number=0;
            }
        }
        array.add(Integer.toString(number));//-- 문자열 파싱 --

        // -- 각 우선순위 별 계산 --
        for(int i = 0; i<6; i++){

            ArrayList<String> temp = new ArrayList<String>();

            // -- 연산자의 우선순위를 cal 배열 안에 순서대로 저장 --
            String[] cal = new String[6];
            if(i %3 == 0)
            {
                cal[0] = "*";
                if(i == 0)
                {
                    cal[1] = "+";
                    cal[2] = "-";
                }
                else{
                    cal[1] = "-";
                    cal[2] = "+";
                }
            }
            else if(i == 1){
                cal[0] = "+";
                if(i == 1)
                {
                    cal[1] = "*";
                    cal[2] = "-";
                }
                else{
                    cal[1] = "-";
                    cal[2] = "*";
                }
            }
            else{
                cal[0] = "-";
                if(i == 2)
                {
                    cal[1] = "*";
                    cal[2] = "+";
                }
                else{
                    cal[1] = "+";
                    cal[2] = "*";
                }
            }

            // -- 우선순위대로 차례로 계산하여 낮은 우선순위의 연산들만 남기기 --
            temp.addAll(array);
            for(int j = 0; j<3; j++){
                temp = StringCal(temp, cal, j);
            }

            if(Math.abs(Long.parseLong(temp.get(0))) > answer)
                answer = Math.abs(Long.parseLong(temp.get(0)));
        }
        return answer;
    }
}