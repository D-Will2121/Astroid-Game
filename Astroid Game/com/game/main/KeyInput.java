package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter 
{
	
	private Handler handler;
	private GameObject player;
	private Cooldowns shootCooldown;
	public KeyInput(Handler handler) {
		this.handler = handler;
		player = handler.findPlayer();
		shootCooldown = handler.addCD(new Cooldowns());
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) player.setVelY(-5);
		if(key == KeyEvent.VK_A) player.setVelX(-5);
		if(key == KeyEvent.VK_S) player.setVelY(+5);
		if(key == KeyEvent.VK_D) player.setVelX(+5);
		if(key == KeyEvent.VK_ENTER)
		{
			if (shootCooldown.getCD() <= 0) 
			{
				GameObject Bullet = handler.addObject(new Projectile(player.x + 16, player.y + 12, ID.Projectile, handler));
				shootCooldown.setCD(Bullet.getCD());
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W) player.setVelY(0);
		if(key == KeyEvent.VK_A) player.setVelX(0);
		if(key == KeyEvent.VK_S) player.setVelY(0);
		if(key == KeyEvent.VK_D) player.setVelX(0);
		
	}
}
