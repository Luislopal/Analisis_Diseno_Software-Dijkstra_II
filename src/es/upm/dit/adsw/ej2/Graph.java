package es.upm.dit.adsw.ej2;

import java.util.ArrayList;
import java.util.List;
/**
* CLASE Graph
* @author Luis Alberto L�pez �lvarez
* @author Carlos Daniel Ram�rez Santana
* @author Heriberto Montalvo Mart�n-Palomino
* @version 11.03.2019
*/
public class Graph {
	private List<Node> nodes;
	private List<Link> links;
    /**
    * M�todo constructor 
    * Inialicializa los atributos que va a usar la clase graph
    */
	public Graph() {
		nodes = new ArrayList<Node>();
		links = new ArrayList<Link>();
	}
	
    /**
    * Getter
    * @return lista de nodes y si esta vacio devuelve una lista vacia
    */
	public List<Node> getNodes() {
		return nodes;
	}
	
	/**
     * Getter
     * @return lista de links, si esta vacia devuelve una lista vacia
     */
	public List<Link> getLinks() {
		return links;
	}
	
    /**
    * este m�todo a�ade un nuevo link a la lista
    * @param link de la clase Link que ser� a�adido
    */
	public void addLink(Link link){
		links.add(link);
	}
	
	/**
    * se a�ade con este metodo un link bidireccional, A => B y B => A
    * @param a un node
    * @param b un node
    * @param w peso del link	
    */
	public void addLink2D(String a,String b,int w){
		links.add(new Link (a, b, w));
		links.add(new Link (b, a, w));
	}
	
	/**
	* este metodo a�ade un nuevo node a la lista  
    * @param node de la clase Node que sera a�adido
    */
	public void addNode(Node node) {
		nodes.add(node);
	}
	
    /**
    * consigue el link desde el node fuente al node destino
    * @param src node fuente
    * @param dst node destino     
    * @return link desde src hasta dst y nulo si no hay link
    */
	public Link getLink(Node src, Node dst) {
		for(Link link : links)
			if(link.getSrc().equals(src.getName()) && link.getDst().equals(dst.getName()))
				return link;
		return null;
	}
	
	/**
    * consigue links de salida de un node
    * @param node source node
    * @return lista de links empezando en un nodo y lista vacia si es nulo
    */
	public List<Link> getLinks(Node node) {
		List<Link> linksNode = new ArrayList<Link>();
		for(Link link : links)
			if(link.getSrc().equals(node.getName()))
				linksNode.add(link);
		return linksNode;
	}
	
    /**
    * consigue el nodo que tenga ese nombre asociado
    * @param string nombre
    * @return nulo si no esta
    */
	public Node getNode(String name) {
		for (Node namec : nodes)
			if(namec.getName().equals(name))
				return namec;
		return null;
	}
	
    /**
    * consigue el peso del camino hasta el nodo
    * @param src lista de nodos llamado path
    * @return el peso del camino, si no hay conexi�n devuel-1, 
    * 	si el nodo no esta conectado devuelve -1, sino ocurre nada de eso 
    * 		devuelve el peso del camino
    */
	public int getWeight(List<Node> path) {
		if(path.isEmpty())
			return -1;
		int weight =0;
		for(int i =0; i < path.size()-1;i=i+1) {
			Link link = getLink(path.get(i),path.get(i+1));
			if(link == null)
				return -1;
			weight+= link.getWeight();		
		}
		return weight;
	}
}
