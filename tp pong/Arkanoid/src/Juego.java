
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Juego {
	final static int ancho = 800;
	final static int alto = 980;
	//CREAR VARIABLE DE NIVELES:
	private Gameplay panelGame;
	private Main main;
	
	public Juego() {
		JFrame ventana = new JFrame();
		ventana.setTitle("ARKANOID");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		ventana.setResizable(false);
		ventana.setSize(ancho, alto);
		ventana.setBounds(0, 0, ancho, alto);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		
		panelGame =new Gameplay();
	    ventana.getContentPane().add(panelGame); 
	    
	}
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Juego();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	
}
