

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("RED SOCIAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Incio = new JPanel();
		contentPane.add(Incio, BorderLayout.CENTER);
		Incio.setLayout(null);
		
		JButton Iniciar = new JButton("INICIAR");
		Iniciar.setBounds(296, 206, 97, 23);
		Incio.add(Iniciar);
		Iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar_Sesion Iniciar = new Iniciar_Sesion();
				Iniciar.setVisible(true);
				dispose();
			}
		});
	}
}
