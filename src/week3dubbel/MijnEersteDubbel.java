package week3dubbel;
import java.util.HashMap;


public class MijnEersteDubbel implements EersteDubbel {
    @Override
    public int eersteDubbel(int[] rij) {
        HashMap<Integer,Integer> myMap = new HashMap<>();

        int i=0;
        int length = rij.length;
        int myDouble = length;
        if(length==0){return -1;}
        while(i<length){

            if(myMap.containsKey(rij[i])){

                if(myMap.get(rij[i])<myDouble) {
                    myDouble = myMap.get(rij[i]);
                }
            } else {
                myMap.put(rij[i],i);
            }

            i++;
        }
        if(myDouble==length){return -1;} else {return rij[myDouble];}

    }
}
