import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

public class Jd_verDatos extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Jd_verDatos dialog = new Jd_verDatos();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the dialog.
     */
    public Jd_verDatos() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 800, 400);
        getContentPane().setLayout(null);

        Consultas consultas = new Consultas();
        DefaultTableModel model = consultas.obtenerDatosTabla_doctores();

        // Crear la tabla usando el modelo
        table = new JTable(model);
        table.setBounds(20, 11, 754, 339);
        getContentPane().add(table);
    }
}