package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -7764115714063645212L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private int numberSpawned;
	private float gameTime;
	private int ticksNeeded;
	private Handler handler;
	private HUD hud;
	private Random r;
	
	public Game() 
	{
		ticksNeeded = 100;
		handler = new Handler();

		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
		
		hud = new HUD();
		r = new Random();
		
		handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player, handler));
		handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
		this.addKeyListener(new KeyInput(handler));


		for(int i = 0; i < 20; i++)
		{
			
		}


	}
	public synchronized void start() 
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() 
	{
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		 long lastTime = System.nanoTime();
		 double amountOfTicks = 60.0;
		 double ns = 1000000000 / amountOfTicks;
		 double delta = 0;
		 long timer = System.currentTimeMillis();
		 int frames = 0;
		 while(running) 
		 {
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			 while(delta >=1)
			 {
				 tick();
				 delta--;
			 }
			 if(running)
			 {
				 render(); 
			 }
			 frames++;
			 
			 if(System.currentTimeMillis() - timer > 1000)
			 {
				 timer += 1000;
				 System.out.println("FPS: " + frames);
				 frames = 0;
			 }	 
		 }
		 stop();
	}
	
	private void tick()
	{
		if (!HUD.FREEZE && gameTime == ticksNeeded)
		{
			if (ticksNeeded <= 100)
			{
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
			}
			
			if (ticksNeeded <= 90)
			{
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));

			}
			
			if (ticksNeeded <= 75)
			{
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
			}
			
			if (ticksNeeded < 50)
			{
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
				handler.addObject(new Astroid(r.nextInt(WIDTH), 0, ID.BasicEnemy, handler));
				ticksNeeded = 49;
			}
			gameTime = 0;
			numberSpawned += 1;
			if (numberSpawned >= 5)
			{
				ticksNeeded -= 5;
				numberSpawned = 0;
			}
		}
		gameTime += 1;
		handler.tick();
		hud.tick();
		
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();		
		g.setColor(Color.blue);
		g.fillRect(0,  0,  WIDTH, HEIGHT);
		handler.renderer(g);
		hud.render(g);
		g.dispose();
		bs.show();
		
	}
	
	public static int clamp (int var, int min, int max) 
	{
		if (var >= max) return var = max;
		else if (var<= min) return var = min;
		else return var;
	}
	
	public static void main(String args[])
	{
		new Game();
	}

}
