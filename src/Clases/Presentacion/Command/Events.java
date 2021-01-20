/**
 * 
 */
package Clases.Presentación.Command;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Events {

	// GUIS //
	public static final int GUI_DAO = 1;
	public static final int GUI_JPA = 101;
	public static final int GUI_EMPLEADOS = 2;
	public static final int GUI_Marca = 3;
	public static final int GUI_Cliente = 4;
	public static final int GUI_Ventas = 5;
	public static final int GUI_Producto = 6;
	public static final int GUI_Empresa = 7;
	public static final int GUI_Departamento = 8;
	public static final int GUI_Trabajador = 9;
	public static final int GUI_Curso = 10;

	// Cliente
	public static final int ALTA_CLIENTEP = 11;
	public static final int ALTA_CLIENTEP_OK = 111;
	public static final int ALTA_CLIENTEP_KO = 112;
	public static final int ALTA_CLIENTEE = 12;
	public static final int ALTA_CLIENTEE_OK = 121;
	public static final int ALTA_CLIENTEE_KO = 122;
	public static final int BAJA_CLIENTE = 13;
	public static final int BAJA_CLIENTE_OK = 131;
	public static final int BAJA_CLIENTE_KO = 132;
	public static final int MOD_CLIENTE = 14;
	public static final int MOD_CLIENTE_E = 142;
	public static final int MOD_CLIENTE_P = 143;
	public static final int MOD_CLIENTE_OKBusqueda = 144;
	public static final int MOD_CLIENTE_OKUpdate = 1441;
	public static final int MOD_CLIENTE_KOBusqueda = 145;
	public static final int MOD_CLIENTE_KOUpdate = 1442;
	public static final int MOSTRAR_CLIENTE = 15;
	public static final int MOSTRAR_CLIENTE_OK = 151;
	public static final int MOSTRAR_CLIENTE_KO = 153;
	public static final int LISTAR_TODOSCLIENTES = 16;
	public static final int LISTAR_TODOSCLIENTES_OK = 161;
	public static final int LISTAR_TODOSCLIENTES_KO = 162;
	public static final int ENTRXYCliente = 17;
	public static final int ENTRXYCliente_OK = 171;
	public static final int ENTRXYCliente_KO = 172;
	public static final int MOSTRAR_VENTAS_CLIENTE = 18;
	public static final int MOSTRAR_VENTAS_CLIENTE_OK = 181;
	public static final int MOSTRAR_VENTAS_CLIENTE_KO = 182;

	// Marca
	public static final int ALTA_MARCA = 31;
	public static final int ALTA_MARCA_OK = 311;
	public static final int ALTA_MARCA_KO = 312;
	public static final int BAJA_MARCA = 32;
	public static final int BAJA_MARCA_OK = 321;
	public static final int BAJA_MARCA_KO = 322;
	public static final int MODIFICA_MARCA = 33;
	public static final int MODIFICA_MARCA_OK = 331;
	public static final int MODIFICA_MARCA_KO = 332;
	public static final int MOSTRAR_UNA_MARCA = 34;
	public static final int MOSTRAR_UNA_MARCA_OK = 341;
	public static final int MOSTRAR_UNA_MARCA_KO = 342;
	public static final int MOSTRAR_MARCAS = 35;
	public static final int MOSTRAR_MARCAS_OK = 351;
	public static final int MOSTRAR_MARCAS_KO = 352;
	public static final int MOSTRAR_MARCA_MODIFICA = 36;
	public static final int MOSTRAR_MARCA_MODIFICA_OK = 361;
	public static final int MOSTRAR_MARCA_MODIFICA_KO = 362;
	public static final int MOSTRAR_PRODUCTOSDEMARCA = 37;
	public static final int MOSTRAR_PRODUCTOSDEMARCA_OK = 371;
	public static final int MOSTRAR_PRODUCTOSDEMARCA_KO = 372;

	// Venta
	public static final int ABRIR_VENTA = 51;
	public static final int ABRIR_VENTA_OK = 511;
	public static final int ABRIR_VENTA_KO = 512;
	public static final int BAJA_VENTA = 52;
	public static final int BAJA_VENTA_OK = 521;
	public static final int BAJA_VENTA_KO = 522;
	public static final int MODIFICA_VENTA = 53;
	public static final int MODIFICA_VENTA_OK = 531;
	public static final int MODIFICA_VENTA_KO = 532;
	public static final int MODIFICA_VENTA_READ = 530;
	public static final int MODIFICA_VENTA_READ_OK = 5301;
	public static final int MODIFICA_VENTA_READ_KO = 5302;
	public static final int INSERTAR_PRODUCTO_VENTA = 54;
	public static final int INSERTAR_PRODUCTO_VENTA_OK = 541;
	public static final int INSERTAR_PRODUCTO_VENTA_KO = 542;
	public static final int REALIZAR_VENTA = 55;
	public static final int REALIZAR_VENTA_OK = 551;
	public static final int REALIZAR_VENTA_KO = 552;
	public static final int MOSTRAR_VENTA = 56;
	public static final int MOSTRAR_VENTA_OK = 561;
	public static final int MOSTRAR_VENTA_KO = 562;
	public static final int MOSTRAR_VENTAS = 58;
	public static final int MOSTRAR_VENTAS_OK = 581;
	public static final int MOSTRAR_VENTAS_KO = 582;
	public static final int MOSTRAR_VENTA_ACTUAL = 563;
	public static final int DEVOLUCION_VENTA = 57;
	public static final int DEVOLUCION_VENTA_OK = 571;
	public static final int DEVOLUCION_VENTA_KO = 572;
	// public static final int BORRAR_PRODUCTO_VENTA = 58;

	// ...Anhadir lo que haga falta

	// Producto
	public static final int ALTA_PRODUCTO = 61;
	public static final int ALTA_PRODUCTO_OK = 611;
	public static final int ALTA_PRODUCTO_KO = 612;
	public static final int BAJA_PRODUCTO = 62;
	public static final int BAJA_PRODUCTO_OK = 621;
	public static final int BAJA_PRODUCTO_KO = 622;
	public static final int MODIFICA_PRODUCTO = 63;
	public static final int MODIFICAR_PRODUCTO_OK = 631;
	public static final int MODIFICAR_PRODUCTO_KO = 632;
	public static final int MODIFICA_PRODUCTO_READ = 630;
	public static final int MODIFICA_PRODUCTO_READ_OK = 6301;
	public static final int MODIFICA_PRODUCTO_READ_KO = 6302;
	public static final int MOSTRAR_UN_PRODUCTO = 64;
	public static final int MOSTRAR_UN_PRODUCTO_OK = 641;
	public static final int MOSTRAR_UN_PRODUCTO_KO = 642;
	public static final int MOSTRAR_PRODUCTOS = 65;
	public static final int MOSTRAR_PRODUCTOS_OK = 651;
	public static final int MOSTRAR_PRODUCTOS_KO = 652;

	// Empresa
	public static final int ALTA_EMPRESA = 71;
	public static final int ALTA_EMPRESA_OK = 711;
	public static final int ALTA_EMPRESA_KO = 712;
	public static final int BAJA_EMPRESA = 72;
	public static final int BAJA_EMPRESA_OK = 721;
	public static final int BAJA_EMPRESA_KO = 722;
	public static final int MOSTRAR_EMPRESA = 73;
	public static final int MOSTRAR_EMPRESA_OK = 731;
	public static final int MOSTRAR_EMPRESA_KO = 732;
	public static final int MODIFICA_EMPRESA = 74;
	public static final int MODIFICA_EMPRESA_OK = 741;
	public static final int MODIFICA_EMPRESA_KO = 742;
	public static final int MODIFICA_EMPRESA_READ = 740;
	public static final int MODIFICA_EMPRESA_READ_OK = 7401;
	public static final int MODIFICA_EMPRESA_READ_KO = 7402;
	public static final int MOSTRAR_EMPRESAS = 75;
	public static final int MOSTRAR_EMPRESAS_OK = 751;
	public static final int MOSTRAR_EMPRESAS_KO = 752;
	public static final int MOSTRAR_CURSOS_EMPRESA = 76;
	public static final int MOSTRAR_CURSOS_EMPRESA_OK = 761;
	public static final int MOSTRAR_CURSOS_EMPRESA_KO = 762;

	// Departamento
	public static final int ALTA_DEPARTAMENTO = 81;
	public static final int ALTA_DEPARTAMENTO_OK = 811;
	public static final int ALTA_DEPARTAMENTO_KO = 812;
	public static final int BAJA_DEPARTAMENTO = 82;
	public static final int BAJA_DEPARTAMENTO_OK = 821;
	public static final int BAJA_DEPARTAMENTO_KO = 822;
	public static final int MOSTRAR_DEPARTAMENTO = 83;
	public static final int MOSTRAR_DEPARTAMENTO_OK = 831;
	public static final int MOSTRAR_DEPARTAMENTO_KO = 832;
	public static final int MODIFICA_DEPARTAMENTO = 84;
	public static final int MODIFICA_DEPARTAMENTO_OK = 841;
	public static final int MODIFICA_DEPARTAMENTO_KO = 842;
	public static final int MODIFICA_DEPARTAMENTO_READ = 840;
	public static final int MODIFICA_DEPARTAMENTO_READ_OK = 8401;
	public static final int MODIFICA_DEPARTAMENTO_READ_KO = 8402;
	public static final int MOSTRAR_DEPARTAMENTOS = 85;
	public static final int MOSTRAR_DEPARTAMENTOS_OK = 851;
	public static final int MOSTRAR_DEPARTAMENTOS_KO = 852;
	public static final int MOSTRAR_TRABAJADORES_DEPARTAMENTO = 86;
	public static final int MOSTRAR_TRABAJADORES_DEPARTAMENTO_OK = 861;
	public static final int MOSTRAR_TRABAJADORES_DEPARTAMENTO_KO = 862;
	public static final int MOSTRAR_SUELDO_DEPARTAMENTO = 87;
	public static final int MOSTRAR_SUELDO_DEPARTAMENTO_OK = 871;
	public static final int MOSTRAR_SUELDO_DEPARTAMENTO_KO = 872;

	// TRABAJADOR
	public static final int ALTA_TRABAJADOR = 91;
	public static final int ALTA_TRABAJADOR_OK = 911;
	public static final int ALTA_TRABAJADOR_KO = 912;
	public static final int BAJA_TRABAJADOR = 92;
	public static final int BAJA_TRABAJADOR_OK = 921;
	public static final int BAJA_TRABAJADOR_KO = 922;
	public static final int MOSTRAR_TRABAJADOR = 93;
	public static final int MOSTRAR_TRABAJADOR_OK = 931;
	public static final int MOSTRAR_TRABAJADOR_KO = 932;

	public static final int MODIFICA_TRABAJADOR = 9400;
	public static final int MODIFICA_TRABAJADOR_T = 94001;
	public static final int MODIFICA_TRABAJADOR_I = 94002;
	public static final int MODIFICA_TRABAJADOR_OK = 941;
	public static final int MODIFICA_TRABAJADOR_KO = 942;
	public static final int MODIFICA_TRABAJADOR_READ_OK = 9401;
	public static final int MODIFICA_TRABAJADOR_READ_KO = 9402;

	public static final int MOSTRAR_TRABAJADORES = 95;
	public static final int MOSTRAR_TRABAJADORES_OK = 951;
	public static final int MOSTRAR_TRABAJADORES_KO = 952;

	public static final int ASIGNAR_CURSO = 96;
	public static final int ASIGNAR_CURSO_OK = 961;
	public static final int ASIGNAR_CURSO_KO = 962;

	public static final int DESVINCULAR_CURSO = 97;
	public static final int DESVINCULAR_CURSO_OK = 971;
	public static final int DESVINCULAR_CURSO_KO = 972;

	public static final int MOSTRAR_CURSOS_TRABAJADOR = 98;
	public static final int MOSTRAR_CURSOS_TRABAJADOR_OK = 981;
	public static final int MOSTRAR_CURSOS_TRABAJADOR_KO = 982;

	// CURSO
	public static final int ALTA_CURSO = 1091;
	public static final int ALTA_CURSO_OK = 10911;
	public static final int ALTA_CURSO_KO = 10912;
	public static final int BAJA_CURSO = 1092;
	public static final int BAJA_CURSO_OK = 10921;
	public static final int BAJA_CURSO_KO = 10922;
	public static final int MOSTRAR_CURSO = 1093;
	public static final int MOSTRAR_CURSO_OK = 10931;
	public static final int MOSTRAR_CURSO_KO = 10932;
	public static final int MODIFICA_CURSO = 1094;
	public static final int MODIFICA_CURSO_OK = 10941;
	public static final int MODIFICA_CURSO_KO = 10942;
	public static final int MODIFICA_CURSO_READ = 10940;
	public static final int MODIFICA_CURSO_READ_OK = 109401;
	public static final int MODIFICA_CURSO_READ_KO = 109402;
	public static final int MOSTRAR_CURSOS = 1095;
	public static final int MOSTRAR_CURSOS_OK = 10951;
	public static final int MOSTRAR_CURSOS_KO = 10952;
	public static final int MOSTRAR_TRABAJADORES_CURSO = 1096;
	public static final int MOSTRAR_TRABAJADORES_CURSO_OK = 10961;
	public static final int MOSTRAR_TRABAJADORES_CURSO_KO = 10962;

}