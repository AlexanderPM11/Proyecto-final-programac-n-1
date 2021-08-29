package clases_ProyectoFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.ScrollPane;

public class Profesor extends JFrame implements ActionListener,  KeyListener{
	Maestro m1=new Maestro();
	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resulSet = null ;
	private JTextField tnombre = new JTextField();;
	private JTextField tapellido = new JTextField();;
	private JTextField tedad = new JTextField();;
	private JTextField ttelefono = new JTextField();;
	private JComboBox ctanda = new JComboBox();;
	DefaultTableModel modelo = new DefaultTableModel();;
	private JComboBox csexo = new JComboBox();;
	private JTextField 	tid = new JTextField();;
	private JTextField 	tgestporid = new JTextField();;
	private JTable 	table_1 = new JTable();;
	JLabel tanda = new JLabel("Tanda");
	JLabel Regmaes = new JLabel("Regitro de maestros");
	JLabel apellido = new JLabel("Apellido");
	JLabel nombre = new JLabel("Nombre\r\n");
	JLabel edad = new JLabel("Edad");
	JLabel telefono = new JLabel("Telefono");
	JLabel materia = new JLabel("Materia");
	JLabel grado = new JLabel("Grado a impartir");
	JComboBox cmateria = new JComboBox();
	JComboBox cgradoimp = new JComboBox();
	JButton btnagregar = new JButton("Agregar");
	JLabel sexo = new JLabel("Sexo");
	JButton btnVerTabla = new JButton("Volver");
	JLabel lblid = new JLabel("ID maestro");
	JButton btnagregar_1 = new JButton("Buscar");
	JButton btnagregar_2 = new JButton("Eliminar");
	JButton btnagregar_3 = new JButton("Modificar");
	JButton btnagregar_4 = new JButton("Actualizar");
	JButton btnagregar_2_1 = new JButton("Mostrar todo\r\n");
	JLabel lblGrstionarPorId = new JLabel("Gestionar por ID\r\n");
	DefaultTableModel modo=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Nombre", "Apellido", "Telefono", "Edad", "Sexo", "Tanda", "Grado", "Materia"
			});;
	
	public Profesor() {
		setLayout(null);
		setResizable(false);
		setTitle("Regitro de maestros");
		getContentPane().setBackground(Color.BLACK);
		setBounds(380, 70, 748, 620);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Regmaes.setBounds(263, 11, 246, 40);
		Regmaes.setForeground(new Color(255, 165, 0));
		Regmaes.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(Regmaes);

		nombre.setBounds(38, 127, 58, 30);
		nombre.setForeground(new Color(255, 165, 0));
		nombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(nombre);

		apellido.setBounds(38, 184, 64, 30);
		apellido.setForeground(new Color(255, 165, 0));
		apellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(apellido);
		
		edad.setBounds(293, 127, 58, 30);
		edad.setForeground(new Color(255, 165, 0));
		edad.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(edad);

		telefono.setBounds(293, 70, 64, 30);
		telefono.setForeground(new Color(255, 165, 0));
		telefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(telefono);
	
		materia.setBounds(549, 184, 58, 30);
		materia.setForeground(new Color(255, 165, 0));
		materia.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(materia);
		
		grado.setBounds(549, 127, 124, 30);
		grado.setForeground(new Color(255, 165, 0));
		grado.setFont(new Font("Tahoma", Font.BOLD, 14));
	    add(grado);
		
		tnombre.setBounds(38, 153, 146, 20);
		tnombre.setHorizontalAlignment(SwingConstants.CENTER);
		tnombre.addKeyListener(this);
		tnombre.setBorder(new LineBorder(Color.WHITE, 2));
		add(tnombre);
		tnombre.setColumns(10);
		
		tapellido.setBounds(38, 210, 146, 20);
		tapellido.setHorizontalAlignment(SwingConstants.CENTER);
		tapellido.addKeyListener(this);
		tapellido.setBorder(new LineBorder(Color.WHITE, 2));
		tapellido.setColumns(10);
		add(tapellido);

		tedad.setBounds(293, 153, 146, 20);
		tedad.setHorizontalAlignment(SwingConstants.CENTER);
		tedad.addKeyListener(this);
		tedad.setBorder(new LineBorder(Color.WHITE, 2));
		tedad.setColumns(10);
		add(tedad);

		ttelefono.setBounds(293, 96, 146, 20);
		ttelefono.setHorizontalAlignment(SwingConstants.CENTER);
		ttelefono.addKeyListener(this);
		ttelefono.setBorder(new LineBorder(Color.WHITE, 2));
		ttelefono.setColumns(10);
		add(ttelefono);
		
		cmateria.setBounds(549, 210, 146, 20);
		cmateria.setBorder(new LineBorder(Color.WHITE, 2));
		cmateria.setModel(new DefaultComboBoxModel(new String[] {"Lengua Espa\u00F1ola", "Matematicas", "Ciencias Sociales", "Ciencias Naturales", "Ingles y Frances", "Formacion y Artistica", "Educacion Fisica"}));
		cmateria.setBackground(Color.WHITE);
		cmateria.setSelectedItem(null);
		add(cmateria);
		
		cgradoimp.setBounds(549, 153, 146, 20);
		cgradoimp.setBorder(new LineBorder(Color.WHITE, 2));
		cgradoimp.setBackground(Color.WHITE);
		cgradoimp.setModel(new DefaultComboBoxModel(new String[] {"3ro de secundaria", "4to de secundaria", "5to de secundaria", "6to de secundaria"}));
		cgradoimp.setSelectedItem(null);
	    add(cgradoimp);

		tanda.setBounds(549, 70, 58, 30);
		tanda.setForeground(new Color(255, 165, 0));
		tanda.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(tanda);

		ctanda.setBounds(549, 96, 146, 20);
		ctanda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		ctanda.setBackground(Color.WHITE);
		ctanda.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino ", "Matutino/Vespertino", "Jornada extendida"}));
		ctanda.setSelectedItem(null);
		add(ctanda);

		btnagregar.setBounds(198, 243, 343, 23);
		btnagregar.addActionListener(this);
		btnagregar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnagregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnagregar);

		sexo.setBounds(293, 184, 45, 30);
		sexo.setForeground(new Color(255, 165, 0));
		sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(sexo);

		btnVerTabla.setBounds(400, 530, 250, 23);
		btnVerTabla.addActionListener(this);
		btnVerTabla.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnVerTabla);
		
		csexo.setBounds(293, 212, 146, 20);
		csexo.setBorder(new LineBorder(Color.WHITE, 2));
		csexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		csexo.setBackground(Color.WHITE);
		csexo.setSelectedItem(null);
		add(csexo);
		
		lblid.setBounds(38, 70, 86, 30);
		lblid.setForeground(new Color(255, 165, 0));
		lblid.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblid);

		tid.setBounds(37, 96, 146, 20);
		tid.setHorizontalAlignment(SwingConstants.CENTER);
		tid.setBorder(new LineBorder(Color.WHITE, 2));
		tid.setColumns(10);
		add(tid);

		btnagregar_1.setBounds(200, 287, 89, 23);
		btnagregar_1.addActionListener(this);
		btnagregar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnagregar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnagregar_1);

		btnagregar_2.setBounds(100,530, 250, 23);
		btnagregar_2.addActionListener(this);
		btnagregar_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnagregar_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnagregar_2);

		btnagregar_3.setBounds(100, 320, 250, 23);
		btnagregar_3.addActionListener(this);
		btnagregar_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnagregar_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnagregar_3);
		
		btnagregar_4.setVisible(false);
		btnagregar_4.addActionListener(this);
		btnagregar_4.setBounds(198, 243, 343, 23);
		btnagregar_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnagregar_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnagregar_4);
		

		btnagregar_2_1.setBounds(401, 320, 250, 23);
		btnagregar_2_1.addActionListener(this);
		btnagregar_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnagregar_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnagregar_2_1);
		
		lblGrstionarPorId.setForeground(new Color(255, 165, 0));
		lblGrstionarPorId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrstionarPorId.setBounds(38, 265, 115, 30);
		add(lblGrstionarPorId);

		tgestporid.setColumns(10);
		tgestporid.setHorizontalAlignment(SwingConstants.CENTER);
		tgestporid.setBorder(new LineBorder(Color.WHITE, 2));
		tgestporid.setBounds(38, 289, 146, 20);
		add(tgestporid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 354, 657, 171);
		add(scrollPane);
		scrollPane.setViewportView(table_1);}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVerTabla) {
			dispose();
			setVisible(false);
			JF_Principal p1=new JF_Principal();}
		
		else if (e.getSource()==btnagregar_1) {
			conexion = conexion_DB.conectando();
			if (tgestporid.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor introduzca un id", "Error", JOptionPane.WARNING_MESSAGE);}
			else {
				while(table_1.getRowCount() > 0){
				    ((DefaultTableModel) table_1.getModel()).removeRow(0);}
				try {
					boolean con1=false;
					preparedStatement = conexion.prepareStatement("select * from MAESTRO_1 WHERE id_maestro= '"+tgestporid.getText()+"'");
					preparedStatement.execute();
					ResultSet res=preparedStatement.executeQuery(); 
					while(res.next()) {
						if(res.getString(1).equals(tgestporid.getText()) ) {
							con1=true;
							m1.id_Maestro=res.getString(1);
							m1.nombre=res.getString("nombre_maestro");
							m1.apellido=res.getString("apellido_Maestro");
							m1.numero_tele=res.getString("Telefono_Maestro");
							m1.edad=res.getInt("edad");
							m1.sexo=res.getString("sexo");
							m1.tanda=res.getString("Tanda");
							m1.grando=res.getString("grado_a_impartir");
							m1.Materia=res.getString("materia");
							modo.addRow(new Object[] {m1.getId_maestro(), m1.getNombre(),m1.getApellido(),m1.getNumero_tele(),m1.getEdad(),m1.getSexo()
									,m1.getTanda(),m1.getGrado(),m1.getMateria()});}
							table_1.setModel(modo);
							tgestporid.setText(null);}
					if (con1==false) {
						JOptionPane.showMessageDialog(null, "Por favor introduzca un ID valido o existente", "Error", JOptionPane.WARNING_MESSAGE);
						tgestporid.setText(null);}		
				} catch (SQLException e1) {
					e1.printStackTrace();}
			}}
		else if (e.getSource()==btnagregar) {
			conexion = conexion_DB.conectando();
			if (tedad.getText().isEmpty() || tid.getText().isEmpty() || tnombre.getText().isEmpty() ||  tapellido.getText().isEmpty()
					||ttelefono.getText().isEmpty() || ttelefono.getText().isEmpty() || csexo.getSelectedItem()==null
					|| ctanda.getSelectedItem()==null|| cgradoimp.getSelectedItem()==null|| cmateria.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
			else {
				 boolean pasa=false;
				 m1.edad= Integer.parseInt(tedad.getText());
					if(m1.edad<=93 && m1.edad>=20) {
						pasa=false;}
					else {
						pasa=true;}
				
				if(pasa==false) {
					try {
						boolean con=false;
						preparedStatement = conexion.prepareStatement("select * from MAESTRO_1");
						preparedStatement.execute();
						ResultSet res=preparedStatement.executeQuery(); 
						while(res.next()) {
							if(res.getString(1).equals(tid.getText())) {
								con=true;}	}
						if(con==false) {
						preparedStatement = conexion.prepareStatement("Insert into MAESTRO_1 (ID_maestro, nombre_maestro, apellido_maestro,"
								+ " Telefono_Maestro,edad, Sexo,Tanda,grado_a_impartir,materia) values (?,?,?,?,?,?,?,?,?)");
						preparedStatement.setString(1, tid.getText());
						preparedStatement.setString(2, tnombre.getText());
						preparedStatement.setString(3, tapellido.getText());
						preparedStatement.setString(4, ttelefono.getText());
						preparedStatement.setInt(5,Integer.valueOf(tedad.getText()));
						preparedStatement.setString(6,String.valueOf(csexo.getSelectedItem()));
						preparedStatement.setString(7,String.valueOf(ctanda.getSelectedItem()));
						preparedStatement.setString(8,String.valueOf(cgradoimp.getSelectedItem()));
						preparedStatement.setString(9,String.valueOf(cmateria.getSelectedItem()));
						preparedStatement.execute();
						preparedStatement.close();		
						modo.addRow(new Object[] {tid.getText(),tnombre.getText(),tapellido.getText(),ttelefono.getText(),tedad.getText(),csexo.getSelectedItem(),ctanda.getSelectedItem()
								,cgradoimp.getSelectedItem(),cmateria.getSelectedItem()});
						table_1.setModel(modo);
						JOptionPane.showMessageDialog(null, "Exito. Persona agregada corractamente");
						tedad.setText(null);
						tid.setText(null);
						tnombre.setText(null);
						tapellido.setText(null);
						ttelefono.setText(null);
						csexo.setSelectedItem(null);
						ctanda.setSelectedItem(null);
						cgradoimp.setSelectedItem(null);
						cmateria.setSelectedItem(null);
						btnagregar.setVisible(true);
						System.err.println("Exitooo");}
						
						else if(con==false) {
							JOptionPane.showMessageDialog(null, "Este ID ya existe, modifiquelo y vuelva a intentar","Error",JOptionPane.WARNING_MESSAGE);
							tid.setText(null);}
						else {
							JOptionPane.showMessageDialog(null, "Asegurese no poner un ID existente","Error",JOptionPane.WARNING_MESSAGE);
							tid.setText(null);
						}
						
					}catch(SQLException e1) {
						e1.printStackTrace();}}
				 else {
					 tedad.setText(null);
					 JOptionPane.showMessageDialog(null, "La edad debe estar entre 20-93 años","Error",JOptionPane.WARNING_MESSAGE);}
				}}
		else if (e.getSource()==btnagregar_2_1) {
			table_1.removeAll();
			conexion = conexion_DB.conectando();
			try {
				while(table_1.getRowCount() > 0){
				    ((DefaultTableModel) table_1.getModel()).removeRow(0);}
				preparedStatement = conexion.prepareStatement("select * from MAESTRO_1");
				preparedStatement.execute();
				ResultSet res=preparedStatement.executeQuery(); 
				while(res.next()) {
					m1.id_Maestro=res.getString(1);
					m1.nombre=res.getString("nombre_maestro");
					m1.apellido=res.getString("apellido_Maestro");
					m1.numero_tele=res.getString("Telefono_Maestro");
					m1.edad=res.getInt("edad");
					m1.sexo=res.getString("sexo");
					m1.tanda=res.getString("Tanda");
					m1.grando=res.getString("grado_a_impartir");
					m1.Materia=res.getString("materia");
					modo.addRow(new Object[] {m1.getId_maestro(), m1.getNombre(),m1.getApellido(),m1.getNumero_tele(),m1.getEdad(),m1.getSexo()
							,m1.getTanda(),m1.getGrado(),m1.getMateria()});}
					table_1.setModel(modo);
			} catch (SQLException e1) {
				e1.printStackTrace();}
			}
		else if (e.getSource()==btnagregar_2) {
			conexion = conexion_DB.conectando();
			if (table_1.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "Para ejecutar esta funcion,\n debe haber un campo \nde la tabla"
						+ " seleccionado","Error",JOptionPane.WARNING_MESSAGE);}
			else {
				try {
					System.out.println(table_1.getValueAt(table_1.getSelectedRow(), 0));
					preparedStatement = conexion.prepareStatement("DELETE MAESTRO_1 from MAESTRO_1 WHERE Id_maestro = '"+table_1.getValueAt(table_1.getSelectedRow(), 0)+"' ");
					preparedStatement.execute();
					modo.removeRow(table_1.getSelectedRow());
					table_1.setModel(modo);
				} catch (SQLException e1) {
					e1.printStackTrace();}
				JOptionPane.showMessageDialog(null, "Exito. Persona eliminada corractamente");}		
		}
		
		else if (e.getSource()==btnagregar_3) {
			tid.setEditable(false);
			btnagregar.setVisible(false);
			btnagregar_4.setVisible(true);
			conexion = conexion_DB.conectando();
			if (table_1.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "Para ejecutar esta funcion,\n debe haber un campo \nde la tabla"
						+ " seleccionado","Error",JOptionPane.WARNING_MESSAGE);}
			else {
			try {
				preparedStatement = conexion.prepareStatement("select * from MAESTRO_1  WHERE Id_maestro = '"+table_1.getValueAt(table_1.getSelectedRow(), 0)+"'");
				preparedStatement.execute();
				ResultSet res=preparedStatement.executeQuery(); 
				while(res.next()) {
					m1.id_Maestro=res.getString(1);
					m1.nombre=res.getString("nombre_maestro");
					m1.apellido=res.getString("apellido_Maestro");
					m1.numero_tele=res.getString("Telefono_Maestro");
					m1.edad=res.getInt("edad");
					tapellido.setText(m1.apellido);
					tedad.setText(String.valueOf(m1.edad) );
					tid.setText(m1.id_Maestro);
					tnombre.setText(m1.nombre);
					ttelefono.setText(m1.numero_tele);
					cgradoimp.setSelectedItem(m1.grando=res.getString("grado_a_impartir"));
					cmateria.setSelectedItem(m1.Materia=res.getString("Materia"));
					csexo.setSelectedItem(m1.sexo=res.getString("Sexo"));
					ctanda.setSelectedItem(m1.tanda=res.getString("Tanda"));}
			} catch (SQLException e1) {
				e1.printStackTrace();}
			}}
		else if (e.getSource()==btnagregar_4) {
			conexion = conexion_DB.conectando();
			if (tedad.getText().isEmpty() || tid.getText().isEmpty() || tnombre.getText().isEmpty() ||  tapellido.getText().isEmpty()
					||ttelefono.getText().isEmpty() || csexo.getSelectedItem()==null
					|| ctanda.getSelectedItem()==null|| cgradoimp.getSelectedItem()==null|| cmateria.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de gurdar", "Error", JOptionPane.WARNING_MESSAGE);}
			else {
				boolean pasa1;
				try {
					m1.edad= Integer.parseInt(tedad.getText());
					if(m1.edad<=93 && m1.edad>=20) {
						pasa1=false;}
					else {
						pasa1=true;}
				
				if(pasa1==false) {
					preparedStatement = conexion.prepareStatement("UPDATE MAESTRO_1 SET nombre_maestro= '"+tnombre.getText()+"' , ID_MAESTRO='"+tid.getText()+"',apellido_Maestro='"+tapellido.getText()+"',"
							+ "Telefono_Maestro= '"+ ttelefono.getText()+"',edad='"+tedad.getText()+"',sexo='"+csexo.getSelectedItem()+"',Tanda ='"+ctanda.getSelectedItem()+"',"
											+ "grado_a_impartir= '"+cgradoimp.getSelectedItem()+"',materia='"+cmateria.getSelectedItem()+"'  "
							+ "  WHERE id_maestro='"+table_1.getValueAt(table_1.getSelectedRow(), 0)+"' ");
					preparedStatement.execute();
					while(table_1.getRowCount() > 0){
					    ((DefaultTableModel) table_1.getModel()).removeRow(0);}
					preparedStatement = conexion.prepareStatement("select * from MAESTRO_1");
					preparedStatement.execute();
					ResultSet res=preparedStatement.executeQuery(); 
					while(res.next()) {
						m1.id_Maestro=res.getString(1);
						m1.nombre=res.getString("nombre_maestro");
						m1.apellido=res.getString("apellido_Maestro");
						m1.numero_tele=res.getString("Telefono_Maestro");
						m1.edad=res.getInt("edad");
						m1.sexo=res.getString("sexo");
						m1.tanda=res.getString("Tanda");
						m1.grando=res.getString("grado_a_impartir");
						m1.Materia=res.getString("materia");
						modo.addRow(new Object[] {m1.getId_maestro(), m1.getNombre(),m1.getApellido(),m1.getNumero_tele(),m1.getEdad(),m1.getSexo()
								,m1.getTanda(),m1.getGrado(),m1.getMateria()});}
						table_1.setModel(modo);
	
					preparedStatement.execute();
					preparedStatement.close();		
					btnagregar_4.setVisible(false);
					tedad.setText(null);
					tid.setText(null);
					tid.setEditable(true);
					tnombre.setText(null);
					tapellido.setText(null);
					ttelefono.setText(null);
					csexo.setSelectedItem(null);
					ctanda.setSelectedItem(null);
					cgradoimp.setSelectedItem(null);
					cmateria.setSelectedItem(null);
					JOptionPane.showMessageDialog(null, "Maestro actualizado correctamente");
					btnagregar.setVisible(true);}
				else if(pasa1==true) {
					 tedad.setText(null);
					 JOptionPane.showMessageDialog(null, "La edad debe estar entre 20-93 años","Error",JOptionPane.WARNING_MESSAGE);}
				}catch(SQLException e1) {
					
				   }}}}

	public void keyTyped(KeyEvent e) {
		char character=e.getKeyChar();
		if(e.getSource()==tnombre) {
			if(Character.isDigit(character)) {
				getToolkit().beep(); 
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Error",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==tapellido) {
			if(Character.isDigit(character)) {
				getToolkit().beep(); 
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente letras por favor","Error",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==tedad) {
			if(Character.isLetter(character)) {
				getToolkit().beep(); 
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Error",JOptionPane.WARNING_MESSAGE);
				}}
		else if(e.getSource()==ttelefono) {
			if(Character.isLetter(character)) {
				getToolkit().beep();
				e.consume();
				JOptionPane.showMessageDialog(null, "Introduzca solamente digitos por favor","Error",JOptionPane.WARNING_MESSAGE);
				}}}
	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

}
	
	
	


