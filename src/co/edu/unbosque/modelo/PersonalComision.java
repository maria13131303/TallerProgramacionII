package co.edu.unbosque.modelo;

import java.util.ArrayList;

public class PersonalComision extends Personal
{
	public static double MINIMO  = 1100000;
	int numClientes;
	ArrayList<Cliente> clientes;
	public PersonalComision(String cedula, String apellido, String nombre, String telefono, String correo,
			String direccion, int anioIngreso, char genero, int numClientes) {
		super(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero);
		this.numClientes = numClientes;
		clientes = new ArrayList<Cliente>();
	}
	
	@Override
	public double calcularSalario() {
		double salario = MINIMO;
		double monto = 0;
		numClientes = clientes.size();
		for (int i = 0; i < clientes.size(); i++) {
			monto += clientes.get(i).getMonto()*clientes.size();
		}
		if (monto>=MINIMO) 
		{
			return monto;
		}
		else
		{
		return salario;
		}
	}

	public int getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}
