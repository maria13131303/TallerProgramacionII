package co.edu.unbosque.modelo;

public class Cliente {
	String nombre;
	String cedula;
	double monto;
	public Cliente(String nombre, String cedula, double monto) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.monto = monto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public boolean verificarMonto()
	{
		boolean correcto = true;
		if (monto<500000 || monto>2000000) {
			correcto = false;
		}
		return correcto;
	}
}
