/**
 * 
 */
package Clases.Integración.query;

import Clases.Integración.query.querys.cliente_entre_x_e_y;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class queryFactoryIMP extends queryFactory {

	@Override
	public query newQuery(String nombre) {
		// TODO Auto-generated method stub
		switch (nombre){
		case "entre_x_e_y":
			return new cliente_entre_x_e_y();
		}
		return null;
			
	}
}