package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	int health;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		health = 100;
		HUD.HEALTH = health;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	public void tick() {
		x += velX;
		y += velY;
		 
		x = Game.clamp(x,  0, Game.WIDTH - 48);
		y = Game.clamp(y,  0, Game.HEIGHT - 70);
		
		collision();

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					hurtObject(tempObject.damage);
					health -= tempObject.damage;
					HUD.HEALTH -= tempObject.damage;
					handler.removeObject(tempObject);					
					if (health <= 0)
					{
						HUD.EndGame();
					}
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.red);
		//g2d.draw(getBounds());
		
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

}
