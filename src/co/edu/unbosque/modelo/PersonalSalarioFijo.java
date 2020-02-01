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
		int año = this.getAnioIngreso();

		if (año>=2 && año<=3) 
		{
			bono = SUELDO_FIJO*0.05;
		}
		if (año>=4 && año<=7) 
		{
			bono = SUELDO_FIJO*0.10;
		}
		if (año>=8 && año<=15) 
		{
			bono = SUELDO_FIJO*0.15;
		}
		if (año>15) 
		{
			bono = SUELDO_FIJO*0.20;
		}
		return bono;
	}
	
	public static double getSUELDO_FIJO() {
		return SUELDO_FIJO;
	}
}
