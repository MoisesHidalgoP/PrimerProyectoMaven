package Modelo;

public class dtoAlumnoAsignaturas {

	public dtoAlumnoAsignaturas(String nom,String ape, String nombA) {
		
		
		nombre = nom;
		apellidos = ape;
		nombAsig = nombA;
		
	}
	
	//Atributos	
			
			String nombre;
			String apellidos;
			String nombAsig;
			
	//Getters y Setters 	
			
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getApellidos() {
				return apellidos;
			}
			public void setApellidos(String apellidos) {
				this.apellidos = apellidos;
			}
			public String getNombA() {
				return nombAsig;
			}
			public void setNombA(String nombA) {
				this.nombAsig = nombA;
			}

			

}
