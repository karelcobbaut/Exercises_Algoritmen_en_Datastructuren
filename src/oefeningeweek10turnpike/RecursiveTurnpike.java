package oefeningeweek10turnpike;

import java.util.*;

public class RecursiveTurnpike implements Turnpike {
    private HashSet<Integer> mySet;
    private Map<Integer,Long> myMap;
    private ArrayList<Integer> myList;
    private int length;
    @Override
    public Map<Integer, Long> pointsToDistances(Set<Integer> points) {

        Map<Integer, Long> myMap = new HashMap<>();
        for(Integer p1 : points){
            for(Integer p2: points){
                if(p1<p2){
                    int key = p2-p1;
                    if(!myMap.containsKey(key)) myMap.put(key,(long) 1);
                    else myMap.put(key, myMap.get(key)+1);
                }

            }
        }
        return myMap;
    }
    @Override
    public Set<Integer> distancesToPoints(Map<Integer, Long> distances) {

        mySet = new HashSet<>();
        myMap = new HashMap<>(distances);

        length = distances.size();
        myList = new ArrayList<>(myMap.keySet());

        Collections.sort(myList);
        mySet.add(0);
        if(myList.size()==0) return mySet;
        mySet.add(myList.get(length-1));
        removeOne(myList.get(length-1));
        if(!recursiveDistancesToPoints(length-2)) return null;
       // myList.add(0);

        return mySet;
    }

    private boolean recursiveDistancesToPoints(int j){

        if(myMap.isEmpty()) return true;
        int i=length-1;
        while(i>=0 && !myMap.containsKey(myList.get(i))){
            i--;
        }
        if(i<0) return false;

        int point1 = myList.get(i);
            int point2 = myList.get(length-1) -point1;

            if(removePoints(point1)){
                mySet.add(point1);
                if(recursiveDistancesToPoints(i-1)) return true;
                mySet.remove(point1);
                addPoints(point1,-1);
               }
            if(removePoints(point2)){
                mySet.add(point2);
                if(recursiveDistancesToPoints(i-1)) return true;
                mySet.remove(point2);
                addPoints(point2,-1);
            }
            i--;

        //}
        return false;
    }


    private boolean removePoints(int myInt){
        if(!myMap.containsKey(myInt)) return false;
        for(Integer point : mySet){
            if(point-myInt>0 && removeOne(point-myInt));
            else if(point-myInt<0 &&removeOne(myInt-point));
            else {
                addPoints(myInt, point);
                return false;
            }
        }
        return true;

    }

    private void addPoints(int myInt,int stopPoint){
        for(Integer point : mySet){
            if(point==stopPoint) return;
            if(point-myInt>0) addOne(point-myInt);
            else addOne(myInt-point);


        }
    }
    private void addOne(int myInt){
        if(!myMap.containsKey(myInt)) myMap.put(myInt,(long) 1);
        else myMap.put(myInt,myMap.get(myInt)+1);
    }
    private boolean removeOne(int myInt){
        if(!myMap.containsKey(myInt)) return false;
        if(myMap.get(myInt)==1) myMap.remove(myInt);
        else myMap.put(myInt,myMap.get(myInt)-1);
        return true;
    }

}
