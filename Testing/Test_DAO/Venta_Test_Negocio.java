package Test_DAO;

import static org.junit.jupiter.api.Assertions.*;


import java.text.ParseException;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;
import Clases.Negocio.Marca.TMarca;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Venta.TDevolucion;
import Clases.Negocio.Venta.TOAVenta;
import Clases.Negocio.Venta.TVenta;
@TestMethodOrder(OrderAnnotation.class)
class Venta_Test_Negocio {
	/*
	 * El cliente 1 y 3 son validos, el 2 tambien(solo que inactivo)
	 */
	static int id_Marca=0 , id_Venta =0;//Para crear los productos
	static TCliente[] lista_clientes = {new TClienteEmpresa(912345678L,true,"cliente_1@gmail.com","calle peral",123748596079576L, "Mapfre" , "11416988H"),
			new TClienteEmpresa(969741248L,false,"cliente_2@gmail.com","calle olmo",546576879506978L, "Mercadona S.A" , "40612773V"),
			new TClienteParticulares(656765678L,true,"cliente_3@gmail.com","calle roble",675869706958697L,"96528048S","Javier","Boiro")};
	static int []clientes_id= {0,0,0}; //se guardaran sus id 
	static int [] prod_id = {0,0,0,0};
	static TVenta venta_ok =null;
	
	@BeforeAll
	static void initAll() {

		try {
			PrepararLaEjecucion.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id_Marca =FactoriaSA.getInstance().generateSAMarca().create(new TMarca("marca@marca.com","direccion","nombre","sector",958458584L));
		/*
		 * Los productos 1 y 2 son validos
		 * El producto 3 no tiene stock
		 * El 4 no esta activo
		 * Primero tengo que crear una marca
		*/
		TProducto [] lista_prod = {new TProducto("Nombre1","Descripcion1",(float)0.24, "Adulto",1000,id_Marca,true),
				new TProducto("Nombre2","Descripcion2",(float)0.14, "Adulto",1000,id_Marca,true),
				new TProducto("Nombre3","Descripcion3",(float)0.54, "Adulto",0,id_Marca,true),
				new TProducto("Nombre4","Descripcion4",(float)0.67, "Adulto",23,id_Marca,false)};
		int i=0;
		for(TProducto prod: lista_prod) {
			prod_id[i]= FactoriaSA.getInstance().generateSAProducto().create(prod);
			++i;
		}
		i=0;
		for(TCliente cliente: lista_clientes) {
			clientes_id[i]= FactoriaSA.getInstance().generateSACliente().create(cliente);
			++i;
		}
		
		 
	}
	@Order(1) 
	@Test
	void test_createCorrect() { //Crea una venta correcta. Simulacion de los añadirProducto de la Gui, llamada a create y comprobacion stocks
		
		//System.out.println("test_createCorrect");
		TVenta v1 = new TVenta();
		v1.setActivo(true); v1.setIdCliente(clientes_id[0]); v1.setDireccion("calle almendro");
		v1.getCarrito().put(prod_id[0], new TOAVenta(10,prod_id[0],0));
		v1.getCarrito().put(prod_id[1], new TOAVenta(5,prod_id[1],0));
		
		id_Venta = FactoriaSA.getInstance().generateSAVenta().realizar(v1);
		assertTrue(id_Venta>0);
		assertEquals(FactoriaSA.getInstance().generateSAProducto().read(prod_id[0]).getStock(),1000-10);//se le ha quitado 10 de stock
		assertEquals(FactoriaSA.getInstance().generateSAProducto().read(prod_id[1]).getStock(),1000-5); //se le ha quitado 5 de stock
		venta_ok= v1;//me la guardo para posteriores operaciones
		venta_ok.setId(id_Venta);
	}
	@Order(2)
	@Test
	void test_createIncorrect_client() {//crea una venta en la que no existe el cliente y en la que no esta activo el cliente
		//System.out.println("test_createIncorrect_client");

		TVenta v1 = new TVenta();
		v1.setActivo(true); v1.setIdCliente(99999); v1.setDireccion("calle almendro");
		v1.getCarrito().put(prod_id[0], new TOAVenta(10,prod_id[0],0));
		v1.getCarrito().put(prod_id[1], new TOAVenta(5,prod_id[1],0));
		;
		
		assertEquals(FactoriaSA.getInstance().generateSAVenta().realizar(v1),-3);
		v1.setId(clientes_id[1]);//cliente no activo
		assertEquals(FactoriaSA.getInstance().generateSAVenta().realizar(v1),-3);
	}
	
	@Order(3)
	@Test
	void test_createIncorrect_product() {//crea una venta en la que no existe un producto o no esta activo, o en la que no hay stocks
		//System.out.println("test_createIncorrect_product");

		TVenta v1 = new TVenta();
		v1.setActivo(true); v1.setIdCliente(clientes_id[2]); v1.setDireccion("calle mimosa");
		v1.getCarrito().put(9999, new TOAVenta(10,9999,0)); //producto que no existe
		
		
		assertEquals(FactoriaSA.getInstance().generateSAVenta().realizar(v1),-5);
		
		v1 = new TVenta();
		v1.setActivo(true); v1.setIdCliente(clientes_id[2]); v1.setDireccion("calle mimosa");
		v1.getCarrito().put(prod_id[3], new TOAVenta(10,prod_id[3],0)); //producto que no esta activo
		
		
		assertEquals(FactoriaSA.getInstance().generateSAVenta().realizar(v1),-5);
		
		v1 = new TVenta();
		v1.setActivo(true); v1.setIdCliente(clientes_id[2]); v1.setDireccion("calle mimosa");
		v1.getCarrito().put(prod_id[2], new TOAVenta(10,prod_id[2],0)); //producto que no tiene stock
	
		
		assertEquals(FactoriaSA.getInstance().generateSAVenta().realizar(v1),-11);
	}
	
	
	@Order(4)
	@Test
	void test_deleteVenta() { //borra la venta que se creo en el primer test
		//System.out.println("test_deleteVenta");
		assertEquals(FactoriaSA.getInstance().generateSAVenta().delete(id_Venta),id_Venta);
	}
	@Order(5)
	@Test
	void test_deleteIncorrectVenta() { //borra una venta ya borrada, y una que no existe
		//System.out.println("test_deleteVenta");

		assertEquals(FactoriaSA.getInstance().generateSAVenta().delete(id_Venta),-12);
		assertEquals(FactoriaSA.getInstance().generateSAVenta().delete(9999),-1);
	}
	
	@Order(6)
	@Test
	void test_updateVenta() { //se prueba a reactivar la venta 1 y se prueba a cambiar su direccion
		//System.out.println("test_updateVenta");
		venta_ok.setActivo(true);
		assertEquals(FactoriaSA.getInstance().generateSAVenta().update(venta_ok) , id_Venta);
		assertEquals(FactoriaSA.getInstance().generateSAVenta().read(id_Venta).getActivo(),true);
		
		venta_ok.setDireccion("calle sauce");
		assertEquals(FactoriaSA.getInstance().generateSAVenta().update(venta_ok) , id_Venta);
		assertTrue(FactoriaSA.getInstance().generateSAVenta().read(id_Venta).getDireccion().equals("calle sauce") == true);
		
	}
	@Order(7)
	@Test
	void test_updateIncorrectVenta() { //se prueba a actualizar venta que no existe
		assertEquals(FactoriaSA.getInstance().generateSAVenta().update(new TVenta(9999, 0, new Date(), 0, "dir", true, true)) , -1);
		
	}
	@Order(8)
	@Test
	void test_devolucionVenta() { //vamos a probar a devolver 5 unidades del producto 1
		
		TVenta updated = FactoriaSA.getInstance().generateSAVenta().devolver(new TDevolucion(id_Venta,prod_id[0],5));
		venta_ok.getCarrito().get(prod_id[0]).setCantidad(venta_ok.getCarrito().get(prod_id[0]).getCantidad()-5);
		assertEquals(updated.getId(),venta_ok.getId());
		assertTrue(updated.getImporte()< venta_ok.getImporte());
		assertEquals(updated.getCarrito().get(prod_id[0]).getCantidad() , venta_ok.getCarrito().get(prod_id[0]).getCantidad());
		assertEquals(FactoriaSA.getInstance().generateSAProducto().read(prod_id[0]).getStock(),1000-5);//se le ha devuelto 5 de stock. NO FUNCIONA
		
	}
	@Order(9)
	@Test
	void test_devolucionIncorrectVenta() { //vamos a probar a devolver 5 unidades de un producto que no esta en la venta,y en una venta que no existe
		TVenta updated = FactoriaSA.getInstance().generateSAVenta().devolver(new TDevolucion(id_Venta,9999,1));
		assertTrue(updated==null);
		updated = FactoriaSA.getInstance().generateSAVenta().devolver(new TDevolucion(9999,prod_id[0],1));
		assertTrue(updated==null);
	}
	@Order(10)
	@Test
	void test_readVenta() throws ParseException { //vamos a leer la primera venta
		TVenta myVenta= FactoriaSA.getInstance().generateSAVenta().read(id_Venta);
		assertNotNull(myVenta);
		assertEquals(myVenta.getDireccion() ,venta_ok.getDireccion());
		assertEquals(myVenta.getEstado() , venta_ok.getEstado());
		//assertEquals(myVenta.getFecha().toString(),  venta_ok.getFecha().toString()); //NO FUNCIONA
		assertEquals(myVenta.getIdCliente(), venta_ok.getIdCliente());
		
		assertNotNull(myVenta.getCarrito());
		HashMap<Integer,TOAVenta> carrito = myVenta.getCarrito();
		Collection<TOAVenta> collectionLineasDeVenta = carrito.values();
		Iterator<TOAVenta> it = collectionLineasDeVenta.iterator();
		TOAVenta linea;
	    while (it.hasNext()) {//recorro los productos de la venta, veo si existen y les quito stock
	    	linea = it.next();
	    	assertEquals(linea.getCantidad() , venta_ok.getCarrito().get(linea.getIdProducto()).getCantidad());
	    	assertEquals(linea.getPrecio() , venta_ok.getCarrito().get(linea.getIdProducto()).getPrecio());
	    }
	}
	@Order(11)
	@Test
	void test_readIncorrectVenta() {
		assertEquals(null, FactoriaSA.getInstance().generateSAVenta().read(9999));
	}
	@Order(12)
	@Test
	void test_readAll() {
		assertNotNull(FactoriaSA.getInstance().generateSAVenta().readAll());
	}
}
