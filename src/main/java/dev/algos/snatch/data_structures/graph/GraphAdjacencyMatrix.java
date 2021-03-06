package dev.algos.snatch.data_structures.graph;


import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class GraphAdjacencyMatrix<T> implements WeightedGraph<T> {
    private int size;
    private int[][] weights;
    private boolean[][] edges;
    private GraphNode<T>[] vertices;
    private boolean directed;

    public GraphAdjacencyMatrix(GraphNode<T>[] nodes, boolean directed) {
        this.size = nodes.length;
        this.edges = new boolean[size][size];
        this.weights = new int[size][size];
        this.vertices = nodes;
        this.directed = directed;
    }

    public GraphAdjacencyMatrix(GraphNode<T>[] nodes) {
        this.size = nodes.length;
        this.edges = new boolean[size][size];
        this.weights = new int[size][size];
        this.vertices = nodes;
        this.directed = false;
    }

    @Override
    public void addEdge(GraphNode<T> a, GraphNode<T> b) {
        int i = findNodeIndex(a);
        int j = findNodeIndex(b);

        edges[i][j] = true;
        if (!directed) {
            edges[j][i] = true;
        }
    }

    public void addEdge(GraphNode<T> a, GraphNode<T> b, int weight) {
        int i = findNodeIndex(a);
        int j = findNodeIndex(b);

        edges[i][j] = true;
        weights[i][j] = weight;
        if (!directed) {
            edges[j][i] = true;
            weights[j][i] = weight;
        }
    }


    public Map<GraphNode<T>, Integer> getNeighbors(GraphNode<T> node) {
        int index = findNodeIndex(node);
        Map<GraphNode<T>, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            if (i != index && edges[index][i]) {
                result.put(vertices[i], weights[index][i]);
            }
        }
        return result;
    }

    @Override
    public void removeEdge(GraphNode<T> a, GraphNode<T> b) {
        int i = findNodeIndex(a);
        int j = findNodeIndex(b);

        edges[i][j] = false;
        weights[i][j] = 0;
        edges[j][i] = false;
        weights[j][i] = 0;
    }

    public List<WeightedGraphAdjacencyList.Edge<T>> getAllEdges() {
        List<WeightedGraphAdjacencyList.Edge<T>> edgeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (edges[i][j]) {
                    edgeList.add(new WeightedGraphAdjacencyList.Edge<T>(weights[i][j], vertices[i], vertices[j]));
                }
            }
        }
        return edgeList;
    }

    @Override
    public String edgesToString() {
        List<List<String>> edgeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (edges[i][j]) {
                    edgeList.add(List.of(vertices[i].getVal().toString(), vertices[j].getVal().toString()));
                }
            }
        }
        return edgeList.toString();
    }

    public int size() {
        return size;
    }

    public int findNodeIndex(GraphNode<T> node) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(node)) {
                return i;
            }
        }
        throw new NoSuchElementException(node.toString());
    }

    @Override
    public List<GraphNode<T>> getGraphNodes() {
        return List.of(vertices);
    }
}

