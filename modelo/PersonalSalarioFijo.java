package co.edu.unbosque.modelo;

public abstract class PersonalSalarioFijo extends Personal{
	
	public static double SUELDO_FIJO  = 3500000;

	public PersonalSalarioFijo(String cedula, String apellido, String nombre, String telefono, String correo,
			String direccion, int anioIngreso, char genero) {
		super(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero);
	}

	public abstract double porcentajeAdicional(int numVentas);
	
	public double calcularBono()
	{
		double bono = 0;
		int a�o = this.getAnioIngreso();

		if (a�o>=2 && a�o<=3) 
		{
			bono = SUELDO_FIJO*0.05;
		}
		if (a�o>=4 && a�o<=7) 
		{
			bono = SUELDO_FIJO*0.10;
		}
		if (a�o>=8 && a�o<=15) 
		{
			bono = SUELDO_FIJO*0.15;
		}
		if (a�o>15) 
		{
			bono = SUELDO_FIJO*0.20;
		}
		return bono;
	}
	
	public static double getSUELDO_FIJO() {
		return SUELDO_FIJO;
	}
}
