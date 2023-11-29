
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class Publicaciones extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public Publicaciones() {
        setLayout(null);

        JLabel lblNombreUsuario = new JLabel("{NombreUsuario}");
        lblNombreUsuario.setBounds(128, 51, 90, 23);
        add(lblNombreUsuario);

        JLabel lblPublicacion = new JLabel("{Publicacion}");
        lblPublicacion.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 17));
        lblPublicacion.setBounds(203, 108, 126, 36);
        add(lblPublicacion);

        JTextPane txtComentarios = new JTextPane();
        txtComentarios.setText("{Autor, Comentario}");
        txtComentarios.setBounds(203, 177, 196, 87);
        add(txtComentarios);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 302, 584, 2);
        add(separator);

    }
}
