
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private static final long serialVersionUID = 1L;
	
	private boolean movimPelota=false;
	private boolean juego=true;
	private boolean gameover=false;
	private Timer timer;

	private int totalLadrillos = 21;
	private GeneradorBloques bloque;
	private Juego juego_vent;
	private Main main;
	
	private int contvidas = 3;
	private int puntaje = 0;
	private int xjugador = 350;
	private int yjugador = 800;
	private int xpelota = 390;
	private int ypelota = 778;
	private int nivelActual=0;
	private int numNiveles=4;
	
	private int xvelocbola = 10;
	private int yvelocbola = 10;
	
	private boolean plyr_left = false;
	private boolean plyr_right = false;
	
	public Gameplay() {
		timer = new Timer(40, this);
		timer.start();
		setFocusable(true);
		addKeyListener(this);
		
		
		if(Main.nivel==1){
			totalLadrillos=21;
			bloque = new GeneradorBloques(3, 7);
		}
		if(Main.nivel==2){
			totalLadrillos=28;
			bloque = new GeneradorBloques(4, 7);
		}
		if(Main.nivel==3){
			totalLadrillos=42;
			bloque = new GeneradorBloques(6, 7);
		}
		if(Main.nivel==4){
			totalLadrillos=56;
			bloque = new GeneradorBloques(8, 7);
		}		
	}

	@Override
    public void paint(Graphics g) {
		if(movimPelota==true) {
			moverPelota();
		}
		moverJugador();
		verificarColision();
		
		g.setColor(Color.BLACK);
	    g.fillRect(0, 0, Juego.ancho, Juego.alto); //pintar fondo
		g.setColor(Color.WHITE);
	    g.fillRect(0, 80, Juego.ancho, 4); //dibujar linea divisora en parte superior de la pantalla
	    if(movimPelota==false && gameover==false) {
	    	g.setFont(new Font("Consolas", Font.PLAIN, 25));
	    	g.drawString("Use las flechas izquierda y derecha para moverse", 65, 600);
	        g.drawString("Presione ENTER para comenzar", 198, 650);
	    }
	    
        g.setFont(new Font("Consolas", Font.PLAIN, 20));
        g.drawString("PUNTAJE: " + puntaje, 306, 45); //texto de puntaje
        
        g.drawString("NIVEL: "+Main.nivel, 680, 45); //texto de nivel actual
        
	    g.setFont(new Font("Consolas", Font.PLAIN, 20));
        g.drawString("VIDAS: ", 10, 45);
        for(int i=0 ; i<contvidas ; i++) {
        	g.setColor(new Color(200, 106, 255));
    	    g.fillOval(80+30*i, 28, 20, 20);       //texto y conteo de vidas del jugador
        }
	        
	    g.setColor(new Color(200, 106, 255));
	    g.fillRect(xjugador, yjugador, 100, 20); // pintar el rectangulo de jugador en la pantalla
	    
	    g.setColor(new Color(200, 106, 255));
	    g.fillOval(xpelota, ypelota, 20, 20); // pintar la pelota en la pantalla
	    
	    bloque.draw((Graphics2D)g); //pintar bloques
	    
	    //Panel de juego terminado al perder las 3 vidas:
	    if (contvidas==0) {
	    	g.setColor(Color.WHITE);
		    g.fillRect(230, 200, 350, 170);
		    
		    g.setColor(Color.BLACK);
		    g.setFont(new Font("Consolas", Font.PLAIN, 25));
	        g.drawString("JUEGO TERMINADO", 290, 230);
		    g.setFont(new Font("Consolas", Font.PLAIN, 20));
	        g.drawString("Tu puntaje fue de: "+puntaje, 235, 275);
	        g.setColor(new Color(200, 106, 255));
	        g.setFont(new Font("Consolas", Font.PLAIN, 18));
	        g.drawString("Aprete ENTER para reiniciar juego", 235, 315);
	        g.drawString("Aprete ESC para volver al menu", 235, 355);
	    }
	    
	    //Panel de nivel terminado al romper todos los ladrillos:
	    if(totalLadrillos==0) {
	    	g.setColor(Color.WHITE);
		    g.fillRect(199, 200, 398, 136);
		    
		    g.setColor(Color.BLACK);
		    g.setFont(new Font("Consolas", Font.PLAIN, 25));
	        g.drawString("NIVEL COMPLETADO!!", 270, 230);
		    g.setFont(new Font("Consolas", Font.PLAIN, 20));
	        g.drawString("Tu puntaje actual es de: "+puntaje, 205, 275);
	        g.setColor(new Color(200, 106, 255));
	        g.setFont(new Font("Consolas", Font.PLAIN, 18));
	        g.drawString("Aprete ENTER para ir al siguiente nivel", 205, 315);
	    }
    }
	
	public void moverPelota() {
		if (juego==true) {
			xpelota += xvelocbola;
			ypelota -= yvelocbola;
					
			if (xpelota < 0 || xpelota > getWidth() - 20) {
				xvelocbola = -xvelocbola;
	        }
	        if (ypelota < 90) {
	        	yvelocbola = -yvelocbola;
	        } 
	        if (ypelota > getHeight()) {
	        	xpelota = xjugador + 40;
	        	ypelota = 778;
	        	movimPelota=false;
	        	xvelocbola = 10;
	        	yvelocbola = 10;
	        	contvidas--;
	        	if(contvidas == 0) {
	        		juegoTerminado();
	        	}
	        }
		}
	}
	
	public void moverJugador() {
		if (juego==true) {
			if(plyr_left==true) {
				xjugador -= 15;
				if (movimPelota==false) { //limita pelota al borde izquierdo mientras este quieta
					xpelota -= 15;					
				}
				if(xjugador < 0) { //limitar jugador al borde izquierdo de la ventana
					if (movimPelota==false) {
						xpelota = 40;
					}
					xjugador=0;
				}
			}
			if(plyr_right==true) {
				xjugador += 15;
				if (movimPelota==false) { //limita pelota al borde derecho mientras este quieta
					xpelota += 15;					
				}
				if(xjugador > getWidth() - 100) { //limitar jugador al borde derecho de la ventana
					if (movimPelota==false) {
						xpelota = getWidth() - 60;
					}		
					xjugador = getWidth() - 100;
				}
			}
		}
	}
	
	public void verificarColision() {
		Rectangle rectPelota = new Rectangle(xpelota, ypelota, 20, 20);
		Rectangle rectJugador = new Rectangle(xjugador, yjugador, 100, 20);
		
		if (rectPelota.intersects(rectJugador)) {
			puntaje+=10;
			if (xpelota + 10 < xjugador || xpelota+1 > xjugador + 100) {
                xvelocbola = -xvelocbola;
            } 
            else {
            	yvelocbola = -yvelocbola;
            }
		}
		
		for(int i=0 ; i<bloque.bloques.length ; i++) {
			for(int j=0 ; j<bloque.bloques[0].length ; j++) {
				
				if(bloque.bloques[i][j] > 0) {
					int bloque_ancho = bloque.bloqueAncho;
					int bloque_alto = bloque.bloqueAlto;
					int xbloque = 52+j*bloque_ancho;
					int ybloque =170+i*bloque_alto;
					
					Rectangle rectBloque = new Rectangle(xbloque, ybloque, bloque_ancho, bloque_alto);
					
					if(rectPelota.intersects(rectBloque)) {			
						puntaje+=100;
						bloque.moverBloque(0, i, j);
						totalLadrillos--;
						
						if(xpelota+10 < xbloque || xpelota > xbloque+bloque_ancho) {
							xvelocbola = -xvelocbola;
			            } 
			            else {
			            	yvelocbola = -yvelocbola;
			            }
					}
				}
				
			}
		}
		if(totalLadrillos==0) {
			juegoTerminado();
		}

	}
	
	public void pasarNivel() {
		juego=true;
		gameover=false;
		movimPelota=false;
		Main.nivel++;
		xjugador = 350;
		yjugador = 800;
		xpelota = 390;
		ypelota = 778;	
		xvelocbola = 10;
		yvelocbola = 10;
		plyr_left = false;
		plyr_right = false;
		if(Main.nivel==2){
			totalLadrillos=28;
			bloque = new GeneradorBloques(4, 7);
		}
		if(Main.nivel==3){
			totalLadrillos=42;
			bloque = new GeneradorBloques(6, 7);
		}
		if(Main.nivel==4){
			totalLadrillos=56;
			bloque = new GeneradorBloques(8, 7);
		}
		
		timer.start();
	}
	
	public void reiniciar() {
		juego=true;
		gameover=false;
		movimPelota=false;
		Main.nivel=1;
        contvidas = 3;
		puntaje = 0;
		xjugador = 350;
		yjugador = 800;
		xpelota = 390;
		ypelota = 778;	
		xvelocbola = 10;
		yvelocbola = 10;
		totalLadrillos=21;
		bloque = new GeneradorBloques(3, 7);
		plyr_left = false;
		plyr_right = false;
		
		timer.start();
	}
	
	public void juegoTerminado() {
		gameover=true;
		juego=false;
		timer.stop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		timer.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			plyr_left=true;
		}
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	plyr_right=true;
		}
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	movimPelota=true;
        	if(gameover==true && totalLadrillos<=0) {
        		pasarNivel();
        	}
        	if(gameover==true && totalLadrillos>0) {
        		reiniciar();
        	}
		}
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        	if(gameover==true && totalLadrillos>0) {
        		Main.main(new String[]{});
        		
        	}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			plyr_left=false;
		}
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	plyr_right=false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	public void startTimer() {
		timer.start();
	}
}
