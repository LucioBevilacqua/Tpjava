package ui;

import ctrl.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.SystemColor;;
	
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
	private Choice choice;
	private Choice choice2;
	private JSlider sliderA1,sliderEv1,sliderE1,sliderD1, sliderEv2,sliderE2,sliderD2,sliderA2;
	
	
	private ABMCPersonaje ctrl;
	private JLabel labelD1,labelA1,labelEv1,labelEv2,labelEn1,labelEn2,labelD2,labelA2;

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
		frame.setBounds(100, 100, 669, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cc);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panelMenu, "panelMenu");
		
		panelCreacion = new JPanel();
		frame.getContentPane().add(panelCreacion, "panelCreacion");
		panelCreacion.setLayout(null);
		panelMenu.setLayout(null);
		
		
		JButton btbIniciarCreacion = new JButton("Administrar personajes");
		btbIniciarCreacion.setBounds(134, 102, 384, 49);
		btbIniciarCreacion.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 22));
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
		btnJugar.setBounds(134, 37, 384, 49);
		btnJugar.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 22));
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarCreacion();
				panelMenu.setVisible(false);
				panelSeleccionPersonaje.setVisible(true);
				cargarNombres();

			}
		});
		panelMenu.add(btnJugar);
		
		JLabel txtInfo = new JLabel("");
		txtInfo.setBounds(603, 23, 0, 0);
		panelCreacion.add(txtInfo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnEliminar.setBounds(426, 337, 121, 34);
		panelCreacion.add(btnEliminar);
		btnEliminar.setForeground(Color.RED);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnCrear.setBounds(63, 337, 121, 34);
		panelCreacion.add(btnCrear);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnModificar.setBounds(242, 337, 121, 34);
		panelCreacion.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		btnBuscar.setBounds(520, 11, 108, 26);
		panelCreacion.add(btnBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 82, 201, 20);
		panelCreacion.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTotalrestante = new JLabel("Total/restante:");
		lblTotalrestante.setBounds(53, 267, 108, 19);
		panelCreacion.add(lblTotalrestante);
		lblTotalrestante.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblEvasion = new JLabel("Evasi\u00F3n");
		lblEvasion.setBounds(339, 226, 59, 26);
		panelCreacion.add(lblEvasion);
		lblEvasion.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblAtaque = new JLabel("Vida");
		lblAtaque.setBounds(339, 188, 63, 27);
		panelCreacion.add(lblAtaque);
		lblAtaque.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(339, 154, 63, 19);
		panelCreacion.add(lblDefensa);
		lblDefensa.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(339, 117, 57, 29);
		panelCreacion.add(lblEnergia);
		lblEnergia.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(53, 82, 62, 20);
		panelCreacion.add(lblNombre);
		lblNombre.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(355, 11, 28, 26);
		panelCreacion.add(lblId);
		lblId.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		
		txtId = new JTextField();
		txtId.setToolTipText("");
		txtId.setBounds(393, 11, 117, 26);
		panelCreacion.add(txtId);
		txtId.setColumns(10);
		
		
		
		sliderEnergia = new JSlider();
		sliderEnergia.setValue(0);
		sliderEnergia.setMaximum(200);
		sliderEnergia.setBounds(63, 120, 185, 26);
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
		txtEnergia.setBounds(276, 113, 46, 29);
		panelCreacion.add(txtEnergia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 113, 395, 34);
		panelCreacion.add(separator);
		
		txtTotal = new JLabel("");
		txtTotal.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		txtTotal.setBounds(167, 264, 81, 24);
		panelCreacion.add(txtTotal);
		
		txtDefensa = new JLabel("0");
		txtDefensa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensa.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtDefensa.setBounds(276, 146, 46, 34);
		panelCreacion.add(txtDefensa);
		
		sliderDefensa = new JSlider();
		sliderDefensa.setValue(0);
		sliderDefensa.setMaximum(20);
		sliderDefensa.setBounds(63, 154, 185, 26);
		sliderDefensa.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int current = ((JSlider)event.getSource()).getValue();
                txtDefensa.setText(String.valueOf(current));
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtAtaque.getText())-Integer.parseInt(txtEvasion.getText())-(int)Float.parseFloat(txtEnergia.getText())-current));

            }
        });
		panelCreacion.add(sliderDefensa);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 146, 395, 34);
		panelCreacion.add(separator_1);
		
		txtAtaque = new JLabel("0");
		txtAtaque.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtaque.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtAtaque.setBounds(276, 186, 46, 31);
		panelCreacion.add(txtAtaque);
		
		sliderAtaque = new JSlider();
		sliderAtaque.setValue(0);
		sliderAtaque.setMaximum(200);
		sliderAtaque.setBounds(63, 191, 185, 26);
		sliderAtaque.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int current = ((JSlider)event.getSource()).getValue();
                txtAtaque.setText(String.valueOf(current));
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtEnergia.getText())-Integer.parseInt(txtEvasion.getText())-Integer.parseInt(txtDefensa.getText())-current));

            }
        });
		panelCreacion.add(sliderAtaque);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 186, 395, 34);
		panelCreacion.add(separator_2);
		
		txtEvasion = new JLabel("0");
		txtEvasion.setHorizontalAlignment(SwingConstants.CENTER);
		txtEvasion.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		txtEvasion.setBounds(276, 226, 46, 26);
		panelCreacion.add(txtEvasion);
		
		sliderEvasion = new JSlider();
		sliderEvasion.setValue(0);
		sliderEvasion.setMaximum(80);
		sliderEvasion.setBounds(63, 228, 185, 26);
		sliderEvasion.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int current = ((JSlider)event.getSource()).getValue();
                txtEvasion.setText(String.valueOf(current));
                txtTotal.setText(String.valueOf(total-Integer.parseInt(txtAtaque.getText())-Integer.parseInt(txtEnergia.getText())-Integer.parseInt(txtDefensa.getText())-current));

            }
        });
		panelCreacion.add(sliderEvasion);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(53, 221, 395, 34);
		panelCreacion.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(53, 255, 395, 34);
		panelCreacion.add(separator_4);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Interfaz.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		btnVolver.setBounds(10, 11, 57, 31);
		panelCreacion.add(btnVolver);
		
		panelSeleccionPersonaje = new JPanel();
		frame.getContentPane().add(panelSeleccionPersonaje, "name_491738062685251");
		panelSeleccionPersonaje.setLayout(null);
		
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
		
		
		
		
		choice = new Choice();
		
		choice.setForeground(Color.BLACK);
		choice.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 16));
		choice.setBounds(25, 62, 266, 20);
		choice.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie)
	        {
	        if(!choice.getSelectedItem().equals("Seleccionar...")){
	        	setDatosPlayer1(choice.getSelectedItem());
	        }else{
	        	limpiarPlayer(choice);
	        }
	        }
	    });
		panelSeleccionPersonaje.add(choice);
		
		
		choice2 = new Choice();
		choice2.setForeground(Color.BLACK);
		choice2.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 16));
		choice2.setBounds(361, 62, 266, 26);
		choice2.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie)
	        {
	        if(!choice2.getSelectedItem().equals("Seleccionar...")){
	        	setDatosPlayer2(choice2.getSelectedItem());
	        }else{
	        	limpiarPlayer(choice2);
	        }
	        }
	    });
		panelSeleccionPersonaje.add(choice2);
		
		sliderE1 = new JSlider();
		sliderE1.setEnabled(false);
		sliderE1.setValue(0);
		sliderE1.setMinorTickSpacing(1);
		sliderE1.setMaximum(200);
		sliderE1.setMajorTickSpacing(10);
		sliderE1.setBounds(10, 129, 146, 34);
		panelSeleccionPersonaje.add(sliderE1);
		
		 labelEn1 = new JLabel("0");
		labelEn1.setHorizontalAlignment(SwingConstants.CENTER);
		labelEn1.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelEn1.setBounds(154, 126, 46, 34);
		panelSeleccionPersonaje.add(labelEn1);
		
		JLabel label_1 = new JLabel("Energia");
		label_1.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		label_1.setBounds(234, 126, 57, 34);
		panelSeleccionPersonaje.add(label_1);
		
		sliderD1 = new JSlider();
		sliderD1.setEnabled(false);
		sliderD1.setValue(0);
		sliderD1.setMaximum(20);
		sliderD1.setBounds(10, 178, 146, 34);
		panelSeleccionPersonaje.add(sliderD1);
		
		labelD1 = new JLabel();
		labelD1.setText("0");
		labelD1.setHorizontalAlignment(SwingConstants.CENTER);
		labelD1.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelD1.setBounds(154, 178, 46, 34);
		panelSeleccionPersonaje.add(labelD1);
		
		JLabel label_3 = new JLabel("Defensa");
		label_3.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		label_3.setBounds(234, 178, 63, 34);
		panelSeleccionPersonaje.add(label_3);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblVida.setBounds(234, 220, 63, 34);
		panelSeleccionPersonaje.add(lblVida);
		
		labelA1 = new JLabel("0");
		labelA1.setHorizontalAlignment(SwingConstants.CENTER);
		labelA1.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelA1.setBounds(154, 220, 46, 34);
		panelSeleccionPersonaje.add(labelA1);
		
		sliderA1 = new JSlider();
		sliderA1.setEnabled(false);
		sliderA1.setValue(0);
		sliderA1.setMaximum(200);
		sliderA1.setBounds(10, 220, 146, 34);
		panelSeleccionPersonaje.add(sliderA1);
		
		sliderEv1 = new JSlider();
		sliderEv1.setEnabled(false);
		sliderEv1.setValue(0);
		sliderEv1.setMaximum(80);
		sliderEv1.setBounds(10, 267, 146, 34);
		panelSeleccionPersonaje.add(sliderEv1);
		
		labelEv1 = new JLabel("0");
		labelEv1.setHorizontalAlignment(SwingConstants.CENTER);
		labelEv1.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelEv1.setBounds(154, 267, 46, 34);
		panelSeleccionPersonaje.add(labelEv1);
		
		JLabel label_7 = new JLabel("Evasi\u00F3n");
		label_7.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		label_7.setBounds(234, 267, 59, 34);
		panelSeleccionPersonaje.add(label_7);
		
		sliderE2 = new JSlider();
		sliderE2.setValue(0);
		sliderE2.setMinorTickSpacing(1);
		sliderE2.setMaximum(200);
		sliderE2.setMajorTickSpacing(10);
		sliderE2.setEnabled(false);
		sliderE2.setBounds(340, 129, 146, 34);
		panelSeleccionPersonaje.add(sliderE2);
		
		labelEn2 = new JLabel("0");
		labelEn2.setHorizontalAlignment(SwingConstants.CENTER);
		labelEn2.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelEn2.setBounds(496, 129, 46, 34);
		panelSeleccionPersonaje.add(labelEn2);
		
		JLabel label_2 = new JLabel("Energia");
		label_2.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		label_2.setBounds(570, 126, 57, 34);
		panelSeleccionPersonaje.add(label_2);
		
		JLabel label_5 = new JLabel("Defensa");
		label_5.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		label_5.setBounds(564, 170, 63, 34);
		panelSeleccionPersonaje.add(label_5);
		
		labelD2 = new JLabel();
		labelD2.setText("0");
		labelD2.setHorizontalAlignment(SwingConstants.CENTER);
		labelD2.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelD2.setBounds(496, 170, 46, 34);
		panelSeleccionPersonaje.add(labelD2);
		
		sliderD2 = new JSlider();
		sliderD2.setValue(0);
		sliderD2.setMaximum(20);
		sliderD2.setEnabled(false);
		sliderD2.setBounds(340, 170, 146, 34);
		panelSeleccionPersonaje.add(sliderD2);
		
		sliderA2 = new JSlider();
		sliderA2.setValue(0);
		sliderA2.setMaximum(200);
		sliderA2.setEnabled(false);
		sliderA2.setBounds(340, 216, 146, 34);
		panelSeleccionPersonaje.add(sliderA2);
		
		labelA2 = new JLabel("0");
		labelA2.setHorizontalAlignment(SwingConstants.CENTER);
		labelA2.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelA2.setBounds(496, 216, 46, 34);
		panelSeleccionPersonaje.add(labelA2);
		
		JLabel lblVida_1 = new JLabel("Vida");
		lblVida_1.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblVida_1.setBounds(564, 216, 63, 34);
		panelSeleccionPersonaje.add(lblVida_1);
		
		labelEv2 = new JLabel("0");
		labelEv2.setHorizontalAlignment(SwingConstants.CENTER);
		labelEv2.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		labelEv2.setBounds(496, 267, 46, 34);
		panelSeleccionPersonaje.add(labelEv2);
		
		sliderEv2 = new JSlider();
		sliderEv2.setValue(0);
		sliderEv2.setMaximum(80);
		sliderEv2.setEnabled(false);
		sliderEv2.setBounds(340, 267, 146, 34);
		panelSeleccionPersonaje.add(sliderEv2);
		
		JLabel label_11 = new JLabel("Evasi\u00F3n");
		label_11.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		label_11.setBounds(568, 267, 59, 34);
		panelSeleccionPersonaje.add(label_11);
		
		JLabel lblNewLabel = new JLabel("JUGADOR 1");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(92, 11, 146, 35);
		panelSeleccionPersonaje.add(lblNewLabel);
		
		JLabel lblJugador = new JLabel("JUGADOR 2");
		lblJugador.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 24));
		lblJugador.setBounds(422, 11, 146, 35);
		panelSeleccionPersonaje.add(lblJugador);
		
		JButton btnListo = new JButton("LISTO!");
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnListo.setBounds(202, 366, 190, 35);
		panelSeleccionPersonaje.add(btnListo);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(303, 11, 292, 344);
		panelSeleccionPersonaje.add(separator_5);
		
		
		
		
		
		
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
	
	private void limpiarPlayer(Choice c){
		if(c.equals(choice)){
			labelD1.setText(String.valueOf(0));
			labelEn1.setText(String.valueOf(0));
			labelA1.setText(String.valueOf(0));
			labelEv1.setText(String.valueOf(0));
			sliderA1.setValue(0);
			sliderD1.setValue(0);
			sliderE1.setValue(0);
			sliderEv1.setValue(0);		
		}else{
			labelD2.setText(String.valueOf(0));
			labelEn2.setText(String.valueOf(0));
			labelA2.setText(String.valueOf(0));
			labelEv2.setText(String.valueOf(0));
			sliderA2.setValue(0);
			sliderD2.setValue(0);
			sliderE2.setValue(0);
			sliderEv2.setValue(0);		
		}
	}
	
	private void setDatosPlayer1(String nom){
		Personaje p = new Personaje();
		p = ctrl.getPersonajeByNom(nom);
		labelD1.setText(String.valueOf(p.getDefensa()));
		labelEn1.setText(String.valueOf(p.getEnergia()));
		labelA1.setText(String.valueOf(p.getAtaque()));
		labelEv1.setText(String.valueOf(p.getEvasion()));
		sliderA1.setValue(p.getAtaque());
		sliderD1.setValue(p.getDefensa());
		sliderE1.setValue((int) p.getEnergia());
		sliderEv1.setValue(p.getEvasion());		
		
	}
	
	private void setDatosPlayer2(String nom){
		Personaje p = new Personaje();
		p = ctrl.getPersonajeByNom(nom);
		labelD2.setText(String.valueOf(p.getDefensa()));
		labelEn2.setText(String.valueOf(p.getEnergia()));
		labelA2.setText(String.valueOf(p.getAtaque()));
		labelEv2.setText(String.valueOf(p.getEvasion()));
		sliderA2.setValue(p.getAtaque());
		sliderD2.setValue(p.getDefensa());
		sliderE2.setValue((int) p.getEnergia());
		sliderEv2.setValue(p.getEvasion());		
		
	}
	
	private void cargarNombres(){
		ArrayList<String> nombres = new ArrayList<String>();
		
		
		choice.removeAll();
		choice2.removeAll();
		choice.add("Seleccionar...");
		choice2.add("Seleccionar...");
		nombres = ctrl.cargarNombres();
		for(String nom: nombres){
			
			/*for (int i =0; i<choice.getItemCount(); i++) {
		        if (choice.getItem(i).equals(nom)) {
		        	existe=true;
		        	break;
		        }else{
		        	existe=false;
		        }
		    }
			if(!existe)*/
			
        choice.add(nom.toUpperCase());
        choice2.add(nom.toUpperCase());

		}
	}
	
	
	
	protected void eliminar() {
		ctrl.delete(MapearDeFormularioId());
		
		limpiarCampos();
	}

	protected void modificar() {
		try {
			if(datosValidos()){
				ctrl.update(MapearDeFormularioConId());
				notifyUser("Personaje: " + txtNombre.getText() + " modificado con éxito!");
				limpiarCampos();
			}
		} catch (ArithmeticException are){
			notifyUser("Ha ocurrido algo inesperado, consulte al administrador de sistemas.", are, Level.ERROR);
		} catch (Exception e){
			notifyUser("Ha ocurrido algo totalmente inesperado, consulte al administrador de sistemas.",e, Level.FATAL);
		} 
	}

	private Personaje MapearDeFormularioConId() {
		
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
			if(ctrl.verficarNombre(p)){
			ctrl.add(p);
			notifyUser(txtNombre.getText() + " creado con éxito");
			MapearAFormulario(p);
			limpiarCampos();		
				
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
		if(idValido()){
		Personaje p = ctrl.getPersonaje(MapearDeFormularioId());
		if(p!=null){
			//total = (int) (p.getAtaque()+p.getDefensa()+p.getEnergia()+p.getEvasion()+p.getPuntosTotales());
			MapearAFormulario(p);
			
		}else{
			notifyUser("Personaje con id: "+txtId.getText() + " no encontrado");
		}
		}
	}

	private boolean idValido() {
		boolean valido=true;
		if(txtId.getText().trim().length()==0){
			valido=false;
			notifyUser("Ingrese el ID a buscar");
		}
		if(valido && !txtId.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("ID inválido");
		}
			
		return valido;
	}

	private Personaje MapearDeFormularioId() {
		
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
		if(txtAtaque.getText().trim().length()==0
			|| txtNombre.getText().trim().length()==0
			|| txtDefensa.getText().trim().length()==0
			|| txtEvasion.getText().trim().length()==0
			|| txtEnergia.getText().trim().length()==0){
			valido=false;
			notifyUser("Complete todos los campos");
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
