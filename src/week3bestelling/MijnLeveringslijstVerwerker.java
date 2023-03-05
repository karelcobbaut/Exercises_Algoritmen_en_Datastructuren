package week3bestelling;

import java.util.Collection;
import java.util.List;
import java.util.HashMap;

public class MijnLeveringslijstVerwerker implements LeveringslijstVerwerker {

    public class MijnLeveringsOverzicht implements LeveringsOverzicht{

        private HashMap<String, Integer> artikelMap;
        @Override
        public Collection<Artikel> getBesteldeArtikels(Leverancier l) {
            return null;
        }

        @Override
        public int getAantalArtikels(Leverancier l, Artikel a) {
            return 5;
        }
    }
    @Override
    public LeveringsOverzicht getLeveringsLijst(List<Bestelling> bestellingen) {
        return null;
    }

}
