package oefeningenweek10subset;

import java.util.List;

public interface SubsetSum {

    /**
     * Geeft een selectie van elementen uit de invoerlijst terug die sommeren
     * tot het gegeven getal. Indien dit niet lukt, wordt null teruggegeven.
     */
    public List<Boolean> subsetSum(List<Integer> list, int sum);

}
