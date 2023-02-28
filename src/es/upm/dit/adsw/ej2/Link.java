package es.upm.dit.adsw.ej2;

/**
* CLASE Link
* @author Luis Alberto L�pez �lvarez
* @author Carlos Daniel Ram�rez Santana
* @author Heriberto Montalvo Mart�n-Palomino
* @version 11.03.2019 
*/
public class Link {
    private String src,dst;
    private int weight;
    /**
    * Constructor
    * @param src  origen
    * @param dst  destino
    * @param weight  peso del camino
    * @throws IllegalArgumentException si src es nulo o dst es nulo o weight es negativo
    */

    public Link(String src, String dst, int weight) {
    	if (src == null || dst == null || weight<0)
    		throw new IllegalArgumentException();
    		this.src = src;
            this.dst = dst;
            this.weight = weight;
    }
    
    /**
    * Getter
    * @return src (String)
    */
    public String getSrc() {
    	return src;
    }
    
    /**
    * Getter
    * @return dst (String)
    */
    public String getDst() {
    	return dst;
    }
    
    /**
    * Getter
    * @return weight(n�mero entero)
    */
    public int getWeight() {
    	return weight;
    }
    
    /**
    * M�todo String
    * @return la estructura que se imprimir� por pantalla
    */
    @Override
    public String toString() {
    	return "Link [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
    }
              
}
