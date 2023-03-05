package oefeningenweek1.doubleletters;

public class MyDoubler implements Doubler {
    @Override
    public boolean isDouble(String str) {
        if(str.length()<2){
            return false;
        } else {
            str = str.toLowerCase();
            int strLength = str.length();
            int i = 0;
            char c = str.charAt(i);
            int j = str.indexOf(c,i+1);
            while(i<strLength && j !=-1 && str.indexOf(c,j+1)==-1){
                str += c;
                i++;
                c = str.charAt(i);
                j = str.indexOf(c,i+1);
            }
            if(i==strLength){
                return true;
            } else {
                return false;
            }
        }
    }
}
