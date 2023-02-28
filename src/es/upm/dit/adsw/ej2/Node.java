package es.upm.dit.adsw.ej2;

/**
* CLASE Node crea los nodos en los que se basa el algoritmo de Dijkstra.
* @author Luis Alberto L�pez �lvarez
* @author Carlos Daniel Ram�rez Santana
* @author Heriberto Montalvo Mart�n-Palomino
* @version 11.03.2019
*/
 public class Node {
     private String name;
     private int x,y;
     /**
     * Constructor
     * @param name
     * @param x
     * @param y
     * @throws IllegalArgumentException si el par�metro name de la clase String es nulo o el tama�o es 0.
     */
     public Node(String name, int x, int y) {
          if (name == null || name.length() == (0)) 
              throw new IllegalArgumentException();
          this.name = name;
          this.x = x;
          this.y = y;
          }
     /**
     * M�todo String
     * @return la estructura que se imprimir� por pantalla
     */
              
     @Override
     public String toString() {
          return "Node [name=" + name + ", x=" + x + ", y=" + y + "]";
     }
     /**
     * Getter
     * @return name
     */
     public String getName() {
           return name;
     }
     
      /**
      * Getter
      * @return x
      */
      public int getX() {
            return x;
      }
      
     /**
     * Getter
     * @return y
     */
     public int getY() {
            return y;
     }
}
