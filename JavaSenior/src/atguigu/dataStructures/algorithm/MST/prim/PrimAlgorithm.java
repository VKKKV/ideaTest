package atguigu.dataStructures.algorithm.MST.prim;

import java.util.Arrays;

/**
 * Created on 2022/8/6星期六16:48
 *
 * @author abc
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex = data.length;

        //大数表示不连通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};


        MGraph mGraph = new MGraph(7);
        MinTree minTree = new MinTree();
        minTree.creatGraph(mGraph, vertex, data, weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);

    }

}


//创建最小生成树
class MinTree {
    public void creatGraph(MGraph graph, int vertex, char[] data, int[][] weight) {
        for (int i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public void prim(MGraph graph, int startVertex) {
        int[] visited = new int[graph.vertex];
        //1为已访问0为未访问
        visited[startVertex] = 1;

        //记录两个顶点的下标
        int index1 = -1;
        int index2 = -1;
        int minWeight = 10000;

        //遍历n-1条边
        for (int i = 1; i < graph.vertex; i++) {
            //查找子图最短边
            for (int j = 0; j < graph.vertex; j++) {
                for (int k = 0; k < graph.vertex; k++) {
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight) {
                        minWeight = graph.weight[j][k];
                        index1 = j;
                        index2 = k;
                    }
                }
            }
            System.out.println(graph.data[index1] + " " +
                    graph.data[index2] + " " +
                    graph.weight[index1][index2]);
            minWeight = 10000;
            visited[index2] = 1;
        }


    }
}


class MGraph {
    int vertex;//表示结点个数
    char[] data;//存放结点数据
    int[][] weight;//邻接矩阵

    public MGraph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}