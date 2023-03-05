package week3verkiezing;

import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
public class MijnFormulierTeller implements FormulierTeller {
    @Override
    public Collection<String> tel(int aantalVerkozenen, List<String> stemmen) {
        if(aantalVerkozenen<=0){
            return null;
        }
        HashMap<String, Integer> kiesMap = new HashMap<>();

        for(String naam: stemmen){
            if(!kiesMap.containsKey(naam)){
                kiesMap.put(naam,1);
            } else {kiesMap.put(naam,kiesMap.get(naam)+1);}
        }
        ArrayList<Integer> stemLijst = new ArrayList<>(kiesMap.values());
        stemLijst.sort(null);
        ArrayList<String> namen = new ArrayList<>();

        int minimumVotes = stemLijst.get(stemLijst.size()-aantalVerkozenen);
        Iterator<HashMap.Entry<String, Integer>> it = kiesMap.entrySet().iterator();
        while(it.hasNext()){
            HashMap.Entry<String, Integer> naam = it.next();
            if(naam.getValue()>=minimumVotes){
                namen.add(naam.getKey());
            }

        }
        return namen;
    }
}
