//길찾기 게임
import java.lang.reflect.Array;
import java.util.*;
public class problem5 {
    static HashMap<Integer, Integer> makeLeftMap(int root, HashMap<Integer,Integer> map) {
        HashMap<Integer, Integer> lMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < root; i++)
            if (map.containsKey(i))
                lMap.put(i, map.get(i));
        return lMap;
    }
    static HashMap<Integer, Integer> makeRightMap(int root, int lim,  HashMap<Integer,Integer> map){
        HashMap<Integer, Integer> rMap = new HashMap<Integer, Integer>();
        for (int i = root+1; i <= lim; i++)
            if (map.containsKey(i))
                rMap.put(i, map.get(i));
        return rMap;
    }
    static ArrayList<Integer> PreOrder(int root, int lim,  HashMap<Integer,Integer> map, HashSet<Integer> set){
        if(map.size() == 1 || map.size() == 0)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(map.get(root));
            return list;
        }

        int lRoot=0, rRoot = 0, lLim = root-1, rLim;
        set.remove(map.get(root));
        int maxY = Collections.max(set);
        for(int i = 0; i<=lim && rRoot == 0; i++){
            if(map.containsKey(i)){
                if(map.get(i) == maxY){
                    if(i < root)
                        lRoot = i;
                    else
                        rRoot = i;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> lMap = makeLeftMap(root, map);
        HashMap<Integer, Integer> rMap = makeRightMap(root,lim, map);

        list.add(root);
        if(lMap.size() > 0)
            list.addAll(PreOrder(lRoot, lLim, lMap, set));
        if(rMap.size() > 0)
            list.addAll(PreOrder(rRoot, lim, rMap, set));

        return list;
    }
    /*static ArrayList<Integer> PostOrder(){

    }*/

    public static int[][] solution(int[][] nodeinfo) {
        HashSet<Integer> ySet = new HashSet<Integer>();
        HashMap<Integer, Integer> xSet = new HashMap<Integer, Integer>();
        int maxY = 0;
        int xToMaxY = 0;
        int maxX = 0;
        for(int i = 0; i<nodeinfo.length; i++){
            if(nodeinfo[i][1] > maxY) {
                maxY = nodeinfo[i][1];
                xToMaxY = nodeinfo[i][0];
            }
            if(maxX < nodeinfo[i][0])
                maxX = nodeinfo[i][0];
            ySet.add(nodeinfo[i][1]);
            xSet.put(nodeinfo[i][0], nodeinfo[i][1]);
        }

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre = PreOrder(xToMaxY, maxX, xSet, ySet);


        System.out.println(pre);
        //return pre.toArray();
        int[][] answer = new int[2][nodeinfo.length];
        return answer;
    }

    public static void main(String[] args) {
        int[][] node = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        solution(node);
    }
}
