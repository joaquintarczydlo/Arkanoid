import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class GeneradorBloques {
	public int bloques[][];
	public int bloqueAncho;
	public int bloqueAlto;
	
	public GeneradorBloques(int filas, int colums) {
		
		bloques = new int[filas][colums];
		
		for(int i=0 ; i<filas ; i++) {
			for(int j=0 ; j<colums ; j++) {
				bloques[i][j]=1;
			}
		}
		
		//CAMBIAR TAMAÑO DE BLOQUES SEGUN NIVEL:
		bloqueAncho = 780 / colums; 
		if(Main.nivel==1) {
			bloqueAlto = 120 / filas;
		}
		if(Main.nivel==2) {
			bloqueAlto = 160 / filas;
		}
		if(Main.nivel==3) {
			bloqueAlto = 240 / filas;
		}
		if(Main.nivel==4) {
			bloqueAlto = 320 / filas;
		}
		
	}
	
	public void moverBloque(int valor, int f, int c) {
		bloques[f][c] = valor;
	}

	
	public void draw(Graphics2D g) {
		
		for(int i=0 ; i<bloques.length ; i++) {
			for(int j=0 ; j<bloques[0].length ; j++) {
				if(bloques[i][j] > 0) {
					
					g.setColor(Color.CYAN);
					g.fillRect(j*bloqueAncho+4, i*bloqueAlto+170, bloqueAncho, bloqueAlto);
					
					g.setColor(Color.BLACK);
					g.setStroke(new BasicStroke(3));
					g.drawRect(j*bloqueAncho+4, i*bloqueAlto+170, bloqueAncho, bloqueAlto);
				}
			}
		}
		
	}
}
