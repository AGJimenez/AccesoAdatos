import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Consultas {
	 private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/accesoadatos";
		String tablaNombre;
		private static final String USUARIO = "root";
		private static final String CLAVE = "1234";
		ResultSet resultado ;
		Connection conect  ;
		private Statement statement;
		private JTable table;

		

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
		        this.statement = conect.createStatement(); // Inicializar el objeto statement aquí
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
		 
		
		 
		 public void insertarTablasMostrar(Jd_insertarDatos datos) throws SQLException {
			    // consulta para ver nombre de tablas
			    statement = conect.createStatement();
			    try {
			        String sql = "SHOW TABLES";
			        ResultSet rs = statement.executeQuery(sql);

			        // sacar datos del result set
			        while (rs.next()) {
			            // saca el nombre de la tabla
			            tablaNombre = rs.getString(1);
			            datos.setCb_tablasItems(tablaNombre);
			        }
			    } finally {
			        if (statement != null) {
			            statement.close();
			        }
			    }
			}
		 
		
		 
		 public void insertDataIntoTable(String tablaNombre, String[] valores) {
		        try {
		           
		            StringBuilder query = new StringBuilder("INSERT INTO " + tablaNombre + " VALUES (");
		            for (int i = 0; i < valores.length; i++) {
		                query.append(i == 0 ? "" : ", ").append("'").append(valores[i]).append("'");
		            }
		            query.append(")");

		            this.statement.executeUpdate(query.toString());
		            System.out.println("Inserción exitosa en la tabla " + tablaNombre);

		        } catch (SQLException e) {
		            e.printStackTrace();
		            System.err.println("Error al insertar datos en la tabla " + tablaNombre);
		        }
		    }
		 
		  
		    public DefaultTableModel obtenerDatosTabla() {
		        DefaultTableModel model = new DefaultTableModel();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM pacientes");

		            // Obtener los metadatos de la consulta
		            ResultSetMetaData metaData = resultado.getMetaData();
		            int columnCount = metaData.getColumnCount();

		            // Agregar columnas al modelo en función de los metadatos
		            for (int i = 1; i <= columnCount; i++) {
		                model.addColumn(metaData.getColumnName(i));
		            }

		            // Agregar filas al modelo
		            while (resultado.next()) {
		                Object[] row = new Object[columnCount];
		                for (int i = 1; i <= columnCount; i++) {
		                    row[i - 1] = resultado.getObject(i);
		                }
		                model.addRow(row);
		            }

		            // Cerrar la conexión
		            conect.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return model;
		    }
		
		
		
}


