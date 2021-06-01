package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Projectile extends GameObject {
	
	Random r = new Random();
	Handler handler;
	
	public Projectile(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velY -= 10;
		CD = 10;
		damage = 50;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	public void tick() {		 
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 48) handler.removeObject(this);
		if(x <= 0 || x >= Game.WIDTH - 32) handler.removeObject(this);
		
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
					tempObject.hurtObject(damage);
					if(tempObject.health <= 0)
					{
						handler.removeObject(tempObject);
						HUD.HIGHSCORE += 100;
					}
					
					handler.removeObject(this);

				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.red);
		//g2d.draw(getBounds());
		
		g.setColor(Color.green);
		g.fillRect(x, y, 4, 16);
	}

}
