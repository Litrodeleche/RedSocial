import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Solicitudes extends JPanel {
    private JTable table;

    /**
     * Create the panel.
     */
    public Solicitudes() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(74, 80, 437, 268);
        add(panel);
        panel.setLayout(null);

        table = new JTable();
        table.setBounds(10, 10, 417, 248);
        panel.add(table);

        JLabel lblNewLabel = new JLabel("Solicitudes entrantes:");
        lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
        lblNewLabel.setBounds(55, 29, 117, 27);
        add(lblNewLabel);

        JButton btnEliminar = new JButton(" Eliminar");
        btnEliminar.setBounds(473, 399, 85, 21);
        add(btnEliminar);

        JButton btnEliminar_1 = new JButton(" Aceptar");
        btnEliminar_1.setBounds(375, 399, 85, 21);
        add(btnEliminar_1);

    }
}