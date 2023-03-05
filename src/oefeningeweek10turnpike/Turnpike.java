package oefeningeweek10turnpike;

import java.util.Map;
import java.util.Set;

public interface Turnpike {

    /**
     * Gegeven een verzameling van collineaire punten, geef de afstand tussen
     * elk paar punten terug.
     *
     * @param points De coördinaten van de punten
     * @return De multiset met afstanden. Elke afstand wordt afgebeeld op het
     *         aantal keer dat hij voorkomt in de multiset.
     */
    public Map<Integer, Long> pointsToDistances(Set<Integer> points);

    /**
     * Deze methode berekent een arbitraire oplossing voor het turnpike
     * probleem. Als er geen oplossing mogelijk is, wordt null teruggegeven.
     * Anders geeft deze methode een arbitraire canonische (de oplossing bevat
     * coördinaat 0 en alle andere coördinaten zijn strikt positief) oplossing.
     *
     * @param distances Multiset met afstanden tussen elk paar punten. Elke
                        afstand wordt afgebeeld op zijn aantal voorkomens.
     * @return Een gereconstrueerde puntenverzameling die aanleiding geeft
     *         tot de gegeven afstanden, die steeds 0 bevat, of null als
     *         er geen oplossing is.
     */
    public Set<Integer> distancesToPoints(Map<Integer, Long> distances);

}
