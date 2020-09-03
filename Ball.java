import java.awt.*;
import java.util.Random;
import java.util.*;
import java.lang.*;

public class Ball {
	private double direction;
	private int vv;
	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private double speed;
	

	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		Random random = new Random();
		this.direction = 0;
		this.vv = 0;
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;
	}

	public void draw(){
		GameLib.setColor(Color.YELLOW);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}


	public void update(long delta){
		double movement = (speed * delta)/2;
		for (int i = 0; i < movement; i++){          
			
			if (this.direction == 0){
			//	this.cx = cx;
				this.cy = cy - 1;
			}
			if (this.direction == 45){
			this.cx = cx + 1;
			this.cy = cy - 1;
			}
			if (this.direction == 90){
			this.cx = cx + 1;
			//this.cy = cy;
				
			}
			if (this.direction == 135){
			this.cx = cx + 1;
			this.cy = cy + 1;
				
			}	
			if (this.direction == 180){
		//	this.cx = cx;
			this.cy = cy - 1;
				
			}
			if (this.direction == 225){
			this.cx = cx - 1;
			this.cy = cy + 1;
				
			}
			if (this.direction == 270){
			this.cx = cx - 1;
		//	this.cy = cy;
				
			}
			if (this.direction == 315){
			this.cx = cx - 1;
			this.cy = cy - 1;

			}
		}
	}

	public void onWallCollision(String wallId){
		if (wallId.equals("Left")){
			if (this.direction == 225)
			this.direction = 135;
			if (this.direction == 270 )
			this.direction = 45;
			if (this.direction == 315 )
			this.direction = 45;
		}

		if (wallId.equals("Right")){
			if (this.direction == 135)
			this.direction = 225;
			if (this.direction ==  45)
			this.direction = 315;
			if (this.direction ==  90)
			this.direction = 225;
		}

		if (wallId.equals("Bottom")){
			if (this.direction == 135)
			this.direction = 45;
			if (this.direction == 180 )
			this.direction = 315;
			if (this.direction == 225 )
			this.direction = 315;
		} 

		if(wallId.equals("Top")){
		if (this.direction == 0 )
			this.direction = 135;
		if (this.direction == 45 )
			this.direction = 135;
			if (this.direction == 315 )
			this.direction = 225;
		}

	}

	public boolean checkCollision(Wall wall){
		if(    
			   (getCx() + this.height/2 > wall.getCx() - wall.getWidth()/2) 
			&& (getCy() + this.width/2 > wall.getCy() - wall.getHeight()/2) 
			&& (getCy() - this.height/2 < wall.getCy() + wall.getHeight()/2)
			&& (getCx() - this.width/2 < wall.getCx() + wall.getWidth()/2))
		{ 
			onWallCollision(wall.getId());
			return true;
		}

		return false;
	}


	public void onPlayerCollision(String playerId){
		if (playerId.equals("Player 1")){
			if (this.direction == 225)
				this.direction = 135;	
			if (this.direction == 270)
				this.direction = 45;
			if (this.direction == 315)
				this.direction = 45;		
		}
		if (playerId.equals("Player 2")){
			if (this.direction == 45)
				this.direction = 315;
			if (this.direction == 90)
				this.direction = 225;
			if (this.direction == 135)
				this.direction = 225; 
		}
	}

	public boolean checkCollision(Player player){
		String playerId = player.getId();
		if ( playerId.equals("Player 1")){	
			if ( ((this.cy <= player.getCy() + (player.getHeight()/2) 
			&& this.cx <= (player.getCx() + player.getWidth()/2))  
			&& (this.cy >= player.getCy() - (player.getHeight()/2) ))) {
				vv = 0;
				return true;
			}

		}
		if ( playerId.equals("Player 2")){	
			if ((this.cy <= player.getCy() + (player.getHeight()/2) 
			&& (this.cy >= player.getCy() - (player.getHeight()/2)))
			&& (this.cx >= (player.getCx() - player.getWidth()/2))){
				vv = 0;
				return true;
			}
		}
		return false;
	}

	public double getCx(){
		return this.cx;
	}

	public double getCy(){
		return this.cy;
	}

	public double getSpeed(){
		return this.speed;
	}
}
