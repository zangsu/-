public class problem2{

    public int[] solution(String s) {
        int maxLen = 0;
        String[] array = s.split("}");
        for(int i = 0; i<array.length; i++){
            array[i] = array[i].replaceAll("\\{", "");
            array[i] = array[i].replaceAll("^,", "");
        }

        int answer[] = new int[array.length];

        int cnt = 0;
        for(int i = 0; cnt<array.length;){
            if(i >= array.length)
                break;
            if(array[i].contains(",") || array[i].length() == 0){
                i++;
                continue;
            }
            answer[cnt] = Integer.parseInt(array[i]);
            String temp = array[i];
            array[i] = array[cnt];
            array[cnt] = temp;
            for(int j = cnt; j<array.length; j++)
            {
                array[j] = array[j].replaceAll(array[cnt], "");
                array[j] = array[j].replaceAll("^,|,$", "");
                array[j] = array[j].replaceAll(",{2,}", ",");
            }
            cnt++;
        }
        return answer;
    }
}
