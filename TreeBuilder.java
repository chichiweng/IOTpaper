package Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import net.datastructures.Edge;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;
public class TreeBuilder {
	static int[] I = { 1, 0 };
	static int[] J = { 0, 1 };

	public static String[][] BuilderTree(WarehouseMap maps) {
		int[][] orgMap = maps.getMap();
		int edgesI = orgMap.length;
		int edgesJ = orgMap[0].length;
		ArrayList<String[]> tempEdges = new ArrayList<String[]>();
		for (int i = 0; i < edgesI; i++) {
			for (int j = 0; j < edgesJ; j++) {
				if (orgMap[i][j] == 0) {
					for (int k = 0; k < 2; k++) {
						int temI = i + I[k];
						int temJ = j + J[k];
						if (checkEdges(temI, temJ, edgesI, edgesJ) && orgMap[temI][temJ] == 0) {
							String[] p = new String[3];
							p[0] = i + "_" + j;
							p[1] = temI + "_" + temJ;
							p[2] = "1";
							tempEdges.add(p);
						}
					}
				}
			}
		}
		String[][] edges = new String[tempEdges.size()][];
		for (int i = 0; i < tempEdges.size(); i++) {
			edges[i] = tempEdges.get(i);
		}
		return edges;
	}

	private static boolean checkEdges(int i, int j, int edgesI, int edgesJ) {
		if (i < edgesI && j < edgesJ) {
			return true;
		}
		return false;
	}

	public static void detail(String[][] edges) {
		// 依邊列舉陣列建構圖形
		MyGraph<String, Integer> graph = MyGraph.graphFromEdgelist(edges, false); // true無向圖

		// System.out.printf("graph=\n%s\n", graph);
		// System.out.printf("\ngraph=\n%s\n", graph.print());

		// 設定最短路徑起點
		Vertex<String> src = graph.getVertex("0_0");
		// System.out.printf("\nsource vertex=%s\n", src.getElement());

		Map<Vertex<String>, Integer> pathDistanceToVertex;
		Map<Vertex<String>, Edge<Integer>> forest;
		// 執行Dijkstra演算法,求解src到其餘各頂點的最短路徑距離
		// 利用最短路徑距離,重建最短路徑走訪樹,可由每一頂點找到其尋獲邊
		// System.out.printf("\nexecute shortestPathLengths\n");
		pathDistanceToVertex = GraphAlgorithms.shortestPathLengths(graph, src);

		// System.out.printf("\nexecute spTree\n");
		forest = GraphAlgorithms.spTree(graph, src, pathDistanceToVertex);

		// String input = InputVertex();
		// // System.out.println(input);
		// // 列印最短路徑結果:
		// // 列印src到其餘各頂點的最短路徑距離
		// Vertex<String> v = graph.getVertex(input);
		// int d = pathDistanceToVertex.get(v);
		// System.out.printf("\npathDistanceToVertex=\n");
		// System.out.printf(" shortest distance from %s to %s is %5d\n",
		// src.getElement(), v.getElement(), d);

		
		// }

		// }
		// System.out.println("非有效的座標");

		 // 列印每一頂點及其尋獲邊
//		 System.out.printf("\nforest=\n");
//		 for(Vertex<String> v : forest.keySet())
//		 {
//		 Edge<Integer> e = forest.get(v);
//		 Vertex<String> vParent = graph.opposite(v, e);
//		 System.out.printf(" Dijkstra tree edge: from v:%s to v:%s\n",
//		 vParent.getElement(), v.getElement());
//		 }
		
		// // 列印起點到每一頂點的最短路徑
		 System.out.printf("\nshortest paths from v:%s=\n",src.getElement());
		 for(Vertex<String> v : graph.vertices())
		 {
		 Iterable<Edge<Integer>> path =
		 GraphAlgorithms.constructPath(graph, src, v, forest);
		
		 System.out.printf("\n shortest path from v:%s to v:%s with tot_len=%5d is\n",
		 src.getElement(), v.getElement(), pathDistanceToVertex.get(v));
		
		 Vertex<String> fromV = src;
		 int count = 0;
		 int totalLen = 0;
		 for(Edge<Integer> e : path)
		 {
		 //System.out.printf("\te:%d\n",e.getElement());
		 Vertex<String> toV = graph.opposite(fromV, e);
		 int d = e.getElement();
		 totalLen += d;
		
		 System.out.printf("\tedge #%d, from v:%s to v:%s, len:%d (tot:%d)\n",
		 ++count, fromV.getElement(), toV.getElement(), d, totalLen);
		
		 fromV = toV;
		 }
		 System.out.printf("\n");
		 }
		 }

	
}
