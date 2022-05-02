import java.util.*;
public class problem3 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int leftTruck = truck_weights.length;//남은 truck수
        Queue<Integer> truck = new LinkedList<Integer>();//올라간 truck의 무게 queue
        Queue<Integer> truckTime = new LinkedList<Integer>();//올라간 truck의 남은시간 queue
        int time = 0;
        int waiting = 0;
        while(leftTruck != 0){
            //기다리는 트럭의 무게를 다리가 버틸 수 있다면 트럭을 한대 더 올리자.
            if(truck_weights[waiting] <= weight){
                time++;
                for(int i = 0; i<truck.size(); i++){
                    int NextTruckTime = truckTime.poll()-1;
                    if(NextTruckTime < 0)
                        continue;
                    truckTime.add(NextTruckTime);
                }
                //시간을 1초 증가시키고
                leftTruck--;
                truck.add(truck_weights[waiting]);//트럭을 올리자.
                weight -= truck_weights[waiting];//다리가 버틸 수 있는 무게는 올라간 트럭의 무게만큼 뺴자.
                truckTime.add(bridge_length-1);//마지막 트럭이 남은시간은 다리의 길이
                waiting++;//이제 기다리는 트럭은 다음트럭입니다.
            }
            //트럭이 더 못올라간다면 트럭을 올릴 수 있을 때 까지 빨리감기
            else{
                int FirstTruckTime = truckTime.poll();//맨 앞 트럭이 남은시간
                time+= FirstTruckTime;
                //이 시점에서 맨 앞의 트럭은 다리를 다 건너기 1초전(다음 while문때 truck이 다리를 다 건넌다.
                weight += truck.poll();//다리가 버틸 수 있는 무게가 늘어남.
                //각 트럭들의 남은 시간을 빼주기.
                for(int i = 0; i<truck.size(); i++){
                    int NextTruckTime = truckTime.poll() - FirstTruckTime;
                    if(NextTruckTime < 0)
                        continue;
                    truckTime.add(NextTruckTime);
                }
            }
            //이 시점에서 모든 트럭이 다리에 다 올라갔다.
        }
        while(!truckTime.isEmpty())
        {
            int FirstTruckTime = truckTime.poll();
            time+= FirstTruckTime;
            if(truckTime.isEmpty())
                break;
            for(int i = 0; i<truckTime.size(); i++){
                int NextTruckTime = truckTime.poll() - FirstTruckTime;
                if(NextTruckTime < 0)
                    continue;
                truckTime.add(NextTruckTime);
            }
        }
        //truck이 다 올라갈 때 까지
        return time+1;
    }

    public static void main(String[] args) {
        int[] array = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(solution(100	,100	,array));

    }
}
