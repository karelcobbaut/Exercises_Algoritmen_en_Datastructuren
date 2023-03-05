package week2feestje;

import java.util.Collections;
import java.util.List;

public class MyParty implements Party {
    @Override
    public boolean check(List<Interval> helpers, int start, int stop) {
        Collections.sort(helpers);
        int len = helpers.size();
        if(len == 0 || helpers.get(0).getStart() > start){
            return false;
        }

        int i= 0;
        int helperStop = helpers.get(i).getStop();
        while(helperStop<stop && i<len){

            Interval helper2 = helpers.get(i);
            if(helper2.getStart()<start && helper2.getStop()>=start && helperStop <helper2.getStop()){
                helperStop = helper2.getStop();
            }
            if(helperStop<=helper2.getStop() && helper2.getStart()<=helperStop){
                helperStop = helper2.getStop();

            }
            i++;
        }
        if(helperStop>=stop){
            return true;
        }
        else{
            return false;
        }
    }

}
