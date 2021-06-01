package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	LinkedList<Cooldowns> CDs = new LinkedList<Cooldowns>();
	
	public void tick()
	{
		for (int i = 0; i <object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		for (int i = 0; i <CDs.size(); i++)
		{
			Cooldowns CD = CDs.get(i);
			CD.tick();
		}
	}
	

	

	public void renderer(Graphics g) 
	{
		for (int i = 0; i <object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public GameObject addObject(GameObject object)
	{
		this.object.add(object);
		return object;
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	

	public Cooldowns addCD(Cooldowns CD)
	{
		this.CDs.add(CD);
		return CD;
	}
	
	public void removeCD(Cooldowns CD)
	{
		this.CDs.remove(CD);
	}
	
	public GameObject findPlayer()
	{
		GameObject player;
		for (int i = 0; i < object.size(); i++)
		{
			player = object.get(i);
			if (player.getID() == ID.Player)
			{
				return player;
			}
		}
		return null;
	}
	
}
