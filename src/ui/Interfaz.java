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
import java.awt.CardLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
	
public class Interfaz {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNombre;
	private CardLayout cc;
	private JPanel panelMenu;
	private JPanel panelCreacion, panelSeleccionPersonaje;
	private JLabel txtEnergia;
	private JLabel txtTotal ;
	private JLabel txtDefensa, txtAtaque, txtEvasion;
	private JSlider sliderDefensa, sliderEnergia, sliderEvasion, sliderAtaque;
	private int total = 200;
	
	
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
		cc = new CardLayout();
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cc);
		
		panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "panelMenu");
		panelMenu.setLayout(null);
		
		panelCreacion = new JPanel();
		frame.getContentPane().add(panelCreacion, "panelCreacion");
		panelCreacion.setLayout(null);
		
		
		JButton btbIniciarCreacion = new JButton("Administrar personajes");
		btbIniciarCreacion.setBounds(173, 71, 226, 23);
		panelMenu.add(btbIniciarCreacion);			
		btbIniciarCreacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarCreacion();
				panelMenu.setVisible(false);
				panelCreacion.setVisible(true);

			}
		});
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(173, 37, 226, 23);
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarCreacion();
				panelMenu.setVisible(false);
				panelSeleccionPersonaje.setVisible(true);

			}
		});
		panelMenu.add(btnJugar);
		
		JLabel txtInfo = new JLabel("");
		txtInfo.setBounds(603, 23, 0, 0);
		panelCreacion.add(txtInfo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnEliminar.setBounds(296, 312, 137, 23);
		panelCreacion.add(btnEliminar);
		btnEliminar.setForeground(Color.RED);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnCrear.setBounds(53, 312, 108, 23);
		panelCreacion.add(btnCrear);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnModificar.setBounds(165, 312, 121, 23);
		panelCreacion.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(458, 15, 108, 19);
		panelCreacion.add(btnBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 82, 145, 20);
		panelCreacion.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTotalrestante = new JLabel("Total/restante:");
		lblTotalrestante.setBounds(53, 267, 108, 19);
		panelCreacion.add(lblTotalrestante);
		lblTotalrestante.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblEvasion = new JLabel("Evasi\u00F3n");
		lblEvasion.setBounds(263, 228, 59, 26);
		panelCreacion.add(lblEvasion);
		lblEvasion.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(263, 190, 63, 27);
		panelCreacion.add(lblAtaque);
		lblAtaque.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(263, 156, 63, 19);
		panelCreacion.add(lblDefensa);
		lblDefensa.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(263, 113, 57, 29);
		panelCreacion.add(lblEnergia);
		lblEnergia.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(53, 81, 62, 19);
		panelCreacion.add(lblNombre);
		lblNombre.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(331, 15, 15, 19);
		panelCreacion.add(lblId);
		lblId.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		txtId = new JTextField();
		txtId.setToolTipText("");
		txtId.setBounds(356, 16, 92, 20);
		panelCreacion.add(txtId);
		txtId.setColumns(10);
		
		
		
		sliderEnergia = new JSlider();
		sliderEnergia.setValue(0);
		sliderEnergia.setMaximum(200);
		sliderEnergia.setBounds(63, 120, 137, 26);
		sliderEnergia.setMinorTickSpacing(1);
		sliderEnergia.setMajorTickSpacing(10);
		sliderEnergia.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
            	
                int current = ((JSlider)event.getSource()).getValue();
                txtEnergia.setText(String.valueOf(current));             
                
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtAtaque.getText())-Integer.parseInt(txtEvasion.getText())-Integer.parseInt(txtDefensa.getText())-current));
                
            }
        });
		panelCreacion.add(sliderEnergia);
		
		 txtEnergia = new JLabel("0");
		 txtEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		 txtEnergia.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtEnergia.setBounds(210, 113, 46, 29);
		panelCreacion.add(txtEnergia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 113, 283, 34);
		panelCreacion.add(separator);
		
		txtTotal = new JLabel("");
		txtTotal.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		txtTotal.setBounds(167, 264, 81, 24);
		panelCreacion.add(txtTotal);
		
		txtDefensa = new JLabel("0");
		txtDefensa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtDefensa.setBounds(210, 146, 46, 34);
		panelCreacion.add(txtDefensa);
		
		sliderDefensa = new JSlider();
		sliderDefensa.setValue(0);
		sliderDefensa.setMaximum(20);
		sliderDefensa.setBounds(63, 154, 137, 26);
		sliderDefensa.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int current = ((JSlider)event.getSource()).getValue();
                txtDefensa.setText(String.valueOf(current));
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtAtaque.getText())-Integer.parseInt(txtEvasion.getText())-Integer.parseInt(txtEnergia.getText())-current));

            }
        });
		panelCreacion.add(sliderDefensa);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 146, 283, 36);
		panelCreacion.add(separator_1);
		
		txtAtaque = new JLabel("0");
		txtAtaque.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtaque.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtAtaque.setBounds(210, 186, 45, 31);
		panelCreacion.add(txtAtaque);
		
		sliderAtaque = new JSlider();
		sliderAtaque.setValue(0);
		sliderAtaque.setMaximum(200);
		sliderAtaque.setBounds(63, 191, 137, 26);
		sliderAtaque.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int current = ((JSlider)event.getSource()).getValue();
                txtAtaque.setText(String.valueOf(current));
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtEnergia.getText())-Integer.parseInt(txtEvasion.getText())-Integer.parseInt(txtDefensa.getText())-current));

            }
        });
		panelCreacion.add(sliderAtaque);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 186, 284, 34);
		panelCreacion.add(separator_2);
		
		txtEvasion = new JLabel("0");
		txtEvasion.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtEvasion.setBounds(210, 228, 46, 26);
		panelCreacion.add(txtEvasion);
		
		sliderEvasion = new JSlider();
		sliderEvasion.setValue(0);
		sliderEvasion.setMaximum(80);
		sliderEvasion.setBounds(63, 228, 137, 26);
		sliderEvasion.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int current = ((JSlider)event.getSource()).getValue();
                txtEvasion.setText(String.valueOf(current));
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtAtaque.getText())-Integer.parseInt(txtEnergia.getText())-Integer.parseInt(txtDefensa.getText())-current));

            }
        });
		panelCreacion.add(sliderEvasion);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(52, 221, 284, 32);
		panelCreacion.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(53, 255, 284, 34);
		panelCreacion.add(separator_4);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		btnVolver.setBounds(10, 11, 57, 31);
		panelCreacion.add(btnVolver);
		
		panelSeleccionPersonaje = new JPanel();
		frame.getContentPane().add(panelSeleccionPersonaje, "name_491738062685251");
		panelSeleccionPersonaje.setLayout(null);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(303, 11, 292, 355);
		panelSeleccionPersonaje.add(separator_5);
		
		JButton btnVolver1 = new JButton("");
		btnVolver1.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		btnVolver1.setBounds(10, 11, 54, 35);
		btnVolver1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSeleccionPersonaje.setVisible(false);
				panelMenu.setVisible(true);
				limpiarCampos();
			}
		});
		panelSeleccionPersonaje.add(btnVolver1);
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelCreacion.setVisible(false);
				panelMenu.setVisible(true);
				limpiarCampos();
			}
		});
		
		
		
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
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
				
			}
		});
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
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
			notifyUser(txtNombre.getText() + " creado con éxito");
			MapearAFormulario(p);
			limpiarCampos();

			panelCreacion.setVisible(false);
			panelMenu.setVisible(true);
				
			}else{
				notifyUser("Nombre en uso");
			}
		}
	}

	private void limpiarCampos() {
		txtAtaque.setText("0");
		txtDefensa.setText("0");
		txtEnergia.setText("0");
		txtNombre.setText("");
		txtEvasion.setText("0");
		txtTotal.setText("");

		sliderAtaque.setValue(0);
		sliderDefensa.setValue(0);
		sliderEvasion.setValue(0);
		sliderEnergia.setValue(0);
		
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
		sliderEnergia.setValue((int) p.getEnergia());
		sliderDefensa.setValue((int) p.getDefensa());
		sliderAtaque.setValue((int) p.getAtaque());
		sliderEvasion.setValue((int) p.getEvasion());
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
