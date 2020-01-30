package c07_graph_theory;

import java.io.File;

public class Main {
    public static void main(String[] args){
        SparseGraph sparseGraph = new SparseGraph(7, false);
        new ReadGraph(sparseGraph,"src/c07_graph_theory/testG2.txt");
        Path path = new Path(sparseGraph, 0);
        path.showPath(6);
        System.out.println();
        ShortestPath shortestPath = new ShortestPath(sparseGraph, 0);
        shortestPath.showPath(6);
        int length = shortestPath.length(6);
        System.out.println();
        System.out.println(length);
//        sparseGraph.show();
//        Component component = new Component(sparseGraph);
//        System.out.println("testG1.txt \t"+"Component count:"+component.getCount());

//        DenseGraph denseGraph = new DenseGraph(7, false);
//        new ReadGraph(denseGraph,"src/c07_graph_theory/testG2.txt");
//        denseGraph.show();
//        Component component1 = new Component(denseGraph);
//        System.out.println("testG2.txt \t"+"Component count:"+component1.getCount());
    }
}
