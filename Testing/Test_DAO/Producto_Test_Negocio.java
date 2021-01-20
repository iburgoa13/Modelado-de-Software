package Test_DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Marca.TMarca;
import Clases.Negocio.Producto.TProducto;

@TestMethodOrder(OrderAnnotation.class)
class Producto_Test_Negocio {

	
	@BeforeAll
	static void setUp() {
		try {
			PrepararLaEjecucion.setUp();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	@Test
	@Order(1) 
	void test_createProduct() {	
		TProducto prod1 = new TProducto("Nombre1","Descripcion1",(float)0.24, "Adulto",23,1,true);
		TProducto prod2 = new TProducto("Nombre2","Descripcion2",(float)0.14, "Adulto",23,58,true);
		TProducto prod3 = new TProducto("Nombre3","Descripcion3",(float)0.95, "Niño",23,1,true);
		TProducto prod4 = new TProducto("Nombre1","Descripcion4",(float)0.95, "Niño",23,2,true);
		TMarca marca1 = new TMarca("Correo@correo.com","Direccion","Nombre","Sector",(long)666222555);
		TMarca marca2 = new TMarca("Correo2@correo.com","Direccion2","Nombre2","Sector2",(long)111222555);
		
		int id_Marca = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		int id_Marca2 = FactoriaSA.getInstance().generateSAMarca().create(marca2);
		
		
		//inserto bien producto con una marca que existe y esta activa
		int id_1 = FactoriaSA.getInstance().generateSAProducto().create(prod1);
		assertTrue(id_1 > 0);
		
		
		//inserto un producto con una marca que no existe
		int id_2 = FactoriaSA.getInstance().generateSAProducto().create(prod2);
		assertTrue(id_2 == -7);
		
		//inserto un producto con una marca que existe PERO es no activa
		FactoriaSA.getInstance().generateSAProducto().delete(id_1);
		
		FactoriaSA.getInstance().generateSAMarca().delete(id_Marca);
		int id_3 = FactoriaSA.getInstance().generateSAProducto().create(prod3);
		
		assertTrue(id_3 == -13);
		
		//el nombre ya existe
		int id_4 = FactoriaSA.getInstance().generateSAProducto().create(prod4);
		
		assertEquals(id_4, -39);
		
	}
	@Test
	@Order(2)
	void test_deleteProduct() {
		TMarca marca1 = new TMarca("CorreoProducto@ee.com","Direccion","NombreNuevo","Sector",(long)666222555);
		
		int m = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		TProducto prod1 = new TProducto("Nombre1sss","Descripcion1",(float)0.24, "Adulto",23,m,true);
		
		int id_1 = FactoriaSA.getInstance().generateSAProducto().create(prod1);
		
		int id_1_delete = FactoriaSA.getInstance().generateSAProducto().delete(id_1);
		
		assertEquals( id_1_delete , id_1);
		
		
		//al ya haber puesto a rechazado no sale el mismo
		assertFalse(FactoriaSA.getInstance().generateSAProducto().delete(id_1) == id_1);
		
		//no existe
		int _id2 = 887;
		int delete = FactoriaSA.getInstance().generateSAProducto().delete(_id2);
		//El producto no existe
		assertTrue(delete == -5);
	}
	@Test
	@Order(3)
	void test_updateProduct() {
		TMarca marca1 = new TMarca("CorreoProducto@ee.com","Direccion","Nombresss","Sector",(long)666322555);
		TMarca marca2 = new TMarca("CorreoProducto2@ee.com","Direccion2","Nombre2ssss","Sector2",(long)666442845);
		
		
		
		//insertamos en base de datos las marcas y los productos
		int m1 = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		int m2 = FactoriaSA.getInstance().generateSAMarca().create(marca2);
		
		TProducto prod1 = new TProducto("Test_Update1","Cambio desde test de update producto",(float)0.40, "Niño",23,m1,true);
		TProducto prod2 = new TProducto("Test_Update2","Cambio desde test de update producto",(float)0.40, "Niño",23,m2,true);
		TProducto prod3 = new TProducto("Test_Update3","Cambio desde test de update producto",(float)0.50, "Niño",23,m1,true);
		TProducto prod4 = new TProducto("Test_Update4","Cambio desde test de update producto",(float)0.50, "Niño",23,m1,true);
		
		int id_1 = FactoriaSA.getInstance().generateSAProducto().create(prod1);
		int id_2 = FactoriaSA.getInstance().generateSAProducto().create(prod2);
		int id_3 = FactoriaSA.getInstance().generateSAProducto().create(prod3);
		int id_4 = FactoriaSA.getInstance().generateSAProducto().create(prod4);
		
		//update para producto valido
		prod1.setDescripcion("Descripcion cambiada");	
		prod1.setPrecio((float)0.95);
		prod1.setId(id_1);
		prod2.setId(id_2);	
		prod3.setId(id_3);
		prod4.setId(id_4);
		
		//el id4 da error por nombre ya existente
		prod4.setNombre("Test_Update1");
		int id4 = FactoriaSA.getInstance().generateSAProducto().update(prod4);
		
		
		assertEquals(id4,-39);
		int id = FactoriaSA.getInstance().generateSAProducto().update(prod1);
		assertTrue(id == id_1);
		
		//la marca que añade no existe
		prod2.setMarca(55);
		prod2.setStock(85);
		prod2.setNombre("Nombre Cambiado");
		
		
		//este mal
		int id2 = FactoriaSA.getInstance().generateSAProducto().update(prod2);
		//int id3 = FactoriaSA.getInstance().generateSAProducto().update(prod3);
		assertTrue(id2!= id_2);
		
		FactoriaSA.getInstance().generateSAProducto().delete(id_2);
		FactoriaSA.getInstance().generateSAMarca().delete(m2);
		prod3.setMarca(m2);
		int id3 = FactoriaSA.getInstance().generateSAProducto().update(prod3);
		
		assertTrue(id3 == -13);
		//assertTrue(id3 < 0);
	}
	@Test
	@Order(4)
	void test_readProduct() {
		TMarca marca1 = new TMarca("CorreoProducto@ee.com","Direccion","Nombrewww","Sector",(long)666222555);
		
		int m1 = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		
		TProducto prod1 = new TProducto("Test_ReadProduct","Lectura de test",(float)0.40, "Niño",23,m1,true);
		TProducto prod2 = new TProducto(88,"Test_ReadProduct2","Lectura de test",(float)0.40, "Niño",23,m1,true);
		int id = FactoriaSA.getInstance().generateSAProducto().create(prod1);

		TProducto prod = FactoriaSA.getInstance().generateSAProducto().read(id);
		TProducto prod_2 = FactoriaSA.getInstance().generateSAProducto().read(prod2.getId());
		
		//existe
		assertTrue(id == prod.getId());
		//no existe
		assertEquals(null,prod_2);
	
	}
	@Test
	@Order(5)
	void test_readAll() {
		List<TProducto> productos = FactoriaSA.getInstance().generateSAProducto().readAll();
		if(productos.size()>0)
		{
			for (TProducto p : productos) {
				assertNotNull(p);
			}
		}
		else assertTrue(productos.size()==0);
	}
}
