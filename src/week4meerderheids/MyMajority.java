package week4meerderheids;

public class MyMajority implements Majority {
    @Override
    public int findMajority(Sequence numbers) {
        return recursiveFindMajority(numbers,0,numbers.size()-1);
    }
    private int recursiveFindMajority(Sequence numbers, int i, int j){
        int len = j-i;

        if(len<=1){
            if(numbers.get(i)==numbers.get(j)){
                return numbers.get(i);
            } else {return -1 ;}
        }
        int mid = (i+j)/2;
        int c1 = recursiveFindMajority(numbers,i,mid);
        int c2 =  recursiveFindMajority(numbers,mid+1,j);
        if(c1==c2) return c1;
        else{
            int count1=0;
            int count2=0;
            for(int i_=i;i_<=j;i_++){
                if(numbers.get(i_)==c1)count1++;
                if(numbers.get(i_)==c2)count2++;
            }
            if(count1>(len+1)/2) return c1;
            else if(count2>(len+1)/2) return c2;
            else return -1;
        }


    }
}
