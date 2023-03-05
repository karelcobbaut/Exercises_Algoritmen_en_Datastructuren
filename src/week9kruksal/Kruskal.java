package week9kruksal;

import graphlib.graphs.UndirectedGraph;
import graphlib.nodes.Node;
import graphlib.edges.UndirectedEdge;

import java.util.HashMap;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

class myCompare implements Comparator<UndirectedEdge<String>>{

    @Override
    public int compare(UndirectedEdge<String> o1, UndirectedEdge<String> o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}

public class Kruskal implements Spanner {
    @Override
    public UndirectedGraph<String> span(UndirectedGraph<String> graph) {
        //int[] myParts = new int[graph.numNodes()];
        HashMap<String,Integer> myMap = new HashMap<>();
        UndirectedGraph<String> returnGraph= new UndirectedGraph<>();

        List<Node<String>> myList = graph.getAllNodes();
        for(int i=0;i<graph.numNodes();i++){
            myMap.put(myList.get(i).key(),i);
            returnGraph.addNode(myList.get(i));
        }

        PriorityQueue<UndirectedEdge<String>> myQueue = new PriorityQueue<>(new myCompare());
        myQueue.addAll(graph.getAllEdges());

        if(myQueue.size()==0) return graph;
        UndirectedEdge<String> myEdge = myQueue.poll();
        returnGraph.addEdge(myEdge);

        int key1=myMap.get(myEdge.getNode1().key());
        int key2=myMap.get(myEdge.getNode2().key());

        myMap.put(myEdge.getNode1().key(),min(key2,key1));
        myMap.put(myEdge.getNode2().key(),min(key2,key1));

        while(returnGraph.numEdges()!=myMap.size()-1){
            myEdge = myQueue.poll();
            key1=myMap.get(myEdge.getNode1().key());
            key2=myMap.get(myEdge.getNode2().key());

            if(key1!=key2){
                returnGraph.addEdge(myEdge);
                int myMin =  min(key1,key2);
                int myMax =  max(key1,key2);
                for(String key: myMap.keySet()){
                    if(myMap.get(key)==myMax) myMap.put(key,myMin);
                }

            }
        }

        //returnGraph.removeNode(nodeList.get(0));


        return returnGraph;
    }
}
