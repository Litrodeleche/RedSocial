package Login;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

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
		setBounds(100, 100, 517, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Incio = new JPanel();
		Incio.setBackground(new Color(255, 255, 255));
		Incio.setBounds(5, 5, 501, 323);
		contentPane.add(Incio);
		Incio.setLayout(null);
		
		JButton Iniciar_1 = new JButton("INICIAR");
		Iniciar_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Iniciar_1.setBackground(SystemColor.activeCaption);
		Iniciar_1.setForeground(SystemColor.textHighlight);
		Iniciar_1.setBounds(355, 266, 119, 38);
		Incio.add(Iniciar_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/producto3.png")));
		lblNewLabel.setBounds(-9, -18, 510, 341);
		Incio.add(lblNewLabel);
		Iniciar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_Sesion Iniciar = new Inicio_Sesion();
				Iniciar.setVisible(true);
				dispose();
			}
		});
	}
}
