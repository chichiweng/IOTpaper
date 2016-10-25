package Map;

import java.util.Scanner;

import net.datastructures.Edge;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;

public class PathDistance {
	MyGraph<String, Integer> graph;
	public PathDistance(MyGraph<String, Integer> graph){
		this.graph = graph; // true無向圖
	}
	
	public static void detail(String[][] edges) {
		// 設定最短路徑起點
		PathDistance pd= new PathDistance(MyGraph.graphFromEdgelist(edges, false));
		
		Map<Vertex<String>, Integer> pathDistanceToVertex= pd.getShortestPathLengths("0_0");
		String input = InputVertex();
		Vertex<String> v = pd.getVertex(input);
		int d = pathDistanceToVertex.get(v);
		System.out.printf("\npathDistanceToVertex=\n");
		System.out.printf(" shortest distance from %s to %s is %5d\n", pd.getVertex("0_0").getElement(), v.getElement(), d);
		
	}
	// 執行Dijkstra演算法,求解src到其餘各頂點的最短路徑距離
	// 利用最短路徑距離,重建最短路徑走訪樹,可由每一頂點找到其尋獲邊
	public Vertex<String> getVertex(String pathName){
		return  this.graph.getVertex(pathName);
	}
	
	public Map<Vertex<String>, Integer> getShortestPathLengths(String pathName){
		// System.out.printf("\nexecute shortestPathLengths\n");
		return  GraphAlgorithms.shortestPathLengths(this.graph,  this.graph.getVertex(pathName));
	}
	
	public Map<Vertex<String>, Edge<Integer>> Dijkstra(String pathName){
		// System.out.printf("\nexecute spTree\n");
		GraphAlgorithms.spTree(graph, getVertex(pathName), getShortestPathLengths(pathName));
		return null;
	}
	

	// 輸入座標值
	public static String InputVertex() {
		String FinalVertex;
		Scanner sca = new Scanner(System.in);
		System.out.println("請輸入想查詢的座標(i_j)：(不包含空白字元、空白鍵、Tab)");
		FinalVertex = sca.next();
		System.out.println("您輸入的座標為：\n" + FinalVertex);
		return FinalVertex;

	}
}
