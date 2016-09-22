package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
	
public class Interfaz {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(110, 27, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(28, 30, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 55, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblEnergia = new JLabel("Energia:");
		lblEnergia.setBounds(28, 88, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setBounds(28, 117, 46, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblAtaque = new JLabel("Ataque:");
		lblAtaque.setBounds(28, 142, 46, 14);
		frame.getContentPane().add(lblAtaque);
		
		JLabel lblEvasion = new JLabel("Evasi\u00F3n:");
		lblEvasion.setBounds(28, 167, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		JLabel lblTotalrestante = new JLabel("Total/restante:");
		lblTotalrestante.setBounds(28, 192, 79, 14);
		frame.getContentPane().add(lblTotalrestante);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 58, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 85, 86, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 114, 86, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 139, 86, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(110, 164, 86, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(110, 189, 86, 20);
		frame.getContentPane().add(textField_6);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(220, 26, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(28, 232, 89, 23);
		frame.getContentPane().add(btnCrear);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(132, 232, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(232, 232, 89, 23);
		frame.getContentPane().add(btnEliminar);
	}
}
