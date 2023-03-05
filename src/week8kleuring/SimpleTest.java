package week8kleuring;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import graphlib.edges.UndirectedEdge;
import graphlib.graphs.UndirectedGraph;
import graphlib.nodes.Node;
import graphlib.util.Graphs;

public class SimpleTest {
    
    private static TweeKleuringZoeker tkz;
    
    @BeforeClass 
    public static void init() {
        tkz = new BreedteEerstZoeker();
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(new TweeKleuring(), tkz.kleur(new UndirectedGraph<>()));
    }

    @Test
    public void testSingle() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> n = graph.addNode("n");
        Assert.assertEquals(
            new TweeKleuring().buildA(n),
            tkz.kleur(graph)
        );
    }

    @Test
    public void testPair() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob");
        graph.addEdge(a, b);
        Assert.assertEquals(
            new TweeKleuring().buildA(a).buildB(b),
            tkz.kleur(graph)
        );
    }

    @Test
    public void testLine() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol");
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        Assert.assertEquals(
            new TweeKleuring().buildA(a, c).buildB(b),
            tkz.kleur(graph)
        );
    }

    @Test
    public void testTriangle() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol");
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, a);
        Assert.assertNull(tkz.kleur(graph));
    }

    @Test
    public void testTwoPair() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol"),
             d = graph.addNode("dave");
        graph.addEdge(a, b);
        graph.addEdge(c, d);

        TweeKleuring kleuring = tkz.kleur(graph);
        Assert.assertNotNull(kleuring);
        Assert.assertTrue(kleuring.equals(new TweeKleuring().buildA(a, c).buildB(b, d))
                       || kleuring.equals(new TweeKleuring().buildA(a, d).buildB(b, c)));
    }

    @Test
    public void testStar() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol"),
             m = graph.addNode("mallory");
        graph.addEdge(a, m);
        graph.addEdge(b, m);
        graph.addEdge(c, m);
        
        Assert.assertEquals(
            new TweeKleuring().buildA(a, b, c).buildB(m),
            tkz.kleur(graph)
        );
    }

    @Test
    public void testTriangleSingle() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol"),
             d = graph.addNode("dave");
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(d, b);

        Assert.assertNull(tkz.kleur(graph));
    }

    @Test
    public void testKeyhole() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol"),
             d = graph.addNode("dave");
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(d, b);

        Assert.assertNull(tkz.kleur(graph));
    }

    @Test
    public void testCompleteFour() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        Node<String> a = graph.addNode("alice"),
             b = graph.addNode("bob"),
             c = graph.addNode("carol"),
             d = graph.addNode("dave");
        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(a, d);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(c, d);

        Assert.assertNull(tkz.kleur(graph));
    }

}