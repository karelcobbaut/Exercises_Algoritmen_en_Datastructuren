package week8kleuring;

import graphlib.graphs.UndirectedGraph;
import java.util.HashSet;
import graphlib.nodes.Node;
import java.util.List;
public class BreedteEerstZoeker implements TweeKleuringZoeker {
    private HashSet<Node<String>> kleurA;
    private HashSet<Node<String>> kleurB;
    UndirectedGraph<String> myGraph;
    private int vertexCount;
    @Override
    public TweeKleuring kleur(UndirectedGraph<String> graph) {
        myGraph=graph;
        kleurB = new HashSet<>();
        kleurA = new HashSet<>();
        List<Node<String>> toppen = graph.getAllNodes();
        vertexCount = toppen.size();
        int len=toppen.size();
        //if(len==0) return null;
        try{
            int i=0;
            while(vertexCount!=(kleurA.size())+kleurB.size()) {
                recursiveColoring(toppen.get(i), true);
                i++;
            }
        } catch(RuntimeException e){
            return null;
        }
        TweeKleuring kleuring = new TweeKleuring(kleurA,kleurB);
        return kleuring;
    }
    private void recursiveColoring(Node<String> parent, boolean kleur){
        if(!kleurA.contains(parent)&&!kleurB.contains(parent)){
            if(kleur) kleurA.add(parent);
            else kleurB.add(parent);
        }
        for(Node<String> node: myGraph.getNeighbours(parent) ){
            if(!kleurA.contains(node) && !kleurB.contains(node)){
                recursiveColoring(node, !kleur);
            } else{
                if((kleurA.contains(parent)&& kleurA.contains(node))||(kleurB.contains(parent) && kleurB.contains(node))) throw new RuntimeException();
            }
        }
    }
}
