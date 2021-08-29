package clases_ProyectoFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.IDDatatypeValidator;

import java.awt.Color;

public class Director1 extends KeyAdapter implements ActionListener,KeyListener {
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulSet = null ;
	JFrame frame;
	JButton btnNewButton_4 = new JButton("Volver");
	JButton btnNewButton_3 = new JButton("Mostrar");
	JButton btnNewButton_5 = new JButton("Buscar");
	JButton btnNewButton_2 = new JButton("Eliminar");
	JButton btnNewButton_1 = new JButton("Modificar");
	JButton btnNewButton = new JButton("Agregar");
	JButton btnNewButton_6 = new JButton("Actualizar");
	JComboBox comboBox = new JComboBox();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table = new JTable();;
	
	DefaultTableModel modo=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Cedula", "Nombre", "Apellido", "Edad", "Dirección", "Sexo"
			});;

	public Director1() {
		btnNewButton_4.addActionListener(this);
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(400, 90, 530, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro director");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(208, 2, 130, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(99, 39, 55, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addKeyListener(this);
		textField.setBounds(99, 51, 104, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(99, 84, 55, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.addKeyListener(this);
		textField_1.setBounds(99, 97, 104, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(99, 128, 55, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.addKeyListener(this);
		textField_2.setBounds(99, 142, 104, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(317, 39, 55, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.addKeyListener(this);
		textField_3.setBounds(317, 51, 104, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(317, 84, 64, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.addKeyListener(this);
		textField_4.setBounds(317, 97, 104, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(317, 128, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
	
		comboBox.setBounds(317, 141, 104, 21);
		frame.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino","Femenino"}));
		comboBox.setSelectedItem(null);
		
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(99, 173, 322,20);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_6.setVisible(false);
		btnNewButton_6.addActionListener(this);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_6.setBounds(99, 173, 322, 20);
		frame.getContentPane().add(btnNewButton_6);
		
		
		JLabel lblNewLabel_7 = new JLabel("Gestionar por cedula");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 202, 130, 17);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.addKeyListener(this);
		textField_5.setBounds(10, 219, 118, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 266, 100, 20);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(120, 266, 115, 20);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(250, 266,115, 20);
		frame.getContentPane().add(btnNewButton_3);
			
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(380, 266, 118, 20);
		frame.getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 294, 491, 122);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(164, 218, 89, 23);
		frame.getContentPane().add(btnNewButton_5);}

	public void actionPerformed(ActionEvent e) {
		 Director D1=new Director();
		 if( e.getSource()==btnNewButton_4) {
			 frame.dispose();
			 frame.setVisible(false);
			 JF_Principal p1=new JF_Principal();}
		 else if (e.getSource()==btnNewButton) {
			 conexion = conexion_DB.conectando();
			 if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() ||  textField_3.getText().isEmpty()
						||textField_4.getText().isEmpty()  ||comboBox.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
			 else { 
				 boolean pasa=false;
				 D1.edad= Integer.parseInt(textField_3.getText());
					if(D1.edad>20 && D1.edad>=93) {
						pasa=false;}
					else {
						pasa=true;} 
				 if(pasa==true) {
					 try {
						 boolean con=false;
						 preparedStatement = conexion.prepareStatement("select * from director");
							preparedStatement.execute();
							ResultSet res=preparedStatement.executeQuery(); 
							while(res.next()) {
								if(res.getString(1).equals(textField.getText())) {
									con=true;}}
						if(con==false) {	
						preparedStatement = conexion.prepareStatement("Insert into DIRECTOR (cedula , Nombre_Director, Apellido_Director,"
									+ " Edad,Direccion, Sexo) values (?,?,?,?,?,?)");
						preparedStatement.setInt(1,Integer.parseInt(textField.getText()) );
						preparedStatement.setString(2, textField_1.getText());
						preparedStatement.setString(3, textField_2.getText());
						preparedStatement.setInt(4, Integer.parseInt(textField_3.getText()));
						preparedStatement.setString(5,textField_4.getText());
						preparedStatement.setString(6,String.valueOf(comboBox.getSelectedItem()));
						System.out.print(comboBox.getSelectedItem());
						preparedStatement.execute();
						preparedStatement.close();		
						modo.addRow(new Object[] {textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),
								textField_4.getText(),comboBox.getSelectedItem()});
						table.setModel(modo);
						textField.setText(null);
						textField.setEditable(true);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
						comboBox.setSelectedItem(null);
						JOptionPane.showMessageDialog(null, "Exito. Persona agregada corractamente");}
						else if (con==true){
							JOptionPane.showMessageDialog(null, "Esta cedula ya existe, modifiquela y vuelva a intentar","Error",JOptionPane.WARNING_MESSAGE);
							textField.setText(null);}
					} catch (SQLException e1) {
						e1.printStackTrace();}}
				 else {
					 textField_3.setText(null);
					 JOptionPane.showMessageDialog(null, "La edad debe estar entre 20-93 años","Error",JOptionPane.WARNING_MESSAGE);}
			 } }
		 else if(e.getSource()==btnNewButton_3){
			 conexion = conexion_DB.conectando();
			 while(table.getRowCount() > 0){
				    ((DefaultTableModel) table.getModel()).removeRow(0);}
				try {
					preparedStatement = conexion.prepareStatement("select * from director");
					preparedStatement.execute();
					ResultSet res=preparedStatement.executeQuery(); 
					while(res.next()) {
						D1.cedula=res.getInt(1);
						D1.nombre=res.getString("Nombre_Director");
						D1.apellido=res.getString("Apellido_Director");
						D1.edad=res.getInt("edad");
						D1.direccion=res.getString("Direccion");
						D1.sexo=res.getString("sexo");
						modo.addRow(new Object[] {D1.getCedula(), D1.getNombre(),D1.getApellido(),D1.getEdad(),D1.getDireccion(),D1.sexo});}
						table.setModel(modo);}
				 catch (SQLException e1) {
					e1.printStackTrace();}
		 } 
		 else if(e.getSource()==btnNewButton_2) {
			 conexion = conexion_DB.conectando();
			 if (table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Para ejecutar esta funcion,\n debe haber un campo \nde la tabla"
							+ "seleccionado","Error",JOptionPane.WARNING_MESSAGE);}
			 else {
				 try {
						System.out.println(table.getValueAt(table.getSelectedRow(), 0));
						preparedStatement = conexion.prepareStatement("DELETE director from director WHERE cedula  = "+table.getValueAt(table.getSelectedRow(), 0)+" ");
						preparedStatement.execute();
						modo.removeRow(table.getSelectedRow());
						table.setModel(modo);
						JOptionPane.showMessageDialog(null, "Exito. Persona eliminada corractamente");
					} catch (SQLException e1) {
						e1.printStackTrace();}		
					}}
		 else if(e.getSource()==btnNewButton_1) {
				conexion = conexion_DB.conectando();
				if (table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Para ejecutar esta funcion,\n debe haber un campo \nde la tabla"
							+ " seleccionado","Error",JOptionPane.WARNING_MESSAGE);}
				else {
					try {
						btnNewButton.setVisible(false);
						 btnNewButton_6.setVisible(true);
						 textField.setEditable(false);
						preparedStatement = conexion.prepareStatement("select * from DIRECTOR  WHERE CEDULA = '"+table.getValueAt(table.getSelectedRow(), 0)+"'");
						preparedStatement.execute();
						ResultSet res=preparedStatement.executeQuery(); 
						while(res.next()) {
							textField.setText(String.valueOf(D1.cedula=res.getInt(1)));
							textField_1.setText(D1.nombre=res.getString("Nombre_Director"));
							textField_2.setText(D1.apellido=res.getString("Apellido_Director"));
							textField_3.setText(String.valueOf(D1.edad=res.getInt("edad")));
							textField_4.setText(D1.direccion=res.getString("Direccion"));
							comboBox.setSelectedItem(D1.sexo=res.getString("Direccion"));
							}
					} catch (SQLException e1) {
						e1.printStackTrace();}}
			  }
		 else if(e.getSource()==btnNewButton_6) {
			 textField.setEditable(false);
			 conexion = conexion_DB.conectando();
			 if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() ||  textField_3.getText().isEmpty()
						||textField_4.getText().isEmpty()  ||comboBox.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
			 else {
					try {
						int edad;
						 boolean pasa=true;
						 edad= Integer.parseInt(textField_3.getText());
							if(edad>=20 && edad>=93) {
								pasa=false;}
							else {
								pasa=true;} 
							
							if (pasa==false) {
						
				
								preparedStatement = conexion.prepareStatement("UPDATE DIRECTOR SET NOMBRE_DIRECTOR= '"+textField_1.getText()+"' , CEDULA='"+textField.getText()+"',Apellido_Director='"+textField_2.getText()+"',"
										+ "Edad= '"+ textField_3.getText()+"',Direccion='"+textField_4.getText()+"',sexo='"+comboBox.getSelectedItem()+"'  WHERE cedula='"+table.getValueAt(table.getSelectedRow(), 0)+"' ");
								preparedStatement.execute();
								while(table.getRowCount() > 0){
								    ((DefaultTableModel) table.getModel()).removeRow(0);}
								preparedStatement = conexion.prepareStatement("select * from director");
								preparedStatement.execute();
								ResultSet res=preparedStatement.executeQuery(); 
								while(res.next()) {
									D1.cedula=res.getInt(1);
									D1.nombre=res.getString("NOMBRE_DIRECTOR");
									D1.apellido=res.getString("Apellido_Director");
									D1.edad=res.getInt("Edad");
									D1.direccion=res.getString("Direccion");
									D1.sexo=res.getString("sexo");
									modo.addRow(new Object[] {D1.getCedula(), D1.getNombre(),D1.getApellido(),D1.getEdad(),D1.getDireccion(),D1.getSexo()});}
									table.setModel(modo);
								preparedStatement.execute();
								preparedStatement.close();		
								textField.setText(null);
								textField.setEditable(true);
								textField_1.setText(null);
								textField_2.setText(null);
								textField_3.setText(null);
								textField_4.setText(null);
								textField_5.setText(null);
								comboBox.setSelectedItem(null);
								btnNewButton.setVisible(true);
								btnNewButton_6.setVisible(false);
								JOptionPane.showMessageDialog(null, "Maestro actualizado correctamente");}
						else if(pasa==true) {
							 JOptionPane.showMessageDialog(null, "La edad debe estar entre 20-93 años","Error",JOptionPane.WARNING_MESSAGE);
							 textField_3.setText(null);}
					}catch(SQLException e1) {
						e1.printStackTrace();} } }
		 
		 else if (e.getSource()==btnNewButton_5) {
				conexion = conexion_DB.conectando();
				if (textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor introduzca un id", "Error", JOptionPane.WARNING_MESSAGE);}
				else {
					while(table.getRowCount() > 0){
					    ((DefaultTableModel) table.getModel()).removeRow(0);}
					try {
						boolean con1=false;
						preparedStatement = conexion.prepareStatement("select * from director where cedula= " +textField_5.getText()+" ");
						preparedStatement.execute();
						ResultSet res=preparedStatement.executeQuery(); 
						while(res.next()) {
							if(res.getInt("cedula")==Integer.parseInt(textField_5.getText()))  {
								con1=true;
								System.out.print(res.getInt(1));
									D1.cedula=res.getInt(1);
									D1.nombre=res.getString("NOMBRE_DIRECTOR");
									D1.apellido=res.getString("Apellido_Director");
									D1.edad=res.getInt("Edad");
									D1.direccion=res.getString("Direccion");
									D1.sexo=res.getString("sexo");
									modo.addRow(new Object[] {D1.getCedula(), D1.getNombre(),D1.getApellido(),D1.getEdad(),D1.getDireccion(),D1.getSexo()});
									table.setModel(modo);
									}
								textField_5.setText(null);}
						
						if (con1==false) {
							JOptionPane.showMessageDialog(null, "Por favor introduzca un ID valido o existente", "Error", JOptionPane.WARNING_MESSAGE);
							textField_5.setText(null);}	
					} catch (SQLException e1) {
						e1.printStackTrace();}}	
			}	  
}
	public void keyTyped(KeyEvent e) {
		char character=e.getKeyChar();
		if(e.getSource()==textField) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textField_1) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textField_2) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textField_3) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textField_5) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
	}

}

	

	
	
	
	
	
	
	

