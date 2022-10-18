package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class dtoADto {

public static ArrayList<dtoAlumno> resultsetAdtoAlumno(ResultSet resultadoConsulta){
		
		System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Entrando en resultsetAdtoAlumno");
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while ( resultadoConsulta.next() ) {
				
				listAlumnos.add(new dtoAlumno(resultadoConsulta.getInt("id_alumno"),
						resultadoConsulta.getString("nombre"),
						resultadoConsulta.getString("apellidos"),
						resultadoConsulta.getString("email"))
						);
			}
			
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Número alumnos: "+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAlumnos;
		
	}


public static ArrayList<dtoAlumnoAsignaturas> resultsetAdtoAlumnoAsig(ResultSet resultadoConsulta){
	
	System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Entrando en resultsetAdtoAlumno");
	ArrayList<dtoAlumnoAsignaturas> listAlumnosAsignaturas = new ArrayList<>();
	
	//Leemos el resultado de la consulta hasta que no queden filas
	try {
		while ( resultadoConsulta.next() ) {
			
			listAlumnosAsignaturas.add(new dtoAlumnoAsignaturas(resultadoConsulta.getString("nombre"),
					resultadoConsulta.getString("apellidos"),
					resultadoConsulta.getString("nombreAsig"))
					
					);
		}
		
		int i = listAlumnosAsignaturas.size();
		System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Número alumnos: "+i);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listAlumnosAsignaturas;
	
}

}
