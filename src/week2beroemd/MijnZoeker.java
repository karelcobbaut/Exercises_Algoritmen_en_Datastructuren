package week2beroemd;

import java.util.List;

public class MijnZoeker implements Zoeker {
    @Override

    public Persoon zoekBeroemdheid(List<Persoon> groep) {
        int j=groep.size()-1;
        int i = 0;
        if(j==-1){
            return null;
        }
        Persoon famous= groep.get(i);
        while(-1!=j && i!=groep.size()){
            System.out.println(i);
            System.out.println(j);
            if(groep.get(j).kent(famous) && !famous.kent(groep.get(j))){
                //System.out.println(j);

                j--;

            } else {
                /*System.out.println("---------------");
                System.out.println(i);
                System.out.println(j);
                System.out.println(groep.get(j).kent(famous));
                System.out.println(famous.kent(groep.get(j)));
                System.out.println("---------------");*/

                famous= groep.get(i);
                i++;

                j=groep.size()-1;
            }
        }
        System.out.println(i);
        System.out.println(j);
        if(j==-1){return famous;} else {return null;}



    }
}
