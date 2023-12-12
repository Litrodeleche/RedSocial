//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Principal extends JFrame {
    private JPanel contentPane;
    private JTextField txtBuscar;
    private JLabel lblNombreUsuario;
    private String nombre;
    private String nombreUs;
    private String telefono;
    private String estado;
    private String nacimiento;
    private String interes;

    private JPanel panel;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal("");
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public Principal(String NombreUs) {
    	this.nombreUs = NombreUs;
        setResizable(true);
        setTitle("Pagina Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 985, 705);
        contentPane = new JPanel();
        contentPane.setForeground(SystemColor.menuText);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel Fondo = new JPanel();
        Fondo.setBackground(new Color(13, 1, 28));
        Fondo.setForeground(SystemColor.activeCaption);
        Fondo.setBounds(0, 0, 981, 668);
        contentPane.add(Fondo);
        Fondo.setLayout(null);

        JPanel Opciones = new JPanel();
        Opciones.setBackground(new Color(31, 80, 135));
        Opciones.setForeground(SystemColor.textHighlight);
        Opciones.setBounds(0, 0, 239, 668);
        Fondo.add(Opciones);
        Opciones.setLayout(null);

        JPanel PaginaInicio = new JPanel();
        PaginaInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Publicaciones p = new Publicaciones(nombreUs);
                panel.removeAll();
                panel.add(p);
                panel.repaint();
                panel.revalidate();

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                PaginaInicio.setBackground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                PaginaInicio.setBackground(new Color(121, 179, 192));
            }
        });
        PaginaInicio.setBackground(new Color(121, 179, 192));
        PaginaInicio.setBounds(0, 215, 239, 46);
        Opciones.add(PaginaInicio);
        PaginaInicio.setLayout(null);

        JLabel lblInicio = new JLabel("Pagina principal");
        lblInicio.setForeground(SystemColor.text);
        lblInicio.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblInicio.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/home-outline.png")));
        lblInicio.setBounds(10, 10, 130, 31);
        PaginaInicio.add(lblInicio);

        JPanel Perfil = new JPanel();
        Perfil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Perfil.setBackground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Perfil.setBackground(new Color(121, 179, 192));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                Perfil p = new Perfil();
                try {
                    BufferedReader lector = new BufferedReader(new FileReader(NombreArchivos.TXT_PERFILES));
                    String linea;
                    while ((linea = lector.readLine()) != null) {
                        String [] datos = linea.split(",");
                        nombreUs = datos[0];
                        if(nombreUs.equals(lblNombreUsuario.getText())) {
                        	nombre = datos[1];
                        	String foto = datos[2];
                        	telefono = datos[3];
                        	nacimiento = datos[4];
                        	estado = datos[5];
                        	interes = datos[6];
                        	break;
                        }
                    }
                    lector.close();
                }catch( IOException ioe ) {
                    JOptionPane.showMessageDialog(null," no se pudo leer el archivo.");
                }
                System.out.println(nombreUs+nombre+telefono+nacimiento+estado+interes);
                p.setPerfil(nombre,telefono,estado,nacimiento,interes);
                panel.removeAll();
                panel.add(p);
                panel.repaint();
                panel.revalidate();
            }
            
        });
        Perfil.setLayout(null);
        Perfil.setBackground(new Color(121, 179, 192));
        Perfil.setBounds(0, 260, 239, 46);
        Opciones.add(Perfil);

        JLabel lblInicio_1 = new JLabel("Perfil");
        lblInicio_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/account-multiple.png")));
        lblInicio_1.setForeground(Color.WHITE);
        lblInicio_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblInicio_1.setBounds(10, 10, 130, 31);
        Perfil.add(lblInicio_1);

        JPanel Solicitudes = new JPanel();
        Solicitudes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Solicitudes.setBackground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Solicitudes.setBackground(new Color(121, 179, 192));
            }
            public void mouseClicked(MouseEvent e) {
                Solicitudes p = new Solicitudes();
                panel.removeAll();
                panel.add(p);
                panel.repaint();
                panel.revalidate();}
        });
        Solicitudes.setLayout(null);
        Solicitudes.setBackground(new Color(121, 179, 192));
        Solicitudes.setBounds(0, 306, 239, 46);
        Opciones.add(Solicitudes);

        JLabel lblSolicitudesDeAmmistad = new JLabel("Solicitudes de amistad");
        lblSolicitudesDeAmmistad.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/calendar-multiple-check.png")));
        lblSolicitudesDeAmmistad.setForeground(Color.WHITE);
        lblSolicitudesDeAmmistad.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblSolicitudesDeAmmistad.setBounds(10, 10, 175, 31);
        Solicitudes.add(lblSolicitudesDeAmmistad);

        JPanel Amigos = new JPanel();
        Amigos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Amigos.setBackground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Amigos.setBackground(new Color(121, 179, 192));
            }
            public void mouseClicked(MouseEvent e) {
                Amigos p = new Amigos(nombreUs);
                panel.removeAll();
                panel.add(p);
                panel.repaint();
                panel.revalidate();
            }
        });
        Amigos.setLayout(null);
        Amigos.setBackground(new Color(121, 179, 192));
        Amigos.setBounds(0, 352, 239, 46);
        Opciones.add(Amigos);

        JLabel lblAmigos = new JLabel("Amigos");
        lblAmigos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/account-multiple.png")));
        lblAmigos.setForeground(Color.WHITE);
        lblAmigos.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblAmigos.setBounds(10, 10, 130, 31);
        Amigos.add(lblAmigos);

        JButton btnNewButton = new JButton("Cerrar sesion");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Iniciar_Sesion p = new Iniciar_Sesion();
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        btnNewButton.setBackground(new Color(251, 233, 218));
        btnNewButton.setBounds(109, 637, 105, 21);
        Opciones.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/iStock.jpg")));
        lblNewLabel.setBounds(39, 43, 152, 137);
        Opciones.add(lblNewLabel);

        JPanel btnPublicar = new JPanel();
        btnPublicar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPublicar.setBackground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnPublicar.setBackground(new Color(121, 179, 192));
            }
            public void mouseClicked(MouseEvent e) {
                Publicar p = new Publicar(lblNombreUsuario.getText());
                panel.removeAll();
                panel.add(p);
                panel.repaint();
                panel.revalidate();
            }
        });
        btnPublicar.setLayout(null);
        btnPublicar.setBackground(new Color(121, 179, 192));
        btnPublicar.setBounds(0, 398, 239, 46);
        Opciones.add(btnPublicar);

        JLabel lblPublicacion = new JLabel("Realizar publicacion");
        lblPublicacion.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/calendar-plus.png")));
        lblPublicacion.setForeground(Color.WHITE);
        lblPublicacion.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblPublicacion.setBounds(10, 10, 161, 31);
        btnPublicar.add(lblPublicacion);

        JPanel Bienvenido = new JPanel();
        Bienvenido.setBackground(new Color(31, 80, 135));
        Bienvenido.setBounds(239, 77, 732, 89);
        Fondo.add(Bienvenido);
        Bienvenido.setLayout(null);

        JLabel lblBienvenido = new JLabel("Bienvenido:");
        lblBienvenido.setForeground(SystemColor.inactiveCaptionBorder);
        lblBienvenido.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
        lblBienvenido.setBounds(35, 10, 185, 41);
        Bienvenido.add(lblBienvenido);

        lblNombreUsuario = new JLabel(nombreUs);
        lblNombreUsuario.setForeground(SystemColor.inactiveCaptionBorder);
        lblNombreUsuario.setBackground(SystemColor.inactiveCaptionBorder);
        lblNombreUsuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 33));
        lblNombreUsuario.setBounds(157, 29, 368, 60);
        Bienvenido.add(lblNombreUsuario);

        panel = new JPanel();
        Publicaciones p = new Publicaciones(nombreUs);
        panel.setBackground(new Color(251, 233, 218));
        panel.setBounds(239, 165, 732, 503);
        panel.removeAll();
        panel.setLayout(new CardLayout(0, 0));
        panel.add(p);
        panel.repaint();
        panel.revalidate();
        Fondo.add(panel);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
        lblBuscar.setForeground(SystemColor.inactiveCaptionBorder);
        lblBuscar.setBounds(269, 10, 112, 57);
        Fondo.add(lblBuscar);

        txtBuscar = new JTextField();
		txtBuscar.setBounds(391, 26, 412, 28);
		Fondo.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		Button btnBuscar = new Button("ir");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtBuscar.getText();
				 
	                try {
	                    BufferedReader lector = new BufferedReader(new FileReader("Perfiles.txt"));
	                    String linea;
	                    while ((linea = lector.readLine()) != null) {
	                        String [] datos = linea.split(",");
	                        String nombreUsuario = datos[0];
	                        if(nombreUsuario.equals(usuario)) {
	                        	nombre = datos[1];
	                        	String foto = datos[2];
	                        	telefono = datos[3];
	                        	nacimiento = datos[4];
	                        	estado = datos[5];
	                        	interes = datos[6];
	                        	break;
	                        }
	                    }
	                    lector.close();
	                }catch( IOException ioe ) {
	                    JOptionPane.showMessageDialog(null," no se pudo leer el archivo.");
	                }
	                Agregar p = new Agregar(nombreUs,usuario);
	                System.out.println(nombreUs+nombre+telefono+nacimiento+estado+interes);
	                p.setPerfil(nombre,telefono,estado,nacimiento,interes);
	                panel.removeAll();
	                panel.add(p);
	                panel.repaint();
	                panel.revalidate();
	            }
			
		});
		btnBuscar.setBackground(SystemColor.desktop);
		btnBuscar.setBounds(809, 32, 44, 22);
		Fondo.add(btnBuscar);

    }
    public void setNombreUsuario(String nombreUsuario) {
        if (lblNombreUsuario != null) {
            lblNombreUsuario.setText(nombreUsuario);
        } else {
            System.err.println("Error: lblNombreUsuario es null.");
        }
    }

}
