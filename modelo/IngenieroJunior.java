package co.edu.unbosque.modelo;

public class IngenieroJunior extends PersonalSalarioFijo{
	int nivel;
	
	public IngenieroJunior(String cedula, String apellido, String nombre, String telefono, String correo,
			String direccion, int anioIngreso, char genero, int nivel) {
		super(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero);
		this.nivel = nivel;
	}

	public void ascenso ()
	{
		nivel++;
	}
	
	public double  porcentajeAdicional(int num)
	{
		double porcentaje = 0;
		if (num==1) 
		{
			porcentaje = 0;
		}
		if (num==2&&num==3) 
		{
			porcentaje = 0.05;
		}
		if (num==4&&num==5) 
		{
			porcentaje = 0.08;
		}
		return porcentaje;
	}
	@Override
	public double calcularSalario()
	{
		double salario = SUELDO_FIJO+calcularBono()+SUELDO_FIJO*porcentajeAdicional(nivel);
		return salario;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
