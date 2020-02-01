package co.edu.unbosque.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.modelo.Personal;

public class controller {
	private ArrayList<Personal> personal;

	public controller() {
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
//	public int agregarPersonal(Personal p, int numero, String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
//			int anioIngreso, char genero, double salario) {
		
//		if (p instanceof PersonalDeComision) {
//			agregarPersonalDeComision(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
//					int anioIngreso, char genero, double salario);
			
			
//		}
//		
//	}
//	public void agregarPersonalDeComision(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
//			int anioIngreso, char genero, double salario) {
//		PersonalDeComision nuevo = new PersonalDeComision( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
//				anioIngreso,  genero,  salario);
//
//		if (buscarPersonal(cedula)== null) {
//			personal.add(nuevo);
//
//
//		}else {
//			JOptionPane.showMessageDialog(null, "Ya existe este empleado");
//
//
//		}

//	}
//	public void agregarIngenierioJunior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
//	int anioIngreso, char genero, double salario) {
//IngenierioJunior nuevo = new IngenierioJunior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
//		anioIngreso,  genero,  salario);
//
//if (buscarPersonal(cedula)== null) {
//	personal.add(nuevo);
//
//
//}else {
//	JOptionPane.showMessageDialog(null, "Ya existe este empleado");
//
//
//}

//}
//	public void agregarIngenierioSenior(String cedula, String apellido, String nombre, String telefono, String correo, String direccion,
//	int anioIngreso, char genero, double salario) {
//	IngenierioSenior nuevo = new IngenierioSenior( cedula,  apellido,  nombre,  telefono,  correo,  direccion,
//		anioIngreso,  genero,  salario);
//
//if (buscarPersonal(cedula)== null) {
//	personal.add(nuevo);
//
//
//}else {
//	JOptionPane.showMessageDialog(null, "Ya existe este empleado");
//
//
//}

//}
	



}
