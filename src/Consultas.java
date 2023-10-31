import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		private static final String URL = "jdbc:mysql://localhost:3306/dentilax_BBDD";
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
		 
		 
		 
		 
		 public void insertarTablasMostrar_borrar(Jd_borrar_datos datos) throws SQLException {
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
		 
		 public void modificarTablasMostrar(Jd_actualizarDatos datos) throws SQLException {
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
		 
		 public void selectTablasMostrar(Jd_verDatos datos) throws SQLException {
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
		 
		  
		    public DefaultTableModel obtenerDatosTabla_citas() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM citas");

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
		    
		    public DefaultTableModel obtenerDatosTabla_doctores() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM doctores");

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
		    
		    public DefaultTableModel obtenerDatosTabla_especialidades() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM especialidades");

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
		    
		    public DefaultTableModel obtenerDatosTabla_facturacion() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM facturacion");

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
		    
		    public DefaultTableModel obtenerDatosTabla_historial_pago() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM historial_pago");

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
		    
		    public DefaultTableModel obtenerDatosTabla_inventario() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM inventario");

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
		    
		    public DefaultTableModel obtenerDatosTabla_pacientes() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

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
		    
		    public DefaultTableModel obtenerDatosTabla_proveedor() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM proveedor");

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
		    
		    public DefaultTableModel obtenerDatosTabla_solicitud() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM solicitud");

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
		    
		    public DefaultTableModel obtenerDatosTabla_tratamientos() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM tratamientos");

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
		    
		    public DefaultTableModel obtenerDatosTabla_usuario() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();
		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM usuario");

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
		    
		    public DefaultTableModel obtenerDatosTabla_pedidos() {
		        DefaultTableModel model = new DefaultTableModel();
		        Jd_verDatos ventana = new Jd_verDatos();

		        // Conexión a la base de datos
		        try {
		          this.conectar();
		             statement = conect.createStatement();
		             resultado  = statement.executeQuery("SELECT * FROM pedidos");

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
		
		    public void deleteUsuario(String DNI_usuario) {
		        String sql = "DELETE FROM usuario WHERE DNI_usuario = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_usuario);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void deleteTratamiento(String ID_tratamiento) {
		        String sql = "DELETE FROM tratamientos WHERE ID_tratamiento = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_tratamiento);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void deleteCita(String DNI_paciente, String fecha) {
		        String sql = "DELETE FROM citas WHERE DNI_paciente = ? AND Fecha = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_paciente);
		            pstmt.setString(2, fecha);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void deletePaciente(String DNI_paciente) {
		        String sql = "DELETE FROM pacientes WHERE DNI_paciente = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_paciente);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    public void deleteEspecialidad(String Nombre_especialidad) {
		        String sql = "DELETE FROM especialidades WHERE Nombre_especialidad = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Nombre_especialidad);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    public void deleteSolicitud(String ID_solicitud) {
		        String sql = "DELETE FROM solicitud WHERE ID_solicitud = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_solicitud);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void deletePedido(String ID_pedido) {
		        String sql = "DELETE FROM pedidos WHERE ID_pedido = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_pedido);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    public void deleteDoctor(String DNI_doctor) {
		        String sql = "DELETE FROM doctores WHERE DNI_doctor = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_doctor);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    public void deleteProveedor(String Proveedor) {
		        String sql = "DELETE FROM proveedores WHERE Proveedor = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Proveedor);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void deletePago(String DNI, String fecha) {
		        String sql = "DELETE FROM historial_pago WHERE DNI = ? AND Fecha = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI);
		            pstmt.setString(1, fecha);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    public void deleteFactura(String ID_factura) {
		        String sql = "DELETE FROM facturacion WHERE ID_factura = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_factura);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    
		    
		    public String numeroUsuarios() {
		        StringBuilder stringBuilder = new StringBuilder();
		        try {
		            statement = conect.createStatement();

		            String sql = "SELECT Rol, COUNT(*) AS cantidad FROM usuario GROUP BY Rol";
		            ResultSet rs = statement.executeQuery(sql);

		            while (rs.next()) {
		                String rol = rs.getString("rol");
		                int cantidad = rs.getInt("cantidad");
		                stringBuilder.append("Rol: ").append(rol).append(", Cantidad: ").append(cantidad).append("\n");
		            }

		            rs.close();
		            statement.close();
		            conect.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return stringBuilder.toString();
		    }

		    public String buscarPacientePorNombre(String nombre) {
		        String nombreEncontrado = null;
		        try {
		            statement = conect.createStatement();

		            String sql = "SELECT * FROM pacientes WHERE Nombre LIKE '%" + nombre + "%'";
		            ResultSet rs = statement.executeQuery(sql);

		            while (rs.next()) {
		                // Aquí puedes procesar el resultado de la búsqueda
		                nombreEncontrado = rs.getString("Nombre");
		                // Haz algo con el nombre encontrado, como imprimirlo en la consola
		                return nombreEncontrado;
		            }

		            rs.close();
		            statement.close();
		            conect.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return nombreEncontrado;
		    }

		    
		    //Actualizar
		    public void actualizarCita(String DNI_paciente, String nuevoDNI_doctor, String nuevaFecha, String nuevaEspecialidad) {
		        String sql = "UPDATE citas SET Fecha = ?, DNI_doctor = ?, Especialidad = ? WHERE DNI_paciente = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, nuevaFecha);
		            pstmt.setString(2, nuevoDNI_doctor);
		            pstmt.setString(3, nuevaEspecialidad);
		            pstmt.setString(4, DNI_paciente);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizarUsuario(String DNI_usuario, String rol, String contraseña) {
		        String sql = "UPDATE usuario SET Contraseña = ?, Rol = ? WHERE DNI_usuario = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_usuario);
		            pstmt.setString(2, rol);
		            pstmt.setString(3, contraseña);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_tratamientos(String DNI_paciente, String Doctor, String Apagar) {
		        String sql = "UPDATE tratamientos SET Doctor = ?, A pagar = ? WHERE DNI_paciente = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_paciente);
		            pstmt.setString(2, Doctor);
		            pstmt.setString(3, Apagar);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_solicitud(String DNI, String Cantidad) {
		        String sql = "UPDATE solicitud SET Cantidad = ? WHERE DNI = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI);
		            pstmt.setString(2, Cantidad);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_proveedor(String ID_producto, String Proveedor) {
		        String sql = "UPDATE proveedor SET Proveedor = ? WHERE ID_producto = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_producto);
		            pstmt.setString(2, Proveedor);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_pedidos(String ID_pedido, String Producto, String Cantidad, String Precio) {
		        String sql = "UPDATE pedidos SET Producto = ?, Cantidad = ?, Precio = ? WHERE ID_pedido = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_pedido);
		            pstmt.setString(2, Producto);
		            pstmt.setString(3, Cantidad);
		            pstmt.setString(4, Precio);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_pacientes(String DNI_paciente, String Nombre, String Apellidos, String Nacimiento, String Genero, String Estado
		    		, String Telefono, String Correo, String Direccion, String Seguro, String Observacion) {
		        String sql = "UPDATE pacientes SET Nombre = ?, Apellidos = ?, Nacimiento = ?, Genero = ?, Estado = ?, Telefono = ?, Correo = ?, Direccion = ?, Seguro = ?, Observacion = ? WHERE DNI_paciente = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_paciente);
		            pstmt.setString(2, Nombre);
		            pstmt.setString(3, Apellidos);
		            pstmt.setString(4, Nacimiento);
		            pstmt.setString(5, Genero);
		            pstmt.setString(6, Estado);
		            pstmt.setString(7, Telefono);
		            pstmt.setString(8, Correo);
		            pstmt.setString(9, Direccion);
		            pstmt.setString(10, Seguro);
		            pstmt.setString(11, Observacion);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_inventario(String ID_producto, String Cantidad) {
		        String sql = "UPDATE inventario SET Cantidad = ? WHERE ID_producto = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, ID_producto);
		            pstmt.setString(2, Cantidad);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_historial_pago(String DNI, String Cantidad, String Fecha, String Tipo) {
		        String sql = "UPDATE historial_pago SET Cantidad = ?, Fecha = ?, Tipo = ? WHERE DNI = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI);
		            pstmt.setString(2, Cantidad);
		            pstmt.setString(3, Fecha);
		            pstmt.setString(4, Tipo);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_facturacion(String DNI, String Nombre, String Apellidos, String Tratamiento, String Telefono, String Fecha
		    		, String Pagado, String Porpagar) {
		        String sql = "UPDATE facturacion SET Nombre = ?, Apellidos = ?, Tratamiento = ?, Telefono = ?, Fecha = ?, Pagado = ?, Por pagar = ? WHERE DNI = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI);
		            pstmt.setString(2, Nombre);
		            pstmt.setString(3, Apellidos);
		            pstmt.setString(4, Tratamiento);
		            pstmt.setString(5, Telefono);
		            pstmt.setString(6, Fecha);
		            pstmt.setString(7, Pagado);
		            pstmt.setString(8, Porpagar);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_especialidades(String  Nombre_especialidad) {
		        String sql = "UPDATE especialidades SET Nombre_especialidad= ? WHERE Nombre_especialidad = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Nombre_especialidad);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_doctores(String DNI_doctor, String Nombre, String Apellidos, String Nacimiento, String Genero, String Estado
		    		, String Telefono, String Correo, String Direccion, String Especialidad, String Salario) {
		        String sql = "UPDATE doctores SET Nombre = ?, Apellidos = ?, Nacimiento = ?, Genero = ?, Estado = ?, Telefono = ?, Correo = ?, Direccion = ?, Especialidad = ?, Salario = ? WHERE DNI_doctor = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI_doctor);
		            pstmt.setString(2, Nombre);
		            pstmt.setString(3, Apellidos);
		            pstmt.setString(4, Nacimiento);
		            pstmt.setString(5, Genero);
		            pstmt.setString(6, Estado);
		            pstmt.setString(7, Telefono);
		            pstmt.setString(8, Correo);
		            pstmt.setString(9, Direccion);
		            pstmt.setString(10, Especialidad);
		            pstmt.setString(11, Salario);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
}


