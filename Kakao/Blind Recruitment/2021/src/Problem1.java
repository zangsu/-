import java.util.Locale;

public class Problem1 {
    public String solution(String new_id) {
        int idLen = new_id.length();
        new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(new_id);
        for(int i = 0; i<idLen; i++){
            if(Character.isDigit(sb.charAt(i)) == false) {
                if (sb.charAt(i) == '-' || sb.charAt(i) == '_')
                    continue;
                else if (sb.charAt(i) == '.') {
                    if (sb.charAt(i + 1) == '.') {
                        sb.deleteCharAt(i);
                        i--;
                    }
                }
                else{
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }
        if(sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        if(sb.charAt(sb.length()-1) == '.')
            sb.deleteCharAt(sb.length()-1);
        if(sb.length() == 0)
            sb.append("a");
        if(sb.length() >= 16)
            sb.delete(15, sb.length()-1);
        if(sb.length() < 3)
        {
            while(sb.length() >= 3)
                sb.append(sb.charAt(sb.length()-1));
        }

        return sb.toString();
    }
}
