
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class Publicar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPublicacion;
	private String usuario;

	/**
	 * Create the panel.
	 */
	public Publicar(String usuario) {
		this.usuario = usuario;
		setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel(usuario);
		lblNombreUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNombreUsuario.setBounds(52, 31, 150, 39);
		add(lblNombreUsuario);
		
		JLabel lblfecha = new JLabel("Fecha Publicacion:");
		lblfecha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblfecha.setBounds(52, 98, 110, 14);
		add(lblfecha);
		
		LocalDateTime l = LocalDateTime.now();
		int dia = l.getDayOfMonth();
        int mes = l.getMonthValue();
        int anio = l.getYear();
		String fecha = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anio);
		
		JLabel lblFecha = new JLabel(fecha);
		lblFecha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblFecha.setBounds(172, 98, 226, 14);
		add(lblFecha);
		
		JLabel lblNewLabel_1 = new JLabel("Publicacion:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(90, 123, 88, 14);
		add(lblNewLabel_1);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setBounds(172, 123, 180, 20);
		add(txtPublicacion);
		txtPublicacion.setColumns(10);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String publicacion = txtPublicacion.getText();
				Publicacion p = new Publicacion(usuario ,publicacion);
				p.guardarEnArchivo();
			}
		});
		btnPublicar.setBounds(232, 373, 89, 23);
		add(btnPublicar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPublicacion.setText("");
			}
		});
		btnCancelar.setBounds(331, 373, 89, 23);
		add(btnCancelar);

	}

}