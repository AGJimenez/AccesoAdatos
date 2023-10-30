import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

public class Jd_verDatos extends JDialog implements TablaDatos {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;

    Consultas consulta;

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

        consulta = new Consultas();
        consulta.conectar();

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 764, 339);
        getContentPane().add(scrollPane);

    }

    @Override
    public void setDatos(List<String[]> datos) {
        model = new DefaultTableModel();
        for (String[] fila : datos) {
            model.addRow(fila);
        }
        table.setModel(model);
    }

    @Override
    public List<String[]> getDatos() {
        return null; // Puedes implementar esto según tus necesidades
    }
}