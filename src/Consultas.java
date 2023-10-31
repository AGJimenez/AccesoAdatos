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

/**
 * La clase Consultas se utiliza para realizar operaciones en la base de datos Dentilax.
 */
public class Consultas {
    // Definición de constantes para la conexión a la base de datos
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dentilax_BBDD?useSSL=false";
    String tablaNombre;
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";
    ResultSet resultado;
    Connection conect;
    private Statement statement;
    private JTable table;

    // Bloque estático para cargar el controlador al inicio de la aplicación
    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    /**
     * Establece una conexión con la base de datos Dentilax.
     * @return la conexión establecida
     */
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

    /**
     * Cierra la conexión actual de la base de datos.
     * @throws SQLException si hay algún error al cerrar la conexión
     */
    public void desconectar() throws SQLException {
        if (conect != null && !conect.isClosed()) {
            conect.close();
            System.out.println("Conexión cerrada");
        }
    }
 // Método para mostrar las tablas al insertar datos en la interfaz Jd_insertarDatos
    public void insertarTablasMostrar(Jd_insertarDatos datos) throws SQLException {
        // Consulta para ver el nombre de las tablas
        statement = conect.createStatement();
        try {
            String sql = "SHOW TABLES";
            ResultSet rs = statement.executeQuery(sql);

            // Extraer datos del result set
            while (rs.next()) {
                // Obtener el nombre de la tabla
                tablaNombre = rs.getString(1);
                datos.setCb_tablasItems(tablaNombre);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Método para mostrar las tablas al borrar datos en la interfaz Jd_borrar_datos
    public void insertarTablasMostrar_borrar(Jd_borrar_datos datos) throws SQLException {
        // Consulta para ver el nombre de las tablas
        statement = conect.createStatement();
        try {
            String sql = "SHOW TABLES";
            ResultSet rs = statement.executeQuery(sql);

            // Extraer datos del result set
            while (rs.next()) {
                // Obtener el nombre de la tabla
                tablaNombre = rs.getString(1);
                datos.setCb_tablasItems(tablaNombre);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Método para mostrar las tablas al modificar datos en la interfaz Jd_actualizarDatos
    public void modificarTablasMostrar(Jd_actualizarDatos datos) throws SQLException {
        // Consulta para ver el nombre de las tablas
        statement = conect.createStatement();
        try {
            String sql = "SHOW TABLES";
            ResultSet rs = statement.executeQuery(sql);

            // Extraer datos del result set
            while (rs.next()) {
                // Obtener el nombre de la tabla
                tablaNombre = rs.getString(1);
                datos.setCb_tablasItems(tablaNombre);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Método para mostrar las tablas al seleccionar datos en la interfaz Jd_verDatos
    public void selectTablasMostrar(Jd_verDatos datos) throws SQLException {
        // Consulta para ver el nombre de las tablas
        statement = conect.createStatement();
        try {
            String sql = "SHOW TABLES";
            ResultSet rs = statement.executeQuery(sql);

            // Extraer datos del result set
            while (rs.next()) {
                // Obtener el nombre de la tabla
                tablaNombre = rs.getString(1);
                datos.setCb_tablasItems(tablaNombre);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Método para insertar datos en una tabla específica
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

    // Método para obtener los datos de la tabla 'citas' y mostrarlos en un modelo de tabla
    public DefaultTableModel obtenerDatosTabla_citas() {
        DefaultTableModel model = new DefaultTableModel();
        Jd_verDatos ventana = new Jd_verDatos();

        // Conexión a la base de datos
        try {
            this.conectar();
            statement = conect.createStatement();
            resultado = statement.executeQuery("SELECT * FROM citas");

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

		    //Método para obtener datos de la tabla doctores
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
		    
		    //Método para obetener datos de especialidades
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
		    
		    //Método para obtener datos de facturación
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
		
		   
		    /**
		     * Elimina un usuario de la tabla 'usuario' en la base de datos, identificado por el DNI del usuario.
		     *
		     * @param DNI_usuario DNI a eliminar.
		     */
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
		    //Se continua haciendo lo mismo que en la anterior tabla
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
		    
		    /**
		     * Elimina un pago de la tabla 'historial_pago' en la base de datos, identificado por el DNI y la fecha del pago.
		     *
		     * @param DNI el DNI asociado al pago a eliminar.
		     * @param fecha La fecha del pago a eliminar.
		     */
		    public void deletePago(String DNI, String fecha) {
		        String sql = "DELETE FROM historial_pago WHERE DNI = ? AND Fecha = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, DNI);
		            pstmt.setString(2, fecha);
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
		    
		    
		    
		    /**
		     * Retorna la cantidad de usuarios agrupados por su rol desde la base de datos en formato de cadena.
		     *
		     * @return Una representación en cadena de los roles y sus cantidades de usuarios asociados.
		     */
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

		    /**
		     * Realiza una búsqueda en la base de datos de pacientes cuyo nombre coincida total o parcialmente con el nombre proporcionado.
		     *
		     * @param nombre El nombre a buscar en la base de datos de pacientes.
		     * @return El nombre del paciente encontrado o null si no se encontró ningún paciente con el nombre especificado.
		     */
		    public String buscarPacientePorNombre(String nombre) {
		        String nombreEncontrado = null;
		        try {
		            statement = conect.createStatement();

		            String sql = "SELECT * FROM pacientes WHERE Nombre LIKE '%" + nombre + "%'";
		            ResultSet rs = statement.executeQuery(sql);

		            while (rs.next()) {
		                // Aquí  procesa el resultado de la búsqueda
		                nombreEncontrado = rs.getString("Nombre");
		                
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
		    /**
		     * Actualiza una cita existente en la base de datos con los nuevos valores proporcionados para la fecha, el DNI del doctor y la especialidad.
		     *
		     * @param DNI_paciente El DNI del paciente asociado a la cita que se desea actualizar.
		     * @param nuevoDNI_doctor El nuevo DNI del doctor asociado a la cita.
		     * @param nuevaFecha La nueva fecha de la cita.
		     * @param nuevaEspecialidad La nueva especialidad asociada a la cita.
		     */
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
		            pstmt.setString(1, contraseña);
		            pstmt.setString(2, rol);
		            pstmt.setString(3, DNI_usuario);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_tratamientos(String DNI_paciente, String Doctor, String Apagar) {
		        String sql = "UPDATE tratamientos SET Doctor = ?, A pagar = ? WHERE DNI_paciente = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Doctor);
		            pstmt.setString(2, Apagar);
		            pstmt.setString(3, DNI_paciente);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_solicitud(String DNI, String Cantidad) {
		        String sql = "UPDATE solicitud SET Cantidad = ? WHERE DNI = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Cantidad);
		            pstmt.setString(2, DNI);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_proveedor(String ID_producto, String Proveedor) {
		        String sql = "UPDATE proveedor SET Proveedor = ? WHERE ID_producto = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Proveedor);
		            pstmt.setString(2, ID_producto);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_pedidos(String ID_pedido, String Producto, String Cantidad, String Precio) {
		        String sql = "UPDATE pedidos SET Producto = ?, Cantidad = ?, Precio = ? WHERE ID_pedido = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Producto);
		            pstmt.setString(2, Cantidad);
		            pstmt.setString(3, Precio);
		            pstmt.setString(4, ID_pedido);
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
		            pstmt.setString(1, Nombre);
		            pstmt.setString(2, Apellidos);
		            pstmt.setString(3, Nacimiento);
		            pstmt.setString(4, Genero);
		            pstmt.setString(5, Estado);
		            pstmt.setString(6, Telefono);
		            pstmt.setString(7, Correo);
		            pstmt.setString(8, Direccion);
		            pstmt.setString(9, Seguro);
		            pstmt.setString(10, Observacion);
		            pstmt.setString(11, DNI_paciente);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_inventario(String ID_producto, String Cantidad) {
		        String sql = "UPDATE inventario SET Cantidad = ? WHERE ID_producto = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Cantidad);
		            pstmt.setString(2, ID_producto);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_historial_pago(String DNI, String Cantidad, String Fecha, String Tipo) {
		        String sql = "UPDATE historial_pago SET Cantidad = ?, Fecha = ?, Tipo = ? WHERE DNI = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Cantidad);
		            pstmt.setString(2, Fecha);
		            pstmt.setString(3, Tipo);
		            pstmt.setString(4, DNI);
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
		            pstmt.setString(1, Nombre);
		            pstmt.setString(2, Apellidos);
		            pstmt.setString(3, Tratamiento);
		            pstmt.setString(4, Telefono);
		            pstmt.setString(5, Fecha);
		            pstmt.setString(6, Pagado);
		            pstmt.setString(7, Porpagar);
		            pstmt.setString(8, DNI);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    public void actualizar_especialidades(String  Nombre_especialidad, String ID_especialidad) {
		        String sql = "UPDATE especialidades SET Nombre_especialidad = ? WHERE ID_especialidad = ?";

		        try (Connection connection = this.conectar();
		             PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setString(1, Nombre_especialidad);
		            pstmt.setString(2, ID_especialidad);

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
		            pstmt.setString(1, Nombre);
		            pstmt.setString(2, Apellidos);
		            pstmt.setString(3, Nacimiento);
		            pstmt.setString(4, Genero);
		            pstmt.setString(5, Estado);
		            pstmt.setString(6, Telefono);
		            pstmt.setString(7, Correo);
		            pstmt.setString(8, Direccion);
		            pstmt.setString(9, Especialidad);
		            pstmt.setString(10, Salario);
		            pstmt.setString(11, DNI_doctor);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		    
		    
		    /**
		     * Realiza una consulta que une los datos de las tablas 'pacientes' y 'citas' basada en la igualdad del DNI del paciente en ambas tablas. 
		     * Devuelve los resultados obtenidos en forma de cadena de texto.
		     * 
		     * @return Una cadena de texto que contiene los resultados de la consulta, incluyendo el DNI, nombre, apellidos, fecha y especialidad de los pacientes y sus citas.
		     */
		    public String mostrarConsulta() {
		    	/*En este caso, estaríamos seleccionando todos los datos de las tablas pacientes y citas donde el DNI_paciente es igual en ambas tablas.*/
		        StringBuilder resultStringBuilder = new StringBuilder();
		        try {
		            // Establecer la conexión
		            conect = this.conectar();

		            // Crear la consulta
		            String sqlQuery = "SELECT * " +
		                    "FROM pacientes " +
		                    "JOIN citas " +
		                    "ON pacientes.DNI_paciente = citas.DNI_paciente";

		            // Crear la declaración
		            statement = conect.createStatement();

		            // Ejecutar la consulta
		            resultado = statement.executeQuery(sqlQuery);

		            // Iterar a través de los resultados
		            while (resultado.next()) {
		                // Concatenar los resultados al StringBuilder
		                resultStringBuilder.append("DNI: ").append(resultado.getString("DNI_paciente")).append("\n");
		                resultStringBuilder.append("Nombre: ").append(resultado.getString("Nombre")).append("\n");
		                resultStringBuilder.append("Apellidos: ").append(resultado.getString("Apellidos")).append("\n");
		                resultStringBuilder.append("Fecha: ").append(resultado.getString("Fecha")).append("\n");
		                resultStringBuilder.append("Especialidad: ").append(resultado.getString("Especialidad")).append("\n\n");
		            }

		            // Cerrar la conexión
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		        
		        return resultStringBuilder.toString();
		    }
		    
		    /**
		     * Obtiene el sueldo medio de todos los doctores en la base de datos. Realiza una consulta para calcular el promedio de los salarios de los doctores.
		     *
		     * @return El sueldo medio de los doctores en la base de datos.
		     */
		    public double obtenerSueldoMedio() {
		        double sueldoMedio = 0;
		        try {
		            // Establecer la conexión
		            conect = this.conectar();

		            // Crear la consulta
		            String sqlQuery = "SELECT AVG(CAST(Salario AS DECIMAL(10,2))) AS SueldoMedio FROM doctores";

		            // Crear la declaración
		            statement = conect.createStatement();

		            // Ejecutar la consulta
		            resultado = statement.executeQuery(sqlQuery);

		            // Obtener el sueldo medio
		            if (resultado.next()) {
		                sueldoMedio = resultado.getDouble("SueldoMedio");
		            }

		            // Cerrar la conexión
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		        
		        return sueldoMedio;
		    }
}

