/**
 * La clase Conexion demuestra un ejemplo básico de conexión a una base de datos.
 * Contiene un método principal que crea una instancia de la clase Consultas y llama al método conectar().
 */
public class Conexion {
    /**
     * El método principal que inicia la aplicación y prueba la conexión a la base de datos.
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase Consultas
        Consultas conect = new Consultas();

        // Llamar al método conectar() para probar la conexión a la base de datos
        conect.conectar();		
    }
}