package clases_ProyectoFinal;

public class Persona {
	String nombre;
	String apellido;
	int edad;
	String sexo;
	// CONSTRUCTORES
	public Persona() {}
	public Persona(String nombre,String apellido,int edad,String sexo) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;}
	// METODOS SETTER
	public void setNombre(String nombre){
		this.nombre=nombre;}
	public void setApellido(String apellido){
		this.apellido=apellido;}
	public void setEdad(int edad){
		this.edad=edad;}
	public void setSexo(String sexo) {
		this.sexo=sexo;}
	// METODOS GETTER
	public  String getNombre(){
		return nombre;}
	public  String getApellido(){
		return apellido;}
	public  int getEdad(){
		return edad;}
	public  String getSexo(){
		return sexo;}	
	}

class Maestro extends Persona{
	String id_Maestro;
	String numero_tele;
	String tanda;
	String grando;
	String Materia;
	public Maestro() {}
	public Maestro(String nombre,String apellido,int edad,String sexo, String id_Maestro,String numero_tele,String tanda,String grando,String Materia) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;
		this.id_Maestro=id_Maestro;
		this.numero_tele=numero_tele;
		this.tanda=tanda;
		this.grando=grando;
		this.Materia=Materia;}
	//Metodos 
	public void setId_maestro(String id_Maestro){
		this.id_Maestro=id_Maestro;}
	public void setNumero_tele(String numero_tele){
		this.numero_tele=numero_tele;}
	////
	public  String getId_maestro(){
		return id_Maestro;}
	public  String getNumero_tele(){
		return numero_tele;}
	public  String getTanda(){
		return tanda;}
	public  String getGrado(){
		return grando;}
	public  String getMateria(){
		return Materia;}
}

class Alumno extends Persona{
	String id_alumno;
	int numero_telefono;
	String seccion;
	public Alumno() {}
	public Alumno(String nombre,String apellido,int edad,String sexo, String id_alumno,int numero_telefono,String seccion){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;
		this.id_alumno=id_alumno;
		this.numero_telefono=numero_telefono;
		this.seccion=seccion;
		}
	//Metodos 
		public void setId_Alumno(String id_alumno){
			this.id_alumno=id_alumno;}
		public void setNumero_telefono(int numero_telefono){
			this.numero_telefono=numero_telefono;}
		////
		public  String getId_alumno(){
			return id_alumno;}
		public  int getNumero_telefono(){
			return numero_telefono;}		
}



class Secretario extends Persona{
	String id_secretario;
	int numero_telefono;
	public Secretario() {}
	public Secretario(String nombre,String apellido,int edad,String sexo, String id_alumno){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;
		this.id_secretario=id_alumno;}
	/// METODOS
	public void setId_secretario(String id_Maestro){
		this.id_secretario=id_Maestro;}
	public void setNumero_tele(int numero_tele){
		this.numero_telefono=numero_tele;}
	////
	public  String getId_maestro(){
		return id_secretario;}
	public  int getNumero_tele(){
		return numero_telefono;}
	
}

class Director extends Persona{
	String direccion;
	int cedula;
	public Director() {
		
	}
	public Director(String nombre,String apellido,int edad,String sexo, String id_alumno,String direccion,int cedula){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;
		this.direccion=direccion;
		this.cedula=cedula;}
	//METODOS 
	public void setCedula(int cedula){
		this.cedula=cedula;}
	public void setDireccion(String direccion){
		this.direccion=direccion;}
	////
	public  int getCedula(){
		return cedula;}
	public  String getDireccion(){
		return direccion;}
}


class subDirector extends Persona{
	String direccion;
	int cedula;
	public subDirector(String nombre,String apellido,int edad,String sexo, String id_alumno,String direccion,int cedula){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;
		this.direccion=direccion;
		this.cedula=cedula;}
	//METODOS 
	public void setCedula(int cedula){
		this.cedula=cedula;}
	public void setDireccion(String direccion){
		this.direccion=direccion;}
	////
	public  int getCedula(){
		return cedula;}
	public  String getDireccion(){
		return direccion;}
}










