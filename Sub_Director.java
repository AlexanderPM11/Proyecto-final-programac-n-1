package clases_ProyectoFinal;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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



import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Sub_Director extends KeyAdapter implements KeyListener {

	JFrame frame;
	private JTextField textCedu;
	private JTextField textNom;
	private JTextField textApe;
	private JTextField textEd;
	private JTextField textDire;
	private JTextField textField_6;
	private JTable table;
	JComboBox comboBoxSex;
	
	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulSet = null;
	
	private void Limpiar() {
		textCedu.setText(null); 
		textNom.setText(null);
		textApe.setText(null);
		textEd.setText(null);
		textDire.setText(null);
		comboBoxSex.setSelectedItem(null);
	}
	
	public Sub_Director() { 
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(400, 100, 569, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Sub-Director");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(193, 0, 177, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(100, 33, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textCedu = new JTextField();
		textCedu.addKeyListener(this);
		textCedu.setHorizontalAlignment(SwingConstants.CENTER);
		textCedu.setBounds(100, 45, 122, 20);
		frame.getContentPane().add(textCedu);
		textCedu.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(100, 76, 68, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textNom = new JTextField();
		textNom.addKeyListener(this);
		textNom.setHorizontalAlignment(SwingConstants.CENTER);
		textNom.setBounds(100, 88, 122, 20);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(100, 119, 68, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textApe = new JTextField();
		textApe.addKeyListener(this);
		textApe.setHorizontalAlignment(SwingConstants.CENTER);
		textApe.setBounds(100, 132, 122, 20);
		frame.getContentPane().add(textApe);
		textApe.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(324, 33, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textEd = new JTextField();
		textEd.addKeyListener(this);
		textEd.setHorizontalAlignment(SwingConstants.CENTER);
		textEd.setBounds(321, 45, 122, 20);
		frame.getContentPane().add(textEd);
		textEd.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(324, 76, 68, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textDire = new JTextField();
		textDire.setHorizontalAlignment(SwingConstants.CENTER);
		textDire.setBounds(324, 88, 119, 20);
		frame.getContentPane().add(textDire);
		textDire.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(324, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = conexion_DB.conectando();
				if (textApe.getText().isEmpty() || textCedu.getText().isEmpty() || textDire.getText().isEmpty() ||  textEd.getText().isEmpty()
						||comboBoxSex.getSelectedItem()==null ||  textNom.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
				else {
					int edad;
					 boolean pasa=true;
					 edad= Integer.parseInt(textEd.getText());
						if(edad>20 && edad<=93) {
							pasa=false;}
						else {
							pasa=true;} 
						
						if (pasa==true) {
						try {
							preparedStatement = conexion
									.prepareStatement("SELECT * from subdirector  ");
							resulSet =preparedStatement.executeQuery();
							boolean con1=true;
							
							while(resulSet.next()) {
								if(resulSet.getString("cedula").equals(textCedu.getText())) {
									con1=false;}}
							if(con1==true) {
									conexion = conexion_DB.conectando();
									int Edad_1 = Integer.parseInt(textEd.getText());
									String Sexo_1 = String.valueOf(comboBoxSex.getSelectedItem()); 
									preparedStatement = conexion
											.prepareStatement("Insert into subdirector (Cedula, Nombres, Apellidos, Edad, Direccion, Sexo) values (?,?,?,?,?,?)");
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
										conexion.close();
									}}
									else if (con1==false) {
										JOptionPane.showMessageDialog(null, "Este sub-Director ya esta registrado, modifique el ID y vuelva a intentar", "Error", JOptionPane.WARNING_MESSAGE);
										textCedu.setText(null);}						
								
							}catch(SQLException e1) {
								e1.printStackTrace();}}
							else if (pasa==false) {
								JOptionPane.showMessageDialog(null, "La edad debe estar entre: 20-93 años","Error",JOptionPane.WARNING_MESSAGE);
								textEd.setText(null);	}
				}}	});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(100, 163, 343, 19);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = conexion_DB.conectando();
				int Edad_1 = Integer.parseInt(textEd.getText());
				String Sexo_1 = String.valueOf(comboBoxSex.getSelectedItem()); 
				try {
					int edad;
					 boolean pasa=true;
					 edad= Integer.parseInt(textEd.getText());
						if(edad>20 && edad<=93) {
							pasa=false;}
						else {
							pasa=true;} 
						
						if (pasa==false) {
							 textCedu.setEditable(true);
							btnActualizar.setVisible(false);
							btnAgregar.setVisible(true);
							preparedStatement = conexion
									.prepareStatement("UPDATE subdirector SET Cedula = ?, Nombres = ?, Apellidos = ?, Edad = ?, Direccion = ?, Sexo = ?  where Cedula =? ");
							preparedStatement.setString(1, textCedu.getText());
							preparedStatement.setString(2, textNom.getText());
							preparedStatement.setString(3, textApe.getText());
							preparedStatement.setInt(4, Edad_1);
							preparedStatement.setString(5, textDire.getText());
							preparedStatement.setString(6, Sexo_1);
							preparedStatement.setString(7, textField_6.getText() );					
							int resultado = preparedStatement.executeUpdate();
							if(resultado > 0) {
								JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
								Limpiar();
								conexion.close();
							}else {
								JOptionPane.showMessageDialog(null, "El registro no pudo ser modificado correctamente");
							}}
						else if (pasa==true) {
							JOptionPane.showMessageDialog(null, "La edad debe estar entre: 20-93 años", "Error", JOptionPane.WARNING_MESSAGE);
							textEd.setText(null);}			
				}catch(SQLException e1) {
					e1.printStackTrace();}
			}});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(110, 163, 327, 19);
		frame.getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel_7 = new JLabel("Gestionar por cedula");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 189, 136, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(this);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(10, 201, 122, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActualizar.setVisible(true);
				btnAgregar.setVisible(false);
				 textCedu.setEditable(false);
				conexion=conexion_DB.conectando();
				try {
					preparedStatement = conexion
							.prepareStatement("SELECT Cedula, Nombres, Apellidos, Edad, Direccion,Sexo from subdirector where Cedula = ?  ");
					preparedStatement.setString(1, textField_6.getText());
					resulSet =preparedStatement.executeQuery();
					
					if (resulSet.next()) {
						textCedu.setText(resulSet.getString("Cedula"));
						textNom.setText(resulSet.getString("Nombres"));
						textApe.setText(resulSet.getString("Apellidos"));
						textEd.setText(resulSet.getString("Edad"));
						textDire.setText(resulSet.getString("Direccion"));
						comboBoxSex.setSelectedItem(resulSet.getString("Sexo"));
					}else {
						JOptionPane.showMessageDialog(null," Introduzca una cedula valida","Error", JOptionPane.WARNING_MESSAGE);
						Limpiar();}		
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");
					e1.printStackTrace();
				}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(110, 228, 89, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion=conexion_DB.conectando();
				try {
					preparedStatement = conexion
							.prepareStatement("DELETE FROM subdirector where Cedula = ? ");
					preparedStatement.setString(1, textField_6.getText());	
					int resultado = preparedStatement.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente");
						Limpiar();
						conexion.close();
					}else {
						JOptionPane.showMessageDialog(null," Introduzca una cedula valida","Error", JOptionPane.WARNING_MESSAGE);
						Limpiar();}
					}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos");} 
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(209, 228, 89, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mostrar todo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  []info = new String[6];
				conexion=conexion_DB.conectando();
				try {
					while(table.getRowCount() > 0){ 
						((DefaultTableModel) table.getModel()).removeRow(0);}
					
					preparedStatement = conexion
							.prepareStatement("SELECT * from subdirector ");
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(308, 228, 119, 20);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  []info = new String[8];
				conexion=conexion_DB.conectando();
				try {
					while(table.getRowCount() > 0){
					    ((DefaultTableModel) table.getModel()).removeRow(0);}
					preparedStatement = conexion
							.prepareStatement("SELECT * from subdirector where Cedula = ? ");
					preparedStatement.setString(1, textField_6.getText());
					resulSet =preparedStatement.executeQuery();
					textField_6.setText(null);
					if (resulSet.next()) {
						info[0]=(resulSet.getString("Cedula"));
						info[1]=(resulSet.getString("Nombres"));
						info[2]=(resulSet.getString("Apellidos"));
						info[3]=(resulSet.getString("Edad"));
						info[4]=(resulSet.getString("Direccion"));
						info[5]=(resulSet.getString("Sexo"));
						((DefaultTableModel) table.getModel()).addRow(info);
					}else {
						JOptionPane.showMessageDialog(null," Introduzca una cedula valida","Error", JOptionPane.WARNING_MESSAGE);

					}
					
					
				}catch (SQLException e1 ) {
					JOptionPane.showMessageDialog(null," ha ocurrido un error al conectar la base de datos","Error", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(10, 228, 89, 20);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				 frame.setVisible(false);
				 JF_Principal p1=new JF_Principal();}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(437, 228,106, 19);
		frame.getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 533, 150);
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombres", "Apellidos", "Edad", "Direccion", "Sexo"
			}
		));
		scrollPane.setViewportView(table);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBoxSex.setSelectedItem(null);
		comboBoxSex.setBounds(324, 131, 119, 22);
		frame.getContentPane().add(comboBoxSex);
	}


	public void keyTyped(KeyEvent e) {
		char character=e.getKeyChar(); 
		if(e.getSource()==textCedu) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		if(e.getSource()==textApe) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		if(e.getSource()==textNom) {
			if(Character.isDigit(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		if(e.getSource()==textEd) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
		if(e.getSource()==textField_6) {
			if(Character.isLetter(character)) {
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Eroor",JOptionPane.WARNING_MESSAGE);
				}}
	}

}
