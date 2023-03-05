package week9dijkstra;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;

import graphlib.edges.DirectedEdge;
import graphlib.graphs.DirectedGraph;
import graphlib.nodes.Node;

public class SimpleTest {

    PathFinder pathFinder = new Dijkstra();

    @Test
    public void testSingleton() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        Node<String> a = graph.addNode("Alice");
        Assert.assertEquals(
                Arrays.asList(a),
                pathFinder.shortestPath(graph, a, a)
        );
    }

    @Test
    public void testSingleEdge() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        Node<String> a = graph.addNode("Alice"),
                b = graph.addNode("Bob");
        graph.addEdge(new DirectedEdge<>(a, b, 5.0));

        Assert.assertEquals(Arrays.asList(a, b), pathFinder.shortestPath(graph, a, b));
        Assert.assertNull(pathFinder.shortestPath(graph, b, a));
    }

    @Test
    public void testVShape() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        Node<String> a = graph.addNode("Alice"),
                b = graph.addNode("Bob"),
                m = graph.addNode("Mallory");
        graph.addEdge(new DirectedEdge<>(a, m, 10.0));
        graph.addEdge(new DirectedEdge<>(m, b, 10.0));

        Assert.assertEquals(Arrays.asList(a), pathFinder.shortestPath(graph, a, a));
        Assert.assertEquals(Arrays.asList(a, m), pathFinder.shortestPath(graph, a, m));
        Assert.assertEquals(Arrays.asList(a, m, b), pathFinder.shortestPath(graph, a, b));
    }

    @Test
    public void testTriangle() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        Node<String> a = graph.addNode("Alice"),
                b = graph.addNode("Bob"),
                c = graph.addNode("Carol");
        graph.addEdge(new DirectedEdge<>(a, b, 5.0));
        graph.addEdge(new DirectedEdge<>(b, c, 5.0));
        graph.addEdge(new DirectedEdge<>(c, a, 5.0));

        Assert.assertEquals(Arrays.asList(a, b, c), pathFinder.shortestPath(graph, a, c));
        Assert.assertEquals(Arrays.asList(b, c, a), pathFinder.shortestPath(graph, b, a));
        Assert.assertEquals(Arrays.asList(c, a, b), pathFinder.shortestPath(graph, c, b));
    }
    @Test
    public void testTriangle2() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        Arrays.asList("Node[key=0]", "Node[key=1]", "Node[key=2]", "Node[key=3]", "Node[key=4]").forEach(graph::addNode);
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=0]"), graph.getNode("Node[key=4]"), 29.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=1]"), graph.getNode("Node[key=0]"), 81.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=1]"), graph.getNode("Node[key=4]"), 34.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=2]"), graph.getNode("Node[key=1]"), 123.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=2]"), graph.getNode("Node[key=3]"), 33.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=3]"), graph.getNode("Node[key=2]"), 132.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=4]"), graph.getNode("Node[key=0]"), 151.000000));
        graph.addEdge(new DirectedEdge(graph.getNode("Node[key=4]"), graph.getNode("Node[key=3]"), 178.000000));

        Assert.assertEquals(Arrays.asList(graph.getNode("Node[key=1]"), graph.getNode("Node[key=0]")), pathFinder.shortestPath(graph,graph.getNode("Node[key=1]"), graph.getNode("Node[key=0]")));

    }

}
