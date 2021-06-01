package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Astroid extends GameObject {

	Random r = new Random();
	
	private Handler handler;
	
	public Astroid(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velY = 4;
		velX = r.nextInt(2);
		health = 100;
		damage = 10;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
		
	}
	
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 48) handler.removeObject(this);
		if(x <= 0 || x >= Game.WIDTH - 32) handler.removeObject(this);
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 32, 32, 0.019f, handler));
	}

	
	public void render(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(x, y, 64, 64);

	}

}
