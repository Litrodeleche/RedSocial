
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.SystemColor;

public class Agregar extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JLabel lblnombre;
    private JLabel lbltelefono;
    private JLabel lblusuario;
    private JLabel lblnacimiento;
    private JLabel lblinteres;
    private String usuario1;
    private String usuario2;

    /**
     * Create the panel.
     */
    public Agregar(String usuario1, String usuario2) {
    	this.usuario1 = usuario1;
    	this.usuario2 = usuario2;
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Perfil del Usuario:");
        lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
        lblNewLabel.setBounds(25, 11, 239, 55);
        add(lblNewLabel);

        JLabel asdasd = new JLabel("Nombre:");
        asdasd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        asdasd.setBounds(67, 77, 84, 28);
        add(asdasd);

        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblTelefono.setBounds(56, 116, 84, 28);
        add(lblTelefono);

        JLabel lblUsuario = new JLabel("Estado:");
        lblUsuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblUsuario.setBounds(67, 155, 84, 28);
        add(lblUsuario);

        JLabel lblEstado = new JLabel("Nacimiento:");
        lblEstado.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblEstado.setBounds(36, 194, 84, 28);
        add(lblEstado);

        JLabel lblInteres = new JLabel("Interes:");
        lblInteres.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblInteres.setBounds(67, 233, 84, 28);
        add(lblInteres);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Perfil.class.getResource("/Imagenes/336799ebb339821f342bc5a13386aff2.jpg")));
        lblNewLabel_1.setBounds(306, 260, 233, 192);
        add(lblNewLabel_1);

        lblnombre = new JLabel("{NOMBRE}");
        lblnombre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblnombre.setBounds(138, 77, 221, 28);
        add(lblnombre);

        lbltelefono = new JLabel("{TELEFONO}");
        lbltelefono.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lbltelefono.setBounds(138, 116, 221, 28);
        add(lbltelefono);

        lblusuario = new JLabel("{ESTADO}");
        lblusuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblusuario.setBounds(138, 155, 172, 28);
        add(lblusuario);

        lblnacimiento = new JLabel("{NACIMIENTO}");
        lblnacimiento.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblnacimiento.setBounds(138, 194, 204, 28);
        add(lblnacimiento);

        lblinteres = new JLabel("{INTERES}");
        lblinteres.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
        lblinteres.setBounds(138, 233, 84, 28);
        add(lblinteres);
        
        Button btnAgregar = new Button("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre del usuario que se va a agregar
                String usuarioManda = usuario1; // Cambia esto si es necesario obtener otro dato

                // Escribir en el archivo de amigos
                try {
                    // Añadir el usuarioInicial y el usuarioAAgregar al archivo
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("Amigos.txt", true));
                    escritor.write(usuarioManda + "," + usuario2);
                    escritor.newLine();
                    escritor.write(usuario2 + "," + usuarioManda);
                    escritor.newLine();
                    escritor.close();

                    // Mostrar un mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Agregado a tus amigos con éxito");
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de amigos.");
                }
            }
        });
        btnAgregar.setBackground(SystemColor.text);
        btnAgregar.setBounds(138, 329, 70, 22);
        add(btnAgregar);

    }
    public void setPerfil(String nombre, String telefono, String estado, String nacimiento, String interes) {
    	if(nombre!=null) {
    		lblnombre.setText(nombre);
        	lbltelefono.setText(telefono);
        	lblusuario.setText(estado);
        	lblnacimiento.setText(nacimiento);
        	lblinteres.setText(interes);
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Usuario no encontrado");
    		lblnombre.setText("----------------");
        	lbltelefono.setText("----------------");
        	lblusuario.setText("----------------");
        	lblnacimiento.setText("----------------");
        	lblinteres.setText("----------------");
    	}
    	
    }
}