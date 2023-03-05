package week2som;

import java.util.List;

public class MijnDrieSomProbleem implements DrieSomProbleem {
    @Override
    public TripletIndices zoekNulSomTriplet(List<Integer> gesorteerdeInvoer) {
        int i_ = 1;
        int s1 = 0;
        int s2 = 1;
        int j=0;
        int i = gesorteerdeInvoer.size() - 1;
        while (i_ < gesorteerdeInvoer.size() - 1 && s1 != -s2) {
            j = 0;
            i = gesorteerdeInvoer.size() - 1;
            s1 = gesorteerdeInvoer.get(i) + gesorteerdeInvoer.get(j);
            s2 = gesorteerdeInvoer.get(i_);
            while (i_ > j && i_ < i && s1 != -s2) {
                s1 = gesorteerdeInvoer.get(i) + gesorteerdeInvoer.get(j);
                if (s1 < -s2) {
                    j++;
                } else if (s1 > -s2) {
                    i--;
                }

            }
        i_++;
        }
        if (s1 == -s2) {
            return new TripletIndices(j, i_-1, i);
        } else {
            return null;
        }
    }

}
