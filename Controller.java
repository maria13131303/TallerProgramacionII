package co.edu.unbosque.controller;
/**
 * 
 * @author Diego Fernando Garnica Ortiz
 * @author Juan David Florez Godoy
 * @author Maria Victoria Lopez Lopez
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.modelo.Cliente;
import co.edu.unbosque.modelo.IngenieroJunior;
import co.edu.unbosque.modelo.IngenieroSenior;
import co.edu.unbosque.modelo.Personal;
import co.edu.unbosque.modelo.PersonalComision;
import co.edu.unbosque.modelo.PersonalSalarioFijo;
import co.edu.unbosque.view.FrameP;
/**
 * Esta es la clase que se encarga de controlar a las demas clases , ademas une a las clases de diferentes paquetes
 *
 */
public class Controller {
	/**
	 * Creacion del ArrayList de personal
	 */
	private ArrayList<Personal> personal;

	private GestorDeArchivo gestor;
	/**
	 * Este es el constructor de Controller donde incializamos al ArrayList de personal
	 */
	public Controller() {
		personal = new ArrayList<Personal>();
		gestor = new GestorDeArchivo();
		personal = gestor.cargarArchivo();
		FrameP fp = new FrameP(this);
	

	}

	//	Metodos 


	public void borrarDatos () {
		for (int i = 0; i < personal.size(); i++) {
			personal.remove(i); 
		}
		gestor.guardarEnArchivo(personal);
	}
	//CRUD Personal
	/**
	 * Busca a un elemento del ArrayList del personal y lo devuelve con la posicion
	 * <b> pre </b> Se debe haber creado el ArrayList de personal y tambien debe estar inicalizado
	 * <b> pre </b> Debe existir al menos un elemento en el ArrayList
	 * @param cedula , Cedula con la que esta identificada el personal
	 * <b> post: </b>  Se encuentra el empleado con la cedula digitada
	 * @return Nos devuelve el personal del cual estamos digitando la cedula
	 */
	public Personal buscarPersonal(String cedula) {
		Personal found  = null;
		if (personal.isEmpty()) {
			found  = null;
		}
		else if (!personal.isEmpty()) {
			for (int i = 0; i < personal.size(); i++) {
				if (personal.get(i).getCedula().equals(cedula)) {
					found = personal.get(i);
				}
			}
		}
		return found;
	}

	/**
	 * Este es el metodo que agrega a un personal dependiendo del valor que se introduzca
	 *<b> pre </b> No debe existir un personal con cedula igual
	 * @param tipo , El numero que se digita para identificar el tipo de personal que es
	 * @param cedula , La cedula que le pondremos al personal  para identificarlo
	 * @param apellido, apellido que tendra nuestro personal
	 * @param nombre, nombre que tendra el personal
	 * @param telefono . telefono del personal
	 * @param correo , Correo que tendra el personal 
	 * @param direccion , Direccion que tendra el personal
	 * @param anioIngreso , Año en el cual nuestro personal ingreso a la empresa
	 * @param genero , genero de nuestro personal
	 * @param num , Numero que cambiara depende del tipo de personal
	 * <b> post : </b> Se agrega el personal dependiendo de la opcion que se haya elegido
	 * @throws Exception 
	 */
	public void agregarPersonal( int tipo, String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int num) throws Exception {

		if (!verificarCorreo(correo)) {
			throw new Exception("El correo debe incluir el caracter @");
		}

		if (cedula.length()!=10) {
			throw new Exception("La cédula debe tener 10 dígitos");
		}
		for (int i = 0; i < personal.size(); i++) {
			if (cedula.contentEquals(personal.get(i).getCedula())) {
				throw new Exception("La cédula ya pertenece a otro empleado");
			}
		}
		if (tipo == 1) {
			agregarPersonalComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
					anioIngreso,  genero);
		}
		else if (tipo == 3) {
			agregarIngenieroJunior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, num);
		}
		else if (tipo == 2) {
			agregarIngenieroSenior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, num);
		}
	}

	public void editarPersonal( int tipo, String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int num) throws Exception {
		if (!verificarCorreo(correo)) {
			throw new Exception("El correo debe incluir el caracter @");
		}
		Personal nuevo = null;
		if (tipo == 1) {
			nuevo = new PersonalComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion, anioIngreso,  genero);
		}
		else if (tipo == 3) {
			nuevo = new IngenieroJunior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, num);
		}
		else if (tipo == 2) {
			nuevo = new IngenieroSenior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, num);
		}

		Personal p = buscarPersonal(cedula);

		for (int i = 0; i < personal.size(); i++) {
			if(p.equals(personal.get(i)))
			{
				personal.set(i, nuevo);
				gestor.guardarEnArchivo(personal);
			}
		}
	}


	/**
	 * Este  metodo se encargara de crear al personal de tipo Personal de Comision 
	 * <b> pre </b> Este metodo requiere que no existan personas con la misma cedula
	 * <b> pre </b> El arraylist debe existir y estar inicializado
	 * @param cedula , La cedula que le pondremos al personal  para identificarlo
	 * @param apellido, apellido que tendra nuestro personal
	 * @param nombre, nombre que tendra el personal
	 * @param telefono . telefono del personal
	 * @param correo , Correo que tendra el personal 
	 * @param direccion , Direccion que tendra el personal
	 * @param anioIngreso , Año en el cual nuestro personal ingreso a la empresa
	 * @param genero , genero de nuestro personal
	 * @param numClientes , numero de clientes que se le agregaran al personal de comision y de los cuales dependera su salario
	 * <b> post : </b> Esto nos creara un objeto de tipo Personal de Comision
	 */
	public void agregarPersonalComision(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero) {
		PersonalComision nuevo = new PersonalComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);
			gestor.guardarEnArchivo(personal);
		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}
		else {
			JOptionPane.showMessageDialog(null, "No se agrego al personal");
		}
	}
	/**
	 * Este  metodo se encargara de crear al personal de tipo Ingenierio Junior 
	 * <b> pre </b> Este metodo requiere que no existan personas con la misma cedula
	 * <b> pre </b> El arraylist debe existir y estar inicializado
	 * @param cedula , La cedula que le pondremos al personal  para identificarlo
	 * @param apellido, apellido que tendra nuestro personal
	 * @param nombre, nombre que tendra el personal
	 * @param telefono . telefono del personal
	 * @param correo , Correo que tendra el personal 
	 * @param direccion , Direccion que tendra el personal
	 * @param anioIngreso , Año en el cual nuestro personal ingreso a la empresa
	 * @param genero , genero de nuestro personal
	 * @param nivel que tendra nuestro ingenierio va desde 1-5
	 * <b> post : </b> Esto nos creara un objeto de tipo  Ingenierio Junior
	 */
	public void agregarIngenieroJunior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int nivel) {
		IngenieroJunior nuevo = new IngenieroJunior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  nivel);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);
			gestor.guardarEnArchivo(personal);
		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Ya existe este empleado");
		}
	}
	/**
	 * Este  metodo se encargara de crear al personal de tipo Ingenierio Senior 
	 * <b> pre </b> Este metodo requiere que no existan personas con la misma cedula
	 * <b> pre </b> El arraylist debe existir y estar inicializado
	 * @param cedula , La cedula que le pondremos al personal  para identificarlo
	 * @param apellido, apellido que tendra nuestro personal
	 * @param nombre, nombre que tendra el personal
	 * @param telefono . telefono del personal
	 * @param correo , Correo que tendra el personal 
	 * @param direccion , Direccion que tendra el personal
	 * @param anioIngreso , Año en el cual nuestro personal ingreso a la empresa
	 * @param genero , genero de nuestro personal
	 * @param numVentas , el numero de ventas de la cual dependera su salario
	 * <b> post : </b> Esto nos creara un objeto de tipo  Ingenierio Senior

	 */
	public void agregarIngenieroSenior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int numVentas) {
		IngenieroSenior nuevo = new IngenieroSenior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  numVentas);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);
			gestor.guardarEnArchivo(personal);
		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}else {
			JOptionPane.showMessageDialog(null, "Ya existe este empleado");
		}
	}


	/**
	 * Este es el metodo que nos permite eliminar a cualquier miembro del personal
	 * <b>pre </b> Es necesario que exista ya un personal con la cedula indicada
	 * @param cedula con la cual buscaremos a el empleado a eliminar
	 * 	<b> post: </b> Nos eliminara el personal  con la cedula indicada
	 */
	public void eliminar (String cedula) {
		Personal p = buscarPersonal(cedula);
		if (p!= null) {
			personal.remove(p);
			gestor.guardarEnArchivo(personal);
		}
	}
	//Calcular salario
	/**
	 * Este metodo nos permite modificar el salario de un elemento p de tipo Personal
	 * <b> pre </b>  Es necesario que el personal ya exista 
	 * @param p el cual nos indicara el objeto de tipo personal
	 * <b> post : </b> Nos devolvera un salario nuevo calculado en base a la caracteristica de cada tipo de personal
	 * @return el nuevo salario
	 */
	public double calcularSalario(Personal p)
	{
		double salario = p.calcularSalario();
		return salario;
	}

	// CRUD clientes

	/**
	 * Este es el metodo que le asignara un personal al personal de comision 
	 * <b> pre </b>  Es necesario que el personal ya exista 
	 * @param cedula la cedula del personal
	 * @param nomCliente el nombre del cliente
	 * @param cedCliente la ceduola del cliente
	 * @param monto el monto que el cliente ha pagado al personal
	 * <b> post : </b> Se le asignara un cliente al personal de comision indicado
	 * @throws Exception tira una excepcion si no se ingresa un monto entre el rango de 500000 y 2000000
	 */
	public void asignarCliente(String cedula, String nomCliente, String cedCliente, double monto) throws Exception
	{

		Cliente cliente = new Cliente(nomCliente, cedCliente, monto);
		if (monto<500000 || monto>2000000) {
			throw new Exception("El monto sale de los parámetros de la venta");
		}
		PersonalComision pc = (PersonalComision)buscarPersonal(cedula);
		for (int i = 0; i < personal.size(); i++) {
			if((pc.getCedula()).equals(personal.get(i).getCedula())) {
				pc.getClientes().add(cliente);
				personal.set(i, pc);
				System.out.println("Agregado");
			}
		}
		gestor.guardarEnArchivo(personal);
	}
	/**
	 * Este es el metodo que busca al cliente 
	 * <b> pre </b> Se debe haber creado el ArrayList de clientes y tambien debe estar inicalizado
	 * @param cedPersonal , es la cedula del personal el cual tiene asignado el cliente
	 * @param cedCliente es la cedula del cliente a buscar
	 * @return Nos retorna el cliente en la posicion que esta
	 * <b>post: </b> Este metodo nos emncontrara al cliente que estemos buscando
	 */
	public Cliente buscarCliente(String cedPersonal, String cedCliente)
	{
		PersonalComision pc = (PersonalComision) buscarPersonal(cedPersonal);
		Cliente buscado = null;
		for (int i = 0; i < pc.getClientes().size(); i++) {
			if (pc.getClientes().get(i).getCedula().equals(cedCliente)) {
				buscado = pc.getClientes().get(i);
			}
		}
		return buscado;
	}

	/**
	  Este es el metodo que nos permite eliminar a cualquier cliente
	 * <b>pre </b> Es necesario que exista ya un personal con la cedula indicada
	 * <b>pre </b> Es necesario que exista ya un cliente con la cedula indicada
	 * @param cedula la cual es del empleado el cual tiene asignado el cliente
	 * @param cedCliente es la cedula del cliente a eliminar
	 * @throws Exception Nos lanza una excepcion si el personal no es del tipo personal de comision
	 *<b> post: </b> Nos eliminara el cliente con la cedula indicada

	 */
	public void eliminarCliente(String cedula, String cedCliente) throws Exception
	{

		PersonalComision pc = (PersonalComision) buscarPersonal(cedula);
		Cliente cliente = buscarCliente(pc.getCedula(), cedCliente);
		for (int i = 0; i < personal.size(); i++) {
			if (personal.get(i).equals(pc)) {
				pc.getClientes().remove(cliente);

				personal.set(i, pc);s
			}
		}
		gestor.guardarEnArchivo(personal);
	}
	/**
	 * Este metodo nos devolera el arraylist de personal
	 */

	public ArrayList<Personal> getPersonal() {
		return personal;
	}

	/**
	 * Este metodo nos permitira modificar el personal del arrayList
	 */
	public void setPersonal(ArrayList<Personal> personal) {
		this.personal = personal;
	}
	/**
	 * Este es el metodo que nos verificara que existe en el correo el caracter "@"
	 * <b> post: </b> Nos retornara true si el correo contiene el caracter
	 */
	public boolean verificarCorreo(String correo)
	{
		boolean correcto = false;
		for (int i = 0; i < correo.length(); i++) {
			if (correo.toCharArray()[i]=='@') {
				correcto = true;
			}
		}
		return correcto;
	}

}
