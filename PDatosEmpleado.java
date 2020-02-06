package co.edu.unbosque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import co.edu.unbosque.controller.Controller;

public class PDatosEmpleado extends JPanel implements ActionListener {

	FrameP f;
	JLabel fondo, titulo, fRegistrar, fCancelar, fEditar;
	JButton btnReg, btnCan, btnEdit;
	JTextField nom, ape, ced, dir, tel, email;
	JSpinner año, nivel;
	JComboBox tipoList;
	Controller co;
	public PDatosEmpleado (FrameP f,Controller c) {
		this.f = f;
		this.co = c;
		setLayout(null);
		setBounds(-5, 0, 995, 515);
		agregarComponentes();
	}

	private void agregarComponentes() {

		nom = new JTextField();
		nom.setBounds(225, 145, 250, 35);
		add(nom);

		ape = new JTextField();
		ape.setBounds(670, 145, 250, 35);
		add(ape);

		ced = new JTextField();
		ced.setBounds(355, 205, 170, 35);
		add(ced);

		dir = new JTextField();
		dir.setBounds(705, 205, 215, 35);
		add(dir);

		tel = new JTextField();
		tel.setBounds(200, 265, 145, 35);
		add(tel); 

		email = new JTextField();
		email.setBounds(455, 265, 230, 35);
		add(email);

		SpinnerModel q = new SpinnerNumberModel(2000,1902,2002,1);
		año = new JSpinner(q);
		año.setBounds(360, 325, 80, 35);
		JFormattedTextField r1 = ((JSpinner.DefaultEditor) año.getEditor()).getTextField();
		r1.setEditable(false);
		add (año);

		String[] tipoStrings = { "--SELECCIONE TIPO--", "Empleado por comision", "Ingeniero Senior", "Ingeniero Junior" };


		tipoList = new JComboBox();
		tipoList.addItem("--SELECCIONE TIPO--");
		tipoList.addItem("Empleado por comision");
		tipoList.addItem("Ingeniero Senior");
		tipoList.addItem("Ingeniero Junior");
		tipoList.setSelectedIndex(0);
		tipoList.addActionListener(this);
		tipoList.setBounds(680, 325, 160, 35);
		add(tipoList);

		SpinnerModel w = new SpinnerNumberModel(1,1,5,1);
		nivel = new JSpinner(w);
		nivel.setBounds(885, 325, 30, 35);
		JFormattedTextField r2 = ((JSpinner.DefaultEditor) nivel.getEditor()).getTextField();
		r2.setEditable(false);
		nivel.setVisible(false);
		add (nivel);

		btnEdit = new JButton();
		btnEdit.setBounds(845, 17, 140, 40);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorderPainted(false);
		btnEdit.addActionListener(this);
		btnEdit.setActionCommand("edit");
		add(btnEdit);

		ImageIcon iconEdit = new ImageIcon("data/editar.png");
		fEditar = new JLabel(iconEdit);
		fEditar.setBounds(825, 10, 180, 53);
		add(fEditar);

		btnReg = new JButton();
		btnReg.setBounds(260, 394, 220, 55);
		btnReg.setContentAreaFilled(false);
		btnReg.setBorderPainted(false);
		btnReg.addActionListener(this);
		btnReg.setActionCommand("reg");
		add(btnReg);

		ImageIcon iconReg = new ImageIcon("data/registrar.png");
		fRegistrar = new JLabel(iconReg);
		fRegistrar.setBounds(250, 384, 240, 74);
		add(fRegistrar);

		btnCan = new JButton();
		btnCan.setBounds(520, 394, 220, 55);
		btnCan.setContentAreaFilled(false);
		btnCan.setBorderPainted(false);
		btnCan.addActionListener(this);
		btnCan.setActionCommand("can");
		add(btnCan);

		ImageIcon iconCan = new ImageIcon("data/cancelar.png");
		fCancelar = new JLabel(iconCan);
		fCancelar.setBounds(510, 384, 240, 74);
		add(fCancelar);

		titulo = new JLabel();
		titulo.setBounds(0, 0, 1000, 495);
		add(titulo);

		ImageIcon fon = new ImageIcon("data/fondoDatosO.png");
		fondo = new JLabel(fon);
		fondo.setBounds(0, 0, 1000, 495);
		add(fondo);
	}
	public void ocultarEdit () {
		fEditar.setVisible(false);
		btnEdit.setVisible(false);
	}

	public void mostrarEdit () {
		fEditar.setVisible(true);
		btnEdit.setVisible(true);
	}
	public void deshabilitar () {
		ImageIcon iconActb = new ImageIcon("data/actualizarb.png");
		fRegistrar.setIcon(iconActb);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == "reg") {
			System.out.println("Registrar");
			
		}

		if (accion == "can") {
			f.getPde().setVisible(false);
			f.setTitle("BosqueSW");
			f.getPi().bloquear();
			f.getPi().setVisible(true);
			deshabilitar();
		}

		if (accion == "edit") {	
			ImageIcon iconAct = new ImageIcon("data/actualizar.png");
			fRegistrar.setIcon(iconAct);
			ocultarEdit();
		}

		JComboBox tipoList = (JComboBox)arg0.getSource();
		String opcion = (String)tipoList.getSelectedItem();
		if (opcion == "Ingeniero Junior") {
			ImageIcon fon = new ImageIcon("data/fondoDatosJunior.png");
			fondo.setIcon(fon);
			año.setBounds(285, 325, 80, 35);
			tipoList.setBounds(580, 325, 160, 35);
			nivel.setVisible(true);
			
			
		} else {
			ImageIcon fon = new ImageIcon("data/fondoDatosO.png");
			fondo.setIcon(fon);
			año.setBounds(360, 325, 80, 35);
			tipoList.setBounds(680, 325, 160, 35);
			nivel.setVisible(false);
		}
		
	}
}
