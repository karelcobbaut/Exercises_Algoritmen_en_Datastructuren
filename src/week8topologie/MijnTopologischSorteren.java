package week8topologie;
import graphlib.graphs.DirectedGraph;
import graphlib.nodes.Node;
import graphlib.edges.DirectedEdge;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.HashMap;
public class MijnTopologischSorteren implements TopologischSorteren {
    @Override
    public List<Node<String>> bepaalTopologischeOrdening(DirectedGraph<String> graph) {
        HashMap<String, Integer> myMap = new HashMap<>();
        List<Node<String>> myList = new ArrayList<>();
        ArrayDeque<Node<String>> myStack = new ArrayDeque<>();
        for(Node<String> node : graph.getAllNodes()){
            if(graph.getIndegree(node)==0) {
                myStack.add(node);
            }
            myMap.put(node.key(),graph.getIndegree(node));
        }
        if(myStack.size()==0) throw new IllegalArgumentException();
        while(myStack.size()!=0){
            Node<String> parentNode = myStack.pop();
            myList.add(parentNode);
            for(DirectedEdge<String> edge: graph.getOutgoingEdges(parentNode)){
                Node<String> myNode = edge.getDestination();
                myMap.put(myNode.key(),myMap.get(myNode.key())-1);
                if(myMap.get(myNode.key())==0) myStack.add(myNode);
            }
        }
        if(myList.size()!=myMap.size()) throw new IllegalArgumentException();
        return myList;
    }
}
