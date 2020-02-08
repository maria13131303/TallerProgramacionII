package co.edu.unbosque.modelo;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 
 * @author Diego Fernando Garnica Ortiz
 * @author Juan David Florez Godoy
 * @author Maria Victoria Lopez Lopez
 */
public abstract class Personal implements Serializable{

	private String cedula;
	private String apellido;
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	private int anio;
	private char genero;
	private int anioActual;

	/**
	 * 
	 * @param cedula , La cedula que le pondremos al personal  para identificarlo
	 * @param apellido, apellido que tendra nuestro personal
	 * @param nombre, nombre que tendra el personal
	 * @param telefono . telefono del personal
	 * @param correo , Correo que tendra el personal 
	 * @param direccion , Direccion que tendra el personal
	 * @param anioIngreso , Año en el cual nuestro personal ingreso a la empresa
	 * @param genero , genero de nuestro personal
	 */

	public Personal(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero) {
		super();
		Calendar c;
		c = Calendar.getInstance();
		anioActual = c.get(Calendar.YEAR);
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.anio = anioActual-anioIngreso;
		this.genero = genero;
	}

	/**
	 * Este es el metodo que nos permite tener acceso a la cedula del personal
	 *Nos retorna un String con la cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * Este es el metodo que nos permite modificar la cedula 
	 * @param cedula que es la cedula anterior del personal
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso al apellido del personal
	 * Nos retorna un String con el apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Este es el metodo que nos permite modificar el apellido del personal
	 * @param apellido el cual es el apellido del personal
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso al nombre del personal
	 * Nos retorna un String con el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Este es el metodo que nos permite modificar el nombre 
	 * @param nombre que es el nombre anterior del personal
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso al telefono del personal
	 * Nos retorna un String con el telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Este es el metodo que nos permite modificar el telefono 
	 * @param telefono que es el telefono anterior del personal
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso al correo del personal
	 * Nos retorna un String con el correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Este es el metodo que nos permite modificar el correo 
	 * @param correo que es el correo anterior del personal
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso a la direccion del personal
	 * Nos retorna un String con la direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Este es el metodo que nos permite modificar la direccion 
	 * @param direccion que es la direccion anterior del personal
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso al año del personal
	 * Nos retorna un int con el año
	 */
	public int getAnio() {
		return anio;
	}
	/**
	 * Este es el metodo que nos permite modificar el año 
	 * @param anio que es el año  anterior del personal
	 */
	public void setAnio(int anio) {
		this.anio = anioActual-anio;
	}
	/**
	 * Este es el metodo que  nos permite tener acceso al genero del personal
	 * Nos retorna un char con el genero
	 */
	public char getGenero() {
		return genero;
	}
	/**
	 * Este es el metodo que nos permite modificar el genero 
	 * @param genero que es el genero anterior del personal
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * Este es el metodo que  nos permite tener acceso al año actual
	 * Nos retorna un int con el año actual
	 */
	public int getAnioActual() {
		return anioActual;
	}
	/**
	 * Este es el metodo que nos permite modificar el año actual 
	 * @param anioActual que es el año actual anterior del personal
	 */
	public void setAnioActual(int anioActual) {
		this.anioActual = anioActual;
	}
	/**
	 * Este es nuestro metodo abstract el cual usaremos en otras clases
	 */
	public abstract double calcularSalario();

}