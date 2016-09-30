package ui;

import ctrl.*;
import data.DataPersonaje;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;
import javax.swing.JTextField;
import org.apache.logging.log4j.Level;

import entidades.Personaje;
import utils.SuperLogger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
	
public class Interfaz {

	private JFrame frame;
	private JFrame frame2;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtAtaque;
	private JTextField txtEvasion;
	private JTextField txtTotal;
	
	private ABMCPersonaje ctrl;

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
		ctrl= new ABMCPersonaje();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame2 = new JFrame();
		frame.setBounds(100, 100, 621, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(137, 29, 166, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblId.setBounds(28, 30, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblNombre.setBounds(28, 63, 96, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblEnergia = new JLabel("Energia:");
		lblEnergia.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblEnergia.setBounds(28, 88, 79, 18);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblDefensa.setBounds(28, 117, 79, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblAtaque = new JLabel("Ataque:");
		lblAtaque.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblAtaque.setBounds(28, 142, 79, 19);
		frame.getContentPane().add(lblAtaque);
		
		JLabel lblEvasion = new JLabel("Evasi\u00F3n:");
		lblEvasion.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblEvasion.setBounds(28, 167, 79, 14);
		frame.getContentPane().add(lblEvasion);
		
		JLabel lblTotalrestante = new JLabel("Total/restante:");
		lblTotalrestante.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblTotalrestante.setBounds(28, 192, 125, 14);
		frame.getContentPane().add(lblTotalrestante);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(137, 62, 265, 20);
		frame.getContentPane().add(txtNombre);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(157, 89, 32, 20);
		frame.getContentPane().add(txtEnergia);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(157, 116, 32, 20);
		frame.getContentPane().add(txtDefensa);
		
		txtAtaque = new JTextField();
		txtAtaque.setColumns(10);
		txtAtaque.setBounds(157, 143, 32, 20);
		frame.getContentPane().add(txtAtaque);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(157, 166, 32, 20);
		frame.getContentPane().add(txtEvasion);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(137, 191, 265, 20);
		frame.getContentPane().add(txtTotal);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		btnBuscar.setBounds(313, 28, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		btnCrear.setBounds(28, 260, 125, 23);
		frame.getContentPane().add(btnCrear);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(163, 232, 125, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.RED);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(298, 232, 102, 23);
		frame.getContentPane().add(btnEliminar);
		
		JLabel txtInfo = new JLabel("");
		txtInfo.setBounds(28, 294, 372, 14);
		frame.getContentPane().add(txtInfo);
		
		
		
		JButton btnMenosE = new JButton("");
		btnMenosE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(txtEnergia.getText())!=0){
					txtEnergia.setText(String.valueOf(Integer.parseInt(txtEnergia.getText())-1));

					txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())+1));
				}
			}
		});
		btnMenosE.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		btnMenosE.setBounds(133, 89, 20, 20);
		frame.getContentPane().add(btnMenosE);
		
		
		
		
		JButton btbIniciarCreacion = new JButton("Iniciar Creacion");
		btbIniciarCreacion.setBounds(28, 232, 125, 23);
		frame.getContentPane().add(btbIniciarCreacion);
		
		
		
		JButton btbMenosD = new JButton("");
		btbMenosD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(txtDefensa.getText())!=0){
					txtDefensa.setText(String.valueOf(Integer.parseInt(txtDefensa.getText())-1));

					txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())+1));
				}
			}
		});
		btbMenosD.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		btbMenosD.setBounds(133, 115, 20, 20);
		frame.getContentPane().add(btbMenosD);
		
		
		
		JButton btnMenosA = new JButton("");
		btnMenosA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(txtAtaque.getText())!=0){
					txtAtaque.setText(String.valueOf(Integer.parseInt(txtAtaque.getText())-1));

					txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())+1));
				}
			}
		});
		btnMenosA.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		btnMenosA.setBounds(133, 142, 20, 20);
		frame.getContentPane().add(btnMenosA);
		
		
		
		JButton btnMenosEv = new JButton("");
		btnMenosEv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(txtEvasion.getText())!=0){
					txtEvasion.setText(String.valueOf(Integer.parseInt(txtEvasion.getText())-1));

					txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())+1));
				}
			}
		});
		btnMenosEv.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		btnMenosEv.setBounds(133, 165, 20, 20);
		frame.getContentPane().add(btnMenosEv);
		
		JButton btnMasEn = new JButton("");
		btnMasEn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtEnergia.setText(String.valueOf(Float.parseFloat(txtEnergia.getText())+1));
				txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())-1));
			}
		});
		btnMasEn.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		btnMasEn.setBounds(197, 90, 20, 20);
		frame.getContentPane().add(btnMasEn);
		
		
		
		
		JButton btnMasD = new JButton("");
		btnMasD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(txtDefensa.getText())!=20){
					txtDefensa.setText(String.valueOf(Integer.parseInt(txtDefensa.getText())+1));
					txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())-1));
				}
			}
		});
		btnMasD.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		btnMasD.setBounds(197, 116, 20, 20);
		frame.getContentPane().add(btnMasD);
		
		
		
		
		JButton btnMasA = new JButton("");
		btnMasA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtAtaque.setText(String.valueOf(Integer.parseInt(txtAtaque.getText())+1));
				txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())-1));
			}
		});
		btnMasA.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		btnMasA.setBounds(197, 143, 20, 20);
		frame.getContentPane().add(btnMasA);
		
		
		
		JButton btnMasEv = new JButton("");
		btnMasEv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(txtEvasion.getText())!=80){
					txtEvasion.setText(String.valueOf(Integer.parseInt(txtEvasion.getText())+1));
					txtTotal.setText(String.valueOf(Integer.parseInt(txtTotal.getText())-1));
				}
			}
		});
		btnMasEv.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		btnMasEv.setBounds(197, 166, 20, 20);
		frame.getContentPane().add(btnMasEv);
		btbIniciarCreacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarCreacion();
			}
		});
	}
	
	protected void eliminar() {
		ctrl.delete(MapearDeFormularioId());
		limpiarCampos();
	}

	protected void modificar() {
		try {
			ctrl.update(MapearDeFormularioConId());
			notifyUser("Personaje: " + txtNombre.getText() + " modificado con éxito!");
			limpiarCampos();
		} catch (ArithmeticException are){
			notifyUser("Ha ocurrido algo inesperado, consulte al administrador de sistemas.", are, Level.ERROR);
		} catch (Exception e){
			notifyUser("Ha ocurrido algo totalmente inesperado, consulte al administrador de sistemas.",e, Level.FATAL);
		} 
	}

	private Personaje MapearDeFormularioConId() {
		// TODO Auto-generated method stub
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtId.getText()));
		p.setNombre(txtNombre.getText());
		p.setEnergia(Float.parseFloat(txtEnergia.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setAtaque(Integer.parseInt(txtAtaque.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setPuntosTotales(Integer.parseInt(txtTotal.getText()));
		return p;
	}

	private void iniciarCreacion(){
		txtTotal.setText("200");
		txtEnergia.setText("0");
		txtDefensa.setText("0");
		txtEvasion.setText("0");
		txtAtaque.setText("0");
	}
	
	protected void agregar() {
		if(datosValidos()){
			Personaje p=MapearDeFormulario();
			if(DataPersonaje.verificarNombre(p)){
			ctrl.add(p);
			MapearAFormulario(p);
			//limpiarCampos();
			}else{
				notifyUser("Nombre en uso");
			}
		}
	}

	private void limpiarCampos() {
		txtAtaque.setText("");
		txtDefensa.setText("");
		txtEnergia.setText("");
		txtNombre.setText("");
		txtEvasion.setText("");
		txtTotal.setText("");
	}

	protected void buscar() {
		Personaje p = ctrl.getPersonaje(MapearDeFormularioId());
		if(p!=null){
			MapearAFormulario(p);
		}else{
			notifyUser("Personaje con id: "+txtId.getText() + " no encontrado");
		}
	}

	private Personaje MapearDeFormularioId() {
		// TODO Auto-generated method stub
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtId.getText()));
		return p;
	}

	public void MapearAFormulario(Personaje p){
		if(p.getId()>0) txtId.setText(String.valueOf(p.getId()));
		
		txtAtaque.setText(String.valueOf( p.getAtaque()));
		txtNombre.setText(p.getNombre());
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		txtTotal.setText(String.valueOf(p.getPuntosTotales()));
	}
	
	
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		p.setNombre(txtNombre.getText());
		p.setEnergia(Float.parseFloat(txtEnergia.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setAtaque(Integer.parseInt(txtAtaque.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setPuntosTotales(Integer.parseInt(txtTotal.getText()));
		
		return p;
	}
	
	public boolean datosValidos(){
		boolean valido=true;
		if(txtId.getText().trim().length()==0
			|| txtNombre.getText().trim().length()==0){
			valido=false;
			notifyUser("Complete todos los campos");
		}
		if(valido && !txtId.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("ID inválido");
		}
			
		return valido;
	}
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);		
	}

	private void notifyUser(String mensaje, Exception e, Level l) {
		notifyUser(mensaje);
		SuperLogger.logger.log(l, mensaje, e);
	}
}
