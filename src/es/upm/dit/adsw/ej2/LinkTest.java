package es.upm.dit.adsw.ej2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
* Pruebas Link.
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramirez Santana
* @author Heriberto Montalvo Martín-Palomino
* @version 11.03.2019
*/
public class LinkTest {

              
	@Test
	public void test00() {
		Link link = new Link ("A", "B", 1);
        assertEquals ("A", link.getSrc());
        assertEquals ("B", link.getDst());
        assertEquals (1, link.getWeight());
    }
	
    @Test (expected = IllegalArgumentException.class)
    public void test01() {
       Link link = new Link ("A", "B", -9);
              }
    
    @Test (expected = IllegalArgumentException.class)
    public void test02() {
       Link link = new Link (null, "B", 1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test03() {
       Link link = new Link ("A", null, 1);
    }
}
