package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.example.logica.Ingrediente;
import org.example.logica.Pedido;
import org.example.logica.ProductoMenu;
import org.example.logica.Producto;
import org.example.logica.ProductoAjustado;
import org.junit.Test;

import exceptions.PedidoException;

public class PedidoTest {

	/*@Test
	public void testPedido() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testSetIdPedido() {
		Pedido pedido = new Pedido("Pepito","Calle 5 #23-2");
		
        pedido.setIdPedido(123);
		assertEquals(123, pedido.getIdPedido());
	}

	@Test
	public void testGetIdPedido() {
		Pedido pedido = new Pedido("Pepito","Calle 5 #23-2");
		
        pedido.setIdPedido(123);
		assertEquals(123, pedido.getIdPedido());
	}

	@Test
	public void testAgregarProducto() throws PedidoException {
		Pedido pedido = new Pedido("Pepito","Calle 5 #23-2");
		Producto p = new ProductoMenu("costeña", 20000);
		pedido.agregarProducto(p);
		assertEquals(p, pedido.getListaProductos().get(0));
	}

	@Test
	public void testGetListaProductos() throws PedidoException {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Pedido pedido = new Pedido("Pepito","Calle 5 #23-2");
		Producto p = new ProductoMenu("costeña", 20000);
		lista.add(p);
		pedido.agregarProducto(p);
		assertEquals(lista, pedido.getListaProductos());
	}

	/*@Test
	public void testGetPrecio() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetNombre() {
		Pedido pedido = new Pedido("Pepito Salle","Calle 5 #23-2");
		
		
		assertEquals("Pepito Salle", pedido.getNombre());
	}

	@Test
	public void testGenerarTextoFactura() throws PedidoException {
		String test_factura = "corral $14000\n"
				+ "Valor neto total: 14000.0\n"
				+ "IVA(19%): 2660.0\n"
				+ "Total (neto + IVA): 16660.0";
		Pedido pedido = new Pedido("Pepito","Calle 5 #23-2");
		Producto p = new ProductoMenu("corral", 14000);
		pedido.agregarProducto(p);
		String factura = pedido.generarTextoFactura();
		assertEquals(test_factura, factura);
		
		//Test para producto ajustado
		String test_factura_2 = "corral $14000\n"
				+ "****lechuga $1000.0\n"
				+ "Valor neto total: 15000.0\n"
				+ "IVA(19%): 2850.0\n"
				+ "Total (neto + IVA): 17850.0";
		Pedido pedido2 = new Pedido("Pepito","Calle 5 #23-2");
		ProductoMenu pm = new ProductoMenu("corral", 14000);
		ProductoAjustado pa = new ProductoAjustado(pm);
		pa.agregarIngrediente(new Ingrediente("lechuga",1000));
		pedido2.agregarProducto(pa);
		String factura2 = pedido2.generarTextoFactura();
		assertEquals(test_factura_2, factura2);
	}

	@Test
	public void testGuardarFactura() throws PedidoException {
		
		Pedido pedido = new Pedido("Pepito","Calle 5 #23-2");
		pedido.setIdPedido(123);
		Producto p = new ProductoMenu("corral", 14000);
		pedido.agregarProducto(p);
		
		String nombreFactura = "factura"+pedido.getIdPedido()+".txt";
        Path pathFactura= Paths.get("facturas/"+nombreFactura);
        File fileFactura = new File(pathFactura .toUri());
        pedido.guardarFactura(fileFactura);
        
		assertTrue(fileFactura.exists());
	}

}
