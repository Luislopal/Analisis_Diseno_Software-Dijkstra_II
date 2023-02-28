package es.upm.dit.adsw.ej2;

import java.util.HashSet;
import java.util.Set;

/**
* CLASE DijkstraMeter
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramírez Santana
* @author Heriberto Montalvo Martín-Palomino
* @version 11.03.2019
*/
public class DijkstraMeter {
	private static final int X = 5;
	
	/**
	* tiempo que tarda en ejecutarse el algoritmo de Dijkstra
	* @param graph Grafo en el que se ejecutará el algoritmo 
	* @return long es el tiempo que tarda(ejecución)
	*/
	private static long doit(Graph graph) {
		Node n0 = graph.getNode("0");
		long t0 = System.currentTimeMillis();
		new Dijkstra(graph, n0);
		long t2 = System.currentTimeMillis();
		return t2 - t0;
	}
	
	/**
	* este método prepara un grafo para evaluar el tiempo de ejecución en el algoritmo de Dijkstra
	* @param graph sobre el que se va a cargar un número n de nodos y unos cuantos enlaces
	* @param número de nodos que contendrá el grafo
	*/
	private static void load(Graph graph, int n) {
		for(int i = 0; i<n; i++)
			graph.addNode(new Node(Integer.toString(i),0,0));
		for(int i = 0; i<n; i++) {
			Set<Integer> yaMetidos = new HashSet<Integer>();
			for(int j = 0; j<X && j<n; j++) {
				int nodeNumber = (int)(n*Math.random());
				while(nodeNumber==i || yaMetidos.contains(nodeNumber))
					nodeNumber = (int)(n*Math.random());
				yaMetidos.add(nodeNumber);
				graph.addLink(new Link(Integer.toString(i),Integer.toString(nodeNumber),1));
			}
		}
	}
	
	/**
	* método main que hace ejecutable la clase DijkstraMeter
	* @param [] args
	*/

	public static void main(String[]args) {
		for (int n = 1000; n<= 40000; n+= 2000) {
			Graph graph = new Graph();
			load(graph, n);
			long t = doit(graph);
			System.out.printf("%s %d%n", n, t);
		}
	}
}
