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

public class Jd_actualizarDatos extends JDialog {
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
					Jd_actualizarDatos dialog = new Jd_actualizarDatos();
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
	public Jd_actualizarDatos() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(null);
		cb_tablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String tablaSeleccionada = (String) cb_tablas.getSelectedItem();
				 Consultas consultas = new Consultas();
				 
				// Lógica para generar dinámicamente los campos en función de la tabla seleccionada
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
		
		JButton btn_actualizar = new JButton("Actualizar");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb_tablas.getSelectedItem().toString().equals("usuario")) {
					int selectedRow = table1.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI_usuario = table1.getValueAt(selectedRow, 0).toString();
				        String nuevo_rol = table1.getValueAt(selectedRow, 1).toString(); // 
				        String nuevo_contraseña = table1.getValueAt(selectedRow, 2).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizarUsuario(DNI_usuario, nuevo_rol, nuevo_contraseña);
				    }
				}
				else if(cb_tablas.getSelectedItem().toString().equals("doctores")) {
					int selectedRow = table11.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI_doctor = table11.getValueAt(selectedRow, 0).toString();
				        String nuevo_nombre = table11.getValueAt(selectedRow, 1).toString(); // 
				        String nuevo_apellidos = table11.getValueAt(selectedRow, 2).toString();
				        String nuevo_nacimiento = table11.getValueAt(selectedRow, 3).toString();
				        String nuevo_genero = table11.getValueAt(selectedRow, 4).toString();
				        String nuevo_estado = table11.getValueAt(selectedRow, 5).toString();
				        String nuevo_telefono = table11.getValueAt(selectedRow, 6).toString();
				        String nuevo_correo = table11.getValueAt(selectedRow, 7).toString();
				        String nuevo_direccion = table11.getValueAt(selectedRow, 8).toString();
				        String nuevo_especialidad = table11.getValueAt(selectedRow, 9).toString();
				        String nuevo_salario = table11.getValueAt(selectedRow, 10).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_doctores(DNI_doctor, nuevo_nombre, nuevo_apellidos, nuevo_nacimiento, nuevo_genero, nuevo_estado, nuevo_telefono, nuevo_correo, nuevo_direccion, nuevo_especialidad, nuevo_salario);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("tratamientos")) {
					int selectedRow = table2.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI_paciente = table2.getValueAt(selectedRow, 0).toString();
				        String nuevo_doctor = table2.getValueAt(selectedRow, 1).toString(); // 
				        String nuevo_a_pagar = table2.getValueAt(selectedRow, 2).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_tratamientos(DNI_paciente, nuevo_doctor, nuevo_a_pagar);
				    }
					}
				else if (cb_tablas.getSelectedItem().toString().equals("citas")) {
				    int selectedRow = table12.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI_paciente = table12.getValueAt(selectedRow, 0).toString();
				        String nuevoDNI_doctor = table12.getValueAt(selectedRow, 1).toString(); // 
				        String nuevaFecha = table12.getValueAt(selectedRow, 2).toString();
				        String nuevaEspecialidad = table12.getValueAt(selectedRow, 3).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizarCita(DNI_paciente, nuevoDNI_doctor, nuevaFecha, nuevaEspecialidad);
				    }
				}
				else if(cb_tablas.getSelectedItem().toString().equals("facturacion")) {
					int selectedRow = table9.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI = table9.getValueAt(selectedRow, 0).toString();
				        String nuevo_nombre = table9.getValueAt(selectedRow, 1).toString(); // 
				        String nuevo_apellidos = table9.getValueAt(selectedRow, 2).toString();
				        String nuevo_tratamiento = table9.getValueAt(selectedRow, 3).toString();
				        String nuevo_telefono = table9.getValueAt(selectedRow, 4).toString();
				        String nuevo_fecha = table9.getValueAt(selectedRow, 5).toString();
				        String nuevo_pagado = table9.getValueAt(selectedRow, 6).toString();
				        String nuevo_por_pagar = table9.getValueAt(selectedRow, 7).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_facturacion(DNI, nuevo_nombre, nuevo_apellidos, nuevo_tratamiento, nuevo_telefono, nuevo_fecha, nuevo_pagado, nuevo_por_pagar);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("historial_pago")) {
					int selectedRow = table8.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI = table8.getValueAt(selectedRow, 0).toString();
				        String nuevo_cantidad = table8.getValueAt(selectedRow, 1).toString(); // 
				        String nuevo_fecha = table8.getValueAt(selectedRow, 2).toString();
				        String nuevo_tipo = table8.getValueAt(selectedRow, 3).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_historial_pago(DNI, nuevo_cantidad, nuevo_fecha, nuevo_tipo);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("pacientes")) {
					int selectedRow = table6.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI_paciente = table6.getValueAt(selectedRow, 0).toString();
				        String nuevo_nombre = table6.getValueAt(selectedRow, 1).toString(); // 
				        String nuevo_apellidos = table6.getValueAt(selectedRow, 2).toString();
				        String nuevo_nacimiento = table6.getValueAt(selectedRow, 3).toString();
				        String nuevo_genero = table6.getValueAt(selectedRow, 4).toString();
				        String nuevo_estado = table6.getValueAt(selectedRow, 5).toString();
				        String nuevo_telefono = table6.getValueAt(selectedRow, 6).toString();
				        String nuevo_correo = table6.getValueAt(selectedRow, 7).toString();
				        String nuevo_direccion = table6.getValueAt(selectedRow, 8).toString();
				        String nuevo_seguro = table6.getValueAt(selectedRow, 9).toString();
				        String nuevo_observacion = table6.getValueAt(selectedRow, 10).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_pacientes(DNI_paciente, nuevo_nombre, nuevo_apellidos, nuevo_nacimiento, nuevo_genero, nuevo_estado, nuevo_telefono, nuevo_correo, nuevo_direccion, nuevo_seguro, nuevo_observacion);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("especialidades")) {
					int selectedRow = table10.getSelectedRow();
				    if (selectedRow != -1) {
				        String Nombre_especialidades = table10.getValueAt(selectedRow, 0).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_especialidades(Nombre_especialidades);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("solicitud")) {
					int selectedRow = table3.getSelectedRow();
				    if (selectedRow != -1) {
				        String DNI = table3.getValueAt(selectedRow, 0).toString();
				        String Cantidad = table3.getValueAt(selectedRow, 1).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_solicitud(DNI, Cantidad);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("pedidos")) {
					int selectedRow = table5.getSelectedRow();
				    if (selectedRow != -1) {
				        String ID_pedido = table5.getValueAt(selectedRow, 0).toString();
				        String Producto = table5.getValueAt(selectedRow, 1).toString();
				        String Cantidad = table5.getValueAt(selectedRow, 2).toString();
				        String Precio = table5.getValueAt(selectedRow, 3).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_pedidos(ID_pedido, Producto, Cantidad, Precio);
				    }
					}
				else if(cb_tablas.getSelectedItem().toString().equals("proveedores")) {
					int selectedRow = table4.getSelectedRow();
				    if (selectedRow != -1) {
				        String ID_producto = table4.getValueAt(selectedRow, 0).toString();
				        String Proveedor = table4.getValueAt(selectedRow, 1).toString();

				        Consultas consulta = new Consultas();
				        consulta.actualizar_proveedor(ID_producto, Proveedor);
				    }
					}
			}
		});
		btn_actualizar.setBounds(10, 328, 89, 23);
		getContentPane().add(btn_actualizar);
		
		

	}
	
	
	
	public JComboBox<String> getCb_tablas() {
        return cb_tablas;
    }

	 public void setCb_tablasItems(String items) {
	        cb_tablas.addItem(items); // Usa addItem en lugar de removeAllItems y luego addItem
	    }
}
