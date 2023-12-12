package Login;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField nroTelefono;
	private JTextField Usuario;
	private JPasswordField Contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Crear Cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Titulo = new JLabel("Crea tu Cuenta");
		Titulo.setFont(new Font("Times New Roman", Font.BOLD, 21));
		Titulo.setBounds(30, 24, 173, 14);
		panel.add(Titulo);
		
		JLabel NombreC = new JLabel("Nombre:");
		NombreC.setFont(new Font("Arial", Font.BOLD, 14));
		NombreC.setBounds(40, 59, 68, 14);
		panel.add(NombreC);
		
		Nombre = new JTextField();
		Nombre.setBounds(50, 80, 153, 20);
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		JLabel Telefono = new JLabel("Telefono:");
		Telefono.setFont(new Font("Arial", Font.BOLD, 14));
		Telefono.setBounds(40, 114, 86, 14);
		panel.add(Telefono);
		
		nroTelefono = new JTextField();
		nroTelefono.setBounds(50, 139, 153, 20);
		panel.add(nroTelefono);
		nroTelefono.setColumns(10);
		
		JComboBox Dias = new JComboBox();
		Dias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
	            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
	            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		Dias.setBounds(40, 220, 44, 22);
		panel.add(Dias);
		
		JComboBox Meses = new JComboBox();
		Meses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		Meses.setBounds(81, 220, 74, 22);
		panel.add(Meses);
		
		JComboBox Años = new JComboBox();
		Años.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
	            "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004",
	            "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994",
	            "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984",
	            "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
	            "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964",
	            "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954",
	            "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944",
	            "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934",
	            "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924",
	            "1923", "1922", "1921", "1920"}));
		Años.setBounds(154, 220, 60, 22);
		panel.add(Años);
		
		JLabel Dia = new JLabel("Dia:");
		Dia.setFont(new Font("Arial", Font.BOLD, 14));
		Dia.setBounds(38, 202, 46, 14);
		panel.add(Dia);
		
		JLabel Mes = new JLabel("Mes:");
		Mes.setFont(new Font("Arial", Font.BOLD, 14));
		Mes.setBounds(81, 202, 46, 14);
		panel.add(Mes);
		
		JLabel Año = new JLabel("Año:");
		Año.setFont(new Font("Arial", Font.BOLD, 14));
		Año.setBounds(154, 202, 46, 14);
		panel.add(Año);
		
		JLabel Fecha = new JLabel("Fecha de Nacimiento");
		Fecha.setFont(new Font("Arial", Font.BOLD, 14));
		Fecha.setBounds(40, 174, 163, 14);
		panel.add(Fecha);
		
		JButton Siguiente = new JButton("Siguiente");
		Siguiente.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		setTitle("Crear Cuenta");
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setBounds(100, 100, 353, 306);
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
        		
        		JLabel Titulo = new JLabel("Crear Cuenta Nueva");
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
        		
        		JButton btnIniciar = new JButton("Crear Cuenta");
        		btnIniciar.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				String nombre = Nombre.getText();
        				int telefono = Integer.parseInt(nroTelefono.getText());
        				String dia = Dias.getSelectedItem().toString();
        				String mes = Meses.getSelectedItem().toString();
        				String año = Años.getSelectedItem().toString();
        				String nacimiento=dia+"/"+mes+"/"+año;
        				String user = Usuario.getText();
        				if(RedSocial.busqueda(user)==true) {
        					JOptionPane.showMessageDialog(null, "Usuario ya existente");
        				}else {
	        				char[] contra = Contraseña.getPassword();
	        				String password = new String (contra);
	        				Users u = new Users(user,password);
        					RedSocial Red = new RedSocial();
        					PerfilUsuario perfil = new PerfilUsuario(nombre, telefono, nacimiento, "-", "-");
        					Red.agregarUsuario(u);
        					u.agregarPerfil(perfil);
	        				dispose();
	        				JOptionPane.showMessageDialog(null, "Cuenta Creada Exitosamente");
        				}
        			}
        		});
        		btnIniciar.setFont(new Font("Arial", Font.BOLD, 13));
        		btnIniciar.setBounds(98, 226, 127, 23);
        		panel.add(btnIniciar);
        		
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
        });
		Siguiente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Siguiente.setBounds(79, 266, 89, 23);
		panel.add(Siguiente);
		

	}
}
