package week6potjes;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class MyMatcher implements Matcher {
    ArrayList<Jar> myJars;
    ArrayList<Lid> myLids;
    ArrayList<Pair> pairs;

    @Override
    public List<Pair> match(List<Jar> jars, List<Lid> lids) {

        myJars = new ArrayList<>(jars);
        myLids = new ArrayList<>(lids);
        pairs = new ArrayList<>();
        if(jars.size()!=0) recursiveMatch(0, jars.size() - 1);
        for (int i = 0; i < lids.size(); i++) {
            pairs.add(new Pair(myJars.get(i), myLids.get(i)));
        }
        return pairs;
    }

    private void recursiveMatch(int i, int j) {
        if(i>=j) return;
        if(j-i==1){
            if(myLids.get(i).compareTo(myJars.get(i))!=0){
                Collections.swap(myLids,i,j);

            }
            return;
        }
        assert(i<j);
        Jar jarSpil = myJars.get(i);

        int start = i;
        Lid lidSpil = myLids.get(start);
        for(int i_=i;i_<=j;i_++){
            if(jarSpil.compareTo(myLids.get(i_))==0){
                Collections.swap(myLids,start,i_);
                lidSpil=myLids.get(start);
                start++;
            }
        }
        //assert(start !=i);
        int i_=start;
        int j_=j;
        while(i_<j_){
            while(i_<j_&&jarSpil.compareTo(myLids.get(i_))>0) i_++;
            while(i_<j_&&jarSpil.compareTo(myLids.get(j_))<0) j_--;
            if(i_<j_) {
                Collections.swap(myLids,i_,j_);
                i_++;
                //j_--;
            }
        }
        assert(i_==j_);

        start = i;
        for(i_=i;i_<=j;i_++){
            if(lidSpil.compareTo(myJars.get(i_))==0){
                Collections.swap(myJars,start,i_);
                start++;
            }
        }
        //assert(start !=i);
        assert(lidSpil.compareTo(jarSpil)==0);
        i_=start;
        j_=j;
        while(i_<j_){
            while(i_<j_&&lidSpil.compareTo(myJars.get(i_))>0) i_++;
            while(i_<j_&&lidSpil.compareTo(myJars.get(j_))<0) j_--;
            if(i_<j_) {
                Collections.swap(myJars,i_,j_);
                i_++;
                //j_--;
            }
        }
        assert(i_==j_);

        recursiveMatch(start,i_);
        recursiveMatch(i_,j);
    }


}
