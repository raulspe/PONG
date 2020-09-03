import java.awt.*;

import javafx.scene.input.KeyEvent;

/**
	Esta classe representa os jogadores (players) do jogo. A classe princial do jogo (Pong)
	instancia dois objetos deste tipo quando a execução é iniciada.
*/

public class Player {

	/**
		Construtor da classe Player.

		@param cx coordenada x da posição inicial do player (centro do retangulo que o representa).
		@param cy coordenada y da posição inicial do player (centro do retangulo que o representa).
		@param width largura do retangulo que representa o player.
		@param height altura do retangulo que representa o player.
		@param color cor do player.
		@param id uma string que identifica o player
		@param v_limit um array de double contendo dois valores (em pixels) que determinam os limites verticais da área útil da quadra.   
		@param speed velocidade do movimento vertical do player (em pixels por millisegundo).
	*/
	double cx;
	double cy;
	double width;
	double height;
	double speed;
	Color color;
	String id;
	double [] v_limit;


	public Player(double cx, double cy, double width, double height, Color color, String id, double [] v_limit, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.id = id;
		this.v_limit = v_limit;
		this.speed = speed;
	}

	/**
		Método chamado sempre que o player precisa ser (re)desenhado.
	*/

	public void draw(){
		if(id.equals("Player 1"))
		GameLib.setColor(Color.GREEN);
		else{
			GameLib.setColor(Color.BLUE);
		}
		GameLib.fillRect(cx, cy, width, height);
	}

	/**
		Método chamado quando se deseja mover o player para cima. 
		Este método é chamado sempre que a tecla associada à ação 
		de mover o player para cima estiver pressionada.

		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void moveUp(long delta){	
		if(id.equals(Pong.PLAYER1)) {
			if(GameLib.isKeyPressed(GameLib.KEY_A)) {
				if(cy <= v_limit[0] + (height/2)); 
				else{
					cy -= speed*delta;
					draw();
				}
			}
		}

		else {
			if(GameLib.isKeyPressed(GameLib.KEY_K)) {
				if(cy <= v_limit[0] + (height/2));
				else{
					cy -= speed*delta;
					draw();
				}
			}
		}
	}

	/**
		Método chamado quando se deseja mover o player para baixo. 
		Este método é chamado sempre que a tecla associada à ação 
		de mover o player para baixo estiver pressionada.

		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void moveDown(long delta){
		if(id.equals(Pong.PLAYER1)) {
			if(GameLib.isKeyPressed(GameLib.KEY_Z)) {
				if(cy >= v_limit[1] - (height/2));
				else{
					cy += speed*delta;
					draw();
				}
			}
		}
		
		else {
			if(GameLib.isKeyPressed(GameLib.KEY_M)) {
				if(cy >= v_limit[1] - (height/2));
				else{
					cy += speed*delta;
					draw();
				}
			}
		}
	}

	/**
		Método que devolve a string de identificação do player.
		@return a String de indentificação.
	*/

	public String getId() { 

		return id; 
	}

	/**
		Método que devolve a largura do retangulo que representa o player.
		@return um double com o valor da largura.
	*/

	public double getWidth() { 

		return width; 
	}

	/**
		Método que devolve a algura do retangulo que representa o player.
		@return um double com o valor da altura.
	*/

	public double getHeight() { 

		return height;
	}

	/**
		Método que devolve a coordenada x do centro do retangulo que representa o player.
		@return o valor double da coordenada x.
	*/

	public double getCx() { 
		
		return cx;
	}

	/**
		Método que devolve a coordenada y do centro do retangulo que representa o player.
		@return o valor double da coordenada y.
	*/

	public double getCy() { 
	
		return cy;
	}

//	public double vlimit(){

//	}
}

