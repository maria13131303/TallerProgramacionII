package co.edu.unbosque.modelo;

public class IngenieroSenior extends PersonalSalarioFijo{
	int numVentas;
	public IngenieroSenior(String cedula, String apellido, String nombre, String telefono, String correo,
			String direccion, int anioIngreso, char genero) {
		super(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double porcentajeAdicional(int numVentas) {
		double porcentaje = 0;

		if (numVentas>=1&&numVentas<=5) 
		{
			porcentaje = 0.10;
		}
		if (numVentas>5&&numVentas<10) 
		{
			porcentaje = 0.15;
		}
		if (numVentas>=10&&numVentas<=20) 
		{
			porcentaje = 0.20;
		}
		if (numVentas>=21) 
		{
			porcentaje = 0.30;
		}
		return porcentaje;
	}
	
	@Override
	public double calcularSalario() {
		double salario = SUELDO_FIJO+calcularBono()+SUELDO_FIJO*porcentajeAdicional(numVentas);
		return salario;
	}

	public int getNumVentas() {
		return numVentas;
	}

	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}
}
