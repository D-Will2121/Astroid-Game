package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	public static int HIGHSCORE = 0;
	public static boolean FREEZE = false;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		if (!FREEZE)
		{
			HIGHSCORE += 1;
		}
	}

	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(400,  15,  200, 24);
		g.setColor(Color.red);
		g.fillRect(400,  15,  HEALTH*2, 24);
		g.setColor(Color.white);
		g.drawRect(400,  15,  200, 24);
		g.drawString("Score: " + HIGHSCORE, 400, 54);
		if (FREEZE)
		{
			g.drawString("Game Over!\n High Score: " + HIGHSCORE, 250, 180);
		}

	}
	
	public static void EndGame()
	{
		FREEZE = true;
	}
	
}
