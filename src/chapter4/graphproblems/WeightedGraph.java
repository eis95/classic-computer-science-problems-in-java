package chapter4.graphproblems;

import java.util.Arrays;
import java.util.List;

public class WeightedGraph<V> extends Graph<V, WeightedEdge> {

    public static final String SEATTLE = "Seattle";
    public static final String SAN_FRANCISCO = "San Francisco";
    public static final String LOS_ANGELES = "Los Angeles";
    public static final String RIVERSIDE = "Riverside";
    public static final String PHOENIX = "Phoenix";
    public static final String CHICAGO = "Chicago";
    public static final String BOSTON = "Boston";
    public static final String NEW_YORK = "New York";
    public static final String ATLANTA = "Atlanta";
    public static final String MIAMI = "Miami";
    public static final String DALLAS = "Dallas";
    public static final String HOUSTON = "Houston";
    public static final String DETROIT = "Detroit";
    public static final String PHILADELPHIA = "Philadelphia";
    public static final String WASHINGTON = "Washington";

    public WeightedGraph(List<V> vertices) {
        super(vertices);
    }

    public void addEdge(WeightedEdge edge) {
        edges.get(edge.fromVertexU).add(edge);
        edges.get(edge.toVertexV).add(edge.reversed());
    }

    public void addEdge(int fromVertexU, int toVertexV, float weight) {
        addEdge(new WeightedEdge(fromVertexU, toVertexV, weight));
    }

    public void addEdge(V first, V second, float weight) {
        addEdge(indexOf(first), indexOf(second), weight);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getVertexCount(); i++) {
            stringBuilder.append(vertexAt(i));
            stringBuilder.append(" -> ");
            stringBuilder.append(Arrays.toString(edgesOf(i).stream()
                .map(weightedEdge -> "(" + vertexAt(weightedEdge.toVertexV) + ", " + weightedEdge.weight + ")").toArray()));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        WeightedGraph<String> weightedCityGraph = new WeightedGraph<>(
                List.of(SEATTLE, SAN_FRANCISCO, LOS_ANGELES, RIVERSIDE, PHOENIX, CHICAGO, BOSTON, NEW_YORK,
                        ATLANTA, MIAMI, DALLAS, HOUSTON, DETROIT, PHILADELPHIA, WASHINGTON)
        );
        weightedCityGraph.addEdge(SEATTLE, CHICAGO, 1737);
        weightedCityGraph.addEdge(SEATTLE, SAN_FRANCISCO, 678);
        weightedCityGraph.addEdge(SAN_FRANCISCO, RIVERSIDE, 386);
        weightedCityGraph.addEdge(SAN_FRANCISCO, LOS_ANGELES, 348);
        weightedCityGraph.addEdge(LOS_ANGELES, RIVERSIDE, 50);
        weightedCityGraph.addEdge(LOS_ANGELES, PHOENIX, 357);
        weightedCityGraph.addEdge(RIVERSIDE, PHOENIX, 307);
        weightedCityGraph.addEdge(RIVERSIDE, CHICAGO, 1704);
        weightedCityGraph.addEdge(PHOENIX, DALLAS, 887);
        weightedCityGraph.addEdge(PHOENIX, HOUSTON, 1015);
        weightedCityGraph.addEdge(DALLAS, CHICAGO, 805);
        weightedCityGraph.addEdge(DALLAS, ATLANTA, 721);
        weightedCityGraph.addEdge(DALLAS, HOUSTON, 225);
        weightedCityGraph.addEdge(HOUSTON, ATLANTA, 702);
        weightedCityGraph.addEdge(HOUSTON, MIAMI, 968);
        weightedCityGraph.addEdge(ATLANTA, CHICAGO, 588);
        weightedCityGraph.addEdge(ATLANTA, WASHINGTON, 543);
        weightedCityGraph.addEdge(ATLANTA, MIAMI, 604);
        weightedCityGraph.addEdge(MIAMI, WASHINGTON, 923);
        weightedCityGraph.addEdge(CHICAGO, DETROIT, 238);
        weightedCityGraph.addEdge(DETROIT, BOSTON, 613);
        weightedCityGraph.addEdge(DETROIT, WASHINGTON, 396);
        weightedCityGraph.addEdge(DETROIT, NEW_YORK, 482);
        weightedCityGraph.addEdge(BOSTON, NEW_YORK, 190);
        weightedCityGraph.addEdge(NEW_YORK, PHILADELPHIA, 81);
        weightedCityGraph.addEdge(PHILADELPHIA, WASHINGTON, 123);

        System.out.println(weightedCityGraph);
    }
}