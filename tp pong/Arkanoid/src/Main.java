
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

public class Main {
	public static int nivel=0;
	private Gameplay panelGame;
	
	public Main() {
		
		
		JFrame ventana = new JFrame();
		ventana.getContentPane().setBackground(new Color(0, 0, 0));
		ventana.setTitle("MENU");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setBounds(0, 0, 604, 468);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("ARKANOID");
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 70));
		titulo.setForeground(new Color(200, 106, 255));
		titulo.setBounds(155, 37, 294, 51);
		ventana.getContentPane().add(titulo);
		
		JButton btnjugar = new JButton("JUGAR");
		btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego.main(new String[]{});
				ventana.setVisible(false);
				nivel=1;
			}
		});
		btnjugar.setForeground(new Color(0, 0, 0));
		btnjugar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnjugar.setBackground(new Color(200, 106, 255));
		btnjugar.setFont(new Font("Consolas", Font.BOLD, 25));
		btnjugar.setBounds(200, 140, 204, 45);
		ventana.getContentPane().add(btnjugar);
		
		JButton btnNiveles = new JButton("NIVELES");
		btnNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Niveles.main(new String[]{});
				ventana.setVisible(false);
			}
		});
		btnNiveles.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNiveles.setForeground(Color.BLACK);
		btnNiveles.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNiveles.setBackground(new Color(200, 106, 255));
		btnNiveles.setBounds(200, 220, 204, 45);
		ventana.getContentPane().add(btnNiveles);
		
		JButton btnCerrar = new JButton("CERRAR JUEGO\r\n");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
			}
		});
		btnCerrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Consolas", Font.BOLD, 25));
		btnCerrar.setBackground(new Color(200, 106, 255));
		btnCerrar.setBounds(200, 300, 204, 45);
		ventana.getContentPane().add(btnCerrar);
		
		
	}
	
	public void establecerNivel(int numNivel) {
		nivel = numNivel;
	}
	
	public int tomarNivel() {
		return nivel;
	}
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
