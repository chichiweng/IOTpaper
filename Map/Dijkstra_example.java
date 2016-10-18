package Map;
/*
  Dijkstra_example.java

    1對多最短路徑執行範例,參考課本圖14.15-16, 616-617頁說明

> javac -cp sourcecode.jar;. Dijkstra_example
> java -cp sourcecode.jar;. Dijkstra_example

graph=
Vertex BOS
 4 adjacencies: (JFK, 187) (MIA, 1258) (ORD, 867) (SFO, 2704)
Vertex BWI
 3 adjacencies: (JFK, 184) (MIA, 946) (ORD, 621)
Vertex DFW
 5 adjacencies: (JFK, 1391) (LAX, 1235) (MIA, 1121) (ORD, 802) (SFO, 1464)
Vertex JFK
 6 adjacencies: (BOS, 187) (BWI, 184) (DFW, 1391) (MIA, 1090) (ORD, 740) (PVD, 144)
Vertex LAX
 3 adjacencies: (DFW, 1235) (MIA, 2342) (SFO, 337)
Vertex MIA
 5 adjacencies: (BOS, 1258) (BWI, 946) (DFW, 1121) (JFK, 1090) (LAX, 2342)
Vertex ORD
 6 adjacencies: (BOS, 867) (BWI, 621) (DFW, 802) (JFK, 740) (PVD, 849) (SFO, 1846)
Vertex PVD
 2 adjacencies: (JFK, 144) (ORD, 849)
Vertex SFO
 4 adjacencies: (BOS, 2704) (DFW, 1464) (LAX, 337) (ORD, 1846)


graph=
 edge 1: v:BOS to v:JFK, len=  187
 edge 2: v:BOS to v:MIA, len= 1258
 edge 3: v:BOS to v:ORD, len=  867
 edge 4: v:BOS to v:SFO, len= 2704
 edge 5: v:BWI to v:JFK, len=  184
 edge 6: v:BWI to v:MIA, len=  946
 edge 7: v:BWI to v:ORD, len=  621
 edge 8: v:DFW to v:JFK, len= 1391
 edge 9: v:DFW to v:LAX, len= 1235
 edge 10: v:DFW to v:MIA, len= 1121
 edge 11: v:DFW to v:ORD, len=  802
 edge 12: v:DFW to v:SFO, len= 1464
 edge 13: v:JFK to v:BOS, len=  187
 edge 14: v:JFK to v:BWI, len=  184
 edge 15: v:JFK to v:DFW, len= 1391
 edge 16: v:JFK to v:MIA, len= 1090
 edge 17: v:JFK to v:ORD, len=  740
 edge 18: v:JFK to v:PVD, len=  144
 edge 19: v:LAX to v:DFW, len= 1235
 edge 20: v:LAX to v:MIA, len= 2342
 edge 21: v:LAX to v:SFO, len=  337
 edge 22: v:MIA to v:BOS, len= 1258
 edge 23: v:MIA to v:BWI, len=  946
 edge 24: v:MIA to v:DFW, len= 1121
 edge 25: v:MIA to v:JFK, len= 1090
 edge 26: v:MIA to v:LAX, len= 2342
 edge 27: v:ORD to v:BOS, len=  867
 edge 28: v:ORD to v:BWI, len=  621
 edge 29: v:ORD to v:DFW, len=  802
 edge 30: v:ORD to v:JFK, len=  740
 edge 31: v:ORD to v:PVD, len=  849
 edge 32: v:ORD to v:SFO, len= 1846
 edge 33: v:PVD to v:JFK, len=  144
 edge 34: v:PVD to v:ORD, len=  849
 edge 35: v:SFO to v:BOS, len= 2704
 edge 36: v:SFO to v:DFW, len= 1464
 edge 37: v:SFO to v:LAX, len=  337
 edge 38: v:SFO to v:ORD, len= 1846


source vertex=BWI

execute shortestPathLengths

execute spTree

pathDistanceToVertex=
 shortest distance from BWI to PVD is   328
 shortest distance from BWI to BOS is   371
 shortest distance from BWI to LAX is  2658
 shortest distance from BWI to DFW is  1423
 shortest distance from BWI to MIA is   946
 shortest distance from BWI to JFK is   184
 shortest distance from BWI to ORD is   621
 shortest distance from BWI to SFO is  2467
 shortest distance from BWI to BWI is     0

forest=
 Dijkstra tree edge: from v:JFK to v:PVD
 Dijkstra tree edge: from v:ORD to v:SFO
 Dijkstra tree edge: from v:BWI to v:ORD
 Dijkstra tree edge: from v:BWI to v:JFK
 Dijkstra tree edge: from v:ORD to v:DFW
 Dijkstra tree edge: from v:BWI to v:MIA
 Dijkstra tree edge: from v:JFK to v:BOS
 Dijkstra tree edge: from v:DFW to v:LAX

shortest paths from v:BWI=

  shortest path from v:BWI to v:BOS with tot_len=  371 is
        edge #1, from v:BWI to v:JFK, len:184 (tot:184)
        edge #2, from v:JFK to v:BOS, len:187 (tot:371)


  shortest path from v:BWI to v:BWI with tot_len=    0 is


  shortest path from v:BWI to v:DFW with tot_len= 1423 is
        edge #1, from v:BWI to v:ORD, len:621 (tot:621)
        edge #2, from v:ORD to v:DFW, len:802 (tot:1423)


  shortest path from v:BWI to v:JFK with tot_len=  184 is
        edge #1, from v:BWI to v:JFK, len:184 (tot:184)


  shortest path from v:BWI to v:LAX with tot_len= 2658 is
        edge #1, from v:BWI to v:ORD, len:621 (tot:621)
        edge #2, from v:ORD to v:DFW, len:802 (tot:1423)
        edge #3, from v:DFW to v:LAX, len:1235 (tot:2658)


  shortest path from v:BWI to v:MIA with tot_len=  946 is
        edge #1, from v:BWI to v:MIA, len:946 (tot:946)


  shortest path from v:BWI to v:ORD with tot_len=  621 is
        edge #1, from v:BWI to v:ORD, len:621 (tot:621)


  shortest path from v:BWI to v:PVD with tot_len=  328 is
        edge #1, from v:BWI to v:JFK, len:184 (tot:184)
        edge #2, from v:JFK to v:PVD, len:144 (tot:328)


  shortest path from v:BWI to v:SFO with tot_len= 2467 is
        edge #1, from v:BWI to v:ORD, len:621 (tot:621)
        edge #2, from v:ORD to v:SFO, len:1846 (tot:2467)
*/

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;

import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.GraphExamples;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Vertex;
import net.datastructures.Edge;
import net.datastructures.Map;
import net.datastructures.ProbeHashMap;


// 擴充課本圖形類別
//   getVertex 依頂點名稱回傳頂點物件
//   graphFromEdgelist 可用2維邊列舉陣列建構圖形
//   outgoingEdges 依字母排序列舉鄰居頂點,方便和課本結果比對
//
class MyGraph<V,E> extends AdjacencyMapGraph<V,E>
{
  public static MyGraph<String,Integer>
    graphFromEdgelist(String[][] edges, boolean directed)
  {
    MyGraph<String,Integer> g = new MyGraph<>(directed);

    // first pass to get sorted set of vertex labels
    TreeSet<String> labels = new TreeSet<>();
    for (String[] edge : edges) {
      labels.add(edge[0]);
      labels.add(edge[1]);
    }

    // now create vertices (in alphabetical order)
    ProbeHashMap<String, Vertex<String> > verts = new ProbeHashMap<>();
    for (String label : labels)
      verts.put(label, g.insertVertex(label));

    // now add edges to the graph
    for (String[] edge : edges) {
      Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2]));
      g.insertEdge(verts.get(edge[0]), verts.get(edge[1]), cost);
    }
    return g;
  }

  // 圖形建構子
  public MyGraph(boolean directed)
  {
    super(directed); // 維持記錄有向圖或無向圖
  }

  // 依字母排序列舉鄰居頂點,方便和課本結果比對
  public Iterable<Edge<E>> outgoingEdges(Vertex<V> u)
  {
    Iterable<Edge<E>> edgeSet = super.outgoingEdges(u);
    ArrayList<String> vertexNameList = new ArrayList<>();
    for(Edge<E> e : edgeSet)
    {
      Vertex<V> toU = opposite(u, e);
      vertexNameList.add(toU.getElement().toString());
    }
    Collections.sort(vertexNameList);


    ArrayList<Edge<E>> edgeList = new ArrayList<>();
    for(String vName : vertexNameList)
    {
      Vertex<V> v = getVertex(vName);
      edgeList.add(getEdge(u,v));
    }

    return edgeList;
  }

  // 依頂點名稱回傳頂點物件
  public Vertex<V> getVertex(String name)
  {
    for(Vertex<V> v : vertices())
    {
      if(v.getElement().equals(name))
        return v;
    }

    return null;
  }

  // 列印圖形
  public String print()
  {
    StringBuilder sb= new StringBuilder();

    //sb.append(String.format("graph=\n"));
    int count = 0;
    for(Vertex<V> fromV: vertices())
    {
      for(Edge<E> e : outgoingEdges(fromV))
      {
        Vertex<V> toV = opposite(fromV, e);
        sb.append(String.format(" edge %d: v:%s to v:%s, len=%5d\n",
                ++count, fromV.getElement(), toV.getElement(), e.getElement()));
      }
    }

    return sb.toString();
  }
}

// ==============================================================

public class Dijkstra_example
{
  // 課本圖14.15-16, 616-617頁航班圖
  static String[][] edges =
  {
      {"SFO", "LAX", "337"},  {"SFO", "BOS", "2704"}, {"SFO", "ORD", "1846"},
      {"SFO", "DFW", "1464"}, {"LAX", "DFW", "1235"}, {"LAX", "MIA", "2342"},
      {"DFW", "ORD", "802"},  {"DFW", "JFK", "1391"}, {"DFW", "MIA", "1121"},
      {"ORD", "BOS", "867"},  {"ORD", "PVD", "849"},  {"ORD", "JFK", "740"},
      {"ORD", "BWI", "621"},  {"MIA", "BWI", "946"},  {"MIA", "JFK", "1090"},
      {"MIA", "BOS", "1258"}, {"BWI", "JFK", "184"},  {"JFK", "PVD", "144"},
      {"JFK", "BOS", "187"}
  };

  // 主程式
  public static void main(String args[])
  {
    // 依邊列舉陣列建構圖形
    MyGraph<String,Integer> graph =
        MyGraph.graphFromEdgelist(edges, false); // true表無向圖

    System.out.printf("graph=\n%s\n", graph);
    System.out.printf("\ngraph=\n%s\n", graph.print());

    // 設定最短路徑起點
    Vertex<String> src = graph.getVertex("BWI");
    System.out.printf("\nsource vertex=%s\n", src.getElement());

    Map<Vertex<String>,Integer> pathDistanceToVertex;
    Map<Vertex<String>,Edge<Integer>> forest;

    // 執行Dijkstra演算法,求解src到其餘各頂點的最短路徑距離
    // 利用最短路徑距離,重建最短路徑走訪樹,可由每一頂點找到其尋獲邊
    System.out.printf("\nexecute shortestPathLengths\n");
    pathDistanceToVertex = GraphAlgorithms.shortestPathLengths(graph, src);

    System.out.printf("\nexecute spTree\n");
    forest = GraphAlgorithms.spTree(graph, src, pathDistanceToVertex);

    // 列印最短路徑結果:
    // 列印src到其餘各頂點的最短路徑距離
    System.out.printf("\npathDistanceToVertex=\n");
    for(Vertex<String> v : pathDistanceToVertex.keySet())
    {
        int d = pathDistanceToVertex.get(v);
        System.out.printf(" shortest distance from %s to %s is %5d\n",
                src.getElement(), v.getElement(), d);
    }

    // 列印每一頂點及其尋獲邊
    System.out.printf("\nforest=\n");
    for(Vertex<String> v : forest.keySet())
    {
        Edge<Integer> e = forest.get(v);
        Vertex<String> vParent = graph.opposite(v, e);
        System.out.printf(" Dijkstra tree edge: from v:%s to v:%s\n",
                vParent.getElement(), v.getElement());
    }

    // 列印起點到每一頂點的最短路徑
    System.out.printf("\nshortest paths from v:%s=\n",src.getElement());
    for(Vertex<String> v : graph.vertices())
    {
        Iterable<Edge<Integer>> path =
          GraphAlgorithms.constructPath(graph, src, v, forest);

        System.out.printf("\n  shortest path from v:%s to v:%s with tot_len=%5d is\n",
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