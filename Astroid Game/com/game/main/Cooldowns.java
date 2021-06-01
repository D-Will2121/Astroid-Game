package com.game.main;

public class Cooldowns {
	
	private double CD;
	
	public double getCD()
	{
		return CD;
	}
	
	public void setCD(double MaxCD)
	{
		CD = MaxCD;
		return;
	}
	
	public void tick()
	{
		CD -= 1;
		if(CD < 0)
		{
			CD = 0;
		}
	}

}
