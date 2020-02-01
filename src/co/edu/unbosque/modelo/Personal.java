package co.edu.unbosque.modelo;

public abstract class Personal {
	
	private String cedula;
	private String apellido;
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	private int anioIngreso;
	private char genero;

	
	public Personal(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.anioIngreso = anioIngreso;
		this.genero = genero;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getAnioIngreso() {
		return anioIngreso;
	}
	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public void verificarCorreo(String correo)
	{
		
	}
	
	public abstract double calcularSalario();

}