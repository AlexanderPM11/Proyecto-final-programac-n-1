package clases_ProyectoFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

 class uso_Proyecto {

	public static void main(String[] args) {
		JF_Principal p1=new JF_Principal();}}


 class JF_Principal extends JFrame implements ActionListener{
	
	
    Border border = BorderFactory.createLineBorder(new Color(23,23,3), 3);
	private Image imagen;
	JButton abrir_Rprofesor=new JButton("Maestro");
	JButton abrir_secretario=new JButton("Secretario");
	JButton abrir_Alumno=new JButton("Alumno");
	JButton abrir_director=new JButton("Director");
	JButton abrir_subDirector=new JButton("Sub director");
	JButton Salir=new JButton("Terminar y Salir");
	JLabel lbTitle=new JLabel("Sistema para secundaria.");
	JLabel lbTitle1=new JLabel("Precione según su requerimiento.");
	
	public JF_Principal() {
		setResizable(false);
		add(lbTitle);
		add(lbTitle1);
		lbTitle.setBounds(175, 1, 400, 100);
		lbTitle.setForeground(new Color(255,122,0));
		lbTitle.setFont(new Font("ariel", Font.BOLD, 14));
		lbTitle1.setFont(new Font("ariel", Font.BOLD, 14));
		lbTitle1.setForeground(new Color(255,122,0));
		lbTitle1.setBounds(145, 20, 400, 100);
		setLayout(null);
		setTitle("Sistema para secundaria");
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(500,200,500,400);
		abrir_Rprofesor.setBounds(20,100,200,30);
		abrir_Rprofesor.setBorder(border);
		abrir_secretario.setBounds(250,100,200,30);
		abrir_secretario.setBorder(border);
		abrir_Alumno.setBounds(20,150,200,30);
		abrir_Alumno.setBorder(border);
		abrir_director.setBounds(250,150,200,30);
		
		abrir_director.setBorder(border);
		abrir_subDirector.setBounds(140,200,200,30);
		add(Salir);
		Salir.setBorder(border);
		Salir.setBackground(Color.yellow);
		Salir.setBounds(20,240,435,30);
		abrir_subDirector.setBorder(border);
		add(abrir_Rprofesor);add(abrir_secretario);add(abrir_Alumno);
		add(abrir_director);add(abrir_subDirector);
		abrir_Rprofesor.addActionListener(this);
		abrir_secretario.addActionListener(this);
		abrir_director.addActionListener(this);
		abrir_Alumno.addActionListener(this);
		abrir_subDirector.addActionListener(this);
		Salir.addActionListener(this);
		setVisible(true);}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==abrir_secretario) {
		dispose();
		setVisible(false);
		Secretario1 se1=new Secretario1();
		se1.frame.setVisible(true);}
		else if(e.getSource()==abrir_Rprofesor) {
			dispose();
			setVisible(false);
			Profesor p1=new Profesor();
			p1.setVisible(true);
			}
		else if(e.getSource()==abrir_director) {
			dispose();
			setVisible(false);
			Director1 window = new Director1();
			window.frame.setVisible(true);
			}
		else if(e.getSource()==abrir_Alumno) {
			dispose();
			setVisible(false);
			Alumnos alu = new Alumnos();
			alu.frame.setVisible(true);
			}
		else if(e.getSource()==abrir_subDirector) {
			dispose();
			setVisible(false);
			Sub_Director sub = new Sub_Director();
			sub.frame.setVisible(true);
			}
		else if(e.getSource()==Salir) {
			System.exit(ABORT);
			}}
}
