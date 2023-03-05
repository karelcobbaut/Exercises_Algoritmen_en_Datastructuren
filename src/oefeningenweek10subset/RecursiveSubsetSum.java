package oefeningenweek10subset;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSubsetSum implements SubsetSum {
    List<Boolean> returnList; //opslaan list die gereturned moet worden
    List<Integer> myList; //numbers allowed to use
    int mySum; //som we search
    int length; //length of myList
    @Override
    public List<Boolean> subsetSum(List<Integer> list, int sum) {
        returnList = new ArrayList<>();
        length = list.size();
        for(int i=0;i<length;i++) returnList.add(false); //initialize on false
        myList=list;
        mySum = sum;

        if(!recursiveSubsetSum(0,0)) return null; //if one recursive returns true all will start to return true
        return returnList;
    }
    private boolean recursiveSubsetSum(int sum, int i){
        if(sum>mySum||i>length) return false; //if new sum >mySum the sum we made is to large return false te exit recursion
        if(mySum == sum) return true; //we found the sum return true to end the recursion
        for(int j=i;j<length;j++){ //start in i (index of myList) and go intil length, (no need to start from 0 to avoid duplicates and faster speed
            returnList.set(j, true); //add number to sum return list
            if(recursiveSubsetSum(sum+myList.get(j),j+1))return true; //if one recursion we called is true is will be true and we will end this recurion
            returnList.set(j, false); //the sum combination didn't work remove the last and add the next one in myList
        }
        return false;
    }
}
