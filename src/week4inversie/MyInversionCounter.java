package week4inversie;

public class MyInversionCounter implements InversionCounter {

    private int[] myRij;
    private int total = 0;
    @Override
    public int countInversions(int[] rij) {
        myRij=rij;
        total = 0;
        int[] tempArr=recursiveCountInversions(0,rij.length-1);

        return total;
    }
    private int[] recursiveCountInversions(int i, int j){
        int len = j-i;
        if(len==0){
            int[] part = {myRij[i]};
            return part;
        }
        if(len==1){
            if(myRij[i]<myRij[j]) {
                int[] part = {myRij[i],myRij[j]};
                return part;
            } else {
                total+=1;
                int[] part = {myRij[j],myRij[i]};
                return part;
            }
        }
        int mid = (i+j)/2;
        int[] inv1 = recursiveCountInversions(i,mid-1);
        int[] inv2 = recursiveCountInversions(mid,j);
        return merge(inv1,inv2);
    }
    private int[] merge(int[] arr1, int[] arr2){
        //len2 always bigger
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] newArr = new int[len1+len2];
        int i=0;
        int j=0;
        while(j<len2 && i<len1){

            if(arr1[i]<arr2[j]) {
                newArr[i+j]=arr1[i];
                i++;
            }
            else{
                total+=len1-i;
                newArr[i+j]=arr2[j];
                j++;
            }

        }

        while(j<len2){
            newArr[i+j]=arr2[j];
            j++;
        }
        while(i<len1){
            newArr[i+j]=arr1[i];
            i++;
        }
        return newArr;


    }
}
