package eggcatcher;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Animal 
{
	Random rand = new Random();
	Image imganimal;
	boolean direction = rand.nextBoolean(); // hướng di chuyển của vật nuôi
	public int x_ani;
	Animal()
	{
		x_ani = rand.nextInt(200);
	}
	public void move()
	{
		if(x_ani >=300 || x_ani < 100)
		{
			if(rand.nextInt(1000)/11 == 0)
			{
				direction = rand.nextBoolean();
			}
		}
		if(direction)
		{
			x_ani++;
		}
		else
		{
			x_ani--;
		}
		if(x_ani >=540 || x_ani <=2)
		{
			direction = !direction;
		}
	}
	public void draw(Graphics g)
	{
		g.drawImage(imganimal, x_ani ,0, null); 
	}
}
