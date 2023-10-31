import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Jd_borrar_datos extends JDialog {
	Consultas consulta;
	JComboBox cb_tablas = new JComboBox();
	private JTable currentTable = null;

	private JTable table1=null;
	private JTable table2=null;
	private JTable table3=null;
	private JTable table4=null;
	private JTable table5=null;
	private JTable table6=null;
	private JTable table7=null;
	private JTable table8=null;
	private JTable table9=null;
	private JTable table10=null;
	private JTable table11=null;
	private JTable table12=null;
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jd_borrar_datos dialog = new Jd_borrar_datos();
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
	public Jd_borrar_datos() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(this);
		cb_tablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String tablaSeleccionada = (String) cb_tablas.getSelectedItem();
				 Consultas consultas = new Consultas();
				 
				// Muestra u oculta hasta la linea 531.
				 if (tablaSeleccionada.equals("usuario")) {
					 if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
					 DefaultTableModel model = consultas.obtenerDatosTabla_usuario();
					 table1 = new JTable(model);
				        table1.setBounds(20, 11, 754, 339);
				        getContentPane().add(table1);
					 
			        } else if (tablaSeleccionada.equals("tratamientos")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	
			        	DefaultTableModel model = consultas.obtenerDatosTabla_tratamientos();
			        	table2 = new JTable(model);
				        table2.setBounds(20, 11, 754, 339);
				        getContentPane().add(table2);
			           
			        } else if (tablaSeleccionada.equals("solicitud")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_solicitud();
			        	table3 = new JTable(model);
				        table3.setBounds(20, 11, 754, 339);
				        getContentPane().add(table3);
			           
			        } else if (tablaSeleccionada.equals("proveedor")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_proveedor();
			        	table4 = new JTable(model);
				        table4.setBounds(20, 11, 754, 339);
				        getContentPane().add(table4);
			        } else if (tablaSeleccionada.equals("pedidos")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_pedidos();
			        	table5 = new JTable(model);
				        table5.setBounds(20, 11, 754, 339);
				        getContentPane().add(table5);
			        } else if (tablaSeleccionada.equals("pacientes")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_pacientes();
			        	table6 = new JTable(model);
				        table6.setBounds(20, 11, 754, 339);
				        getContentPane().add(table6);
			        } else if (tablaSeleccionada.equals("inventario")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_inventario();
			        	table7 = new JTable(model);
				        table7.setBounds(20, 11, 754, 339);
				        getContentPane().add(table7);
			        } else if (tablaSeleccionada.equals("historial_pago")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_historial_pago();
			        	table8 = new JTable(model);
				        table8.setBounds(20, 11, 754, 339);
				        getContentPane().add(table8);
			        } else if (tablaSeleccionada.equals("facturacion")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_facturacion();
			        	table9 = new JTable(model);
				        table9.setBounds(20, 11, 754, 339);
				        getContentPane().add(table9);
			        } else if (tablaSeleccionada.equals("especialidades")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_especialidades();
			        	table10 = new JTable(model);
				        table10.setBounds(20, 11, 754, 339);
				        getContentPane().add(table10);
			        } else if (tablaSeleccionada.equals("doctores")) {
			        	if(table12!=null) {
			        		table12.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table1!=null) {
			        		table1.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_doctores();
			        	table11 = new JTable(model);
				        table11.setBounds(20, 11, 754, 339);
				        getContentPane().add(table11);
			        } else if (tablaSeleccionada.equals("citas")) {
			        	if(table1!=null) {
			        		table1.show(false);
			        	}
					 if(table2!=null) {
			        		table2.show(false);
			        	}
					 if(table3!=null) {
			        		table3.show(false);
			        	}
					 if(table4!=null) {
			        		table4.show(false);
			        	}
					 if(table5!=null) {
			        		table5.show(false);
			        	}
					 if(table6!=null) {
			        		table6.show(false);
			        	}
					 if(table7!=null) {
			        		table7.show(false);
			        	}
					 if(table8!=null) {
			        		table8.show(false);
			        	}
					 if(table9!=null) {
			        		table9.show(false);
			        	}
					 if(table10!=null) {
			        		table10.show(false);
			        	}
					 if(table11!=null) {
			        		table11.show(false);
			        	}
			        	DefaultTableModel model = consultas.obtenerDatosTabla_citas();
			        	table12 = new JTable(model);
				        table12.setBounds(20, 11, 754, 339);
				        getContentPane().add(table12);
			        }
				
				
			}
		});
		
		
		cb_tablas.setBounds(669, 328, 105, 22);
		getContentPane().add(cb_tablas);
		
		//Borra los valores introducidos por el diálogo con el usuario, pasando eso a nuestros "Deletes" instanciados desde la clase Consultas
		JButton btn_delete = new JButton("Borrar");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb_tablas.getSelectedItem().toString().equals("usuario")) {
				String borrar = JOptionPane.showInputDialog("Introduce el DNI del usuario que quieres borrar");
				Consultas consulta = new Consultas();		
				consulta.deleteUsuario(borrar);
				}
				else if(cb_tablas.getSelectedItem().toString().equals("doctores")) {
					String borrar = JOptionPane.showInputDialog("Introduce el DNI del doctor que quieres borrar");
					Consultas consulta = new Consultas();		
					consulta.deleteDoctor(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("tratamientos")) {
					String borrar = JOptionPane.showInputDialog("Introduce el id");
					Consultas consulta = new Consultas();		
					consulta.deleteTratamiento(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("citas")) {
					String borrar = JOptionPane.showInputDialog("Introduce el DNI del paciente");
					String borrar2 = JOptionPane.showInputDialog("Introduce la fecha en la que estuvo (AAAA-MM-DD)");
					Consultas consulta = new Consultas();		
					consulta.deleteCita(borrar,borrar2);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("facturacion")) {
					String borrar = JOptionPane.showInputDialog("Introduce el ID de la factura a borrar");
					Consultas consulta = new Consultas();		
					consulta.deleteFactura(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("historial_pago")) {
					String borrar = JOptionPane.showInputDialog("Introduce el DNI del paciente");
					String borrar2 = JOptionPane.showInputDialog("Introduce la fecha en la que pagó");
					Consultas consulta = new Consultas();		
					consulta.deletePago(borrar,borrar2);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("pacientes")) {
					String borrar = JOptionPane.showInputDialog("Introduce el DNI del paciente");
					Consultas consulta = new Consultas();		
					consulta.deletePaciente(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("especialidades")) {
					String borrar = JOptionPane.showInputDialog("Nombre de la especialidad a borrar");
					Consultas consulta = new Consultas();		
					consulta.deleteEspecialidad(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("solicitud")) {
					String borrar = JOptionPane.showInputDialog("Introduce el ID de la solicitud");
					Consultas consulta = new Consultas();		
					consulta.deleteSolicitud(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("pedidos")) {
					String borrar = JOptionPane.showInputDialog("Introduce el ID del pedido");
					Consultas consulta = new Consultas();		
					consulta.deletePedido(borrar);
					}
				else if(cb_tablas.getSelectedItem().toString().equals("proveedores")) {
					String borrar = JOptionPane.showInputDialog("Introduce el nombre del proveedor");
					Consultas consulta = new Consultas();		
					consulta.deleteProveedor(borrar);
					}
			}
		});
		btn_delete.setBounds(10, 328, 89, 23);
		getContentPane().add(btn_delete);
		
		

	}
	
	public JComboBox<String> getCb_tablas() {
        return cb_tablas;
    }

	 public void setCb_tablasItems(String items) {
	        cb_tablas.addItem(items); // Usa addItem en lugar de removeAllItems y luego addItem
	    }
}
