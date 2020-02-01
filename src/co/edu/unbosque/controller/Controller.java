package co.edu.unbosque.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.modelo.Cliente;
import co.edu.unbosque.modelo.IngenieroJunior;
import co.edu.unbosque.modelo.IngenieroSenior;
import co.edu.unbosque.modelo.Personal;
import co.edu.unbosque.modelo.PersonalComision;
import co.edu.unbosque.modelo.PersonalSalarioFijo;

public class Controller {

	private ArrayList<Personal> personal;

	public Controller() {
		personal = new ArrayList<Personal>();
	}

	public Personal buscarPersonal(String cedula) {
		Personal found  = null;
		if (personal.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay empleados");
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
	public void agregarPersonal( int tipo, String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int num) {

		if (tipo == 1) {
			agregarPersonalComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
					anioIngreso,  genero, num);
		}
		else if (tipo == 2) {
			agregarIngenieroJunior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, num);
		}
		else if (tipo == 3) {
			agregarIngenieroSenior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, num);

		}
	}
	public void agregarPersonalComision(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int numClientes) {
		PersonalComision nuevo = new PersonalComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero, numClientes);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);
		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}
		else {
			JOptionPane.showMessageDialog(null, "No se pudo :C");
		}
	}
	
	public void agregarIngenieroJunior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int nivel) {
		IngenieroJunior nuevo = new IngenieroJunior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  nivel);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);
		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Ya existe este empleado");
		}
	}
	public void agregarIngenieroSenior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, int numVentas) {
		IngenieroSenior nuevo = new IngenieroSenior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  numVentas);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);
		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}else {
			JOptionPane.showMessageDialog(null, "Ya existe este empleado");
		}
	}

	public void modificarPersonalDeComision( String cedula, String apellido, String nombre
			, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {

		Personal p = buscarPersonal(cedula);

		if (p!= null) {
			if(p instanceof PersonalComision) {
				p.setAnioIngreso(anioIngreso);
				p.setApellido(apellido);
				p.setCedula(cedula);
				p.setCorreo(correo);
				p.setDireccion(direccion);
				p.setGenero(genero);
				p.setNombre(nombre);
				p.setTelefono(telefono);


			} 
		}
	}
	
	public void modificarPersonalSalarioFijo( String cedula, String apellido, String nombre
			, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {

		Personal p = buscarPersonal(cedula);
		if (p!= null) {
			if(p instanceof PersonalComision) {
				p.setAnioIngreso(anioIngreso);
				p.setApellido(apellido);
				p.setCedula(cedula);
				p.setCorreo(correo);
				p.setDireccion(direccion);
				p.setGenero(genero);
				p.setNombre(nombre);
				p.setTelefono(telefono);

			} 
		}

	}
	public void modificarIngenierioJunior( String cedula, String apellido, String nombre
			, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {

		Personal p = buscarPersonal(cedula);
		if (p!= null) {

			if(p instanceof IngenieroJunior) {
				p.setAnioIngreso(anioIngreso);
				p.setApellido(apellido);
				p.setCedula(cedula);
				p.setCorreo(correo);
				p.setDireccion(direccion);
				p.setGenero(genero);
				p.setNombre(nombre);
				p.setTelefono(telefono);

			} 
		}
	}
	
	public void modificarIngenierioSenior( String cedula, String apellido, String nombre
			, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {

		Personal p = buscarPersonal(cedula);
		if (p!= null) {
			if(p instanceof IngenieroSenior) {
				p.setAnioIngreso(anioIngreso);
				p.setApellido(apellido);
				p.setCedula(cedula);
				p.setCorreo(correo);
				p.setDireccion(direccion);
				p.setGenero(genero);
				p.setNombre(nombre);
				p.setTelefono(telefono);
			} 
		}
	}
	public void eliminar (String cedula) {
		Personal p = buscarPersonal(cedula);
		if (p!= null) {
			personal.remove(p);
		}
	}
	
	public double calcularSalario(Personal p)
	{
		double salario = p.calcularSalario();
		return salario;
	}

	public void asignarCliente(String cedula, String nomCliente, String cedCliente, double monto) throws Exception
	{
		Personal p = buscarPersonal(cedula);
		Cliente cliente = new Cliente(nomCliente, cedCliente, monto);
		if(!p.getClass().equals("class co.edu.unbosque.modelo.PersonalComision"))
		{
			throw new Exception("Solo al personal por comisión se le pueden asignar clientes");
		}
		else
		{
			PersonalComision pc = (PersonalComision) buscarPersonal(cedula);
			for (int i = 0; i < personal.size(); i++) {
				if (personal.get(i).equals(pc)) {
					pc.getClientes().add(cliente);
					personal.set(i, pc);
				}
			}
		}
	}
	
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
	
	public void eliminarCliente(String cedula, String cedCliente) throws Exception
	{
	Personal p = buscarPersonal(cedula);
		if(!p.getClass().equals("class co.edu.unbosque.modelo.PersonalComision"))
		{
			throw new Exception("Solo al personal por comisión se le pueden asignar clientes");
		}
		else
		{
			PersonalComision pc = (PersonalComision) buscarPersonal(cedula);
			Cliente cliente = buscarCliente(pc.getCedula(), cedCliente);
			for (int i = 0; i < personal.size(); i++) {
				if (personal.get(i).equals(pc)) {
					pc.getClientes().remove(cliente);
					personal.set(i, pc);
				}
			}
		}
	}
}
