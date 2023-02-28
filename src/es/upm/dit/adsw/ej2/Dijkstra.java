package es.upm.dit.adsw.ej2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.upm.dit.adsw.ej2.Graph;
import es.upm.dit.adsw.ej2.Node;
              
/**
 * CLASE DIJKSTRA har� el algoritmo de dijkstra
 * @author Luis Alberto L�pez �lvarez
 * @author Carlos Daniel Ram�rez Santana
 * @author Heriberto Montalvo Mart�n-Palomino
 * @version 11.03.2019
 * FUENTE: Vogella (https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html)
 */
public class Dijkstra {
    private Graph graph;
    private Node src;
    private List<Link> links;
    private Set<Node> settledNodes;//crea un set de nodes que est�n comprobados
    private Set<Node> unSettledNodes;//crea un set de nodes que est�n no comprobados
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;
    /**
    * Constructor calcula el camino m�nimo a cada uno de los otros nodes en el grafo
    * @param graph Graph
    * @param src es el node origen
    */
    public Dijkstra(Graph graph, Node src) {
    	this.graph = graph;
        this.src = src;
        links = graph.getLinks();
        settledNodes = new HashSet<Node>();
        unSettledNodes = new HashSet<Node>();
        predecessors = new HashMap<Node,Node>();
        distance = new HashMap<Node,Integer>();
        distance.put(this.src, 0);
        unSettledNodes.add(this.src);
        while (unSettledNodes.size() > 0) {
        	Node node = getMinimun(unSettledNodes);
        	settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }
    
    /**
    * consigue el camino m�s corto (el peso m�nimo) 
    * @param dst Destination node
    * @return shortest path
    */
    public List<Node> getPath(Node dst) {
        List<Node> path = new ArrayList<Node>();
        if(dst.equals(this.src)) {
        	path.add(src);
            return path;
        }
        Node step = dst;
        if(predecessors.get(step) == null) {
             return null;
        }
        path.add(step);
        while(predecessors.get(step) != null) {
             step = predecessors.get(step);
             path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
    
    /**
    * @param node nodo cuyos vecinos se van a estudiar
    */
    private void findMinimalDistances(Node node) {
    	List<Node> adjacentNodes = getNeighbors(node);
    	for(Node target: adjacentNodes) {
    		if(getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
    			distance.put(target,  getShortestDistance(node)+ getDistance(node,target));
    			predecessors.put(target, node);
    			unSettledNodes.add(target);
            }
    	}
    }
    
    /**
    * obtener la distancia entre el node src y el dst.
    * @param node nodo fuente
    * @param target nodo destino
    * @return int Integer.MAX_VALUE
    */
    private int getDistance(Node node, Node target) {
    	for(Link link: links) {
    		if(link.getSrc().equals(node.getName()) && link.getDst().equals(target.getName())) {
            	return link.getWeight();
            }
        }
        return Integer.MAX_VALUE;
     }
    
    /**
    * obtener una lista de nodos vecinos al nodo pasado como par�metro
    * @param node nodo fuente
    * @return List<Node> 
    */
    private List<Node> getNeighbors(Node node) {
    	List<Node> neighbors = new ArrayList<Node>();
        for (Link link: links) {
        	if (link.getSrc().equals(node.getName()) && !isSettled(graph.getNode(link.getDst()))) {
                 neighbors.add(graph.getNode(link.getDst()));
            }
        }
        return neighbors;
    }
    
    /**
    * obtiene el nodo a menos distancia 
    * @param nodes (Set)
    * @return Node nodo
    */
    private Node getMinimun(Set<Node> nodes) {
    	Node minimun = null;
        for (Node node: nodes) {
        	if (minimun == null) {
        	   minimun = node;
        	} else {
        		if (getShortestDistance(node) < getShortestDistance(minimun)) {
        			minimun = node;
        		}
        	}
        }
        return minimun;
    }
    
    /**
    * comprobar si un nodo ya esta visitado o comprobado
    * @param node nodo
    * @return settledNodes.contains(node)
    */
    private boolean isSettled(Node node) {
    	return settledNodes.contains(node);
    }
    
    /**
    * devuelve la distancia al nodo destino, pero la m�s peque�a
    * @param destination
    * @return int (distancia)
    */
    private int getShortestDistance(Node destination) {
    	Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        	}
    	}
	}
