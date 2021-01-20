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
class Marca_Test_Negocio {

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
	void test_createMarca() {	
		TMarca marca1 = new TMarca("correo1@ee.com","Direccion1","Nombre1","sector1",(long) 638824371);
		TMarca marca2 = new TMarca("correo2@ee.com","Direccion2","Nombre2","sector2",(long) 638824372);
		TMarca marca3 = new TMarca("correo3@ee.com","Direccion3","Nombre3","sector3",(long) 63882437);
		TMarca marca4 = new TMarca("correo4@ee.com","Direccion4","Nombre1","sector4",(long) 638824374);
		//TProducto prod3 = new TProducto("Nombre","Descripcion",(float)-0.44, "Adulto",23,4,true);
		
		//creo 3 marcas
		int id_1 = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		int id_2 = FactoriaSA.getInstance().generateSAMarca().create(marca2);
		int id_3 = FactoriaSA.getInstance().generateSAMarca().create(marca3);
		int id_4 = FactoriaSA.getInstance().generateSAMarca().create(marca4);

		assertTrue(id_1 > 0);
		assertTrue(id_2 > 0);
		assertTrue(id_3 == -22); // esta daria error debido a que la marca3 tiene un numero de telefono erroneo
		assertTrue(id_4 == -37); // esta daria error debido a que la marca3 tiene un numero de telefono erroneo

		System.out.print("Create: id1: "+ id_1 +" id2: "+ id_2+" id3: "+ id_3+" id4: "+ id_4+"\n");
		
	}
	@Test
	@Order(2)
	void test_deleteMarca() { 
		
		
		TMarca marca1 = new TMarca("correo1@ee.com","Direccion1","Nombre5","sector1",(long) 638824371);
		int id_1 = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		TMarca marca3 = new TMarca("correo3@ee.com","Direccion3","Nombre3","sector3",(long) 638824373);
		int id_3 = FactoriaSA.getInstance().generateSAMarca().create(marca3);
		TProducto prod = new TProducto("Nombre2","Descripcion2",(float)0.14, "Adulto",23,id_3,true);
		int id_prod = FactoriaSA.getInstance().generateSAProducto().create(prod);
		
		assertEquals(FactoriaSA.getInstance().generateSAMarca().delete(id_1) , id_1);
		
		//al ya haber puesto a rechazado no sale el mismo
		int x=FactoriaSA.getInstance().generateSAMarca().delete(id_1);
		assertTrue(FactoriaSA.getInstance().generateSAMarca().delete(id_1) == -13);
		
		//no existe
		int _id2 = 887;
		assertTrue(FactoriaSA.getInstance().generateSAMarca().delete(_id2) ==-7);
		
		// la marca esta asociada a un producto y deberia darme fallo
		assertTrue(FactoriaSA.getInstance().generateSAMarca().delete(id_3) ==-21);
		System.out.print("Delete: id1: "+ id_1 +" x: "+x+" id2: "+ FactoriaSA.getInstance().generateSAMarca().delete(_id2)+" id3: "+ FactoriaSA.getInstance().generateSAMarca().delete(id_3)+"\n");
		
	}
	@Test
	@Order(3)
	void test_updateMarca() {

		TMarca marca1 = new TMarca("correo1@qss.com","Direccion1","Nombre9","sector1",(long) 638824371);
		TMarca marca2 = new TMarca("correo2@wss.com","Direccion2","Nombre8","sector2",(long) 638824373);
		int id_1 = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		int id_2 = FactoriaSA.getInstance().generateSAMarca().create(marca2);
		marca1.setCorreo("dodo11@ss.com");
		marca1.setId(id_1);
		marca2.setId(id_2);
		marca2.setTelefono((long)6388243);
		//este bien
		int id = FactoriaSA.getInstance().generateSAMarca().update(marca1);
		//este mal por el numero de telefono
		int id2 = FactoriaSA.getInstance().generateSAMarca().update(marca2);
		// este da fallo ya que pone el mismo nombre repetido en marca1

		marca2.setNombre("Nombre9");
		marca2.setTelefono((long)111222333);
		int id3 = FactoriaSA.getInstance().generateSAMarca().update(marca2);
		assertEquals(id ,id_1);
		assertEquals(id2,-22);
		
		assertEquals(id3,-37);
		System.out.print("Update: id1: "+ id +" id2: "+ id2+" id3: "+ id3+"\n");
	}
	@Test
	@Order(4)
	void test_readMarca() {
		int id = 1;
		int id2 = 5578;
		TMarca marca1 = FactoriaSA.getInstance().generateSAMarca().read(id);
		TMarca marca2 = FactoriaSA.getInstance().generateSAMarca().read(id2);
		//existe
		assertTrue(id == marca1.getId());
		//no existe
		assertEquals(null,marca2);
	
	}
	@Test
	@Order(5)
	void test_readAllMarca() {
		List<TMarca> marcas = FactoriaSA.getInstance().generateSAMarca().readAll();
		if(marcas.size()>0)
		{
			for (TMarca p : marcas) {
				assertNotNull(p);
			}
		}
		else assertTrue(marcas.size()==0);
	}
	
	@Test
	@Order(6)
	void test_readAllProductos_Marca(){
		TMarca marca1 = new TMarca("readAllProd@ucm.com","Direccion2","ReadAllProd_Marca","sector2",(long) 666555888);
		int id_1 = FactoriaSA.getInstance().generateSAMarca().create(marca1);
		TProducto prod1 = new TProducto("ReadAllProd1","Descripcion1",(float)0.14, "Adulto",23,id_1,true);
		TProducto prod2 = new TProducto("ReadAllProd2","Descripcion1",(float)0.14, "Adulto",23,id_1,true);
		TProducto prod3 = new TProducto("ReadAllProd3","Descripcion1",(float)0.14, "Adulto",23,id_1,true);

		int id_prod1 = FactoriaSA.getInstance().generateSAProducto().create(prod1);
		int id_prod2 = FactoriaSA.getInstance().generateSAProducto().create(prod2);
		int id_prod3 = FactoriaSA.getInstance().generateSAProducto().create(prod3);
		List<TProducto> lista = FactoriaSA.getInstance().generateSAProducto().readMarca(id_1);
		if(lista!=null) {
			if(lista.size()==0) {
				assertEquals(lista.size(),0);
			}
			else {
				for(TProducto p : lista) {
					assertNotNull(p);
					assertEquals(p.getMarca(),id_1);
				}
			}
			
		}
		
		
	}
	
}
