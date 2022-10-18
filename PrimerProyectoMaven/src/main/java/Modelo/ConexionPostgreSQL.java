package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgreSQL {

	//MÉTODOS
			/** generaConexion - Método que genera a partir de parámetros la conexión a PostgreSQL
			 * @param host
			 * @param port
			 * @param db
			 * @param user
			 * @param pass
			 * @return Conexión a postgreSQL, null si no es válida, y la correspondiente si sí lo es.
			 */
			public Connection generaConexion(final String host, final String port, final String db, final String user, final String pass) {

				System.out.println("[INFORMACIÓN-conexionPostgresql-generaConexion] Entra en generaConexion");
				
		        /*(Definición local) Definimos connection a null y url a vacío para 
		         * asegurarnos de que ambas variables están limpias.
		         */
		        Connection conexion = null;
		        String url = "";            
		        url = "jdbc:postgresql://" + host + ":" + port + "/" + db;
				
		        try {
		        	
		        	/*Class.forName obtiene una instancia de la clase de java especificada.
					*En este caso registra la clase como driver JDBC
					*/
		            try {
		                Class.forName("org.postgresql.Driver");
		            } catch (ClassNotFoundException cnfe) {
		                System.out.println("[ERROR-conexionPostgresql-generaConexion] Error en registro driver PostgreSQL: " + cnfe);
		            }
		      
		            //Conexión a la base de datos en PostgreSQL y validación de esta
		            conexion = DriverManager.getConnection(url, user, pass);           
		            boolean esValida = conexion.isValid(50000);
		            if(esValida == false) {
		            	conexion = null;
		            }
		            System.out.println(esValida ? "[INFORMACIÓN-conexionPostgresql-generaConexion] Conexión a PostgreSQL válida" : "[ERROR-conexionPostgresql-generaConexion] Conexión a PostgreSQL no válida");
		            return conexion;
		            
		        } catch (java.sql.SQLException jsqle) {
		        	
		            System.out.println("[ERROR-conexionPostgresql-generaConexion] Error en conexión a PostgreSQL (" + url + "): " + jsqle);
		            return conexion;
		            
		        }
		    }
			
			
			public static void cerrarConexion (Connection conexionGenerada) {
				
				System.out.println("[INFORMACIÓN-conexionPostgresql-cerrarConexion] Entra en cerrar conexión");
				
				try {
					
					//Si el auto commit está habilitado no se hace de forma explícita el commit.
					//conexionGenerada.commit();
					conexionGenerada.close();
					
				} catch (SQLException e) {
					
					System.out.println("[ERROR-conexionPostgresql-cerrarConexion] Error al cerrar conexión PostgreSQL: " + e);
				
				}	
				
			}

		}

