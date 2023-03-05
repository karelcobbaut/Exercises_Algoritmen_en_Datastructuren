package week4circ;

public class MijnMaximumBepaler implements MaximumBepaler {
    @Override
    public int bepaalMaximum(int... rij) {
        if(rij.length==-1){
            throw new IllegalArgumentException();
        }
        return recursiveMaximum(rij,0,rij.length-1);
    }
    private int recursiveMaximum(int[] rij, int i, int j){
        int len = j-i;

        if(len==0){
            return rij[i];
        }
        int mid = i+len/2;
        if(rij[i]>rij[mid+1]){
            return recursiveMaximum(rij,i,mid);
        } else {
            return recursiveMaximum(rij,mid+1,j);
        }
    }
}
