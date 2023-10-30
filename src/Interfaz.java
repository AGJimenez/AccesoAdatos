import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		Consultas conectar = new Consultas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 11, 1244, 552);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 572, 1244, 98);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Insertar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jd_insertarDatos mostrar = new Jd_insertarDatos();
				try {
                    conectar.insertarTablasMostrar(mostrar); // Llama al método verTablas y pasa la instancia de Jd_verDatos
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
				mostrar.setVisible(true);
				//MOSTRAR DATOS
			}
		});
		btnNewButton.setBounds(10, 11, 112, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Object[] options = {"usuario", "citas", "doctores", "pacientes", "facturacion", "especialidades", "tratamientos", "proveedor", "pedidos", "solicitud", "inventario", "historial_pago"};
		        int choice = JOptionPane.showOptionDialog(null, "Selecciona un valor", "Opción",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		                null, options, options[0]);

		     // En tu acción de botón existente
		        if (choice != JOptionPane.CLOSED_OPTION) {
		            String selectedValue = options[choice].toString();
		            System.out.println("Valor seleccionado: " + selectedValue);

		            Consultas consultas = new Consultas();
					consultas.conectar();
           
					Jd_verDatos dialog = new Jd_verDatos();
					dialog.setVisible(true);
		        }

				//MOSTRAR DATOS
			}
		});
		btnNewButton_1.setBounds(156, 11, 120, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrar datos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jd_borrar_datos mostrar = new Jd_borrar_datos();
				try {
                    conectar.insertarTablasMostrar_borrar(mostrar); // Llama al método verTablas y pasa la instancia de Jd_verDatos
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
				mostrar.setVisible(true);
				//MOSTRAR DATOS
			}
		});
		btnNewButton_2.setBounds(310, 11, 112, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mostrar datos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jd_verDatos mostrar = new Jd_verDatos();
				
				mostrar.setVisible(true);
				//MOSTRAR DATOS
				
			}
		});
		btnNewButton_3.setBounds(454, 11, 112, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Total de usuarios");
		btnNewButton_4.setBounds(600, 11, 120, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Total género");
		btnNewButton_5.setBounds(764, 11, 120, 23);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Buscar usuario");
		btnNewButton_6.setBounds(938, 11, 103, 23);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Conectar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conectar.conectar();
			}
		});
		btnNewButton_7.setBounds(454, 64, 112, 23);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Sueldo medio");
		btnNewButton_8.setBounds(1104, 11, 112, 23);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Desconectar");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectar.desconectar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_9.setBounds(602, 64, 118, 23);
		panel_1.add(btnNewButton_9);
		
		JButton btn_tratamiento = new JButton("Mostrar tratamiento");
		btn_tratamiento.setBounds(764, 64, 129, 23);
		panel_1.add(btn_tratamiento);
	}
}
