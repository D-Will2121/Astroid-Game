package com.game.main;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY, health, damage;
	protected double CD;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	//public abstract Shape getCircleBounds();
	
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setID(ID id)
	{
		this.id = id;
	}
	public ID getID()
	{
		return id;
	}
	public double getCD()
	{
		return CD;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	public void hurtObject(int damage)
	{
		health -= damage;
		return;
	}

	
	
	
	
}
