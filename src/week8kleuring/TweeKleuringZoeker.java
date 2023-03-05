package week8kleuring;

import graphlib.graphs.UndirectedGraph;

public interface TweeKleuringZoeker {
    
    TweeKleuring kleur(UndirectedGraph<String> graph);
    
}
