import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Consultas {
	 private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/accesoadatos";
		String tablaNombre;
		private static final String USUARIO = "root";
		private static final String CLAVE = "1234";
		ResultSet resultado ;
		Connection conect  ;
		Statement statement;


		static {
			try {
				Class.forName(CONTROLADOR);
			} catch (ClassNotFoundException e) {
				System.out.println("Error al cargar el controlador");
				e.printStackTrace();
			}
		}
		
		public Connection conectar() {

			try {
				conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
				System.out.println("Conexión OK");
				 statement = conect.createStatement();
				

			} catch (SQLException e) {
				System.out.println("Error en la conexión");
				e.printStackTrace();
			}
			
			return conect;
		}
		
		 public void desconectar()throws SQLException{

		
		        
		        if(conect!=null&&!conect.isClosed()){
		            conect.close();
		            System.out.println("Conexión cerrada");
		        }
		        }//cerramos desconcetar
		 
		 public void verTablas(Jd_verDatos datos) throws SQLException {
		        // consulta para ver nombre de tablas
		        statement = conect.createStatement();
		        String sql = "SHOW TABLES";
		        ResultSet rs = statement.executeQuery(sql);

		        // sacar datos del result set
		        while (rs.next()) {
		            // saca el nombre de la tabla
		            tablaNombre = rs.getString(1);
		            datos.setCb_tablasItems(tablaNombre);
		        }
		    }
		 
		 public void insertDataIntoTable(String tablaNombre, String[] valores) {
		        try {
		            statement = conect.createStatement();
		            StringBuilder query = new StringBuilder("INSERT INTO " + tablaNombre + " VALUES (");
		            for (int i = 0; i < valores.length; i++) {
		                query.append(i == 0 ? "" : ", ").append("'").append(valores[i]).append("'");
		            }
		            query.append(")");

		            statement.executeUpdate(query.toString());
		            System.out.println("Inserción exitosa en la tabla " + tablaNombre);

		        } catch (SQLException e) {
		            e.printStackTrace();
		            System.err.println("Error al insertar datos en la tabla " + tablaNombre);
		        }
		 
		 
}
}



