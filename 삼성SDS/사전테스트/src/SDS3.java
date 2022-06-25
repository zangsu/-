import java.util.*;

class MBTI{
    String[] mbti = {"ENFJ", "ENFP", "ENTJ", "ENTP", "ESFJ", "ESFP", "ESTJ", "ESTP",
            "INFJ", "INFP", "INTJ", "INTP", "ISFJ", "ISFP", "ISTJ", "ISTP"};
    int[] price = new int[16];

}
public class SDS3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Test_Num = sc.nextInt();
        for(int test = 0; test<Test_Num; test++){

            //입력 part
            int needs = sc.nextInt();
            MBTI person = new MBTI();
            for(int index = 0; index<16; index++)
                person.price[index] = sc.nextInt();
            //입력 끝

            //

        }//test는 여기까지
    }
}
