import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class Pantalla_Principal extends JFrame {

	private JPanel contentPane;
	public Pantalla_Principal() {
		setTitle("Comida Rapida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelcen = new JPanel();
		contentPane.add(panelcen);
		panelcen.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		panelcen.add(desktopPane, BorderLayout.CENTER);
	}	
}