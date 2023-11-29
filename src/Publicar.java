
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Publicar extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;

    /**
     * Create the panel.
     */
    public Publicar() {
        setLayout(null);

        JLabel lblNombreUsuario = new JLabel("{Nombre Usuario}");
        lblNombreUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
        lblNombreUsuario.setBounds(52, 31, 150, 39);
        add(lblNombreUsuario);

        JLabel lblfecha = new JLabel("Fecha Publicacion:");
        lblfecha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
        lblfecha.setBounds(52, 98, 110, 14);
        add(lblfecha);

        JLabel lblNewLabel = new JLabel("{Fecha actual}");
        lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
        lblNewLabel.setBounds(172, 98, 110, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Publicacion:");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(90, 123, 88, 14);
        add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(172, 123, 180, 20);
        add(textField);
        textField.setColumns(10);

        JButton btnPublicar = new JButton("Publicar");
        btnPublicar.setBounds(232, 373, 89, 23);
        add(btnPublicar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(331, 373, 89, 23);
        add(btnCancelar);

    }

}