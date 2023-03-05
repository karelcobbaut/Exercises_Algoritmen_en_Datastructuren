package week9kruksal;

import graphlib.edges.Edge;
import graphlib.graphs.UndirectedGraph;
import graphlib.edges.UndirectedEdge;
import graphlib.nodes.Node;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    Spanner kruskal = new Kruskal();

    private static double sumCosts(UndirectedGraph<String> tree) {
        return tree.getAllEdges().stream().mapToDouble(Edge::getWeight).sum();
    }

    @Test
    public void testSingleNode() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addNode("Alice");
        Assert.assertEquals(0.0, sumCosts(kruskal.span(graph)), 1e-8);
    }

    @Test
    public void testSingleEdge() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addEdge(new UndirectedEdge<>(
            graph.addNode("Alice"),
            graph.addNode("Bob"),
            10.0));
        Assert.assertEquals(10.0, sumCosts(kruskal.span(graph)), 1e-8);
    }

    @Test
    public void testVShape() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("Alice"),
                     b = graph.addNode("Bob"),
                     m = graph.addNode("Mallory");
        graph.addEdge(new UndirectedEdge<>(a, m, 10.0));
        graph.addEdge(new UndirectedEdge<>(m, b, 10.0));
        Assert.assertEquals(20.0, sumCosts(kruskal.span(graph)), 1e-8);
    }

    @Test
    public void testTriangle() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("Alice"),
                     b = graph.addNode("Bob"),
                     c = graph.addNode("Carol");
        graph.addEdge(new UndirectedEdge<>(a, b, 10.0));
        graph.addEdge(new UndirectedEdge<>(b, c, 5.0));
        graph.addEdge(new UndirectedEdge<>(c, a, 1.0));
        Assert.assertEquals(6.0, sumCosts(kruskal.span(graph)), 1e-8);
    }

}
