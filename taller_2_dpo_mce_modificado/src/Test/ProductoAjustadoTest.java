package Test;

import static org.junit.Assert.*;

import org.example.logica.Ingrediente;
import org.example.logica.ProductoAjustado;
import org.example.logica.ProductoMenu;
import org.junit.Test;

public class ProductoAjustadoTest {

	/*@Test
	public void testProductoAjustado() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testGetIngredientes() {
		ProductoAjustado pa = new ProductoAjustado(new ProductoMenu("costeña", 20000));
		Ingrediente ingrediente = new Ingrediente("lechuga",1000);
		pa.agregarIngrediente(ingrediente);
		assertEquals(ingrediente, pa.getIngredientes().get(0));
		
	}

	@Test
	public void testAgregarIngrediente() {
		ProductoAjustado pa = new ProductoAjustado(new ProductoMenu("costeña", 20000));
		pa.agregarIngrediente(new Ingrediente("lechuga",1000));
		assertEquals(1, pa.getIngredientes().size());
	}

	@Test
	public void testEliminarIngrediente() {
		ProductoAjustado pa = new ProductoAjustado(new ProductoMenu("costeña", 20000));
		Ingrediente ingrediente = new Ingrediente("lechuga",1000);
		pa.agregarIngrediente(ingrediente);
		pa.eliminarIngrediente(ingrediente);
		assertEquals(0, pa.getIngredientes().size());
	}

	@Test
	public void testGetPrecio() {
		ProductoAjustado pa = new ProductoAjustado(new ProductoMenu("costeña", 20000));
		Ingrediente ingrediente = new Ingrediente("lechuga",1000);
		pa.agregarIngrediente(ingrediente);
		assertEquals(20000, pa.getPrecio());
		
	}



}
