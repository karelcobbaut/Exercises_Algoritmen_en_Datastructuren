package week8kleuring;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Arrays;

import graphlib.graphs.UndirectedGraph;
import graphlib.nodes.Node;

public class TweeKleuring {

    private final Set<Node<String>> aKleurig;
    private final Set<Node<String>> bKleurig;

    public TweeKleuring() {
        aKleurig = new HashSet<>();
        bKleurig = new HashSet<>();
    }

    public TweeKleuring(Collection<Node<String>> aKleurig, Collection<Node<String>> bKleurig) {
        this.aKleurig = new HashSet<>(aKleurig);
        this.bKleurig = new HashSet<>(bKleurig);
    }

    public void kleurA(Node<String> n) {
        aKleurig.add(n);
    }

    public void kleurB(Node<String> n) {
        bKleurig.add(n);
    }

    public Set<Node<String>> getAKleurig() {
        return Collections.unmodifiableSet(aKleurig);
    }

    public Set<Node<String>> getBKleurig() {
        return Collections.unmodifiableSet(bKleurig);
    }

    public String toString() {
        return nodesToString(aKleurig) + " | " + nodesToString(bKleurig);
    }

    private String nodesToString(Set<Node<String>> nodes) {
        return nodes.stream().map(Node::key).collect(
            Collectors.joining(" ")
        );
    }

    /* -----------------------------------------------------------------
     * Hieronder staat code die wij gebruiken in de testen. Je kan deze
     * ook gebruiken in jouw code, maar zal ze normaal niet nodig
     * hebben.
     *
     * Je kan ze eventueel ook wijzigen, maar op Dodona zullen we
     * uiteraard ons origineel gebruiken. */

    @SafeVarargs
    public final TweeKleuring buildA(Node<String>... nodes) {
        aKleurig.addAll(Arrays.asList(nodes));
        return this;
    }

    @SafeVarargs
    public final TweeKleuring buildB(Node<String>... nodes) {
        bKleurig.addAll(Arrays.asList(nodes));
        return this;
    }

    public boolean equals(Object object) {
        if(this == object) return true;
        if(!(object instanceof TweeKleuring that)) return false;

        return (this.aKleurig.equals(that.aKleurig) && this.bKleurig.equals(that.bKleurig))
            || (this.aKleurig.equals(that.bKleurig) && this.bKleurig.equals(that.aKleurig));
    }

    public boolean isTweeKleuringVoor(UndirectedGraph<String> graph) {
        return aKleurig.size() + bKleurig.size() == graph.numNodes()
            && !bevatDubbeleKleuren()
            && TweeKleuring.geenConflictIn(aKleurig, graph)
            && TweeKleuring.geenConflictIn(bKleurig, graph);
    }

    public boolean bevatDubbeleKleuren() {
        return new HashSet<>(aKleurig).removeAll(bKleurig);
    }

    private static boolean geenConflictIn(Set<Node<String>> k, UndirectedGraph<String> graph) {
        return k.stream().allMatch(n1 -> k.stream().allMatch(n2 ->
            n1 == n2 || graph.getEdge(n1, n2) == null
        ));
    }

}
