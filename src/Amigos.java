import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Amigos extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private String nombreUs;

    /**
     * Create the panel.
     */
    public Amigos(String nombreUs) {
    	this.nombreUs = nombreUs;
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(74, 80, 437, 268);
        add(panel);
        panel.setLayout(null);

        // Crear el modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Amigo Añadido");

        // Crear la tabla con el modelo
        table = new JTable(tableModel);
        table.setBounds(10, 10, 417, 248);
        panel.add(table);

        JLabel lblNewLabel = new JLabel("Amigos");
        lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
        lblNewLabel.setBounds(55, 29, 117, 27);
        add(lblNewLabel);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(473, 399, 85, 21);
        add(btnEliminar);

        // Llenar la tabla con datos del archivo
        llenarTabla();
    }

    private void llenarTabla() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Amigos.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                // Asumiendo que el primer dato es el amigo añadido
                String usuario = datos[0];
                String amigoAñadido = datos[1];
                if(usuario.equals(nombreUs)) {
                	tableModel.addRow(new Object[]{amigoAñadido});
                }
                	
            }

            lector.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo leer el archivo de amigos.");
        }
    }
}