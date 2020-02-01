package co.edu.unbosque.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.modelo.Personal;

public class controller {
	private ArrayList<Personal> personal;

	public controller() {
		personal = new ArrayList<Personal>();
	}


	public ArrayList<Personal> getPersonal() {
		return personal;
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
	public void agregarPersonal( int numero, String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {

		if (numero == 1) {
			agregarPersonalDeComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
					anioIngreso,  genero,  salario);
		}else if (numero == 2) {
			agregarIngenierioJunior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, salario);
		}
		else if (numero == 3) {
			agregarIngenierioSenior(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, salario);

		}else if (numero == 4) {
			agregarPersonalDeSalarioFijo(cedula, apellido, nombre, telefono, correo, direccion, anioIngreso, genero, salario);
		}

	}
	public void agregarPersonalDeComision(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {
		PersonalDeComision nuevo = new PersonalDeComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  salario);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);


		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}else {
			JOptionPane.showMessageDialog(null, "No se pudo :C");


		}

	}
	public void agregarPersonalDeSalarioFijo(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {
		PersonalDeSalarioFijo nuevo = new PersonalDeSalarioFijo( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  salario);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);


		}
		else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}else {
			JOptionPane.showMessageDialog(null, "No se pudo :C");


		}

	}
	public void agregarIngenierioJunior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {
		IngenierioJunior nuevo = new IngenierioJunior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  salario);

		if (buscarPersonal(cedula)== null) {
			personal.add(nuevo);


		}else if (buscarPersonal(cedula)!=null) {
			System.out.println("Ya existe");

		}
		else {
			JOptionPane.showMessageDialog(null, "Ya existe este empleado");


		}

	}
	public void agregarIngenierioSenior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
			int anioIngreso, char genero, double salario) {
		IngenierioSenior nuevo = new IngenierioSenior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
				anioIngreso,  genero,  salario);

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
			if(p instanceof PersonalDeComision) {
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
			if(p instanceof PersonalDeComision) {
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

			if(p instanceof IngenierioJunior) {
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
			if(p instanceof IngenierioSenior) {
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

	// crear cliente :c despues de resolver los de arriba miramos eso

}
