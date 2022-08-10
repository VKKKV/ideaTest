package atguigu.dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on 2022/8/2星期二17:46
 *
 * @author abc
 * <p>
 * 无向图
 */
public class Graph {
    private final ArrayList<String> vertexList = new ArrayList<>();
    private final int[][] edges;
    private int numOfEdges;

    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    public static void main(String[] args) {
        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(8);

        for (String s : str) {
            graph.insertVertex(s);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.getGraph();

        System.out.println("深度遍历");
        graph.dfs(); // [1->2->4->8->5->3->6->7]

        System.out.println();
        System.out.println("广度优先");
        graph.bfs(); // [1->2->3->4->5->6->7->8]

    }

    private void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


    private void bfs(boolean[] isVisited, int i) {
        int u;//队列下标
        int w;

        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(vertexList.get(i) + ">>");
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.remove();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(vertexList.get(w) + ">>");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }


    private void dfs() {

        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getValue(i) + ">>");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    private int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;

    }

    public void getGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public void insertVertex(String str) {
        vertexList.add(str);
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValue(int i) {
        return vertexList.get(i);
    }


    public int getWeight(int i, int j) {
        return edges[i][j];

    }


    public void insertEdge(int i, int j, int weight) {
        edges[i][j] = weight;
        edges[j][i] = weight;
        numOfEdges++;

    }
}
