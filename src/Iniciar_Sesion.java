import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Iniciar_Sesion extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField Contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iniciar_Sesion frame = new Iniciar_Sesion();
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
	public Iniciar_Sesion() {
		setTitle("Inicio de Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Usuario = new JTextField();
		Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		Usuario.setToolTipText("");
		Usuario.setBounds(52, 98, 226, 25);
		panel.add(Usuario);
		Usuario.setColumns(10);
		
		JLabel Titulo = new JLabel("Iniciar Sesion en Red Social");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Titulo.setBounds(24, 21, 282, 31);
		panel.add(Titulo);
		
		JLabel NombreUsuario = new JLabel("Nombre de Usuario:");
		NombreUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		NombreUsuario.setBounds(52, 73, 143, 14);
		panel.add(NombreUsuario);
		
		JLabel Contra = new JLabel("Contraseña:");
		Contra.setFont(new Font("Arial", Font.BOLD, 14));
		Contra.setBounds(52, 139, 143, 14);
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
				else{
					Principal p = new Principal();
					p.setNombreUsuario(user);
					p.setVisible(true);
					dispose();
				}
            }
        });
		btnInicar.setFont(new Font("Arial", Font.BOLD, 13));
		btnInicar.setBounds(98, 226, 127, 23);
		panel.add(btnInicar);
		
		JLabel Pregunta = new JLabel("¿No tienes Cuenta?");
		Pregunta.setFont(new Font("Arial", Font.BOLD, 13));
		Pregunta.setBounds(98, 260, 127, 14);
		panel.add(Pregunta);
		
		JLabel Registrarse = new JLabel("Registrarse");
		Registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	Registro Reg = new Registro();
				Reg.setVisible(true);
            }
        });
		Registrarse.setForeground(new Color(0, 0, 255));
		Registrarse.setHorizontalAlignment(SwingConstants.CENTER);
		Registrarse.setFont(new Font("Arial", Font.BOLD, 14));
		Registrarse.setBounds(98, 285, 127, 14);
		panel.add(Registrarse);
		
		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Arial", Font.PLAIN, 11));
		Contraseña.setBounds(52, 164, 226, 25);
		panel.add(Contraseña);
		
		JCheckBox Mostrar = new JCheckBox("Mostrar Contraseña");

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
		Mostrar.setBounds(98, 196, 159, 23);
		panel.add(Mostrar);
	}
}
