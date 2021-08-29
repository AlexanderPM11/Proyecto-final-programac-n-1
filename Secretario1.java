package clases_ProyectoFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class Secretario1 extends KeyAdapter implements KeyListener {

	JFrame frame;
	private JTextField textCedu;
	private JTextField textNom;
	private JTextField textApe;
	private JTextField textEda;
	private JTextField textDire;
	private JTextField textField_5;
	private JTable table;
	JComboBox comboBoxSex;

	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulSet = null;
	
	private void Limpiar() {
		textCedu.setText(null); 
		textNom.setText(null);
		textApe.setText(null);
		textEda.setText(null);
		textDire.setText(null);
		comboBoxSex.setSelectedItem(null);}

	public Secretario1() {
	
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(400, 100, 547, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Secretaria");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(209, 0, 160, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(99, 40, 60, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textCedu = new JTextField();
		textCedu.addKeyListener(this);
		textCedu.setHorizontalAlignment(SwingConstants.CENTER);
		textCedu.setBounds(99, 52, 115, 20);
		frame.getContentPane().add(textCedu);
		textCedu.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(99, 83, 60, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textNom = new JTextField();
		textNom.addKeyListener(this);
		textNom.setHorizontalAlignment(SwingConstants.CENTER);
		textNom.setBounds(99, 96, 115, 20);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(99, 127, 60, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textApe = new JTextField();
		textApe.addKeyListener(this);
		textApe.setHorizontalAlignment(SwingConstants.CENTER);
		textApe.setBounds(99, 141, 115, 20);
		frame.getContentPane().add(textApe);
		textApe.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(347, 40, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textEda = new JTextField();
		textEda.addKeyListener(this);
		textEda.setHorizontalAlignment(SwingConstants.CENTER);
		textEda.setBounds(347, 52, 115, 20);
		frame.getContentPane().add(textEda);
		textEda.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(347, 83, 60, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textDire = new JTextField();
		textDire.setHorizontalAlignment(SwingConstants.CENTER);
		textDire.setBounds(347, 96, 115, 20);
		frame.getContentPane().add(textDire);
		textDire.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(347, 127, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino"}));
		comboBoxSex.setSelectedItem(null);
		comboBoxSex.setBounds(347, 140, 115, 22);
		frame.getContentPane().add(comboBoxSex);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = conexion_DB.conectando();
				if (textCedu.getText().isEmpty() || textNom.getText().isEmpty() || textApe.getText().isEmpty() ||  textDire.getText().isEmpty()
						||comboBoxSex.getSelectedItem()==null || textEda.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
				else {
					int edad;
					 boolean pasa=true;
					 edad= Integer.parseInt(textEda.getText());
						if(edad>=19 && edad<=80) {
							pasa=false;}
						else {
							pasa=true;} 
						if(pasa==false) {
					
							try {
								textCedu.setEditable(true);
								int Edad_1 = Integer.parseInt(textEda.getText());
								String Sexo_1 = String.valueOf(comboBoxSex.getSelectedItem()); 
								preparedStatement = conexion
										.prepareStatement("Insert into secretaria (Cedula, Nombres, Apellidos, Edad, Direccion, Sexo) values (?,?,?,?,?,?)");
								preparedStatement.setString(1, textCedu.getText());
								preparedStatement.setString(2, textNom.getText());
								preparedStatement.setString(3, textApe.getText());
								preparedStatement.setInt(4, Edad_1);
								preparedStatement.setString(5, textDire.getText());
								preparedStatement.setString(6, Sexo_1);
								
								
								int resultado = preparedStatement.executeUpdate();
								if(resultado > 0) {
									JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
									Limpiar();
									conexion.close();}
					}catch(SQLException e1) {
						e1.printStackTrace();}}
					else if (pasa==true){
							JOptionPane.showMessageDialog(null, "La edad debe estar entre: 19-80 años","Error",JOptionPane.WARNING_MESSAGE);
							textEda.setText(null);}
						}}});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(99, 167, 363, 20);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setVisible(false);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = conexion_DB.conectando();
				
				try {
					int edad;
					 boolean pasa=true;
					 edad= Integer.parseInt(textEda.getText());
						if(edad>=19 && edad<=80) {
							pasa=false;}
						else {
							pasa=true;} 
						
						if(pasa==false) {
							int Edad_1 = Integer.parseInt(textEda.getText());
							String Sexo_1 = String.valueOf(comboBoxSex.getSelectedItem()); 
							btnActualizar.setVisible(false);
							btnAgregar.setVisible(true);
							preparedStatement = conexion
									.prepareStatement("UPDATE secretaria SET Nombres = ?, Apellidos = ?, Edad = ?, Direccion = ?, Sexo = ?  where Cedula =? ");
							
							preparedStatement.setString(1, textNom.getText());
							preparedStatement.setString(2, textApe.getText());
							preparedStatement.setInt(3, Edad_1);
							preparedStatement.setString(4, textDire.getText());
							preparedStatement.setString(5, Sexo_1);
							preparedStatement.setString(6, textCedu.getText());	
												
							int resultado = preparedStatement.executeUpdate();
							if(resultado > 0) {
								JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
								Limpiar();
								conexion.close();
								textCedu.setEditable(true);
							}else {
								JOptionPane.showMessageDialog(null, "El registro no pudo ser modificado correctamente");}
							
							}
									
						else if (pasa==true){
								JOptionPane.showMessageDialog(null, "La edad debe estar entre: 19-80 años","Error",JOptionPane.WARNING_MESSAGE);
								textEda.setText(null);}
						}catch(SQLException e1) {
							e1.printStackTrace();}	
			}
		});
		btnActualizar.setBounds(99, 166, 363, 20);
		frame.getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel_7 = new JLabel("Gestionar por cedula");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 197, 131, 11);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(this);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(10, 209, 131, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  []info = new String[8];
				conexion=conexion_DB.conectando();
				try {
					while(table.getRowCount() > 0){
					    ((DefaultTableModel) table.getModel()).removeRow(0);}
					preparedStatement = conexion
							.prepareStatement("SELECT * from secretaria where Cedula = ? ");
					preparedStatement.setString(1, textField_5.getText());
					
					resulSet =preparedStatement.executeQuery();
					textField_5.setText(null);
					
					if (resulSet.next()) {
						info[0]=(resulSet.getString("Cedula"));
						info[1]=(resulSet.getString("Nombres"));
						info[2]=(resulSet.getString("Apellidos"));
						info[3]=(resulSet.getString("Edad"));
						info[4]=(resulSet.getString("Direccion"));
						info[5]=(resulSet.getString("Sexo"));
						((DefaultTableModel) table.getModel()).addRow(info);
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Introduzca una cedula valida","Error",JOptionPane.WARNING_MESSAGE);
						textField_5.setText(null);
					}
					
					
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 234, 89, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion=conexion_DB.conectando();
				try {
					preparedStatement = conexion
							.prepareStatement("SELECT Cedula, Nombres, Apellidos, Edad, Direccion,Sexo from secretaria where Cedula = ?  ");
					preparedStatement.setString(1, textField_5.getText());
					
					resulSet =preparedStatement.executeQuery();
					textField_5.setText(null);
					
					if (resulSet.next()) {
						textCedu.setText(resulSet.getString("Cedula"));
						textNom.setText(resulSet.getString("Nombres"));
						textApe.setText(resulSet.getString("Apellidos"));
						textEda.setText(resulSet.getString("Edad"));
						textDire.setText(resulSet.getString("Direccion"));
						comboBoxSex.setSelectedItem(resulSet.getString("Sexo"));
						btnActualizar.setVisible(true);
						btnAgregar.setVisible(false);
						textCedu.setEditable(false);
						
					}else {
						JOptionPane.showMessageDialog(null, "Introduzca una cedula valida","Error",JOptionPane.WARNING_MESSAGE);
						textField_5.setText(null);
					}
					
					
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(109, 234, 89, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion=conexion_DB.conectando();
				try {
					
					preparedStatement = conexion
							.prepareStatement("DELETE FROM secretaria where Cedula = ? ");
					preparedStatement.setString(1, textField_5.getText());
					textField_5.setText(null);

					
					int resultado = preparedStatement.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente");
						Limpiar();
						conexion.close();
					}else {
						JOptionPane.showMessageDialog(null, "Introduzca una cedula valida","Error",JOptionPane.WARNING_MESSAGE);
						textField_5.setText(null);
					}
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
				} 
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(209, 234, 89, 20);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mostrar todo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  []info = new String[6];
				conexion=conexion_DB.conectando();
				try {
					Limpiar();
					while(table.getRowCount() > 0){ 
						((DefaultTableModel) table.getModel()).removeRow(0);}
					
					preparedStatement = conexion
							.prepareStatement("SELECT * from secretaria ");
					resulSet =preparedStatement.executeQuery();
					
					
					while(resulSet.next()) {
						info[0]=(resulSet.getString("Cedula"));
						info[1]=(resulSet.getString("Nombres"));
						info[2]=(resulSet.getString("Apellidos"));
						info[3]=(resulSet.getString("Edad"));
						info[4]=(resulSet.getString("Direccion"));
						info[5]=(resulSet.getString("Sexo"));
						((DefaultTableModel) table.getModel()).addRow(info);
						
						
					}
					
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(308, 234, 115, 20);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				 frame.setVisible(false);
				 JF_Principal p1=new JF_Principal();}});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(433, 234, 89, 20);
		frame.getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 511, 150);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombres", "Apellidos", "Edad", "Direccion", "Sexo"}));
		scrollPane.setViewportView(table);}

	
	public void keyTyped(KeyEvent e) {
		char character=e.getKeyChar(); 
		if(e.getSource()==textCedu) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textApe) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textNom) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textField_5) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textEda) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
	}}
