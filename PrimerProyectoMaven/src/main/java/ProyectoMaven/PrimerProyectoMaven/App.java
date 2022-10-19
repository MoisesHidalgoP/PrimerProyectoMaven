package ProyectoMaven.PrimerProyectoMaven;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import Modelo.ConexionPostgreSQL;

import Modelo.ConsultasPostgreSQL;
import Modelo.dtoAlumno;
import Modelo.dtoAlumnoAsignaturas;
import Util.variablesConexionPostgreSQL;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CONSTANTES
		final String HOST = variablesConexionPostgreSQL.getHost();
		final String PORT = variablesConexionPostgreSQL.getPort();
		final String DB = variablesConexionPostgreSQL.getDb();
		final String USER = variablesConexionPostgreSQL.getUser();
		final String PASS = variablesConexionPostgreSQL.getPass();
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<>();
		ArrayList<dtoAlumnoAsignaturas> listAlumnosAsignaturas = new ArrayList<>();

		
		/*Se crea una instancia de la clase en la que estamos para poder generar la conexión a PostgreSQL
		*utilizando el método generaConexion
		*/
		System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada generaConexion");
		ConexionPostgreSQL conexionPostgresql = new ConexionPostgreSQL();
		Connection conexionGenerada = conexionPostgresql.generaConexion(HOST,PORT,DB,USER,PASS);
		
		if(conexionGenerada != null) {
			
			
			
			//Llama al método que ejecuta la consulta de insert
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada insertNuevoAlumno");
			//Si los métodos se crean como estáticos no es necesario instanciar una clase.
			ConsultasPostgreSQL.insertNuevoAlumno("INSERT INTO \"proyectoEclipse\".\"alumnos\" (id_Alumno,nombre,apellidos,email)"
					+ "VALUES(50,'Juanjo','Hernandez','jh@altair.es')", conexionGenerada);
			
			
	
			//Llamada al método que ejecuta la consulta
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada selectAllAlumnos");
			listAlumnos = ConsultasPostgreSQL.selectAllAlumnos(conexionGenerada);
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Número alumnos: "+i);
			for(Modelo.dtoAlumno alumnos: listAlumnos) {
				System.out.println(alumnos.getNombre()+ " " +alumnos.getApellidos());			}
			
			
			//Llamada al metodo que borra el alumno
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada deleteAlumnos");
			// Pedimos un id al usuario para borrar
		    System.out.print("\n\tIntroduzca el id del alumno para eliminarlo:\t");
		    Scanner sc = new Scanner(System.in);
		    int id = sc.nextInt();
			ConsultasPostgreSQL.deleteAlumnos("DELETE FROM \"proyectoEclipse\".\"alumnos\" WHERE id_alumno = '"+id+"'", conexionGenerada);
			
			
			//Llama daal metodo que actualiza el alumno
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada updateAlumnos");
			// Pedimos un id al usuario para borrar
		    System.out.print("\n\tIntroduzca el id del alumno para actualizarlo:\t");
		    Scanner sc1 = new Scanner(System.in);
		    int id1 = sc1.nextInt();
			ConsultasPostgreSQL.deleteAlumnos("UPDATE \"proyectoEclipse\".\"alumnos\" SET nombre = 'Juanca', apellidos = 'Bada' WHERE id_alumno = '"+id1+"'", conexionGenerada);
			
			
			
			//Llamada al metodo que crea una tabla 
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada crearTabla");
			ConsultasPostgreSQL.crearTabla("CREATE TABLE IF NOT EXISTS profesores (id_profesor CHARACTER VARYING NOT NULL)", conexionGenerada);
			
			}
		
		System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada a cerrarConexion");
        ConexionPostgreSQL.cerrarConexion(conexionGenerada);
			
			
		}		
	}
	

	




