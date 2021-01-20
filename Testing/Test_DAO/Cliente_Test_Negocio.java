package Test_DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

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
import Clases.Negocio.Venta.TOAVenta;
import Clases.Negocio.Venta.TVenta;


@TestMethodOrder(OrderAnnotation.class)
class Cliente_Test_Negocio {

	private TCliente[] lista_clientes = {new TClienteEmpresa(912345678L,true,"cliente_1@gmail.com","calle peral",123748596079576L, "Mapfre" , "11416988H"),
			new TClienteEmpresa(969741248L,false,"cliente_2@gmail.com","calle olmo",546576879506978L, "Mercadona S.A" , "40612773V"),
			new TClienteParticulares(656765678L,true,"cliente_3@gmail.com","calle roble",675869706958697L,"95404897T","Javier","Boiro")};
	static int id_Marca=0 , id_Venta =0;//Para crear los productos
	
	
	static int []clientes_id= {0,0,0}; //se guardaran sus id 
	static int [] prod_id = {0,0,0,0};
	static TVenta venta_ok =null;
	// Creación de clientes para probar.
			// Casos a probar:
			// Añadir un cliente con el mismo cif, con el mismo dni, con ncuentas erróneos, parseo de emails.
			// Dar de baja un cliente ya desactivada,dar de baja uno que no existe.
			// Update con datos erróneos, update con datos repetidos.
			// Read uno que no existe, read uno bien
			// Read All, asegurar que la lista de transfers tiene el tamaño de los que haya.
			// Probar la query no se muy bien pq fer la ha hecho mal <3
			// lets do dis
	@BeforeAll
	static void setUp() throws Exception { 
		
		/*
		 * Los productos 1 y 2 son validos
		 * El producto 3 no tiene stock
		 * El 4 no esta activo
		 * Primero tengo que crear una marca
		*/
		
		
		try {
			PrepararLaEjecucion.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	@Test
	@Order(1)
	void saCreate() {
		TClienteEmpresa repe_empresa=new TClienteEmpresa(912345678L,true,"cliente_1@gmail.com","calle peral",123748596079576L, "Mapfre" , "11416988H");
		TClienteEmpresa repe_malncuenta=new TClienteEmpresa(912345678L,true,"cliente_1@gmail.com","calle peral",-1239999L, "Mapfre" , "11416988H");
		TClienteEmpresa repe_malemail=new TClienteEmpresa(912345678L,true,"ckktecom","calle peral",123748596079576L, "Mapfre" , "60609354F");
		TClienteParticulares repe_malDNI= new TClienteParticulares(656765678L,true,"cliente_4gmail.com","calle roble",675869706958697L,"6758697MN","Alfonso","Boiro");

		TClienteParticulares repe_particular=new TClienteParticulares(656765678L,true,"cliente_3@gmail.com","calle roble",675869706958697L,"95404897T","Javier","Boiro");
		assertTrue(1==FactoriaSA.getInstance().generateSACliente().create(lista_clientes[0]));
		assertTrue(2==FactoriaSA.getInstance().generateSACliente().create(lista_clientes[1]));
		assertTrue(3==FactoriaSA.getInstance().generateSACliente().create(lista_clientes[2]));
		assertTrue(-31==FactoriaSA.getInstance().generateSACliente().create(repe_empresa));
		assertTrue(-32==FactoriaSA.getInstance().generateSACliente().create(repe_particular));
		assertTrue(-36==FactoriaSA.getInstance().generateSACliente().create(repe_malDNI));
		assertTrue(-35==FactoriaSA.getInstance().generateSACliente().create(repe_malncuenta));
		assertEquals(-34,FactoriaSA.getInstance().generateSACliente().create(repe_malemail));

	}
	@Test
	@Order(2)
	void saread() {
		TClienteEmpresa buen_read=new TClienteEmpresa(1,912345678L,true,"cliente_1@gmail.com","calle peral",123748596079576L, "Mapfre" , "11416988H");
		TClienteEmpresa read_retorno= (TClienteEmpresa) FactoriaSA.getInstance().generateSACliente().read(1);
		assertTrue(null==FactoriaSA.getInstance().generateSACliente().read(99999));
		assertTrue(true==FactoriaSA.getInstance().generateSACliente().read(1).getActivo());
		assertTrue(1==FactoriaSA.getInstance().generateSACliente().read(1).getId());
		assertTrue(912345678L==FactoriaSA.getInstance().generateSACliente().read(1).getTelefono());
		assertEquals("cliente_1@gmail.com",FactoriaSA.getInstance().generateSACliente().read(1).getCorreo());
		assertEquals("calle peral",FactoriaSA.getInstance().generateSACliente().read(1).getDireccion());
		assertTrue(123748596079576L==FactoriaSA.getInstance().generateSACliente().read(1).getNcuenta());
		assertEquals("Mapfre",read_retorno.getNombre());
		assertEquals("11416988H",read_retorno.getCif());
	}
	@Test
	@Order(3)
	void saUpdate() {
		// Si insertas datos mal.
		TClienteParticulares repe_malDNI= new TClienteParticulares(656765678L,true,"cliente_4@gmail.com","calle roble",675869706958697L,"6758697MN","Alfonso","Boiro");
		TClienteEmpresa repe_malncuenta=new TClienteEmpresa(000L,true,"cliente_1@gmail.com","calle peral",-1239999L, "Mapfre" , "15645675Q");
		TClienteEmpresa repe_malemail=new TClienteEmpresa(912345678L,true,"clim","calle peral",123748596079576L, "Mapfre" , "60609354F");
		
		assertTrue(-36==FactoriaSA.getInstance().generateSACliente().update(repe_malDNI));
		assertTrue(-35==FactoriaSA.getInstance().generateSACliente().update(repe_malncuenta));
		assertEquals(-34,FactoriaSA.getInstance().generateSACliente().update(repe_malemail));
		TClienteEmpresa buen_update=new TClienteEmpresa(1,912345678L,true,"cliente_1@gmail.com","calle trucha",123748596079576L, "Mapfre" , "11416988H");
		assertTrue(1==FactoriaSA.getInstance().generateSACliente().update(buen_update));
		assertEquals("calle trucha",FactoriaSA.getInstance().generateSACliente().read(1).getDireccion());
		// then, está bien el cambio, de peral a trucha.
	}
	@Test
	@Order(4)
	void saDelete() {
		assertTrue(-3==FactoriaSA.getInstance().generateSACliente().delete(9999));
		assertTrue(1==FactoriaSA.getInstance().generateSACliente().delete(1));
		// if cliente tiene venta abierta, then no puedo dar de baja.
		assertTrue(-41==FactoriaSA.getInstance().generateSACliente().delete(1));
		// antes, voy a probar si puedo dar de baja un cliente dado ya de baja
		TClienteEmpresa buen_update=new TClienteEmpresa(1,912345678L,true,"cliente_1@gmail.com","calle trucha",123748596079576L, "Mapfre" , "11416988H");
		assertTrue(1==FactoriaSA.getInstance().generateSACliente().update(buen_update));
		int id_Marca =FactoriaSA.getInstance().generateSAMarca().create(new TMarca("marca@marca.com","direccion","nombre","sector",958458584L));
		int i=0;
		TProducto [] lista_prod = {new TProducto("Nombre1","Descripcion1",(float)0.24, "Adulto",1000,id_Marca,true),
				new TProducto("Nombre2","Descripcion2",(float)0.14, "Adulto",1000,id_Marca,true),
				new TProducto("Nombre3","Descripcion3",(float)0.54, "Adulto",0,id_Marca,true),
				new TProducto("Nombre4","Descripcion4",(float)0.67, "Adulto",23,id_Marca,false)};
		for(TProducto prod: lista_prod) {
			prod_id[i]= FactoriaSA.getInstance().generateSAProducto().create(prod);
			++i;
		}
		TVenta v1 = new TVenta();
		v1.setActivo(true); v1.setIdCliente(1); v1.setDireccion("calle trucha");
		v1.getCarrito().put(prod_id[0], new TOAVenta(10,prod_id[0],0));
		v1.getCarrito().put(prod_id[1], new TOAVenta(5,prod_id[1],0));
		id_Venta = FactoriaSA.getInstance().generateSAVenta().realizar(v1);
		venta_ok= v1;//me la guardo para posteriores operaciones
		venta_ok.setId(id_Venta);	
		assertEquals(-42,FactoriaSA.getInstance().generateSACliente().delete(1));
			
	}
	@Test
	@Order(5)
	void saReadAll() {
		assertTrue(3==FactoriaSA.getInstance().generateSACliente().readAll().size());
	}
	
	
	@Test
	@Order(6)
	void SAentreXY() {
		
		//cliente que se gasto entre 0,5, solo hay 1
		assertTrue(1==FactoriaSA.getInstance().generateSACliente().clienteXY(0, 5).size());
		//cliente que hay entre 200 y 300, no hay
		assertTrue(0==FactoriaSA.getInstance().generateSACliente().clienteXY(200, 300).size());
		
		
	}
	

}
