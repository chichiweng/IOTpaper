package Map;

import java.util.Scanner;

import net.datastructures.Edge;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;

public class PathDistance {
	MyGraph<String, Integer> graph;
	public PathDistance(MyGraph<String, Integer> graph){
		this.graph = graph; // true�o��D
	}
	
	public static void detail(String[][] edges) {
		// �O�����·�����c
		PathDistance pd= new PathDistance(MyGraph.graphFromEdgelist(edges, false));
		
		Map<Vertex<String>, Integer> pathDistanceToVertex= pd.getShortestPathLengths("0_0");
		String input = InputVertex();
		Vertex<String> v = pd.getVertex(input);
		int d = pathDistanceToVertex.get(v);
		System.out.printf("\npathDistanceToVertex=\n");
		System.out.printf(" shortest distance from %s to %s is %5d\n", pd.getVertex("0_0").getElement(), v.getElement(), d);
		
	}
	// ����Dijkstra���㷨,���src�����N����c�����·�����x
	// �������·�����x,�ؽ����·�����L��,����ÿһ��c�ҵ��䌤�@߅
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
	

	// ݔ������ֵ
	public static String InputVertex() {
		String FinalVertex;
		Scanner sca = new Scanner(System.in);
		System.out.println("Ոݔ�����ԃ������(i_j)��(�������հ���Ԫ���հ��I��Tab)");
		FinalVertex = sca.next();
		System.out.println("��ݔ������˞飺\n" + FinalVertex);
		return FinalVertex;

	}
}
