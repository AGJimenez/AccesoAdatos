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
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Ejecutar app.
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
	 * Crear el Frame
	 */
	public Interfaz() {
		//Constructor de consultas, incluyendo todos los valores
		Consultas conectar = new Consultas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(63, 63, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		JButton btnNewButton = new JButton("Insertar datos");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(32, 53, 153, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar datos");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(32, 123, 153, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrar datos");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(32, 89, 153, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mostrar datos");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(32, 157, 153, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Total de usuarios");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(32, 259, 153, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btn_tratamiento = new JButton("Mostrar tratamiento");
		btn_tratamiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_tratamiento.setBackground(new Color(255, 255, 255));
		btn_tratamiento.setBorder(null);
		btn_tratamiento.setBounds(32, 191, 153, 23);
		contentPane.add(btn_tratamiento);
		
		JButton btnNewButton_6 = new JButton("Buscar paciente");
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setBounds(32, 225, 153, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setFocusPainted(false);
		btnNewButton_7.setDefaultCapable(false);
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setOpaque(false);
		btnNewButton_7.setIcon(new ImageIcon(Interfaz.class.getResource("/iconos_menus/conectIcon.png")));
		btnNewButton_7.setBounds(31, 11, 36, 31);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_9.setOpaque(false);
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.setIcon(new ImageIcon(Interfaz.class.getResource("/iconos_menus/discIcon.png")));
		btnNewButton_9.setBounds(143, 11, 42, 31);
		contentPane.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectar.desconectar();
					JOptionPane.showMessageDialog(null, "Base de datos cerrada, saliendo...");
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conectar.conectar();
				JOptionPane.showMessageDialog(null, "Abriendo base de datos...");
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas consulta = new Consultas();
				consulta.conectar();
				String nombre = JOptionPane.showInputDialog("Introduce un nombre o el comienzo de el para buscar coincidencias");
				String resultado = consulta.buscarPacientePorNombre(nombre);
				JOptionPane.showMessageDialog(null, "Coincidencias:\n"+resultado);
				
				//Busca coincidencias con el nombre introducido
			}
		});
		btn_tratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultas consulta = new Consultas();
				String resultado = consulta.mostrarConsulta();
				JOptionPane.showMessageDialog(null, "Coincidencias:\n"+resultado);
			}
			//Muestra las los pacientes y su cita asignada mediante un JOIN, con el correspondiente tratamiento.
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Consultas consulta = new Consultas();
				consulta.conectar();
				
                String resultado = consulta.numeroUsuarios();
              JOptionPane.showMessageDialog(null, "El número total de usuarios es:\n " + resultado);

				//Ejecuta la función "Total de usuarios" agrupando en el tipo de usuario y contando cuántos hay de cada uno
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jd_verDatos mostrar = new Jd_verDatos();
				try {
                    conectar.selectTablasMostrar(mostrar); // Llama al método verTablas y pasa la instancia de Jd_verDatos
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
				mostrar.setVisible(true);
				//MOSTRAR DATOS
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jd_borrar_datos mostrar = new Jd_borrar_datos();
				try {
                    conectar.insertarTablasMostrar_borrar(mostrar); // Permite ver los datos y borrar los que queramos
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
				mostrar.setVisible(true);
				//MOSTRAR DATOS
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Jd_actualizarDatos datos = new Jd_actualizarDatos();
				datos.setVisible(true);
				try {
                    conectar.modificarTablasMostrar(datos); // permite cargar tablas y actualizar sus celdas
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
				datos.setVisible(true);
				//MOSTRAR DATOS
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jd_insertarDatos mostrar = new Jd_insertarDatos();
				try {
                    conectar.insertarTablasMostrar(mostrar); // Al pulsar los botones, aparecen las tablas en un CB y permite insertar valores 
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
				mostrar.setVisible(true);
				//MOSTRAR DATOS
			}
		});
	}
}
