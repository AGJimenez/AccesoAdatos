import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

public class Jd_verDatos extends JDialog {
	Consultas consulta;
	JComboBox cb_tablas = new JComboBox();
	private static final long serialVersionUID = 1L;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JTextField txt11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jd_verDatos dialog = new Jd_verDatos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		JPanel panelContenedor = new JPanel();
		panelContenedor.setBackground(Color.WHITE);
		panelContenedor.setBounds(10, 44, 764, 256);
		getContentPane().add(panelContenedor);
		panelContenedor.setLayout(null);
		
		JLabel lb1 = new JLabel("DNI_usuario");
		lb1.setFont(new Font("Arial", Font.PLAIN, 14));
		lb1.setBounds(21, 17, 69, 14);
		panelContenedor.add(lb1);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Arial", Font.PLAIN, 14));
		txt1.setText("dni");
		txt1.setBounds(100, 14, 86, 20);
		panelContenedor.add(txt1);
		txt1.setColumns(10);
		
		JLabel lb2 = new JLabel("DNI_usuario");
		lb2.setFont(new Font("Arial", Font.PLAIN, 14));
		lb2.setBounds(21, 45, 69, 14);
		panelContenedor.add(lb2);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Arial", Font.PLAIN, 14));
		txt2.setText("dni");
		txt2.setColumns(10);
		txt2.setBounds(100, 42, 86, 20);
		panelContenedor.add(txt2);
		
		JLabel lb3 = new JLabel("DNI_usuario");
		lb3.setFont(new Font("Arial", Font.PLAIN, 14));
		lb3.setBounds(21, 73, 69, 14);
		panelContenedor.add(lb3);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Arial", Font.PLAIN, 14));
		txt3.setText("dni");
		txt3.setColumns(10);
		txt3.setBounds(100, 70, 86, 20);
		panelContenedor.add(txt3);
		
		JLabel lb4 = new JLabel("DNI_usuario");
		lb4.setFont(new Font("Arial", Font.PLAIN, 14));
		lb4.setBounds(21, 101, 69, 14);
		panelContenedor.add(lb4);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Arial", Font.PLAIN, 14));
		txt4.setText("dni");
		txt4.setColumns(10);
		txt4.setBounds(100, 98, 86, 20);
		panelContenedor.add(txt4);
		
		JLabel lb5 = new JLabel("DNI_usuario");
		lb5.setFont(new Font("Arial", Font.PLAIN, 14));
		lb5.setBounds(21, 129, 69, 14);
		panelContenedor.add(lb5);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Arial", Font.PLAIN, 14));
		txt5.setText("dni");
		txt5.setColumns(10);
		txt5.setBounds(100, 126, 86, 20);
		panelContenedor.add(txt5);
		
		JLabel lb6 = new JLabel("DNI_usuario");
		lb6.setFont(new Font("Arial", Font.PLAIN, 14));
		lb6.setBounds(21, 157, 69, 14);
		panelContenedor.add(lb6);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Arial", Font.PLAIN, 14));
		txt6.setText("dni");
		txt6.setColumns(10);
		txt6.setBounds(100, 154, 86, 20);
		panelContenedor.add(txt6);
		
		JLabel lb7 = new JLabel("DNI_usuario");
		lb7.setFont(new Font("Arial", Font.PLAIN, 14));
		lb7.setBounds(196, 14, 69, 14);
		panelContenedor.add(lb7);
		
		txt7 = new JTextField();
		txt7.setFont(new Font("Arial", Font.PLAIN, 14));
		txt7.setText("dni");
		txt7.setColumns(10);
		txt7.setBounds(275, 11, 86, 20);
		panelContenedor.add(txt7);
		
		JLabel lb8 = new JLabel("DNI_usuario");
		lb8.setFont(new Font("Arial", Font.PLAIN, 14));
		lb8.setBounds(196, 42, 69, 14);
		panelContenedor.add(lb8);
		
		txt8 = new JTextField();
		txt8.setFont(new Font("Arial", Font.PLAIN, 14));
		txt8.setText("dni");
		txt8.setColumns(10);
		txt8.setBounds(275, 39, 86, 20);
		panelContenedor.add(txt8);
		
		JLabel lb9 = new JLabel("DNI_usuario");
		lb9.setFont(new Font("Arial", Font.PLAIN, 14));
		lb9.setBounds(196, 73, 69, 14);
		panelContenedor.add(lb9);
		
		txt9 = new JTextField();
		txt9.setFont(new Font("Arial", Font.PLAIN, 14));
		txt9.setText("dni");
		txt9.setColumns(10);
		txt9.setBounds(275, 70, 86, 20);
		panelContenedor.add(txt9);
		
		JLabel lb10 = new JLabel("DNI_usuario");
		lb10.setFont(new Font("Arial", Font.PLAIN, 14));
		lb10.setBounds(196, 98, 69, 14);
		panelContenedor.add(lb10);
		
		txt10 = new JTextField();
		txt10.setFont(new Font("Arial", Font.PLAIN, 14));
		txt10.setText("dni");
		txt10.setColumns(10);
		txt10.setBounds(275, 95, 86, 20);
		panelContenedor.add(txt10);
		
		JLabel lb11 = new JLabel("DNI_usuario");
		lb11.setFont(new Font("Arial", Font.PLAIN, 14));
		lb11.setBounds(196, 126, 69, 14);
		panelContenedor.add(lb11);
		
		txt11 = new JTextField();
		txt11.setFont(new Font("Arial", Font.PLAIN, 14));
		txt11.setText("dni");
		txt11.setColumns(10);
		txt11.setBounds(275, 123, 86, 20);
		panelContenedor.add(txt11);
		cb_tablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String tablaSeleccionada = (String) cb_tablas.getSelectedItem();
				
				 
				// Lógica para generar dinámicamente los campos en función de la tabla seleccionada
				 if (tablaSeleccionada.equals("usuario")) {
					 
					mostrarUsuario(lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11);
					 	
					 
			        } else if (tablaSeleccionada.equals("tratamientos")) {
			        	
			        	mostrarTratamiento(lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11);
			           
			        } else if (tablaSeleccionada.equals("solicitud")) {
						 mostrarSolicitudes(lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11);
			           
			        } else if (tablaSeleccionada.equals("proveedor")) {
			        	mostrarProveedor(lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11);
			           
			        } else if (tablaSeleccionada.equals("pedidos")) {
			          
			        } else if (tablaSeleccionada.equals("pacientes")) {
			           
			        } else if (tablaSeleccionada.equals("inventario")) {
			           
			        } else if (tablaSeleccionada.equals("historial_pago")) {
			           
			        } else if (tablaSeleccionada.equals("facturacion")) {
			           
			        } else if (tablaSeleccionada.equals("especialidades")) {
			           
			        } else if (tablaSeleccionada.equals("doctores")) {
			           
			        } else if (tablaSeleccionada.equals("citas")) {
			            
			        }
				panelContenedor.revalidate();
				
			}

			public void mostrarSolicitudes(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4, JLabel lb5, JLabel lb6,
					JLabel lb7, JLabel lb8, JLabel lb9, JLabel lb10, JLabel lb11) {
				lb1.setText("ID_producto");
				 txt1.setText("");
				 lb2.setText("DNI_doctor");
				 txt2.setText("");
				 lb3.setText("Cantidad");
				 txt3.setText("");
				 				 
				 lb4.setVisible(false);
				 txt4.setVisible(false);
				 lb5.setVisible(false);
				 txt5.setVisible(false);
				 lb6.setVisible(false);
				 txt6.setVisible(false);
				 lb7.setVisible(false);
				 txt7.setVisible(false);
				 lb8.setVisible(false);
				 txt8.setVisible(false);
				 lb9.setVisible(false);
				 txt9.setVisible(false);
				 lb10.setVisible(false);
				 txt10.setVisible(false);
				 lb11.setVisible(false);
				 txt11.setVisible(false);
			}

			public void mostrarTratamiento(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4, JLabel lb5, JLabel lb6,
					JLabel lb7, JLabel lb8, JLabel lb9, JLabel lb10, JLabel lb11) {
				lb1.setText("ID_tratamiento");
				 txt1.setText("");
				 lb2.setText("DNI_paciente");
				 txt2.setText("");
				 lb3.setText("Dcotor");
				 txt3.setText("");			
				 lb4.setVisible(true);
				 lb4.setText("A pagar");
				 txt4.setVisible(true);
				 txt4.setText("");
				 lb5.setVisible(false);
				 txt5.setVisible(false);
				 lb6.setVisible(false);
				 txt6.setVisible(false);
				 lb7.setVisible(false);
				 txt7.setVisible(false);
				 lb8.setVisible(false);
				 txt8.setVisible(false);
				 lb9.setVisible(false);
				 txt9.setVisible(false);
				 lb10.setVisible(false);
				 txt10.setVisible(false);
				 lb11.setVisible(false);
				 txt11.setVisible(false);
			}

			public void mostrarUsuario(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4, JLabel lb5, JLabel lb6,
					JLabel lb7, JLabel lb8, JLabel lb9, JLabel lb10, JLabel lb11) {
				lb1.setText("DNI_usuario");
				 txt1.setText("");
				 lb2.setText("Contraseña");
				 txt2.setText("");
				 lb3.setText("Rol");
				 txt3.setText("");
				 				 
				 lb4.setVisible(false);
				 txt4.setVisible(false);
				 lb5.setVisible(false);
				 txt5.setVisible(false);
				 lb6.setVisible(false);
				 txt6.setVisible(false);
				 lb7.setVisible(false);
				 txt7.setVisible(false);
				 lb8.setVisible(false);
				 txt8.setVisible(false);
				 lb9.setVisible(false);
				 txt9.setVisible(false);
				 lb10.setVisible(false);
				 txt10.setVisible(false);
				 lb11.setVisible(false);
				 txt11.setVisible(false);
			}
			
			public void mostrarProveedor(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4, JLabel lb5, JLabel lb6,
					JLabel lb7, JLabel lb8, JLabel lb9, JLabel lb10, JLabel lb11) {
				lb1.setText("DNI_usuario");
				 txt1.setText("");
				 lb2.setText("Contraseña");
				 txt2.setText("");
				 lb3.setText("Rol");
				 txt3.setText("");
				 				 
				 lb4.setVisible(false);
				 txt4.setVisible(false);
				 lb5.setVisible(false);
				 txt5.setVisible(false);
				 lb6.setVisible(false);
				 txt6.setVisible(false);
				 lb7.setVisible(false);
				 txt7.setVisible(false);
				 lb8.setVisible(false);
				 txt8.setVisible(false);
				 lb9.setVisible(false);
				 txt9.setVisible(false);
				 lb10.setVisible(false);
				 txt10.setVisible(false);
				 lb11.setVisible(false);
				 txt11.setVisible(false);
			}
		});
		
		
		cb_tablas.setBounds(669, 11, 105, 22);
		getContentPane().add(cb_tablas);
		
		

	}
	
	public JComboBox<String> getCb_tablas() {
        return cb_tablas;
    }

	 public void setCb_tablasItems(String items) {
	        cb_tablas.addItem(items); // Usa addItem en lugar de removeAllItems y luego addItem
	    }
}
