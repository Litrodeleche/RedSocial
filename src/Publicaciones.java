
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//... (otras importaciones y código)

public class Publicaciones extends JPanel {

 private List<JPanel> publicacionPanels;
 private JScrollPane publicacionesScrollPane;
 private List<Comentario> comentarios;
 private String usuario;

 public Publicaciones(String usuario) {
	 this.usuario = usuario;
     setLayout(new BorderLayout());
     comentarios = new ArrayList<>();
     publicacionPanels = new ArrayList<>();
     publicacionesScrollPane = new JScrollPane();
     add(publicacionesScrollPane, BorderLayout.CENTER);

     cargarPublicaciones();
 }

 private void cargarPublicaciones() {
     try (BufferedReader reader = new BufferedReader(new FileReader("Publicaciones.txt"))) {
         String line;
         while ((line = reader.readLine()) != null) {
             JPanel publicacionPanel = crearPublicacionPanel(line);
             publicacionPanels.add(publicacionPanel);
         }

         // Actualizar el JScrollPane con los nuevos paneles
         publicacionesScrollPane.setViewportView(createPanel(publicacionPanels));

     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 private JPanel crearPublicacionPanel(String publicacionInfo) {
     // Parsear la información de la publicación
     String[] campos = publicacionInfo.split(";");

     if (campos.length == 3) {
         String autor = campos[0];
         LocalDateTime fecha = LocalDateTime.parse(campos[1]);
         String contenido = campos[2];

         // Crear un nuevo panel para la publicación con GridLayout
         JPanel panel = new JPanel(new GridLayout(4, 1));

         // Labels para autor, fecha y contenido
         JLabel autorLabel = new JLabel(autor);
         JLabel fechaLabel = new JLabel(fecha.toString());
         JLabel contenidoLabel = new JLabel(contenido);
         contenidoLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
 		 contenidoLabel.setBounds(172, 223, 248, 48);
 		 autorLabel.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 13));
		 autorLabel.setBounds(172, 198, 97, 30);

         // Textarea para comentarios
         JTextArea comentariosTextArea = new JTextArea();
         comentariosTextArea.setEditable(false);
         JScrollPane comentariosScrollPane = new JScrollPane(comentariosTextArea);
         String com = "COMENTARIOS: \n ";
         comentariosTextArea.setText(com);

         // Textfield para nuevo comentario
         JTextField nuevoComentarioTextField = new JTextField();

         // Botón para comentar
         JButton comentarButton = new JButton("Comentar");
         comentarButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 comentar(comentariosTextArea, nuevoComentarioTextField);
             }
         });

         // Agregar componentes al panel de la publicación
         panel.add(autorLabel);
         panel.add(fechaLabel);
         panel.add(contenidoLabel);
         panel.add(comentariosScrollPane);
         panel.add(nuevoComentarioTextField);
         panel.add(comentarButton);

         return panel;
     }

     return null;
 }

 private void comentar(JTextArea comentariosTextArea, JTextField nuevoComentarioTextField) {
	    String nuevoComentarioTexto = nuevoComentarioTextField.getText();
	    if (!nuevoComentarioTexto.isEmpty()) {
	        // Crear un nuevo comentario
	        Comentario nuevoComentario = new Comentario();

	        // Agregar el nuevo comentario a la lista y guardar en el archivo
	        comentarios.add(nuevoComentario);
	        nuevoComentario.guardarEnArchivo();

	        // Actualizar el JTextArea con los comentarios
	        comentariosTextArea.append(usuario +": "+ nuevoComentarioTexto + "\n");

	        // Limpiar el campo de texto
	        nuevoComentarioTextField.setText("");
	    }
	}

 private JPanel createPanel(List<JPanel> panels) {
     JPanel containerPanel = new JPanel();
     containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
     for (JPanel panel : panels) {
         containerPanel.add(panel);
     }
     return containerPanel;
 }

 public static void main(String[] args) {
     SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
             JFrame frame = new JFrame("Publicaciones Panel");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.getContentPane().add(new Publicaciones(""));
             frame.setSize(600, 400);
             frame.setVisible(true);
         }
     });
 }
}
