import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {

	String playerId;
	int pontos1;
	int pontos2;

	public Score(String playerId){
		this.playerId = playerId;
		this.pontos1 = 0;
		this.pontos2 = 0;
	}

	/**
		Método de desenho do placar.
	*/

	public void draw(){	
		if(playerId.equals("Player 1")){
			GameLib.setColor(Color.GREEN);
			GameLib.drawText(playerId+" : " + getScore(), 70, GameLib.ALIGN_LEFT);
		}
		else if(playerId.equals("Player 2")){
			GameLib.setColor(Color.BLUE);
		GameLib.drawText(playerId + " : " + getScore2(), 70, GameLib.ALIGN_RIGHT);
		}
	}

	/**
		Método que incrementa em 1 unidade a contagem de pontos.
	*/

	public void inc(){
		if(playerId.equals("Player 1")){
			GameLib.setColor(Color.GREEN);
			GameLib.drawText(playerId + " : " + (getScore()), 70, GameLib.ALIGN_LEFT);	}		
		if(playerId.equals("Player 2")){
			GameLib.setColor(Color.BLUE);
			GameLib.drawText(playerId + " : 0" + (getScore2()), 70, GameLib.ALIGN_RIGHT);}	
		pontos1++;
		pontos2++;
	}

	/**
		Método que devolve a contagem de pontos mantida pelo placar.

		@return o valor inteiro referente ao total de pontos.
	*/

	public int getScore(){

		return pontos1;
	
	}

	public int getScore2(){
	
		return pontos2;
	
	}

	public String getPontos(){

		return Integer.toString(pontos1);
	}

	public String getPontos2(){

		return Integer.toString(pontos2);
	}
}