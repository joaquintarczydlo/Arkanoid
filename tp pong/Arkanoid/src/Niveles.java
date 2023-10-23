import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class Niveles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Niveles frame = new Niveles();
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
	public Niveles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 486);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel titulo = new JLabel("Niveles de Arkanoid:");
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 60));
		titulo.setForeground(new Color(200, 106, 255));
		titulo.setBounds(87, 30, 430, 51);
		contentPane.add(titulo);
		
		JButton btnlevel1 = new JButton("NIVEL 1");
		btnlevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego.main(new String[]{});
				Niveles.this.setVisible(false);
				Main.nivel=1;
			}
		});
		btnlevel1.setForeground(new Color(0, 0, 0));
		btnlevel1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnlevel1.setBackground(new Color(200, 106, 255));
		btnlevel1.setFont(new Font("Consolas", Font.BOLD, 25));
		btnlevel1.setBounds(200, 130, 204, 45);
	    contentPane.add(btnlevel1);
	    
	    JButton btnlevel2 = new JButton("NIVEL 2");
	    btnlevel2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Juego.main(new String[]{});
				Niveles.this.setVisible(false);
				Main.nivel=2;
	    	}
	    });
	    btnlevel2.setVerticalAlignment(SwingConstants.BOTTOM);
	    btnlevel2.setForeground(Color.BLACK);
	    btnlevel2.setFont(new Font("Consolas", Font.BOLD, 25));
	    btnlevel2.setBackground(new Color(200, 106, 255));
	    btnlevel2.setBounds(200, 210, 204, 45);
	    contentPane.add(btnlevel2);
	    
	    JButton btnlevel3 = new JButton("NIVEL 3");
	    btnlevel3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Juego.main(new String[]{});
				Niveles.this.setVisible(false);
				Main.nivel=3;
	    	}
	    });
	    btnlevel3.setVerticalAlignment(SwingConstants.BOTTOM);
	    btnlevel3.setForeground(Color.BLACK);
	    btnlevel3.setFont(new Font("Consolas", Font.BOLD, 25));
	    btnlevel3.setBackground(new Color(200, 106, 255));
	    btnlevel3.setBounds(200, 290, 204, 45);
	    contentPane.add(btnlevel3);
	    
	    JButton btnlevel4 = new JButton("NIVEL 4");
	    btnlevel4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Juego.main(new String[]{});
				Niveles.this.setVisible(false);
				Main.nivel=4;
	    	}
	    });
	    btnlevel4.setVerticalAlignment(SwingConstants.BOTTOM);
	    btnlevel4.setForeground(Color.BLACK);
	    btnlevel4.setFont(new Font("Consolas", Font.BOLD, 25));
	    btnlevel4.setBackground(new Color(200, 106, 255));
	    btnlevel4.setBounds(200, 370, 204, 45);
	    contentPane.add(btnlevel4);
	    
	    JButton btnvolver = new JButton("Volver");
	    btnvolver.setVerticalAlignment(SwingConstants.TOP);
	    btnvolver.setForeground(new Color(0, 0, 0));
	    btnvolver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Main.main(new String[]{});
	    		Niveles.this.setVisible(false);
	    	}
	    });
	    btnvolver.setFont(new Font("Consolas", Font.BOLD, 14));
	    btnvolver.setBackground(new Color(200, 106, 255));
	    btnvolver.setBounds(0, 424, 89, 23);
	    contentPane.add(btnvolver);
	}

}
