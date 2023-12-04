package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.example.logica.Combo;
import org.example.logica.ProductoMenu;
import org.example.logica.Producto;
import org.junit.Test;

public class ComboTest {

	/*@Test
	public void testCombo() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testAgregarItemACombo() {
		Combo combo = new Combo("combo corral", 10);
		Producto item = new ProductoMenu("corral", 14000);
		combo.agregarItemACombo(item);
		assertEquals(1, combo.getListaProductos().size());
		//assertThat(combo.getListaProductos(), hasItems("b"));
	}

	@Test
	public void testGetListaProductos() {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		
		Combo combo = new Combo("combo corral", 10);
		Producto item = new ProductoMenu("corral", 14000);
		listaProductos.add(item);
		combo.agregarItemACombo(item);
		
		
		assertEquals( listaProductos, combo.getListaProductos());
	}

	@Test
	public void testGetDescuento() {

		
		Combo combo = new Combo("combo corral", 10);
		Producto item = new ProductoMenu("corral", 14000);
		
		combo.agregarItemACombo(item);
		
		int descuento = (int) combo.getDescuento();
		assertEquals(10, descuento);
	}

	//@Test
	/*public void testGenerarTextoFactura() {
		fail("Not yet implemented");
	}*/

}
