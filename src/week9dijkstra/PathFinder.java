package week9dijkstra;

import java.util.List;

import graphlib.nodes.Node;
import graphlib.graphs.DirectedGraph;

public interface PathFinder {

    List<Node<String>> shortestPath(DirectedGraph<String> graph, Node<String> source, Node<String> dest);

}
