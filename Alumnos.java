package clases_ProyectoFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
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

public class Alumnos  extends KeyAdapter implements KeyListener{
	DefaultTableModel modelo = new DefaultTableModel();
	JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldNom;
	private JTextField textFieldApe;
	private JTextField textFieldTel;
	private JTextField textFieldEda;
	private JTextField textField_5;
	private JTable table;
	JComboBox comboBoxCur, comboBoxSec, comboBoxSex; 
	JButton btnNewButton_6, btnNewButton;

	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulSet = null;
	
	private void Limpiar() {
		textFieldID.setText(null); 
		textFieldNom.setText(null);
		textFieldApe.setText(null);
		textFieldTel.setText(null);
		textFieldEda.setText(null);
		comboBoxCur.setSelectedItem(null);
		comboBoxSec.setSelectedItem(null);
		comboBoxSex.setSelectedItem(null);
	}
	
	

	public Alumnos() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(400, 80, 583, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registros Estudiantes");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(207, 0, 163, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_alumno = new JLabel("ID Alumno");
		lbl_alumno.setForeground(Color.ORANGE);
		lbl_alumno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_alumno.setBounds(10, 36, 67, 14);
		frame.getContentPane().add(lbl_alumno);
		
		textFieldID = new JTextField();
		textFieldID.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldID.setBounds(10, 49, 107, 20);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lbl_Nombres = new JLabel("Nombres");
		lbl_Nombres.setForeground(Color.ORANGE);
		lbl_Nombres.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Nombres.setBounds(10, 80, 67, 14);
		frame.getContentPane().add(lbl_Nombres);
		
		textFieldNom = new JTextField();
		textFieldNom.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNom.addKeyListener(this);
		textFieldNom.setBounds(10, 93, 107, 20);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lbl_Apellido = new JLabel("Apellido");
		lbl_Apellido.setForeground(Color.ORANGE);
		lbl_Apellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Apellido.setBounds(10, 124, 67, 14);
		frame.getContentPane().add(lbl_Apellido);
		
		textFieldApe = new JTextField();
		textFieldApe.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldApe.addKeyListener(this);
		textFieldApe.setBounds(10, 138, 107, 20);
		frame.getContentPane().add(textFieldApe);
		textFieldApe.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(222, 36, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldTel = new JTextField();
		textFieldTel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTel.addKeyListener(this);
		textFieldTel.setBounds(222, 49, 107, 20);
		frame.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(222, 80, 67, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldEda = new JTextField();
		textFieldEda.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEda.addKeyListener(this);
		textFieldEda.setBounds(222, 93, 108, 20);
		frame.getContentPane().add(textFieldEda);
		textFieldEda.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo   ");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(222, 124, 67, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Curso");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(415, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		comboBoxCur = new JComboBox();
		comboBoxCur.setModel(new DefaultComboBoxModel(new String[] { "3ro de secundaria", "4to de secundaria", "5to de  secundaria", "6to de secundaria"}));
		comboBoxCur.setSelectedItem(null);
		comboBoxCur.setBackground(Color.WHITE);
		comboBoxCur.setBounds(415, 48, 109, 21);
		frame.getContentPane().add(comboBoxCur);
		
		JLabel lblNewLabel_5 = new JLabel("Seccion");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(415, 80, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		comboBoxSec = new JComboBox();
		comboBoxSec.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D"}));
		comboBoxSec.setSelectedItem(null);
		comboBoxSec.setBounds(415, 92, 109, 21);
		frame.getContentPane().add(comboBoxSec);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] { "Femenino", "Masculino"}));
		comboBoxSex.setSelectedItem(null);
		comboBoxSex.setBounds(222, 137, 108, 21);
		frame.getContentPane().add(comboBoxSex);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldID.getText().isEmpty() || textFieldEda.getText().isEmpty() || textFieldApe.getText().isEmpty() ||  textFieldEda.getText().isEmpty()
						||comboBoxSec.getSelectedItem()==null ||comboBoxSex.getSelectedItem()==null||comboBoxCur.getSelectedItem()==null|| 
						 textFieldNom.getText().isEmpty()||  textFieldTel.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
			
				else {
					 int edad;
					 boolean pasa=true;
					 edad= Integer.parseInt(textFieldEda.getText());
						if(edad>23 || edad<10) {
							pasa=false;}
						else {
							pasa=true;} 
						if(pasa==true) {
							try {
								conexion = conexion_DB.conectando();
								int Edad_1 = Integer.parseInt(textFieldEda.getText());
								String Sexo_1 = String.valueOf(comboBoxSex.getSelectedItem()); 
								String Seccion = String.valueOf(comboBoxSec.getSelectedItem());
								String Curso = String.valueOf(comboBoxCur.getSelectedItem());
								preparedStatement = conexion
										.prepareStatement("SELECT * from Alumnos  ");
								resulSet =preparedStatement.executeQuery();
								boolean con1=true;
								
								while(resulSet.next()) {
									if(resulSet.getString("ID_Alumnos").equals(textFieldID.getText())) {
										con1=false;}}
								System.out.print(con1);
								if (con1==true) {	
									preparedStatement = conexion
											.prepareStatement("Insert into alumnos (ID_Alumnos, Nombres, Apellidos, Telefono, Edad, Sexo, Curso, Seccion) values (?,?,?,?,?,?,?,?)");
									preparedStatement.setString(1, textFieldID.getText());
									preparedStatement.setString(2, textFieldNom.getText());
									preparedStatement.setString(3, textFieldApe.getText());
									preparedStatement.setString(4, textFieldTel.getText());
									preparedStatement.setInt(5, Edad_1);
									preparedStatement.setString(6, Sexo_1);
									preparedStatement.setString(7, Curso);
									preparedStatement.setString(8, Seccion);
									int resultado = preparedStatement.executeUpdate();
									if(resultado > 0) {
										JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
										Limpiar();
										conexion.close();}	
									}
									
								else if (con1==false){
									JOptionPane.showMessageDialog(null, "Este alumno ya esta registrado, modifique el ID y vuelva a intentar", "Error", JOptionPane.WARNING_MESSAGE);
									textFieldID.setText(null);}					
			
							}catch(SQLException e1) {
								e1.printStackTrace();}
							}
						else if (pasa==false){
							JOptionPane.showMessageDialog(null, "La edad debe estar entre: 10-23 años","Error",JOptionPane.WARNING_MESSAGE);
							textFieldEda.setText(null);}
					}
				
				
				}});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(98, 161, 324, 19);
		btnNewButton.setVisible(true);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Gestionar por ID");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 188, 107, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(10, 201, 107, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  []info = new String[8];
				conexion=conexion_DB.conectando();
				try {
					while(table.getRowCount() > 0){
					    ((DefaultTableModel) table.getModel()).removeRow(0);}
					preparedStatement = conexion
							.prepareStatement("SELECT * from Alumnos where ID_Alumnos = ? ");
					preparedStatement.setString(1, textField_5.getText());
					resulSet =preparedStatement.executeQuery();
					textField_5.setText(null);
					if (resulSet.next()) {
						info[0]=(resulSet.getString("ID_Alumnos"));
						info[1]=(resulSet.getString("Nombres"));
						info[2]=(resulSet.getString("Apellidos"));
						info[3]=(resulSet.getString("Telefono"));
						info[4]=(resulSet.getString("Edad"));
						info[5]=(resulSet.getString("Sexo"));
						info[6]=(resulSet.getString("Curso"));
						info[7]=(resulSet.getString("Seccion"));
						((DefaultTableModel) table.getModel()).addRow(info);
						
						
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo encotrar el registro con dicha matricula");
						textField_5.setText(null);
					}
					
					
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 232, 89, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setEditable(false);
				btnNewButton_6.setVisible(true);
				
				btnNewButton.setVisible(false);
				conexion=conexion_DB.conectando();
				try {
					preparedStatement = conexion
							.prepareStatement("SELECT ID_Alumnos, Nombres, Apellidos, Telefono, Edad, Sexo, Curso, Seccion from alumnos where ID_Alumnos = ?  ");
					preparedStatement.setString(1, textField_5.getText());
					System.out.print(textField_5.getText());
					
					resulSet =preparedStatement.executeQuery();
					
					if (resulSet.next()) {
						textFieldID.setText(resulSet.getString("ID_Alumnos"));
						textFieldNom.setText(resulSet.getString("Nombres"));
						textFieldApe.setText(resulSet.getString("Apellidos"));
						textFieldTel.setText(resulSet.getString("Telefono"));
						textFieldEda.setText(resulSet.getString("Edad"));
						comboBoxSex.setSelectedItem(resulSet.getString("Sexo"));
						comboBoxCur.setSelectedItem(resulSet.getString("Curso"));
						comboBoxSec.setSelectedItem(resulSet.getString("Seccion"));
					}else {
						System.out.print(textField_5.getText());
						JOptionPane.showMessageDialog(null, "No se pudo encotrar el registro con dicha matricula");
					}
					
					
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}
				textField_5.setText(null);
				
			}
		});
		btnNewButton_2.setBounds(109, 232, 89, 20);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion=conexion_DB.conectando();
				try {
					
					preparedStatement = conexion
							.prepareStatement("DELETE FROM Alumnos where ID_Alumnos = ? ");
					preparedStatement.setString(1, textField_5.getText());
					

					
					int resultado = preparedStatement.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente");
						Limpiar();
						conexion.close();
					}else {
						JOptionPane.showMessageDialog(null, "Introduzca un ID valido para poder eleminar correctamente");
					}
					
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
				} 

			}
		});
		btnNewButton_3.setBounds(208, 232, 89, 20);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mostrar todo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  []info = new String[8];
				conexion=conexion_DB.conectando();
				try {
					while(table.getRowCount() > 0){
					    ((DefaultTableModel) table.getModel()).removeRow(0);}
					preparedStatement = conexion
							.prepareStatement("SELECT * from Alumnos ");
					resulSet =preparedStatement.executeQuery();
					
					while (resulSet.next()) {
						info[0]=(resulSet.getString("ID_Alumnos"));
						info[1]=(resulSet.getString("Nombres"));
						info[2]=(resulSet.getString("Apellidos"));
						info[3]=(resulSet.getString("Telefono"));
						info[4]=(resulSet.getString("Edad"));
						info[5]=(resulSet.getString("Sexo"));
						info[6]=(resulSet.getString("Curso"));
						info[7]=(resulSet.getString("Seccion"));
						((DefaultTableModel) table.getModel()).addRow(info);}

				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(307, 232, 113, 20);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Volver");
		btnNewButton_5.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		frame.dispose();
					 frame.setVisible(false);
					 JF_Principal p1=new JF_Principal();
		    	}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(430, 232, 122, 20);
		frame.getContentPane().add(btnNewButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 546, 127);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Telefono", "Edad", "Sexo", "Curso", "Seccion"
			}
		));
		scrollPane.setViewportView(table);
		
	    btnNewButton_6 = new JButton("Actualizar");
	    btnNewButton_6.setVisible(false);
	   
	    btnNewButton_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 textFieldID.setEditable(true);
	    		conexion = conexion_DB.conectando();
				int Edad_1 = Integer.parseInt(textFieldEda.getText());
				String Sexo_1 = String.valueOf(comboBoxSex.getSelectedItem()); 
				String Seccion = String.valueOf(comboBoxSec.getSelectedItem());
				String Curso = String.valueOf(comboBoxCur.getSelectedItem());
				
				try {
					int edad;
					 boolean pasa=true;
					 edad= Integer.parseInt(textFieldEda.getText());
						if(edad>23 || edad<10) {
							pasa=false;}
						else {
							pasa=true;} 
						
						if (pasa==true) {
							btnNewButton_6.setVisible(false);
							btnNewButton.setVisible(true);
					preparedStatement = conexion
							.prepareStatement("UPDATE Alumnos SET  Nombres = ?, Apellidos = ?, Telefono = ?, Edad = ?, Sexo = ?, Curso = ?, Seccion = ? where ID_Alumnos =? ");
					preparedStatement.setString(1, textFieldNom.getText());
					preparedStatement.setString(2, textFieldApe.getText());
					preparedStatement.setString(3, textFieldTel.getText());
					preparedStatement.setInt(4, Edad_1);
					preparedStatement.setString(5, Sexo_1);
					preparedStatement.setString(6, Curso);
					preparedStatement.setString(7, Seccion);
					preparedStatement.setString(8,textFieldID.getText());
					preparedStatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
					Limpiar();
					conexion.close();	}
				else if(pasa==false) {
					JOptionPane.showMessageDialog(null, "La edad debe estar entre: 10-23","Error",JOptionPane.WARNING_MESSAGE);
					textFieldEda.setText(null);
				}
				
				}catch(SQLException e1) {
					e1.printStackTrace();}	
		
	    		
	    	}
	    });
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_6.setBounds(98, 163, 324, 19);
		frame.getContentPane().add(btnNewButton_6);}
	

	public void keyTyped(KeyEvent e) {
		char character=e.getKeyChar(); 
		if(e.getSource()==textFieldApe) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textFieldNom) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==textFieldEda) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		else if (e.getSource()==textFieldTel) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente numeros por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}}
	
	}
	

