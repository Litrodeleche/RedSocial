package Login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Inicio_Sesion extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField Contraseña;
	private ImageIcon imagen;
	private Icon icono;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio_Sesion frame = new Inicio_Sesion();
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
	public Inicio_Sesion() {
		this.setLocationRelativeTo(this);
	
		setTitle("Inicio de Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(Inicio_Sesion.class.getResource("/Imagenes/inicio (1).png")));
		lblImagen.setBounds(66, 53, 159, 132);
		panel.add(lblImagen);
		
		
		
		Usuario = new JTextField();
		Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		Usuario.setToolTipText("");
		Usuario.setBounds(34, 234, 226, 25);
		panel.add(Usuario);
		Usuario.setColumns(10);
		
		JLabel Titulo = new JLabel("Iniciar Sesion en Red Social");
		Titulo.setForeground(SystemColor.menu);
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Titulo.setBounds(10, 11, 282, 31);
		panel.add(Titulo);
		
		JLabel NombreUsuario = new JLabel("Nombre de Usuario:");
		NombreUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		NombreUsuario.setBounds(34, 209, 143, 14);
		panel.add(NombreUsuario);
		
		JLabel Contra = new JLabel("Contraseña:");
		Contra.setFont(new Font("Arial", Font.BOLD, 14));
		Contra.setBounds(34, 275, 143, 14);
		panel.add(Contra);
		
		JButton btnInicar = new JButton("Iniciar Sesion");
		btnInicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = Usuario.getText();
				char[] contra = Contraseña.getPassword();
				String password = new String (contra);
				if(RedSocial.iniciosesion(user, password)==false) {
    				JOptionPane.showMessageDialog(null, "Usuario o Contraseña Erroena");
				}
            }
        });
		btnInicar.setFont(new Font("Arial", Font.BOLD, 13));
		btnInicar.setBounds(80, 362, 127, 23);
		panel.add(btnInicar);
		
		JLabel Pregunta = new JLabel("¿No tienes Cuenta?");
		Pregunta.setFont(new Font("Arial", Font.BOLD, 13));
		Pregunta.setBounds(80, 398, 127, 14);
		panel.add(Pregunta);
		
		JLabel Registrarse = new JLabel("Registrarse");
		Registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	Registro Reg = new Registro();
				Reg.setVisible(true);
            }
        });
		Registrarse.setForeground(SystemColor.controlLtHighlight);
		Registrarse.setHorizontalAlignment(SwingConstants.CENTER);
		Registrarse.setFont(new Font("Arial", Font.BOLD, 16));
		Registrarse.setBounds(66, 423, 145, 23);
		panel.add(Registrarse);
		
		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Arial", Font.PLAIN, 11));
		Contraseña.setBounds(34, 300, 226, 25);
		panel.add(Contraseña);
		
		JCheckBox Mostrar = new JCheckBox("Mostrar Contraseña");
		Mostrar.setBackground(new Color(255, 255, 255));

        Mostrar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Contraseña.setEchoChar((char) 0); 
                } else {
                    Contraseña.setEchoChar('●'); 
                }
            }
        });
        setVisible(true);
		Mostrar.setBounds(66, 332, 143, 23);
		panel.add(Mostrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio_Sesion.class.getResource("/Imagenes/city.png")));
		lblNewLabel.setBounds(0, 0, 296, 511);
		panel.add(lblNewLabel);
	}
	
}
